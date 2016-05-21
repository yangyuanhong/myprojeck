package com.yyh.ch18;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		      new   MapTest().test1();
	}
public void test1()
   {
	Map<Integer, Student> map =new HashMap<Integer, Student>();
	map.put(1001,new Student(1001,"larry",13) );
	map.put(1002, new Student(1002,"terry",14));
	map.put(1003, new Student(1003,"tom",15));
	map.put(1001, new Student(1001,"larry",13));
	System.out.println(map.get(1002));
	Set<Integer> keys =map.keySet();
    map.remove(1001);
	for(int key:keys)
	{
		Student val=map.get(key);
		System.out.println(key+"="+val);
	}
	System.out.println("---------values--------");
	Collection<Student> values =map.values();
	Iterator<Student>  iter= values.iterator();
	while(iter.hasNext())
	{
		System.out.println(iter.next());
	}
	
	
	
	
	}
}

