package com.dss.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PredefindElementList {
	public static void main(String[] args) {	
		//string class
		List<String> stringList=Arrays.asList("Z","A","M","D","K","S");
		System.out.println("Before Sorting:"+stringList);
		//Before Sorting:[Z, A, M, D, K, S]
		
		Collections.sort(stringList);
		System.out.println("After Sorting:"+stringList);
		//After Sorting:[A, D, K, M, S, Z]
		
		//customize sorting order by comeprator
		Collections.sort(stringList, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+stringList);
		//Customize Sorting:[Z, S, M, K, D, A]
		
		//Wrapper classes
		List<Integer> wrapperList=Arrays.asList(5,3,8,2,7,6);
		System.out.println("Before Sorting:"+wrapperList);
		//Before Sorting:[5, 3, 8, 2, 7, 6]
		
		Collections.sort(wrapperList);
		System.out.println("After Sorting:"+wrapperList);
		//After Sorting:[2, 3, 5, 6, 7, 8]
		
		//customize sorting
		Collections.sort(wrapperList, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+wrapperList);
		//Customize Sorting:[8, 7, 6, 5, 3, 2]
		
		//return max number in list
		Integer max=Collections.max(wrapperList);
		System.out.println("Max Number:"+max);
		
	}

}
