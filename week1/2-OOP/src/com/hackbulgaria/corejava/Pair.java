package com.hackbulgaria.corejava;

public class Pair {
	final Object a;
	final Object b;
	
	public Pair(Object a, Object b){
		this.a=a;
		this.b=b;
	}
	
	public Object getFirstObject(){
		return a;
	}
	
	public Object getSecondObject(){
		return a;
	}
	
	public boolean equals(Pair p){
		if(this.a.equals(p.a) && (this.b.equals(p.b))){
			return true;
		}
		return false;
	}
	
	//Test main
	public static void main(String[] args){
		Pair p=new Pair(1, 2);
		System.out.println(p.equals(new Pair(2, 1))); //false
		
		Pair p1=new Pair(1, 2);
		System.out.println(p1.equals(new Pair(1, 2))); //true
		
		Pair p3=new Pair("aa", "bb");
		System.out.println(p3.equals(new Pair("aa", "bb"))); //true
		
		Pair p4=new Pair("aa", "bb");
		System.out.println(p4.equals(new Pair("bb", "aa"))); //false
	}
}


//Reduce brightness
//Grayscale
//Gaussian Blur
//Antialaising