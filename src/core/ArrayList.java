package core;

import java.util.Objects;

/**
 * Implementation of ArrayList<E> with it's basic methods
 * 
 * @author Viktoria Angelova
 * @param <E> the type of the element stored in the ArrayList
 */

public class ArrayList<E> {

	private Object[] array;
	private int count;
	private static final int INITIAL_CAPACITY = 10;

	/**
	 * Constructs an ArrayList with initial capacity of 10.
	 */
	public ArrayList() {
		array = new Object[INITIAL_CAPACITY];
		count = 0;
	}

	/**
	 * Constructs an ArrayList with specified capacity.
	 * 
	 * @param initialCapacity the initial capacity of the ArrayList
	 * @throws IllegalArgumentException if the specified capacity is less or equal
	 *                                  to 0
	 */
	public ArrayList(final int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException();
		}
		array = new Object[initialCapacity];
		count = 0;
	}

	/**
	 * Adds an element to the ArrayList at the next available index.
	 * 
	 * @param element The element to add
	 * @return true if the element is added successfully
	 * @throws NullPointerException if the element is null
	 */
	public boolean add(final E element) {
		add(count, element);
		return true;
	}

	/**
	 * Adds an element at the specified index and reorders the rest of the elements.
	 * If the list capacity is full it doubles it's size.
	 * 
	 * @param index   the index at which to add the element
	 * @param element the element to add
	 * @throws IndexOutOfBoundsException if the index does not exist
	 * @throws NullPointerException      if the element is null
	 */
	public void add(final int index, final E element) {
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Objects.requireNonNull(element);
		Object[] newArray = array;

		if (index + 1 == array.length) {
			newArray = new Object[array.length * 2];
		}

		System.arraycopy(array, 0, newArray, 0, index);
		System.arraycopy(array, index, newArray, index + 1, array.length - 1 - index);
		newArray[index] = element;
		array = newArray;
		count++;
	}

	/**
	 * Gets the element at the specified index. Iterates over the list and reorders
	 * the rest of the elements.
	 * 
	 * @param index the index from which to remove the element
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if the index does not exist
	 */
	public E remove(final int index) {
		E removedElement = get(index);
		for (int i = index; i <= count; i++) {
			array[i] = array[i + 1];
		}
		count--;
		return removedElement;
	}

	/**
	 * Iterates over the list, finds the specified element, reorders the rest of the
	 * elements.
	 * 
	 * @param element the element to remove
	 * @return true if the element is removed successfully
	 * @throws NullPointerException if The element is null
	 */
	public boolean remove(final E element) {
		Objects.requireNonNull(element);
		if (contains(element)) {
			for (int i = 0; i <= count; i++) {
				if (array[i].equals(element)) {
					for (int j = i; j < count; j++) {
						array[j] = array[j + 1];
					}
					count--;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Checks if the array contains the specified element.
	 * 
	 * @param element the element to check
	 * @return true if the array contains the element
	 */
	public boolean contains(final E element) {
		return indexOf(element) >= 0;
	}

	/**
	 * Gets the element at a specified index.
	 * 
	 * @param index the index of the required element
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index does not exist
	 */
	@SuppressWarnings("unchecked")
	public E get(final int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (E) array[index];
	}

	/**
	 * Gets the index of an element in the array.
	 * 
	 * @param element the element at the required index
	 * @return the index at which is placed the specified element or -1 if there is
	 *         no such element in the array
	 */
	public int indexOf(final E element) {
		for (int i = 0; i < count; i++) {
			if (array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Checks if the ArrayList is empty.
	 * 
	 * @return true if the array is empty
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * @return The size of the ArrayList
	 */
	public int size() {
		return count;
	}

}
