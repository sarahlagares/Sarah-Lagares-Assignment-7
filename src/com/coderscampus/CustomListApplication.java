package com.coderscampus;

public class CustomListApplication {

	public static void main(String[] args) {
		CustomList<String> myCustomList = new CustomArrayList<>();

		// Add elements to the list
		for (int i = 1; i <= 20; i++) {
			myCustomList.add("Element " + i);
		}

		// Validate all the elements 
		for (int i = 0; i < myCustomList.getSize(); i++) {
			System.out.println(myCustomList.get(i));
		}
	}

}
