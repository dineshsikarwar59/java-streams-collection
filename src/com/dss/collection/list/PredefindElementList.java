package com.dss.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PredefindElementList {
	public static void main(String[] args) {	
		//string class
		List<String> stringList=Arrays.asList("Z","A","M","D","K","S");
		System.out.println("Before Sorting:"+stringList);
		Collections.sort(stringList);
		System.out.println("After Sorting:"+stringList);
		
		//customize sorting order by comeprator
		Collections.sort(stringList, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+stringList);
		
		//Wrapper classes
		List<Integer> wrapperList=Arrays.asList(5,3,8,2,7,6);
		System.out.println("Before Sorting:"+wrapperList);
		Collections.sort(wrapperList);
		System.out.println("After Sorting:"+wrapperList);
		
		//customize sorting
		Collections.sort(wrapperList, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+wrapperList);
		
	}

}
