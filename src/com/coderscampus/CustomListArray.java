package com.coderscampus;

public class CustomListArray<T> implements ListCustom<T> {
	private Object[] items = new Object[10];
	private int size = 0; // Current number of elements in the list

	@Override
	public boolean add(T item) {
		// Check if backing array is full, if so, double its size
		if (size == items.length) {
			growBackingArray();
		}
		items[size++] = item; // Add the new item and increment size
		return true; // Return true since the addition was successful
	}

	// Method to double the size of the backing array
	private void growBackingArray() {
		int newSize = items.length * 2; // Double the size
		Object[] newItems = new Object[newSize]; // Create a new array with the doubled size
		System.arraycopy(items, 0, newItems, 0, size); // Copy elements from old array to new array
		items = newItems; // Replace old array with new array
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		// Check if index is valid
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (T) items[index];
	}

}
