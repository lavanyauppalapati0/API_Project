package com.java.learn;

public class constructor {

	int eno;
	float esal;
	String ename;
	
	constructor(){
	//	System.out.println("o -org contructor");
	}
	constructor(String ename,int eno,float esal) {
		 this.ename =ename;
		 this.esal=esal;
		 this.eno=eno;
	 }
	void lavanya() {
		System.out.println(eno);
		System.out.println(ename);
		System.out.println(esal);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructor c = new constructor();
		constructor c1 = new constructor("lav",235941,35000.00f);
		c1.lavanya();
		constructor c2 = new constructor("suma",235942,39000.00f);
		c2.lavanya();
		
	}

}
