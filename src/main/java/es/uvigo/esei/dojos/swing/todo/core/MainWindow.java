package main.java.es.uvigo.esei.dojos.swing.todo.core;

import zeng.siyuan.reuseutil.r;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.Box.createVerticalStrut;
import static main.java.es.uvigo.esei.dojos.swing.todo.core.TodoApp.c1s;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel mainContentPane;
	private JPanel newTaskControls;
	private JButton addTaskButton;
	private JTextField newTaskField;
	private JScrollPane taskListScrollPane;
	private JPanel taskListControls;
	private JButton upButton;
	private JButton deleteButton;
	private JButton downButton;
	private JList<String> taskList;
	private JLabel statusBar;
		
	private TodoList todoList;
	private TodoListModel todoListModel;
	public static transient Properties prop;


	public MainWindow(TodoList t, Properties prop){
		this.prop = prop;
		this.todoListModel = new TodoListModel(t);
		
		this.setContentPane( this.getMainContentPane() );
		
		this.setTitle("Todo list");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(new Dimension(250, 250));
		
		this.pack();
	}

	private Container getMainContentPane() {
		if (mainContentPane == null) {
			this.mainContentPane = new JPanel();
			this.mainContentPane.setLayout(new BorderLayout());
			
			this.mainContentPane.add(getNewTaskControls(), BorderLayout.NORTH);
			this.mainContentPane.add(getTasksListScrollPane(), BorderLayout.CENTER);
			this.mainContentPane.add(getTasksListControls(), BorderLayout.EAST);
			this.mainContentPane.add(getStatusBar(), BorderLayout.SOUTH);
			
		}
		return this.mainContentPane;
	}

	private Component getNewTaskControls() {
		if (this.newTaskControls == null) {
			this.newTaskControls = new JPanel();
			
			BorderLayout layout = new BorderLayout();
			this.newTaskControls.setLayout(layout);
			layout.setHgap(5);
			this.newTaskControls.setBorder(createEmptyBorder(10,0,10,10));
			
			this.newTaskControls.add(getNewTaskField(), BorderLayout.CENTER);
			this.newTaskControls.add(getAddTaskButton(), BorderLayout.EAST);
		}
		
		return this.newTaskControls;
	}

	private JTextField getNewTaskField() {
		if (this.newTaskField == null) {
			this.newTaskField = new JTextField();
		}
		return this.newTaskField;
	}

	private Component getTasksListScrollPane() {
		if (this.taskListScrollPane == null) {
			this.taskListScrollPane = new JScrollPane(getTaskList());			
		}
		
		return this.taskListScrollPane;
	}

	private JList<String> getTaskList() {
		if (this.taskList == null) {
			this.taskList = new JList<>();
			this.taskList.setModel(this.todoListModel);
			this.taskList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() == 2) {

						// Double-click detected
						int index = list.locationToIndex(evt.getPoint());

						System.out.println("hello" + index);
						System.out.println(list.getSelectedValue());
						r.o((String)prop.get(list.getSelectedValue()));
					}

//					else if (evt.getClickCount() == 3) {

						// Triple-click detected
//						int index = list.locationToIndex(evt.getPoint());
//					}
				}
			});
		}
		
		return this.taskList;
	}

	private Component getTasksListControls() {
		if (this.taskListControls == null) {
			this.taskListControls = new JPanel();
			
			BoxLayout layout = new BoxLayout(this.taskListControls, BoxLayout.Y_AXIS);
			this.taskListControls.setLayout(layout);
			this.taskListControls.setBorder(createEmptyBorder(5, 5, 5, 5));
			
			JButton button = getUpButton();
			button.setAlignmentX(CENTER_ALIGNMENT);
			this.taskListControls.add(button);
			
			this.taskListControls.add(createVerticalStrut(10));
			
			button = getDeleteButton();
			button.setAlignmentX(CENTER_ALIGNMENT);
			this.taskListControls.add(button);
			
			this.taskListControls.add(createVerticalStrut(10));
			
			button = getDownButton();
			button.setAlignmentX(CENTER_ALIGNMENT);
			this.taskListControls.add(button);
		}
		
		return this.taskListControls;
	}

	private JButton getUpButton() {
		if (this.upButton == null) {
			this.upButton = new JButton("Up");
			this.upButton.setIcon(createIcon("up.png"));
			
			this.upButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					int pos = getTaskList().getSelectedIndex();
					todoListModel.moveUp(pos);
					
					getTaskList().setSelectedIndex(max(0, pos - 1));
				}
			});
		}
		
		return this.upButton;
	}

	private JButton getDeleteButton() {
		if (this.deleteButton == null) {
			this.deleteButton = new JButton("Delete");
			this.deleteButton.setIcon(createIcon("bin.png"));
			
			this.deleteButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					todoListModel.removeAt(getTaskList().getSelectedIndex());
				}
			});
		}
		
		return this.deleteButton;
	}

	private JButton getDownButton() {
		if (this.downButton == null) {
			this.downButton = new JButton("Down");
			this.downButton.setIcon(createIcon("down.png"));
			
			this.downButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					int pos = getTaskList().getSelectedIndex();
					todoListModel.moveDown(pos);
				
					getTaskList().setSelectedIndex(
						min(getTaskList().getModel().getSize() - 1, pos + 1));
				}
			});
		}
		
		return this.downButton;
	}

	private JButton getAddTaskButton() {
		if (this.addTaskButton == null) {
			this.addTaskButton = new JButton("Add");
			this.addTaskButton.setIcon(createIcon("diary.png"));
			
			this.addTaskButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(getNewTaskField().getText());
					if (getNewTaskField().getText().length() > 0) {

						todoListModel.add(getNewTaskField().getText().trim().split("=")[0]);


						getTaskList().setSelectedIndex(getTaskList().getModel().getSize()-1);

						if (getNewTaskField().getText().trim().contains("=")&& getNewTaskField().getText().trim().indexOf("http") > getNewTaskField().getText().trim().indexOf("=")) {
							c1come2melater(getNewTaskField().getText().trim().split("=")[0], getNewTaskField().getText().trim().substring(getNewTaskField().getText().trim().indexOf("=") + 1));
							getNewTaskField().setText("");


//							SolrDataDAO solrBaseDAO = null;
//							try {
//								solrBaseDAO = new SolrDataDAO();
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//
//
//							try {
//								solrBaseDAO.addData(prop.size()+1, getNewTaskField().getText().trim().split("=")[0], getNewTaskField().getText().trim().substring(getNewTaskField().getText().trim().indexOf("=") + 1));
//							} catch (Exception e1) {
//								e1.printStackTrace();
//							}



						}






					}
				}
			});
		}
		
		return this.addTaskButton;
	}

	public void c1come2melater(String c1, String c1Path) {

		OutputStream output = null;
		OutputStream output_solr = null;
		try {

			output = new FileOutputStream("/Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/src/main/resources/c1s.properties");
			c1 = c1.replace(" ", "%20");
			System.out.println("c1come2melater();");
			// set the properties value
			prop.setProperty(c1, c1Path);

			// save properties to project root folder
			prop.store(output, null);


//			output_solr = new FileOutputStream("/Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/c1s.properties.solr");

//			int count = 0;
//			for (Map.Entry<Object, Object> e : prop.entrySet()) {
//				String key = ((String) e.getKey()).replace("%20", " ");
//				String v = (String) e.getValue();
//				output_solr.write(String.valueOf(count).getBytes());
//				output_solr.write(',');
//				output_solr.write(key.getBytes());
//				output_solr.write(',');
//				output_solr.write(v.getBytes());
//				output_solr.write(System.getProperty("line.separator").getBytes());
//				count++;
//			}
//
			c1s();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
					output_solr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private JLabel getStatusBar() {
		if (this.statusBar == null) {
			this.statusBar = new JLabel("Number of tasks: 0");
			this.todoListModel.addListDataListener(new ListDataListener() {
				@Override
				public void contentsChanged(ListDataEvent e) {
					updateLabel(e);
				}
				
				private void updateLabel(ListDataEvent e) {
					getStatusBar().setText("Number of tasks: "+((TodoListModel)e.getSource()).getSize());
				}
				
				@Override
				public void intervalRemoved(ListDataEvent e) {}
				@Override
				public void intervalAdded(ListDataEvent e) {}
			});
		}
		
		return this.statusBar;
	}
	
	private Icon createIcon(String iconfilename) {
		return new ImageIcon(
				getClass().
				getResource("/"+iconfilename));
	}
}
