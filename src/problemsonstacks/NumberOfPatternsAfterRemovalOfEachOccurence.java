package problemsonstacks;

import customexceptions.EmptyStackException;

public class NumberOfPatternsAfterRemovalOfEachOccurence {

	public static int calculateNoOfPatterns(String str, String pattern) throws EmptyStackException {

		int patlen = pattern.length();
		StringBuffer sb = new StringBuffer(str);

		int i = 0;
		int j,k;
		int res=0;
		while (i < sb.length()) {
			if (sb.charAt(i) == pattern.charAt(patlen - 1) && i >= patlen - 1) {
				j = patlen - 2;
				k=i-1;
				boolean patternFound=true;
				while (j >= 0) {
					if(pattern.charAt(j)==sb.charAt(k)) {
						j--;
						k--;
					}else {
						patternFound=false;
						break;
					}
				}
				if(patternFound) {
					k++;
					sb.delete(k,k+patlen-1);
					res++;
					i=k;
					continue;
				}
			}
			i++;
		}
		return res;
		// */
	}

	public static void main(String[] args) throws EmptyStackException {
		//String str = "ABABCC";
		String str = "ABABCABCC";
		String pattern = "ABC";
		System.out.println(calculateNoOfPatterns(str, pattern));

	}

}
