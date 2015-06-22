package org.groovy.work;

import groovy.util.GroovyCollections;

import java.util.ArrayList;
import java.util.List;

public class GroovyCollectionTest {
	
	public static void main(String[] args) {
        List<Double> lists = new ArrayList<Double>();
		lists.add(0.2);
		lists.add(0.3);
		lists.add(0.2);

		Object sum = GroovyCollections.sum(lists);
		System.out.println(sum);
	}
}
