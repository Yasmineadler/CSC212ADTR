package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
	
	//Tasha
	@Test
	public void setIndex() {
		ListADT<String> data = makeFullList();
		data.setIndex(2, "e");
		data.setIndex(2, "a");
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("a", "b", "a", "d"));
		assertEquals(data, checkdata);
		}
	
	//Tasha
	@Test
	public void addIndex() {
		ListADT<String> data = makeFullList();
		data.addIndex(4, "e");
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("a", "b", "c", "d", "e"));
		assertEquals(data, checkdata);
		}
	
	//Allison
	@Test
	public void addNotIndex() {
		
		}
	
	//Tasha
	@Test
	public void addBack() {
		ListADT<String> data = makeFullList();
		data.addBack("e");
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("a", "b", "c", "d", "e"));
		assertEquals(data, checkdata);
		
	}
	
	//Allison
	@Test
	public void addBackTwice() {
		ListADT<String> data = makeFullList();
		data.addBack("a");
		ListADT<String> checkData = new JavaList<>(Arrays.asList("a", "b", "c", "d", "a"));
		assertEquals(data, checkData);
	}
	
	//Tasha
	@Test
	public void removeBack() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("a", "b", "c"));
		assertEquals(data, checkdata);
		data.removeBack();
		ListADT<String> checkdata2 = new JavaList<>(Arrays.asList("a", "b"));
		assertEquals(data, checkdata2);
	}
	
	//Allison
	public void removeBackEmpty() {
		ListADT<String> noData = makeEmptyList();
		noData.removeBack();
		ListADT<String> checkNoData = makeEmptyList();
		assertEquals(noData, checkNoData);
		
	}
	
	//Tasha
	@Test
	public void removeIndex() {
		ListADT<String> data = makeFullList();
		data.removeIndex(0);
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("b", "c", "d"));
		assertEquals(data, checkdata);
		data.removeIndex(1);
		ListADT<String> checkdata1 = new JavaList<>(Arrays.asList("b", "d"));
		assertEquals(data, checkdata1);
	}
	
	//Allison
	public void removeIndexEmpty() {
		ListADT<String> noData = makeEmptyList();
		noData.removeIndex(0);
		ListADT<String> checkNoData = makeEmptyList();
		assertEquals(noData, checkNoData);
	}
	
	//Tasha
	@Test
	public void removeFront() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		ListADT<String> checkdata = new JavaList<>(Arrays.asList("b", "c", "d"));
		assertEquals(data, checkdata);
		data.removeFront();
		ListADT<String> checkdata1 = new JavaList<>(Arrays.asList("c", "d"));
		assertEquals(data, checkdata1);
	}
	//Allison
	@Test
	public void removeFrontTwice() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		ListADT<String> checkNoData = new JavaList<>(Arrays.asList("b", "c", "d"));
		assertEquals(data, checkNoData);
		data.removeFront();
		ListADT<String> checkTwiceData = new JavaList<>(Arrays.asList("c", "d"));
		assertEquals(data, checkTwiceData);
	}
}

