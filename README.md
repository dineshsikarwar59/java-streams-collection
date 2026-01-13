# java-streams-collection
Sorting-List-Predefind-Objects-(String-Wrapper(Integer))

String class
Default Sorting order

		List<String> list=Arrays.asList("Z","A","M","D","K","S");
		System.out.println("Before Sorting:"+list);//Before Sorting:[Z, A, M, D, K, S]
		Collections.sort(list);
		System.out.println("After Sorting:"+list);//After Sorting:[A, D, K, M, S, Z]

Cutomize Sorting Order

  		Collections.sort(list, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+list);//Customize Sorting:[Z, S, M, K, D, A]
  
Wrapper Classes
Default Sorting order

		List<Integer> wrapperList=Arrays.asList(5,3,8,2,7,6);
		System.out.println("Before Sorting:"+wrapperList);//Before Sorting:[5, 3, 8, 2, 7, 6]
		Collections.sort(wrapperList);
		System.out.println("After Sorting:"+wrapperList);//After Sorting:[2, 3, 5, 6, 7, 8]

  Customize Sorting order

  		Collections.sort(wrapperList, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+wrapperList);//Customize Sorting:[8, 7, 6, 5, 3, 2]

-----------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------
Q.1 Find even numbers from a list

    List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30);
    List<Integer> evens = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    System.out.println(evens);// Output: [10, 20, 30]

Q.2 Convert list of strings to uppercase

    List<String> names = Arrays.asList("java", "spring", "microservice");
    List<String> upercase = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
    System.out.println(upercase);// Output: [JAVA, SPRING, MICROSERVICE]

Q.3 Find sum of all numbers

    List<Integer> sum = Arrays.asList(5, 10, 15);
    Integer sumOfList = sum.stream().mapToInt(Integer::intValue).sum();
    System.out.println(sumOfList);// 30

 Q.4 Remove duplicate elements
 
    List<Integer> duplicateList = Arrays.asList(1, 2, 2, 3, 3, 4);
    // Set<Integer> removedDuplicate = duplicateList.stream().collect(Collectors.toSet());
    List<Integer> removedDuplicate = duplicateList.stream().distinct().toList();
    System.out.println(removedDuplicate);

Q.5 Count elements greater than 10

    List<Integer> elements = Arrays.asList(5, 12, 18, 7, 20);
    List<Integer> greater = elements.stream().filter(n -> n > 10).toList();
    System.out.println(greater);

Q.7 Sort a list in descending order

    List<Integer> list = Arrays.asList(5, 1, 9, 3);
    List<Integer> descOrder = list.stream().sorted(Comparator.reverseOrder()).toList();
    System.out.println(descOrder);
    List<Integer> aseOrder = list.stream().sorted().toList();
    System.out.println(aseOrder);

Q.8 Find maximum and minimum number

    List<Integer> numbers = Arrays.asList(10, 40, 20, 5);
    Integer max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
    System.out.println(max);
    Integer min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
    System.out.println(min);

Q.9 Convert list to map (id : name)

    /*
     * class Employee { int id; String name; }
     */
    List<Employee> empList = Arrays.asList(new Employee(101, "Dinesh"), new Employee(103, "Ankit"),new Employee(102, "Zoya"));
    Map<Integer, String> employees = empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
    System.out.println(employees);

Q.9 Sort employes by name

    List<Employee> sortEmp = empList.stream().sorted(Comparator.comparing(Employee::getName)).toList();
    System.out.println(sortEmp);

Q.10 Group employees by department
    // Map<String, List<Employee>>
	
    List<Employee> empDept = Arrays.asList(new Employee(101, "Amit", "IT"),new Employee(102, "Vikram", "Sales"), new Employee(103, "Deepak", "IT"));
    Map<String, List<Employee>> department = empDept.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    System.out.println(department);

Advanced Level (Most Asked)
Q.11 Find second highest number

    List<Integer> number = Arrays.asList(10, 20, 30, 40, 50);
    Integer secondHighest = number.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
    System.out.println(secondHighest);

Q.12 Find frequency of each character in a string

    String input = "programming";
    Map<Character, Long> frequency = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    System.out.println(frequency);

Q.13 Partition numbers into even and odd
    // Map<Boolean, List<Integer>>
    
	List<Integer> nums1 = Arrays.asList(10, 15, 20, 25, 30);
    Map<Boolean, List<Integer>> partition = nums1.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    System.out.println(partition);


Q.14 Find duplicate elements

    List<Integer> elements1 = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
    Set<Integer> seen = new HashSet<>();
    Set<Integer> duplicates = elements1.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());
    System.out.println(duplicates);


Q.15 Find longest string in a list

    List<String> words = Arrays.asList("Java", "SpringBoot", "Microservices");
    Optional<String> longestString = words.stream().max(Comparator.comparingInt(String::length));
    longestString.ifPresent(System.out::println);

Q.16 Sort employees by salary (descending) and get top 3
    // List<Employee>
    
	List<Employee> employee =Arrays.asList(new Employee(101, "Dinesh", 35000.0), new Employee(102, "Amir", 25000.0),new Employee(103, "Zoya", 12000.0), new Employee(104, "Mohan", 18000.0));
    List<Employee> sortEmp1 = employee.stream().sorted(Comparator.comparing(Employee::getSallary).reversed()).limit(3).toList();
    System.out.println(sortEmp1);

Q.17. Find department-wise highest salary employee
    // Map<String, Optional<Employee>>

    List<Employee> employeeDept = Arrays.asList(new Employee(101, "Dinesh", "IT", 35000.0),new Employee(102, "Amir", "IT", 25000.0), new Employee(103, "Zoya", "HR", 12000.0),new Employee(104, "Mohan", "HR", 18000.0));
Map<String, Optional<Employee>> highestSalarydepartmentWise = employeeDept.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSallary))));
    System.out.println(highestSalarydepartmentWise);

Q.17 Find highest salary for employee

    Employee highestSalaryEmp = employeeDept.stream().max((e1, e2) -> e1.getSallary().compareTo(e2.getSallary())).orElse(null);
    System.out.println(highestSalaryEmp);

Q.17. Find  highest salary

    Double highestSalary = employeeDept.stream().mapToDouble(Employee::getSallary).max().getAsDouble();
    System.out.println(highestSalary);

Q.18 Join all names with comma 

    List<String> namess = Arrays.asList("A", "B", "C");
    String str = namess.stream().collect(Collectors.joining());
    System.out.println(str);
    String str2 = namess.stream().collect(Collectors.joining(","));
    System.out.println(str2);

Q.19 Check if all numbers are positive
    List<Integer> positiveNumbers = Arrays.asList(1, 2, 3, -4);
    boolean check = positiveNumbers.stream().allMatch(n -> n > 0);
    System.out.println(check);

Q.20. A list of lists

    List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
    List<Integer> flattenList = list1.stream().flatMap(List::stream).toList();
    System.out.println(flattenList);

Q.21 Given a list of integers, find all non duplicate integers using Java

    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);
    List<Integer> unique = numbers1.stream().filter(n -> Collections.frequency(numbers1, n) == 1).toList();
    System.out.println(unique);

Q.22 Find the longest string using Java streams.

    List<String> stringsList = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
    String longestString1 = stringsList.stream().max((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse(null);
    System.out.println(longestString1);

Q.23 Find average sallary

    List<Employee> employeeSallary = Arrays.asList(new Employee(101, "Dinesh", "IT", 35000.0),new Employee(102, "Amir", "IT", 25000.0), new Employee(103, "Zoya", "HR", 12000.0),new Employee(104, "Mohan", "HR", 18000.0));
    Double averageSallary = employeeSallary.stream().mapToDouble(Employee::getSallary).average().getAsDouble();
    System.out.println(averageSallary);

 Q.24 Find Department with Maximum Number of Employee:
 
    List<Employee> numberOfEmployee = Arrays.asList(new Employee(101, "Dinesh", "IT", 35000.0),new Employee(102, "Amir", "IT", 25000.0), new Employee(103, "Zoya", "HR", 12000.0),new Employee(104, "Mohan", "HR", 18000.0), new Employee(105, "Anil", "IT", 30000.0));
    Entry<String, Long> maximumNumberEmployee = numberOfEmployee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet()
    .stream().max(Map.Entry.comparingByValue()).orElseGet(null);
    System.out.println(maximumNumberEmployee);

Q.25 Find the Lowest sallary in Each Department:

    List<Employee> lowestSallaryDepartment = Arrays.asList(new Employee(101, "Dinesh", "IT", 35000.0),new Employee(102, "Amir", "IT", 25000.0), new Employee(103, "Zoya", "HR", 12000.0),
            new Employee(104, "Mohan", "HR", 18000.0), new Employee(105, "Anil", "IT", 30000.0));
    Map<String, Optional<Employee>> lowestSallaryEachDepartment = lowestSallaryDepartment.stream().collect(Collectors.groupingBy(Employee::getDepartment,
	Collectors.minBy(Comparator.comparing(Employee::getSallary))));
    System.out.println(lowestSallaryEachDepartment);

Q.26 Concatenate Strings:Concatenate all strings in a list into a single string.

    List<String> words1 = Arrays.asList("Stream", "API", "is", "powerful");
    String concatenate = words1.stream().reduce("", (s1, s2) -> s1 + " " + s2).trim();
    System.out.println(concatenate);

Q.27 Find the Longest String

    List<String> words2 = Arrays.asList("Java", "Stream", "API", "Development");
    String longest = words2.stream().max(Comparator.comparing(String::length)).get();
    System.out.println(longest);

Q.28 Remove Null Values

    List<String> words3 = Arrays.asList("Java", null, "Stream", null, "API");
    List<String> nonNullWords = words3.stream().filter(Objects::nonNull).toList();
    System.out.println(nonNullWords);

Q.29 Find All Palindromic Strings

    List<String> words4 = Arrays.asList("radar", "level", "world", "java");
    List<String> palindromes = words4.stream().filter(word -> word.equals(new StringBuilder(word).reverse().toString())).toList();
    System.out.println(palindromes);

Q.30 Find the Most Frequent Character in a String(finding frequncy and adding in map then

    // getting high frequency)
    String input1 = "success";
    Map<Character, Long> map1 = input1.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Character character = map1.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    System.out.println(character);

    // second approch in one line
    Character character2 = input1.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
	.stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    System.out.println(character2);

Q.31 Find Common Elements Between Two Lists

    List<Integer> list11 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> list22 = Arrays.asList(3, 4, 5, 6, 7);
    List<Integer> common = list11.stream().filter(list22::contains).toList();
    System.out.println(common);

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 Q.1 Find the longest string in a list of strings using Java streams:
 
    List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
    Optional<String> longestSring = strings.stream().max(Comparator.comparingInt(String::length));
    longestSring.ifPresent(System.out::println);

Q2. Calculate the average age of a list of Person objects using Java streams:

    List<Person> persons =Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 35));
    Double averageAge1 = persons.stream().collect(Collectors.averagingLong(Person::getAge));
    Double averageAge2 = persons.stream().mapToInt(Person::getAge).average().orElse(0);
    System.out.println(averageAge1);
    System.out.println(averageAge2);

Q3. Check if a list of integers contains a prime number using Java streams:

Q4. Merge two sorted lists into a single sorted list using Java streams:

    List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
    List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
    List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
    System.out.println(mergedList);


Q5. Find the intersection of two lists using Java streams:

    List<Integer> list11 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> list22 = Arrays.asList(3, 4, 5, 6, 7);
    // output:[3, 4, 5]
    List<Integer> intersection = list11.stream().filter(list22::contains).toList();
    System.out.println(intersection);

Q6. Remove duplicates from a list while preserving the order using Java
    List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
    List<Integer> duplicatesRemoved = numbersWithDuplicates.stream().distinct().toList();
    System.out.println(duplicatesRemoved);

Q7. Given a list of transactions, find the sum of transaction amounts for each day using Java

    // streams:
    List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
	new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));
    Map<String, Integer> transactionsMap = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
    System.out.println(transactionsMap);

Q8. Given a list of strings, find the frequency of each word using Java streams:

    List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
    Map<String, Long> frequency = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(frequency);

Q9. Given a list of strings, find the count of each word using Java streams:

    List<String> wordss = Arrays.asList("apple", "banana", "cherry");
    Map<String, Long> carecterFrequency = wordss.stream().collect(Collectors.toMap(Function.identity(), ch -> ch.chars().count()));
    // Map<String, Long> carecterFrequency = wordss.stream().collect(Collectors.toMap(str -> str, ch -> ch.chars().count()));
    System.out.println(carecterFrequency);

Q10. Implement a method to partition a list into two groups based on a predicate using Java

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    System.out.println(partition);

Q.12 remove duplicate from string

    String str = "java is programming language";
    String uniqueStr = str.chars().distinct().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
    System.out.println(uniqueStr);

Q.13 Find frequency of each character in a string

    Map<Character, Long> frequency1 = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    // Map<Character, Long> frequency1 = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    System.out.println(frequency1);

Q.13 Find the first non-repeated character in it using Stream functions?

    String input = "Java articles are Awesome J";
    Character firstNonRepeated = input.chars().filter(Character::isLetter).mapToObj(ch -> (char) ch)
        .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).findFirst().orElse(null);
    System.out.println(firstNonRepeated);

Q.14 Find the non-repeated character in it using Stream functions?

    String nonRepeated = input.chars().mapToObj(ch -> String.valueOf((char) ch)).filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).collect(Collectors.joining());
    System.out.println(nonRepeated);

Q.15 Find the first repeated character in it using Stream functions?
    
	String input1 = "Java articles are Awesome";
    Character repeated = input1.chars().mapToObj(ch -> (char) ch).filter(ch -> input1.indexOf(ch) != input1.lastIndexOf(ch)).findFirst().orElse(null);
    System.out.println(repeated);

Q.16 Find duplicates Integer duplicates

    List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
    Set<Integer> duplicates = myList.stream().filter(n -> Collections.frequency(myList, n) > 1).collect(Collectors.toSet());
    System.out.println(duplicates);

Q.17 Find only duplicate elements with its count from the String ArrayList

    List<String> words1 = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
    Map<String, Long> duplicateElements =words1.stream().filter(s -> Collections.frequency(words1, s) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(duplicateElements);

Q.18 Write a program to print the count of each character in a String and preserve order

    String input2 = "string data to count";
    Map<Character, Long> count =input2.chars().filter(Character::isAlphabetic).mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    System.out.println(count);
