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
