# java-streams-collection
Sorting-List-Predefind-Objects-(String-Wrapper(Integer))

Default Sorting order

		List<String> list=Arrays.asList("Z","A","M","D","K","S");
		System.out.println("Before Sorting:"+list);//Before Sorting:[Z, A, M, D, K, S]
		Collections.sort(list);
		System.out.println("After Sorting:"+list);//After Sorting:[A, D, K, M, S, Z]

Cutomize Sorting Order

  		Collections.sort(list, (a,b)->b.compareTo(a));
		System.out.println("Customize Sorting:"+list);//Customize Sorting:[Z, S, M, K, D, A]
