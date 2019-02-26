package core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Viktoria Angelova
 */

public class ArrayListTest {

	private static ArrayList<Object> arrayList;
	private Object element;

	@Before
	public void setUp() {
		arrayList = new ArrayList<>();
		element = new Object();
	}

	@Test
	public void testAdd_Object() {
		assertTrue(arrayList.add(element));
	}

	@Test(expected = NullPointerException.class)
	public void testAdd_Object_Null() {
		arrayList.add(null);
	}

	@Test
	public void testAdd_ObjectAtIndex() {
		arrayList.add(0, element);
		Object expected = arrayList.get(0);
		assertEquals(expected, element);
	}

	@Test(expected = NullPointerException.class)
	public void testAdd_ObjectAtIndex_Null() {
		arrayList.add(0, null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd_ObjectAtIndex_NegativeIndex() {
		arrayList.add(-1, element);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd_ObjectAtIndex_IndexGreaterThenArrayListSize() {
		arrayList.add(arrayList.size() + 1, element);
	}

	@Test
	public void testRemove_ObjectAtIndex() {
		arrayList.add(0, element);
		Object expected = arrayList.get(0);
		assertEquals(expected, arrayList.remove(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ObjectAtIndex_EmptyArrayList() {
		arrayList.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ObjectAtIndex_NegativeIndex() {
		arrayList.remove(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ObjectAtIndex_indexGreaterThenArrayListSize() {
		arrayList.remove(arrayList.size() + 1);
	}

	@Test
	public void testRemove_Object() {
		arrayList.add(element);
		assertTrue(arrayList.remove(element));
	}

	@Test
	public void testRemove_Object_Nonexistant() {
		assertFalse(arrayList.remove(element));
	}

	@Test(expected = NullPointerException.class)
	public void testRemove_Object_Null() {
		arrayList.remove(null);
	}

	@Test
	public void testContains() {
		arrayList.add(element);
		assertTrue(arrayList.contains(element));
	}

	@Test
	public void testContains_NonexistantObject() {
		assertFalse(arrayList.contains(element));
	}

	@Test
	public void testGet() {
		arrayList.add(0, element);
		Object expected = element;
		assertEquals(expected, arrayList.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_NegativeIndex() {
		arrayList.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_IndexGreaterThenArrayListSize() {
		arrayList.get(arrayList.size() + 1);
	}

	@Test
	public void testIndexOf() {
		arrayList.add(0, element);
		assertEquals(0, arrayList.indexOf(element));
	}

	@Test
	public void testIndexOf_NonexistentObject() {
		assertEquals(-1, arrayList.indexOf(element));
	}

	@Test
	public void testIndexOf_Null() {
		assertEquals(-1, arrayList.indexOf(null));
	}

	@Test
	public void testIsEmpty_EmptyArrayList() {
		assertTrue(arrayList.isEmpty());
	}

	@Test
	public void testIsEmpty_NonEmptyArrayList() {
		arrayList.add(element);
		assertFalse(arrayList.isEmpty());
	}

	@Test
	public void testSize_EmptyArrayList() {
		assertTrue(arrayList.size() == 0);
	}

	@Test
	public void testSize_NonEmptyArrayList() {
		arrayList.add(element);
		assertFalse(arrayList.size() == 0);
	}
}
