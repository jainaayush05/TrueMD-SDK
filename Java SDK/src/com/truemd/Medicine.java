package com.truemd;

public class Medicine {
  String manufacturer;
	String brand;
	
	String category;
	String d_class;
	String unit_qty;
	String unit_type;
	String package_qty;
	String package_type;
	String package_price;
	String unit_price;
	String generic_id; 
	
	
	//Ticker
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	//Name
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//Price
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	//Change
	public String getDClass() {
		return d_class;
	}
	public void setDClass(String d_class) {
		this.d_class = d_class;
	}
	//DayHigh
	public String getUnitType() {
		return unit_type;
	}
	public void setUnitType(String unit_type) {
		this.unit_type = unit_type;
	}
	//DayLow
	public String getUnitQty() {
		return unit_qty;
	}
	public void setUnitQty(String unit_qty) {
		this.unit_qty= unit_qty;
	}
	//YearHigh
	public String getPackageType() {
		return package_type;
	}
	public void setPackageType(String package_type) {
		this.package_type = package_type;
	}
	//YearLow
	public String getPackageQty() {
		return package_qty;
	}
	public void setPackageQty(String package_qty) {
		this.package_qty= package_qty;
	}
	
	public String getPackagePrice() {
		return package_price;
	}
	public void setPackagePrice(String package_price) {
		this.package_price= package_price;
	}
	//prev close
	public String getUnitPrice() {
		return unit_price;
	}
	public void setUnitPrice(String unit_price) {
		this.unit_price= unit_price;
	}
	//Change Percent
	public String getGenericId() {
		return generic_id;
	}
	public void setGenericId(String generic_id) {
		this.generic_id= generic_id;
	}
	
	
}
