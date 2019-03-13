/*
        Document   : Verify Captcha Class
        Created on : ‎February ‎20, ‎2019, ‏‎10:56:03 PM
        Author     : Pushkar and Shivani

        This class contains a method named verifyCaptcha, which perform a POST request to the Google Recaptcha API 
        which checks wheather the captcha is correct or not.
*/
package javaFiles;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class VerifyCaptcha {
    public static final String URL_ADDRESS="https://www.google.com/recaptcha/api/siteverify";   //URL for google recaptcha API
    public static final String SECRET_KEY="6Lfcb5IUAAAAAJoHFgT3G2tIxpTiAQInqSX0S6Jf";           //Private key given by google for our CSSS application
    private static final String USER_AGENT = "Mozilla/5.0"; //A parameter which is used in HTTP POST request, which tells about the browser we are using
    
    public static boolean verifyCaptcha(String googleCaptchaResponse) throws MalformedURLException, IOException
    {
        if(googleCaptchaResponse.equals("")||googleCaptchaResponse==null)   //An Initial check for null or empty captcha
        {
            return false;
        }
        URL url=new URL(URL_ADDRESS);    //Creates a new URL using the google recaptcha api url address
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();  //Open a new HTTP connection using the url created above
        connection.setRequestMethod("POST");    //Set request method to POST
        connection.setRequestProperty("User-Agent", USER_AGENT);    //Set USER agent parameter
        connection.setRequestProperty("Accept-Language","en-US,en;q=0.5");  //Set language parameter
        String postParameter = "secret=" + SECRET_KEY + "&response="+ googleCaptchaResponse;    //Set private key and captcha response to their respective values which is included in POST request further
        connection.setDoOutput(true);       //
        DataOutputStream dataOutputStream=new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(postParameter); //Set our parameters which is used to verify captcha
        dataOutputStream.flush();           //Send the rqeuest to Google API
        dataOutputStream.close();
        
        int responseCode=connection.getResponseCode();  //Get the response code from google recaptcha API
        
        //Print various fields for testing
        System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + postParameter);
	System.out.println("Response Code : " + responseCode);
        
        //Get the output from the google recaptcha API and assign it to BufferedReader Stream
        BufferedReader in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        
        StringBuffer response=new StringBuffer();
        while((inputLine=in.readLine())!=null)
        {
            response.append(inputLine); //Build String from BufferedReader
        }
        in.close();
        
        System.out.println(response.toString());
        
        //Use Json Reader to find success in the response
        JsonReader jsonReader=Json.createReader(new StringReader(response.toString()));
        JsonObject jsonObject=jsonReader.readObject();
        jsonReader.close();
        
        
        return jsonObject.getBoolean("success");    
    }
}
