package utils.recherche.utils;

import java.util.Set;
import java.util.TreeSet;


public final class Similarite {
	
	public static final int SEUIL_MINIMUM = 40; // en %
	
	public static int similarity(String s1, String s2) {
	    String longer = s1, shorter = s2;
	    if (s1.length() < s2.length()) {
	      longer = s2; shorter = s1;
	    }
	    int longerLength = longer.length();
	    if (longerLength == 0) { return 100; }

	    return (int) (((longerLength - editDistance(longer, shorter)) / (double) longerLength)*100);

	}
	
	public static Set<String> selectNGrams (String term) {
		int PARTIAL_COUNT = term.length()/3;
		int PARTIAL_LENGTH = term.length()/3;
		
	    Set<String> partialSet = new TreeSet<String>();
	    int availDistance = Math.max( term.length()-PARTIAL_LENGTH, 0);
	    //
	    for (int i = 0; i < PARTIAL_COUNT; i++) {
	        int pos0 = (PARTIAL_COUNT > 1)  ?
	                availDistance * i / (PARTIAL_COUNT-1)  :
	                0;
	        int pos1 = Math.min( pos0+PARTIAL_LENGTH, term.length());
	        //
	        String partial = term.substring( pos0, pos1);
	        partial = partial.toLowerCase();
	        //
	        partialSet.add( partial);
	    }
	    return partialSet;
	}

	public static int editDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue),
									costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}

	public static void printSimilarity(String s, String t) {
		System.out.println("La similarit entre "+"\""+s+"\" et \""+t+"\""+" est de "+similarity(s, t)+"%");
	}
}
