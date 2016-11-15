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

// ever prorressional anhas its own peolbmea nd they can do thing sthat it si right s


// sue hteall the first letter tni the key baor dthen seu all the seconce lattet int he key baod make things so esmple athat you can't lieve tiwht thie

// don't worry i won't hurt you
    // don't worry i won't hurt you
    // i am just plakidding just playing you
    // i am just playing
    // i am just palying
    // they don't want to see you stealing they want to you to have it and they don't want to know that
    // they don't want to protecting you anmad make them lose their principles
    // they don't wan tto to do that
    // nobody they don't want to be good prole
    // they wan tto functional that is all they wan tto
    // they wan tot do that

   // i write everythign here and leave it here
    // this is the fiertydies code i have ever wirttiner
    // and peolwe know that to watdo with tit they will funnali 0 that the hell si tis just maek as much errors ac you wan can and you can be ther best programmer in the worlds
    // that is the problems
public class solr {
    // lazy thing si easy to do
    // i love to be lazy, it is love there if i can be lazy if wreally love to do it it feel so smar t and lovelyli love to be lazy that is just so awesome it is just a kiss away it is jasut lsetter arway

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
        String url22 = "http://localhost:8983/solr/jcg/select?q=name:%22come"+"%22OR%20name_ngram:%22"+"come"+"%22"+ "OR%20name_ngram:%22"+"%3f"+"%22" + "OR%20name_ngram:%22"+"what"+"%22" +"OR%20name_ngram:%22"+"everything"+"%22" +"OR%20name_ngram:%22"+"nothing"+"%22" + "OR%20name_ngram:%22"+"something"+"%22" + "&wt=json";

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
//i wrote dirty code, i love sex sex is good, i should put come sexy jokesinandout herei m a dierty i writoe dirty code
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
