package main.java.es.uvigo.esei.dojos.swing.todo.core;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TodoApp {
	public static transient Properties prop;


	public static void c1s() {
		prop = new Properties();
		Properties temprop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("/Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/src/main/resources/c1s.properties");
			// fjlasdjfl a properties file
			temprop.load(input);


			for (Map.Entry<Object, Object> e : temprop.entrySet()) {
				String key = ((String) e.getKey()).replace("%20", " ");
				String v = (String) e.getValue();
				prop.put(key, v);
			}
			System.out.println("Done Propertiesy loading");

/*
            SolrDataDAO solrBaseDAO = null;
            try {
                solrBaseDAO = new SolrDataDAO();
            } catch (Exception e) {
                e.printStackTrace();
            }


            int count =1;
            for (Map.Entry<Object, Object> e : prop.entrySet()) {
                System.out.println(count);
                String key = ((String) e.getKey()).replace("%20", " ");
                String v = (String) e.getValue();
                try {
                    solrBaseDAO.addData(count, key,v);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                count++;
            }
            System.out.println("stop");

*/



		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		TodoApp.todo();
	}

	public static void todo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		c1s();

		configureLookAndFeel();
		Iterator itr = prop.keySet().iterator();
		List<String> lists = new ArrayList<String>();
		while(itr.hasNext()) {
			lists.add((String) itr.next());
		}
		TodoList t = new TodoList(lists);
		MainWindow window = new MainWindow(t, prop);
		window.setLocationRelativeTo( null );
		window.setVisible(true);
	}

	private static void configureLookAndFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("GTK+".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break; //preferred!
		        }
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		        }
		    }
		} catch (Exception e) {}
	}
}
