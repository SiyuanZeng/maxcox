package zeng.siyuan.reuseutil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class r {

    public static void o(String url) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(url);
        String[] args = { "osascript", "-e", "open location \"" + url + "\"" };
        try {
            Process process = runtime.exec(args);
        }
        catch (IOException e) {
            // do what you want with this
        }
    }

    public static long randInt(long min, long max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        long randomNum = rand.nextInt(Integer.parseInt(String.valueOf((max - min) + 1))) + min;

        return randomNum;
    }
    public static Date j(String dsf) {
//        String s = "03/24/2013 21:54";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat i = new SimpleDateFormat("MM/dd/yyyy");
        try {
            String h=i.format(new Date());
            h +=" "+dsf;
            Date date = simpleDateFormat.parse(h);
            System.out.println("date : " + simpleDateFormat.format(date));
            return date;
        } catch (ParseException ex) {
            System.out.println("Exception " + ex);
        }
        return null;
    }

    public static Date jk(String dsf) {
//        String s = "03/24/2013 21:54";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        SimpleDateFormat i = new SimpleDateFormat("MM/dd/yyyy");
        try {
            String h=i.format(new Date());
            h +=" "+dsf;
            Date date = simpleDateFormat.parse(h);
            System.out.println("date : " + simpleDateFormat.format(date));
            return date;
        } catch (ParseException ex) {
            System.out.println("Exception " + ex);
        }
        return null;
    }

    public static Date d(String dsf) {
//        String s = "03/24/2013 21:54";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dsf);
            System.out.println("date : " + simpleDateFormat.format(date));
            return date;
        } catch (ParseException ex) {
            System.out.println("Exception " + ex);
        }
        return null;
    }

    public static Date h(Date d){
        Calendar calendar = Calendar.getInstance();
        d=calendar.getTime();
        SimpleDateFormat s;
        s=new SimpleDateFormat("MM/dd/yy");

        System.out.println(s.format(d));

        int days = 5;
        for(int i=0;i<days;)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            //here even sat and sun are added
            //but at the end it goes to the correct week day.
            //because i is only increased if it is week day
            if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
            {
                i++;
            }

        }
        d=calendar.getTime();
        s=new SimpleDateFormat("MMM dd, yyyy");
        System.out.println(s.format(d));
        return calendar.getTime();
    }

    public static Date l(Date d){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.add(Calendar.DATE,1);
        return calendar.getTime();
    }

    public static Date ls(Date d){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.add(Calendar.MONTH,1);
        return calendar.getTime();
    }


    public static Date m(Date d){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.add(Calendar.DATE,22);
        return calendar.getTime();
    }


    public static Date k(Date d){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }


    public static Date strifasld(String dsf){

        Calendar c = Calendar.getInstance();

        c.add(Calendar. MINUTE, Integer.parseInt(dsf));
        return c.getTime();
    }




    public final static String INTEXT_HYPHEN = "intext:";
    public static final String PLUGS = "+";
    public static final String SPACE = " ";


    public static boolean isUrl(String s ) {
        try {
            new URL(s);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public void waitUntilNotEmpty(JTextArea textArea) {
        while (!textArea.getText().trim().isEmpty()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void open(String s ){
        if(r.isUrl(s)){
            r.openUrlInBrowser(s);
        } else {
            try {
                Desktop.getDesktop().open(new File(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void openUrlInBrowser(String url) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(url);
        String[] args = { "osascript", "-e", "open location \"" + url + "\"" };
        try {
            Process process = runtime.exec(args);
        }
        catch (IOException e) {
            // do what you want with this
        }
    }


    public static void resetfiles() {
        String inntuitive = "";
        inntuitive +=  "datatypeps:(";
        inntuitive +=  "\n";
        inntuitive +=  "I dont want&";
        inntuitive +=  "\n";
        inntuitive +=  "parameters$";
        inntuitive +=  "\n";
        inntuitive +=  "variables#";
        inntuitive +=  "\n";
        inntuitive +=  "actions%";
        inntuitive +=  "\n";
        inntuitive +=  "impport*";
        inntuitive +=  "\n";
        inntuitive +=  "(optionalstackoverflow)First step 1:c1cometome:this is what yourwelcome want";
        inntuitive +=  "\n";
        inntuitive +=  "(optional documentation)First step 1:c1cometome:this is what yourwelcome want";
        inntuitive +=  "\n";
        inntuitive +=  "(optional everywhere)First step 1:c1cometome:this is what yourwelcome want";
        //  textArea.setText(inntuitive);
    }


/*


    String textStr[] = textTrs.split("\\r\\n|\\n|\\r");
    String intext = "+intext";
    String datatypes = textStr[0].trim().replace("datatypeps:(", "intext").replace(SPACE, "+AND"+intext);
    String idontwant = textStr[1].trim().replace("I dont want&", "+-").replace(SPACE, "+AND"+"+-");
    String datatypes1 = textStr[2].trim().replace("parameters$", intext).replace(SPACE, "+AND"+intext);
    String datatypes2 = textStr[3].trim().replace("variables#", intext).replace(SPACE, "+AND"+intext);
    String datatypes3 = textStr[4].trim().replace("actions%", intext).replace(SPACE, "+AND"+intext);
    String iomport = textStr[5].trim().replace("impport*", intext).replace(SPACE, "+AND"+intext);
    String c1cometome1 = textStr[6].trim().replace("how to","").replace("How to", "").replace("(optionalstackoverflow)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);
    String c1cometome2 = textStr[7].trim().replace("how to","").replace("How to", "").replace("(optional documentation)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);
    String c1cometome3 = textStr[8].trim().replace("how to","").replace("How to", "").replace("(optional everywhere)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);


*/


    public static boolean isNotNullOrEmpty(String s){
        if(null==s){
            return false;
        }
        return !s.isEmpty();
    }
    public static final String plusANDplus = "+AND+";
    public static final String plusANDplusintextcolon = "+AND+intext:";
    public static final String plus= "+";

    public static String splitStringandAddOnebyone(String str){
        StringBuilder result = new StringBuilder();

        for(String s: str.split(" ")){
                if(result.length()> 0){
                    result.append(plusANDplusintextcolon);
                }
            result.append(s);
        }
        return result.toString();
    }


    public static String splitStringandAddOnebyoneonlyplussign(String str){


        StringBuilder result = new StringBuilder();

        for(String s: str.split(" ")){
                if (result.length() > 0) {
                    result.append(plus);
                }

                result.append(s);

            }
        return result.toString();

    }




    public static String generate(String str) {
        String textStr[] = str.split("\\r\\n|\\n|\\r");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < textStr.length; i++) {
            String s  = textStr[i];

            if (s.split(":").length >1 && s.split(":")[1].trim().isEmpty()!=true) {
                if(stringBuilder.length()> 0){
                    stringBuilder.append(plus);
                }

                String keyword = s.split(":")[0];
                String keysearchstring = s.split(":")[1];

                switch (s.split(":")[0]) {
                    case "filetype": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "Restrict a search to a given type of file": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "link": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "related": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "info": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "define": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "site": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allintitle": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "intitle": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allintext": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allinurl": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "inurl": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "OR": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "+": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "-": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "~": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "*": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "[#]...[#]": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "daterange": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "\"\"": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, r.INTEXT_HYPHEN)); break;
                    case "date": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "safesearch": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "cache": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "stocks": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                }
        }
    }
        return String.format("http://www.google.com/#tbs=li:1&q=%s", stringBuilder.toString());
}

    private static String generateStringSplitAndCombine(String s, String keyword) {
            StringBuilder result = new StringBuilder();
            result.append(keyword);

        for (int i = 0; i < s.trim().split(" ").length; i++) {
                result.append(s.trim().split(" ")[i]);

            if(i<s.trim().split(" ").length-1)
            result.append(plusANDplus+keyword);

            }
            return result.toString();
    }
}
