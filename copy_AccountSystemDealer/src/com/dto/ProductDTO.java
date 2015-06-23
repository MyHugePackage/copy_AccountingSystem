package com.dto;

public class ProductDTO {

	private String prod_no;
	private String prod_class_name;
	private String prod_name;
	private int price;

	public ProductDTO(String prod_no, String prod_class_name, String prod_name,
			int price) {
		super();
		this.prod_no = prod_no;
		this.prod_class_name = prod_class_name;
		this.prod_name = prod_name;
		this.price = price;
	}

	public String getProd_no() {
		return prod_no;
	}

	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}

	public String getProd_class_name() {
		return prod_class_name;
	}

	public void setProd_class_name(String prod_class_name) {
		this.prod_class_name = prod_class_name;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}