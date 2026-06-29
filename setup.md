# java-streams-collection

    static List<Employee> employees = Arrays.asList(new Employee(103, "Dinesh", "IT", 35000.0,"Bangalore"),
            new Employee(102, "Amir", "IT", 25000.0,"Bangalore"), new Employee(101, "Zoya", "HR", 12000.0,"Chenai"),
            new Employee(105, "Mohan", "HR", 18000.0,"Bangalore"),new Employee(104, "Rohit", "Sales", 12000.0,"Bhopal"),new Employee(106, "Dinesh", "IT", 10000.0,"Bhopal"));
    
	static int[] arr = { 1, 2, 3, 4, 5, 2, 3, 6 };
	static List<Integer> list=Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6 );
	static List<String> namesList=Arrays.asList("Dinesh","Amit","Suresh","Amit","Rakesh","Naveen","Aman","Naveen","Amit");
	static String string="I told you again and again, but you didn't listen";


1. Write a Program to find the duplicates in an array using stream API
     
		Set<Integer> findDuplicate=Arrays.stream(arr).boxed().filter(num->Collections.frequency(Arrays.stream(arr).boxed().toList(), num)>1).collect(Collectors.toSet());
		System.out.println("Find Duplicates in Array: "+findDuplicate);
		
2.Find duplicate in list
  
		List<Integer> listWithDuplicates=Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6 );
		Set<Integer> findDuplicate2=listWithDuplicates.stream().filter(num->Collections.frequency(listWithDuplicates, num)>1).collect(Collectors.toSet());
		System.out.println("Find duplicate in list: "+findDuplicate2);
		
3.remove duplicate from array

		int[] removeDuplicate=Arrays.stream(arr).distinct().toArray();
		System.out.println("Remove duplicate: "+Arrays.toString(removeDuplicate));
		
4. How to sort the employee list in ascending and descending order using Java 8 streams API?
   
		List<Employee> sortedEmpAsc1= employees.stream().sorted((e1,e2)->e1.getId().compareTo(e2.getId())).toList();
		System.out.println("Sorted Employee ascending: "+sortedEmpAsc1);
		
second approch

		List<Employee> sortedEmpDesc=employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();
		System.out.println("Sort employee list by name desc: "+sortedEmpDesc);
		
Sort list by name Asc

		List<String> empNames=employees.stream().map(Employee::getName).toList();
		List<String> srotedEmpNamesAsc=empNames.stream().sorted().toList();
		System.out.println("Sort Employee Name Asc: "+srotedEmpNamesAsc);
		
Sort list by name desc

		List<String> srotedEmpNamesDesc=empNames.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("Sort Employee Name Desc:"+srotedEmpNamesDesc);
		
5. Find the highest salary of an employee from the HR department using Java stream API.
   
		Employee employee= employees.stream().filter(emp->"HR".equals(emp.getDepartment())).max((e1,e2)->e1.getSallary().compareTo(e2.getSallary())).get();
		System.out.println("Find the highest salary of an employee: "+employee);
		
find max number in array

		int maxNumber=Arrays.stream(arr).max().getAsInt();
		System.out.println("find max number in array: "+maxNumber);
		
6.Find an average of even numbers in array using Java 8 stream API.

		double averageOfArray=Arrays.stream(arr).filter(num->num%2==0).average().getAsDouble();
		System.out.println("Find an average of even: "+averageOfArray);
		
7.Find an average of even numbers in list using Java 8 stream API.

		double averageOfList= list.stream().filter(num->num%2==0).mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println("Find an average in list: "+averageOfList);
		
8.Find sum of odd numbers in array

		int sumArray=Arrays.stream(arr).filter(num->num%2!=0).sum();
		System.out.println("Find sum of odd numbers in array: "+sumArray);
		
9.Find sum of odd numbers in list

		Integer sumList=list.stream().filter(num->num%2!=0).mapToInt(Integer::intValue).sum();
		System.out.println("Find sum of odd numbers in list: "+sumList);
		
10. Write a program using stream API to find the employee count in each department.
    
		Map<String,Long> empCount=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("Find the employee count in each department: "+empCount);
		
11.Find employees based on location or city and sort them alphabetically using stream API.

		List<Employee> empSortLocation=employees.stream().filter(e->"Bangalore".equals(e.getCity())).sorted(Comparator.comparing(Employee::getName)).toList();
		System.out.println("Find employees based on location: "+empSortLocation);
		
12.Find the occurrence of names of employees and the frequency of each name.

		Map<String,Long> namesOccurrence=employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		System.out.println("Find the occurrence of names of employees: "+namesOccurrence);
		
13. Write a program to print only numbers from an alphanumeric char array using stream API.
    
		char[] charArr = {'A', '1', 'B', '2', 'C', '3', 'D', '4'};
		new String(charArr).chars().filter(ch->!Character.isDigit(ch)).mapToObj(ch->(char)ch).forEach(System.out::println);
		
14. Write a program to find the sum of the entire array using Java 8 streams.
    
		int sumOfArray=Arrays.stream(arr).sum();
		System.out.println("sum of the entire array: "+sumOfArray);
		
15. Write a program to find even numbers from a list and multiply them by 2 using streams.
    
		list.stream().filter(num->num%2==0).map(num->num*2).forEach(System.out::println);
		
16. Write a program to find the occurrence of each word in a given list.
 
		Map<String,Long> occurrenceOfWord=namesList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("Occurrence of each word in a given list: "+occurrenceOfWord);
		
17. Write a program to find the occurrence of each word in a given string.
    
		Map<String,Long> occurrenceOfWord1=Arrays.asList(string.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("occurrence of each word in a given string: "+occurrenceOfWord1);
		
18. Write a program to find common elements from three ArrayLists.
    
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(2, 4, 5, 8));
         
		List<Integer> commanElement=new ArrayList<Integer>(list1);

		commanElement.retainAll(list2);//retainAll(list2) keeps only elements present in both list1 and list2
		System.out.println("common elements from two ArrayLists: "+commanElement);//[3, 4, 5]

		commanElement.retainAll(list3);//retainAll(list3) further keeps only elements present in list3.
		System.out.println("common elements from three ArrayLists: "+commanElement);//[4, 5]
		
19. Write a program to convert a string to integer without using any API but realtime nob one use without api
    
        String str = "12345";
        int number = Integer.parseInt(str);
        System.out.println("Integer value: " + number);
        
20.Write a program to find the first occurrence of a character in a string.

        String string1="java";
        int index=string1.indexOf('a');
        System.out.println("first occurrence of a character 'a' in a string: "+index);//1
        
21. Write a program to check the minimum number of occurrences of a character in a string
    
        String string2="programming";
        Map<Character,Long> minNumOfOccurrences= string2.chars().mapToObj(ch->(char)ch).distinct().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("minimum number of occurrences of a character in a string: "+minNumOfOccurrences);
        
22. Write a program to check the max number of occurrences of a character in a string
    
        Map<Character,Long> maxNumOfOccurrences=string2.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Long maxValue=  maxNumOfOccurrences.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        maxNumOfOccurrences.entrySet().stream().filter(e->maxValue.longValue()==e.getValue()).forEach(System.out::println);;
        System.out.println("max number of occurrences of a character in a string: "+maxValue);
        
23.How to count every character in a string using Java 8 streams?

        String string3="occurrences";
        Map<Character,Long> occurrences=string3.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("count every character in a string: "+occurrences);
        
24.Write a program to check if a string has all unique characters.

        String string4="occurrences";
        boolean check=string4.chars().mapToObj(ch->(char)ch).distinct().toList().size()==string4.length();
        System.out.println("check if a string has all unique characters: "+check);
        
25. Find the second highest salary of an employee using Java 8 streams.
    
        Employee emp=  employees.stream().sorted(Comparator.comparing(Employee::getSallary).reversed()).skip(1).findFirst().get();
        System.out.println("second highest salary of an employee: "+emp);
        
26. How to handle null values safely in Java 8 streams?
    
        List<String> listNullCcheck = Arrays.asList("Java", null, "Python", null, "C++");
        List<String> listNullCcheckResult= listNullCcheck.stream().filter(Objects::nonNull).map(String::toUpperCase).toList();
        System.out.println("handle null values safely: "+listNullCcheckResult);
        
27.Write a program to partition numbers into even and odd using streams.

        Map<Boolean,List<Integer>> partitionNumbers=  list.stream().collect(Collectors.partitioningBy(num->num%2==0));
        System.out.println("Even Numbers: "+partitionNumbers.get(true));
        System.out.println("Odd Numbers: "+partitionNumbers.get(false));
        
28.Find the longest string in a list using Java 8 streams.

        String longestString=namesList.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Find the longest string in a list: "+longestString);
        
29.Convert a List to Map using Java 8 streams (handle duplicate keys).

        List<String> cities=Arrays.asList("Bhopal","Bangalore","Hydrabad","Pune","Dehli","Chanai");
        Map<String,Integer> convertedMap=cities.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Convert a List to Map : "+convertedMap);
        
30.Write a program to find the top 3 highest paid employees.

       List<Employee> top3HigesPaidEmp= employees.stream().sorted(Comparator.comparing(Employee::getSallary).reversed()).limit(3).toList();
       System.out.println("find the top 3 highest paid employees.: "+top3HigesPaidEmp);
		
31.Write a program to remove duplicate elements while preserving order using streams.

       List<String> preservedList=namesList.stream().distinct().toList();
       System.out.println("remove duplicate elements while preserving order: "+preservedList);
