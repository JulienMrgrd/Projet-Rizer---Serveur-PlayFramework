package utils.recherche.utils;

import utils.RizerUtils;



public final class Similarite {
	
	private int seuil_minimum;
	
	public Similarite(){ }
	
	public Similarite(int seuil){ 
		if(seuil>=0 && seuil<=100) setSeuilMinimum(seuil);
		else setSeuilMinimum(RizerUtils.DEFAULT_SEUIL);
	}
	
	public int similarity(String s1, String s2) {
	    String longer = s1, shorter = s2;
	    if (s1.length() < s2.length()) {
	      longer = s2; shorter = s1;
	    }
	    int longerLength = longer.length();
	    if (longerLength == 0) { return 100; }

	    return (int) (((longerLength - editDistance(longer, shorter)) / (double) longerLength)*100);

	}
	
//	public Set<String> selectNGrams (String term) {
//		int PARTIAL_COUNT = term.length()/3;
//		int PARTIAL_LENGTH = term.length()/3;
//		
//	    Set<String> partialSet = new TreeSet<String>();
//	    int availDistance = Math.max( term.length()-PARTIAL_LENGTH, 0);
//	    //
//	    for (int i = 0; i < PARTIAL_COUNT; i++) {
//	        int pos0 = (PARTIAL_COUNT > 1)  ?
//	                availDistance * i / (PARTIAL_COUNT-1)  :
//	                0;
//	        int pos1 = Math.min( pos0+PARTIAL_LENGTH, term.length());
//	        //
//	        String partial = term.substring( pos0, pos1);
//	        partial = partial.toLowerCase();
//	        //
//	        partialSet.add( partial);
//	    }
//	    return partialSet;
//	}

	public int editDistance(String longer, String shorter) {
		longer = longer.toLowerCase();
		shorter = shorter.toLowerCase();

		int[] costs = new int[shorter.length() + 1];
		for (int i = 0; i <= longer.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= shorter.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (longer.charAt(i - 1) != shorter.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue),
									costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[shorter.length()] = lastValue;
		}
		return costs[shorter.length()];
	}

	public void printSimilarity(String s, String t) {
		System.out.println("La similarit entre "+"\""+s+"\" et \""+t+"\""+" est de "+similarity(s, t)+"%");
	}

	public int getSeuilMinimum() {
		return seuil_minimum;
	}

	public void setSeuilMinimum(int seuil_minimum) {
		this.seuil_minimum = seuil_minimum;
	}
	
}
