package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;


/**
 * Creates unions, intersections, and word counts 
 * @author tasha & allison
 *
 */
public class Challenges {

	/**
	 * Returns the set of all elements in both sets without repeats
	 * @param left
	 * @param right
	 * @return
	 */
	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String thing: left) {
			output.insert(thing);
		}
		for(String thingy: right) {
			if (!left.contains(thingy)) {
				output.insert(thingy);
			}
		}
		
		return output;
	}
	
	/**
	 * Returns a set of the elements in both sets
	 * @param left
	 * @param right
	 * @return
	 */
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String x: left) {
			if (right.contains(x)) {
				output.insert(x);
			}
		}
		return output;
	}
	
	/**
	 * returns a map of the number of times each word appears in a list
	 * @param words
	 * @return
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		for (String thing: words) {
			if (output.get(thing) != null) {
				int count = output.get(thing);
				count += 1;
				output.put(thing, count);
			}
			else if (output.get(thing) == null) {
				output.put(thing, 1);	
			}
		}
		return output;
	}
}
