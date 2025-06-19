package com.dss.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunctionalInterface {
	
	public static void main(String[] args) {
		//condition check and filter and return true and flase based on condition
		//Q.1 check number is even 
		Predicate<Integer> predicate1=n->n%2==0;
		boolean result1=predicate1.test(10);
		System.out.println(result1);
		
		//Q.2 check string start with given charector
		Predicate<String> predicate2=str->str.startsWith("A");
		boolean result2=predicate2.test("Ankit");
		System.out.println(result2);
		
		//Q3.check string cantaion
		Predicate<String> predicate3=str->str.contains("h");
		boolean result3=predicate3.test("Dines");
		System.out.println(result3);
		
		//Q.4 print even number
		List<Integer> listInteger=Arrays.asList(4,3,2,1,6,5,7,9,8,10);
		List<Integer> result5= listInteger.stream().filter(predicate1).collect(Collectors.toList());
		System.out.println(result5);
		System.out.println(listInteger.stream().filter(predicate1.and(n->n%3==0)).collect(Collectors.toList()));
		
		//Q.5 print whos lenght more then 6
		List<String> wordList=Arrays.asList("Amit","RamLakan","Ramesh","Suresh","Mahesh","Dinesh","Ankit","AnupKumar");
		List<String> result6=wordList.stream().filter(str->str.length()>6).toList();
		System.out.println(result6);
		
		//Q.6 print whos lenght more then 5 and contain 'N' using with And method
		Predicate<String> predicate4=str->str.length()>5;
		Predicate<String> predicate5=str->str.contains("n");		
		System.out.println(wordList.stream().filter(predicate5.and(predicate4)).toList());
		
		//Using && operator
		System.out.println(wordList.stream().filter(str->str.contains("e") && str.length()>5).toList());
		
		//use of or method
		System.out.println(wordList.stream().filter(predicate5.or(predicate4)).toList());
		
		//use of negate
		System.out.println(wordList.stream().filter(predicate5.negate()).toList());
		//use not operator !
		System.out.println(wordList.stream().filter(str->!str.contains("n")).toList());
		
		
	}

}
