package com.truemd;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


import com.truemd.Medicine;
import com.truemd.TrueMDAPI;


public class TrueMDExample {

  /**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//only medicine information
		
		System.out.println("Enter the medicine name exact, Eg.\"Combicold\" :");
		InputStreamReader irs1 = new InputStreamReader(System.in);
		BufferedReader in1 = new BufferedReader(irs1);
		String brand1 = in1.readLine();
		TrueMDAPI.key="yash6992";
		
		Medicine medicine= TrueMDAPI.getMedicineData(brand1);
		printMedicine(medicine);
		
		//all medicine alternatives with information for each
		
		System.out.println("Enter the medicine name exact for alternatives, Eg.\"Combicold\" :");
		InputStreamReader irs2 = new InputStreamReader(System.in);
		BufferedReader in2 = new BufferedReader(irs2);
		String brand2 = in2.readLine();
		
		HashMap<String, Medicine> medicineAlternatives= TrueMDAPI.getMedicineAlternatives(brand2);
		int count=1;
		System.out.println(medicineAlternatives.size());
		for (String altBrand: medicineAlternatives.keySet()){
		   System.out.println("alternative "+count); count++;
           Medicine value = medicineAlternatives.get(altBrand);  
           printMedicine(value);  
          } 
	//all suggestions for any search string
		
		System.out.println("Enter the text for suggestions, Eg.\"Com\" :");
		InputStreamReader irs3 = new InputStreamReader(System.in);
		BufferedReader in3 = new BufferedReader(irs3);
		String brand3 = in3.readLine();
		System.out.println("Enter the limit for no. of suggestions, Eg.\"10\" or \"0\" for no limit");
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		

		int limit=Integer.parseInt(b.readLine());
		if(limit==0)
		{
			ArrayList<String> medicineSuggestions=TrueMDAPI.getMedicineSuggestions(brand3);
			
		}
		else
		{
			ArrayList<String> medicineSuggestions=TrueMDAPI.getMedicineSuggestions(brand3,limit);
			
		}
			
		ArrayList<String> medicineSuggestions=TrueMDAPI.getMedicineSuggestions(brand3,limit);
		
		System.out.println(medicineSuggestions.size());
		for(String brand: medicineSuggestions)
		{
			System.out.println(brand);
		}
		
		
	}

private static void printMedicine(Medicine medicine)
{	
	System.out.println("manufacturer :"+medicine.getManufacturer());
	System.out.println("brand :"+medicine.getBrand());
	System.out.println("category :"+medicine.getCategory());
	System.out.println("d_class :"+medicine.getDClass());
	System.out.println("unit_type :"+medicine.getUnitType());
	System.out.println("unit_qty :"+medicine.getUnitQty());
	System.out.println("package_type :"+medicine.getPackageType());
	System.out.println("package_qty :"+medicine.getPackageQty());
	System.out.println("package_price :"+medicine.getPackagePrice());
	System.out.println("unit_price :"+medicine.getUnitPrice());
	System.out.println("generic_id :"+medicine.getGenericId());
}

}
