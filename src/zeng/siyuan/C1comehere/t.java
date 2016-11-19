package zeng.siyuan.C1comehere;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vn0xrjh on 11/18/16.
 */
public class t {
    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://textbelt.com/text");
        try
        {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("number", "3522136176"));
            nameValuePairs.add(new BasicNameValuePair("message", "I lve you"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            


            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null)
            {
                System.out.println(line);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
