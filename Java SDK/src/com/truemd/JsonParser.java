package com.truemd;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
  
	public static ArrayList<HashMap<String, String>> parse(String url,String node, String...elements){
		JSONObject json= JsonRetriever.getJSONFromUrl(url);
		ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String,String>>();
		
			try {
           
				JSONArray array = json.getJSONArray(node);
 
         
					for(int i = 0; i < array.length(); i++){
					JSONObject c = array.getJSONObject(i);
					HashMap<String, String> map = new HashMap<String, String>();
					for(int j=0;j<elements.length;j++){
					map.put(elements[j], ""+c.get(elements[j]));
					}
                
                arraylist.add(map);
 
            }
        } catch (JSONException e) {
            
        }
		
		
		return arraylist;
		
	}

}
