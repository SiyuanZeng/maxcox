package zeng.siyuan.solr;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import zeng.siyuan.button.untoggle;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * Created by SiyuanZeng's on 9/4/2016.
 */

public class solr {
    // lazy thing si easy to do 

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        solr http = new solr();
        System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet("", textArea);
    }

    // get rid of it if it cause peoleble them get it back
    // there are so much things that you don't need it
    // the method is another things that i can't delete it
    // i have to do it

    public List<String> sendGet(String types, JTextArea textArea) throws Exception {
        String url1 = "http://localhost:8983/solr/jcg/select?q=name:a&wt=json";
        String url22 = "http://localhost:8983/solr/jcg/select?q=name:%22"+types+"%22OR%20name_ngram:%22"+types+"%22&wt=json";

        String buttonSelected ="";
        for (Enumeration<AbstractButton> buttons = untoggle.bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                buttonSelected=button.getText();
            }
        }

        boolean deleteCommand = buttonSelected.contains("delete");
        boolean isShowCommand = buttonSelected.equalsIgnoreCase("sho");// shw
        boolean add = buttonSelected.equalsIgnoreCase("add");// shw

//include is better than exclude because i don't need it i only care about what i need
        if (deleteCommand || add || isShowCommand) {

            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet getRequest = new HttpGet(
                        url22);
                getRequest.addHeader("accept", "application/json");

                HttpResponse response = httpClient.execute(getRequest);

                BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

                String output;
                String str = "";
                while ((output = br.readLine()) != null) {
                    str += output;
                }

                List<String> list = new ArrayList<String>();

                JSONObject json = new JSONObject(str);
                JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
                for (int i = 0, size = jsonArray.length(); i < size; i++) {
                    JSONObject objectInArray = jsonArray.getJSONObject(i);
                    list.add(((JSONArray)objectInArray.get("name")).get(0).toString());
                }
                System.out.println(list);
                httpClient.getConnectionManager().shutdown();
                return list;
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

/// the import thing is what do i hawant
// i don't want to see you so what ever you try is subelow emm emememe
    public List<String> sendGet_comec(String types, JTextArea textArea) throws Exception {
        String url22 = "http://localhost:8983/solr/jcg/select?q=name:%22come"+"%22OR%20name_ngram:%22"+"come"+"%22"+ "OR%20name_ngram:%22"+"%3f"+"%22" + "OR%20name_ngram:%22"+"what"+"%22" + "&wt=json";

        String buttonSelected ="";
        for (Enumeration<AbstractButton> buttons = untoggle.bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                buttonSelected=button.getText();
            }
        }
        // women like to hear bad words because they sounds good

        boolean deleteCommand = buttonSelected.contains("saerchdiarydallq");// source of truth it can be rwrong everythere , what if everything is wrong then how can i know
        boolean isShowCommand = buttonSelected.equalsIgnoreCase("sho");// shw
        boolean add = buttonSelected.equalsIgnoreCase("add");// shw

//include is better than exclude because i don't need it i only care about what i need
        if (deleteCommand) {
//i wrote dirty code, i love sex sex is good, i should put come sexy jokes herei m a dierty i writoe dirty code
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet getRequest = new HttpGet(
                        url22);
                getRequest.addHeader("accept", "application/json");

                HttpResponse response = httpClient.execute(getRequest);

                BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

                String output;
                String str = "";
                while ((output = br.readLine()) != null) {
                    str += output;
                }

                List<String> list = new ArrayList<String>();

                JSONObject json = new JSONObject(str);
                JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
                for (int i = 0, size = jsonArray.length(); i < size; i++) {
                    JSONObject objectInArray = jsonArray.getJSONObject(i);
                    list.add(((JSONArray)objectInArray.get("name")).get(0).toString());
                }
                System.out.println(list);
                httpClient.getConnectionManager().shutdown();
                return list;
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
