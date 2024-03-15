package com.coderscampus;

public class Application {

	public static void main(String[] args) {
		ListCustom<String> myCustomList = new CustomListArray<>();

		// Add elements to the list
		for (int i = 1; i <= 20; i++) {
			myCustomList.add("Element " + i);
		}

		// Validate that all the elements you've inserted actually exist in your data
		// structure
		for (int i = 0; i < myCustomList.getSize(); i++) {
			System.out.println(myCustomList.get(i));
		}
	}

}
