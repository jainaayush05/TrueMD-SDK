/*Created By Aayush Jain
 * jainaayush05@gmail.com*/
package com.truemd;
/*
 * 
 * EDIT USING JSON PARSER
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.truemd.JsonParser;

public class TrueMDAPI {
	//private static HashMap<String, Medicine> medicine = new HashMap<String, Medicine>();
	public static String key="";
	private static HashMap<String, Medicine> medicineList = new HashMap<String, Medicine>();
	private static ArrayList<String> suggestions=new ArrayList<String>();
	
	public static Medicine getMedicineData(String brand) {
		try {
			 
			String url=  "http://oaayush-aayush.rhcloud.com/old_api/medicine.json?key="+key+"&id="+brand;
			
		 
			ArrayList<HashMap<String, String>> medicines= JsonParser.parse(url,"medicine" ,"manufacturer","brand","category","d_class","unit_qty","unit_type", "package_qty", "package_type", "package_price","unit_price", "generic_id");
		
			
		for(int j=0;j<medicines.size();j++){
			 Medicine medicine= new Medicine();
			medicine.setManufacturer(""+(medicines.get(j).get("manufacturer")));
			medicine.setBrand(""+(medicines.get(j).get("brand")));
			medicine.setCategory(""+(medicines.get(j).get("category")));
			medicine.setDClass(""+(medicines.get(j).get("d_class")));
			medicine.setUnitQty(""+(medicines.get(j).get("unit_qty")));
			medicine.setUnitType(""+(medicines.get(j).get("unit_type")));
			medicine.setPackageQty(""+(medicines.get(j).get("package_qty")));
			medicine.setPackageType(""+(medicines.get(j).get("package_type")));
			medicine.setPackagePrice(""+(medicines.get(j).get("package_price")));
			medicine.setUnitPrice(""+(medicines.get(j).get("unit_price")));
			medicine.setGenericId(""+(medicines.get(j).get("generic_id")));
			medicineList.put(brand, medicine);
			//URL yahoofin = new URL("http://172.16.14.149:3000/api/medicine.json?key=yash6992&id="+brand);
		}
			
		} catch (Exception ex) {
			System.out.println("Unable to get medicine info for: " + brand + ex);
		}
		return medicineList.get(brand);
     }

	public static  HashMap<String, Medicine> getMedicineAlternatives(String brand) {
		try {
			 
			String url=  "http://oaayush-aayush.rhcloud.com/old_api/search.json?key="+key+"&id="+brand;
			
		 
			ArrayList<HashMap<String, String>> medicines= JsonParser.parse(url,"drugs" ,"manufacturer","brand","category","d_class","unit_qty","unit_type", "package_qty", "package_type", "package_price","unit_price", "generic_id");
		
			
		for(int j=0;j<medicines.size();j++){
			 Medicine medicine= new Medicine();
			medicine.setManufacturer(""+(medicines.get(j).get("manufacturer")));
			medicine.setBrand(""+(medicines.get(j).get("brand")));
			medicine.setCategory(""+(medicines.get(j).get("category")));
			medicine.setDClass(""+(medicines.get(j).get("d_class")));
			medicine.setUnitQty(""+(medicines.get(j).get("unit_qty")));
			medicine.setUnitType(""+(medicines.get(j).get("unit_type")));
			medicine.setPackageQty(""+(medicines.get(j).get("package_qty")));
			medicine.setPackageType(""+(medicines.get(j).get("package_type")));
			medicine.setPackagePrice(""+(medicines.get(j).get("package_price")));
			medicine.setUnitPrice(""+(medicines.get(j).get("unit_price")));
			medicine.setGenericId(""+(medicines.get(j).get("generic_id")));
			medicineList.put(""+(medicines.get(j).get("brand")), medicine);
			
		}
			
		} catch (Exception ex) {
			System.out.println("Unable to get medicine info for: " + brand + ex);
		}
		return medicineList;
     }
	
	public static  ArrayList<String> getMedicineSuggestions(String find) {
		try {
			
			String url=  "http://oaayush-aayush.rhcloud.com/old_api/suggest.json?key=yash6992&id="+find;
			
			ArrayList<HashMap<String, String>> jsonarray= JsonParser.parse(url,"suggestions" ,"suggestion");
			
			System.out.println(jsonarray.size());
			for(int j=0;j<jsonarray.size();j++){
				
				
				//System.out.println(jsonarray.get(j).get("suggestion"));
				
			
			suggestions.add(jsonarray.get(j).get("suggestion"));
			
		}
			
		} catch (Exception ex) {
			System.out.println("Unable to get medicine info for: " + find + ex);
		}
		return suggestions;
     }
	public static  ArrayList<String> getMedicineSuggestions(String find, int limit) {
		try {
			 
			String url=  "http://oaayush-aayush.rhcloud.com/old_api/suggest.json?key="+key+"&id="+find+"&limit="+limit;
			
			ArrayList<HashMap<String, String>> medicineSuggestions= JsonParser.parse(url,"suggestions" ,"suggestion");
		
			
		for(int j=0;j<medicineSuggestions.size();j++){
			String suggest;
			suggest=""+(medicineSuggestions.get(j).get("suggestion"));
			
			suggestions.add(suggest);
			
		}
			
		} catch (Exception ex) {
			System.out.println("Unable to get medicine info for: " + find + ex);
		}
		return suggestions;
     }
}
