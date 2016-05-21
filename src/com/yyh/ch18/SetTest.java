package com.yyh.ch18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		new SetTest ().test1();
 	}
	public void test1()
	{
		Set<String> set =new HashSet<String>();
		set.add("terry");
		set.add("larry");
		set.add("tom");
		set.add("terry");
		set.remove("tom");
		System.out.println("元素的个数"+set.size());
		/*System.out.println(set.contains(null));
		System.out.println(set.isEmpty());*/
		Iterator<String> iter=set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("--------------------------");
		
		for(String  stu:set )
		{
			System.out.println(stu);
		}
	}

}
