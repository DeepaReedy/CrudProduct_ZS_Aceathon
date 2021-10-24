package com.ram.hibernate;
import java.io.Serializable;
import java.util.Date;


public class Product implements Serializable{
	
//product details
private int productnumber;	
private String productname;
private String imgurl;
private String details;
private double price;


public int getProductnumber() {
	return productnumber;
}
public void setProductnumber(int productnumber) {
	this.productnumber = productnumber;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}
