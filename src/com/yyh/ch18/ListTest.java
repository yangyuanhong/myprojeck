package com.yyh.ch18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
          public static void main(String[] args) {
	                   new ListTest().test1();
}
          public void test1(){
        	  List<Integer> list=new ArrayList<Integer>();
        	  list.add(3);
        	  list.add(6);
        	  list.add(9);
        	  list.add(0);
        	  list.add(5);
        	  list.add(4);
        	  list.add(0, 100);
        	list.remove(1);
        	  System.out.println("元素的个数"+list.size());
        	  System.out.println("第五个元素"+list.get(4));
        	  System.out.println("---foreach------");
        	  for(int val:list)
        	  {
        		  System.out.println(val);
        	  }
        	  System.out.println("---------for-----");
        	  for(int i=0;i<list.size();i++)
        	  {
        		  System.out.println(list.get(i));
        	  }        	  
        	  System.out.println("--------迭代器---------");
        	  Iterator<Integer> iter=list.iterator();
        	  while(iter.hasNext()){
        		  System.out.println(iter.next()); 
        	  }
          }
}
