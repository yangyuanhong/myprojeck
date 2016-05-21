package com.yyh.ch19;

public class Multil {
	public static void main(String[] args) {
		Multil   m=new Multil();
		m.Test();
	}
     public void Test()
             {
    	 int tmp=1;
      	 for(int j = 1; j < 10; j++) {
      		for(int k=0;k<9-j;k++){
 					System.out.print ("              ");
 				}
 			for(int i = 1; i <=j; i++) {
                 tmp = i * j;
 				System.out.print(i + "*" + j);
 				if(tmp >= 10)
 				   System.out.print("=" + tmp + "  ");
 				else
 				   System.out.print("=  " + tmp + "  ");
 		    } //end for inner FOR
 		   
 		   System.out.println("");
 	  } //end for outer FOR	  
             }
}
