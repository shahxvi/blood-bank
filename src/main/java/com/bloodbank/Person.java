//MIT LICENSE
//Copyright (c) 2026 Isya

public abstract Person {
	//Declare
	protected int nric;
	protected String name;
	protected String dob;
	protected char gender;
	protected int contact;
   
   public person(){
   	nric = 0;
   	name = "";
   	dob = "";
   	gender = "";
   	contact = 0;
   }
   //Normal constructor 
   public person(int nric, String name, int contact){
   	this.nric = nric;
   	this.name = name;
   	this.gender = gender;
   	this.dob = dob;
   	this.contact = contact;
   }
   //Setter
   public void setNRIC(int nric){
   	this.nric = nric;
   }
   public void setName(String name){
   	this.name = name;
   }
   public void setDob(String dob){
   	this.dob = dob;
   }
   public void setGender(char gender){
   	this.gender = gender;
   }
   public void setContact(int contact){
   	this.contact = contact;
   }
   //Getter
   public int getNRIC(){
   	return nric;
   }
   public String getName(){
   	return name;
   }
   public String getDob(){
   	return dob;
   }
   public char getGender(){
   	return gender;
   }
   public int getContact(){
   	return contact;
   }
 }
 //printer
 public void display(){
 	System.out.print("IC Number: "+nric);
    System.out.print("Name: "+name);
    System.out.print("Date Of Birth: "+dob);
    System.out.print("Gender: "+gender);
    System.out.print("Contact Number: "+contact);
 }
 