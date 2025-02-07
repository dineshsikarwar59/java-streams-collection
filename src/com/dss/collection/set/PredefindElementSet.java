package com.dss.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PredefindElementSet {
	public static void main(String[] args) {
		Set<String> stringSet=new HashSet<>();
		stringSet.add("D");
		stringSet.add("N");
		stringSet.add("K");
		stringSet.add("Z");
		stringSet.add("P");
		System.out.println("Before Sorting:"+stringSet);
		//Before Sorting:[P, D, Z, K, N]
		
		//cant sort set directly we can convert to list or Sorted set
		System.out.println("After Sorting:"+new TreeSet<String>(stringSet));
		//After Sorting:[D, K, N, P, Z]
		
		//cutomize sorting
		TreeSet<String> stringTreeSet=new TreeSet<>((a,b)->b.compareTo(a));
		stringTreeSet.add("D");
		stringTreeSet.add("N");
		stringTreeSet.add("K");
		stringTreeSet.add("Z");
		stringTreeSet.add("P");
		System.out.println("Customize Sorting:"+stringTreeSet);
		//Customize Sorting:[Z, P, N, K, D]
		
	}

}
