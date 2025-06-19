package com.dss.streams;

import java.util.List;
import java.util.stream.Stream;

public class BasicStreamOperation {
	public static void main(String[] args) {
		List<Double> ramdomNumbers = Stream.generate(Math::random).limit(5).toList();
		System.out.println("Random Numbers:"+ramdomNumbers);
		
		List<Integer> genratedNumber = Stream.iterate(1,n->n+1).limit(5).toList();
		System.out.println("Genrated Number+"+genratedNumber);
		
	}

}
