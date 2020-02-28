package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSize() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Gecko");
		assertEquals(pets.size(), 1);
		pets.insert("Fish");
		assertEquals(pets.size(), 2);
	}
	
	@Test
	public void testInsertOneThing() {
		SetADT<String> one = new JavaSet<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}

	@Test
	public void testInsertRepeated() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Dog");
		assertEquals(pets.size(), 1);
		pets.insert("Cat");
		assertEquals(pets.size(), 2);
		pets.insert("Dog");
		assertEquals(pets.size(), 2);
		assertEquals(true, pets.contains("Dog"));
		assertEquals(true, pets.contains("Cat"));


	}
	
	@Test
	public void testRemove() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Dog");
		assertEquals(pets.size(), 1);
		pets.insert("Cat");
		assertEquals(pets.size(), 2);
		pets.remove("Dog");
		assertEquals(pets.size(), 1);
		assertTrue(pets.contains("Cat"));
		assertFalse(pets.contains("Dog"));
	}
	
	@Test
	public void testNotRemove() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Dog");
		assertEquals(pets.size(), 1);
		pets.insert("Cat");
		assertEquals(pets.size(), 2);
		pets.remove("Gecko");
		assertEquals(pets.size(), 2);
		assertTrue(pets.contains("Dog"));
		assertTrue(pets.contains("Cat"));
		assertFalse(pets.contains("Gecko"));
	}
	
	@Test
	public void testContains () {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Cat");
		assertEquals(pets.size(), 1);
		assertTrue(pets.contains("Cat"));
	}
	
	@Test
	public void testNotContains() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("Gecko");
		assertEquals(pets.size(), 1);
		assertFalse(pets.contains("Dog"));
	}
	
	
	

	
	
}
