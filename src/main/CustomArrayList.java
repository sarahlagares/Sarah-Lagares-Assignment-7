package main;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException{
		//Assigment5: double array size
		if (size == items.length) {
			items = Arrays.copyOf(items, items.length * 2);
		}
		//throw index out bounds exception:
		throwIndexException(index);
		//insert an item at a specific index in the list
		for(int i = size -1; i >= index; i--){
			items[i + 1] = items [i];
		}
		items[index] = item;
		size ++;
		//System.out.println("capacity: " + items.length);
		return true;
	}

	@Override
	public boolean add(T item) {
		return add (size, item);
	}

	@Override
	public int getSize() {

		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];
	}
	@SuppressWarnings("unchecked") // warning for unchecked cast. situation from stackoverflow :)
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		throwIndexException(index);
		T item = (T) items[index];
		items[index] = null;
		for (int i=index; i < size -1; i++) {
			items[i] = items[i + 1];
		}
		items[size - 1] = null;
		size--;

		return item;
	}
	private void throwIndexException(int index) {
		if(index > size || index < 0) throw new IndexOutOfBoundsException();
	}
}
