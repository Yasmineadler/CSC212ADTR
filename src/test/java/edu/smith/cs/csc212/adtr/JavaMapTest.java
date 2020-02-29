package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}
	@Test
	public void testSize() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		assertEquals(two.size(), 1);
		two.put("banana", "10");
		assertEquals(two.size(), 2);
	}
	
	
	//Tasha
	@Test
	public void testPut() {
		MapADT<String, String> one = new JavaMap<>();
		one.put("apple", "6");
		assertEquals(one.size(), 1);
	}
	
	//Tasha
	@Test
	public void testPutTwo() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		two.put("apple", "10");
		
		MapADT<String, String> one = new JavaMap<>();
		one.put("apple", "10");
		
		assertEquals(one, two);	
	}
	
	//Tasha
	@Test
	public void testGet() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		two.put("banana", "10");
		two.put("banana", "20");
		
		assertEquals(two.get("banana"), "20");	
		assertEquals(two.get("apple"), "6");
	}
	
	
	//Tasha
	@Test
	public void testNotGet() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		assertEquals(two.get("banana"), null);
		assertEquals(two.get("apple"), "6");
	}
	
	//Tasha
	@Test
	public void testRemove() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		two.put("banana", "10");
		two.remove("apple");
		
		assertEquals(two.get("apple"), null);	
		assertEquals(two.get("banana"), "10");
	}

	//Tasha
	@Test
	public void testNotRemove() {
		MapADT<String, String> two = new JavaMap<>();
		two.put("apple", "6");
		two.put("banana", "10");
		two.remove("pear");
		
		assertEquals(two.size(), 2);
		assertEquals(two.get("pear"), null);
	}
}

