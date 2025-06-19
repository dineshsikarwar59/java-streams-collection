package com.dss.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * Intermediate operation with string and wrapper objects
 */
public class IntermediateOperationsList {
	public static void main(String[] args) {
		List<String> stringList=Arrays.asList("V","M","K","A","L","U","A","K");
        List<String> fruitList = Arrays.asList("apple", "banana", "cherry", "date", "grape", "kiwi");
		List<Integer> integerList=Arrays.asList(90,50,80,20,10,30,100,60,70,20);
		
		//1. sorted()
		List<String> sortedList=stringList.stream().sorted().toList();
		System.out.println("Sorted List:"+sortedList);
		System.out.println("-------------------------------------------------------");
		
		//2. sorted(Comparator<? super T> comparator)
		List<String> customizeSort=stringList.stream().sorted((a,b)->b.compareTo(a)).toList();
		System.out.println("Customize sort:"+customizeSort);
		System.out.println("-------------------------------------------------------");
		
		//3.filter(Predicate<? super T> predicate)
		List<String> notEquale=stringList.stream().filter(a->!a.equals("A")).toList();
		System.out.println("Ignore A fro List:"+notEquale);
		List<String> filterdFruitList=fruitList.stream().filter(s->s.contains("a")).toList();
		System.out.println("Filterd Fruit list:"+filterdFruitList);		
		List<Integer> divisibleList=integerList.stream().filter(i->i%20==0).toList();
		System.out.println("Divisible by 20:"+divisibleList);	
		List<Integer> lessThenList=integerList.stream().filter(i->i<50).toList();
		System.out.println("Less then 50 List:"+lessThenList);
		System.out.println("-------------------------------------------------------");
		
		//4.map(Function<? super T, ? extends R> mapper)
		List<String> upperCaseList=fruitList.stream().map(String::toUpperCase).toList();
		System.out.println("Uppercase:"+upperCaseList);
		List<String> upperCaseFistLatterList=fruitList.stream().map(word->word.substring(0,1).toUpperCase()+word.substring(1)).toList();
		System.out.println("First latter Upper case"+upperCaseFistLatterList);
		System.out.println("-------------------------------------------------------");
		
		//5.flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		List<List<String>> listOfLists=Arrays.asList(stringList,fruitList);
		System.out.println("List of Lists:"+listOfLists);
		List<String> flateMap=listOfLists.stream().flatMap(List::stream).toList();
		System.out.println("FlateMap:"+flateMap);
		System.out.println("-------------------------------------------------------");
		
		//6.distinct()
		List<String> distinctList=stringList.stream().distinct().toList();
		System.out.println("DistinctList:"+distinctList);
		//7.peek(Consumer<? super T> action)
		
		//8. limit(long maxSize)
		List<String> limitList=stringList.stream().limit(3).toList();
		System.out.println("Limit list:"+limitList);
		System.out.println("-------------------------------------------------------");
		
		//9. skip(long n)
		List<String> skipList=fruitList.stream().skip(2).filter(a->a.contains(a)).toList();
		System.out.println("Skip list:"+skipList);
		System.out.println("-------------------------------------------------------");
		
		//10. takeWhile(Predicate<? super T> predicate) (Java 9+)
		List<Integer> takeWhileList=integerList.stream().takeWhile(n-> n<100).toList();
		System.out.println("Take while:"+takeWhileList);
		System.out.println("-------------------------------------------------------");
		
		//11.dropWhile(Predicate<? super T> predicate) (Java 9+)
		List<Integer> dropWhileList=integerList.stream().dropWhile(n->n<100).toList();
		System.out.println("Drop while List:"+dropWhileList);
		System.out.println("-------------------------------------------------------");
		
		//12. mapToInt(ToIntFunction<? super T> mapper)
		Integer sum=integerList.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of Numbers:"+sum);
		OptionalDouble average=integerList.stream().mapToInt(Integer::intValue).average();
		System.out.println("Average:"+average.getAsDouble());
        // Convert the list of strings to an IntStream and calculate various statistics
        IntSummaryStatistics stats = integerList.stream().mapToInt(Integer::intValue).summaryStatistics();  
        
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Count: " + stats.getCount());
        System.out.println("-------------------------------------------------------");
        
		//13. mapToDouble(ToDoubleFunction<? super T> mapper)
        List<String> doubleNumbers = Arrays.asList("1.1", "2.2", "3.3", "4.4", "5.5");
        Double sum1 = doubleNumbers.stream().mapToDouble(Double::parseDouble).sum();
        System.out.println("Sum2:"+sum1);
        OptionalDouble avg=doubleNumbers.stream().mapToDouble(Double::parseDouble).average();
        System.out.println("-------------------------------------------------------");
        
		//14. mapToLong(ToLongFunction<? super T> mapper)
        List<Long> longNumbers = Arrays.asList(new Long(10), new Long(20), new Long(30), new Long(40));
        Long longSum=longNumbers.stream().mapToLong(Long::longValue).sum();
        System.out.println("Long sum:"+longSum);
        System.out.println("-------------------------------------------------------");
        
		//15. flatMapToInt(Function<? super T, ? extends IntStream> mapper)
        
		//16. flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)
		//17. flatMapToLong(Function<? super T, ? extends LongStream> mapper)
		//18. boxed()
        List<Long> longNum = Arrays.asList(Long.parseLong("10"), Long.parseLong("20"));
        List<Long> longBoxed=longNum.stream().mapToLong(Long::longValue).boxed().toList();
        System.out.println("LongStream Boxed to Long List:"+longBoxed);
        System.out.println("-------------------------------------------------------");
        
		//19. unbox() (Java 10+, but not directly available via the Stream API)
		//20. concat(Stream<? extends T> a, Stream<? extends T> b) (Not an instance method, but part of the Stream utility class)
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        // Concatenate the two streams
        List<Integer> concatenatedStream = Stream.concat(stream1, stream2).collect(Collectors.toList());
        System.out.println("Merge tow Streams:"+concatenatedStream);
        System.out.println("-------------------------------------------------------");
		//21. range(int startInclusive, int endExclusive) (Static utility method)
        List<Integer> rangeStream=IntStream.range(0, 10).boxed().toList();
        System.out.println("range stream:"+rangeStream);
        //range stream:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        
		//22. rangeClosed(int startInclusive, int endInclusive) (Static utility method)
        List<Integer> rangeCloseStream=IntStream.rangeClosed(0, 10).boxed().toList();
        System.out.println("range close stream:"+rangeCloseStream);
        //range close stream:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
				
	}

}
