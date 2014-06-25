package com.truemd;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonRetriever {
  
    static JSONObject jObj = null;
    static String json = "";
    
    public static JSONObject getJSONFromUrl(String url) {
    	try{
    	URL u = new URL(url);
		URLConnection uc = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"iso-8859-1"),8);
		
		StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = in.readLine()) != null) {
            sb.append(line + "\n");
        }
        uc.getInputStream().close();
        json = sb.toString();
    	}catch(Exception e){
    		
    	}
    	try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            
        }
    	return jObj;
    	
    }

}
