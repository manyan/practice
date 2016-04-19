package google;

/*
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Subscribe to see which companies asked this question
 * */
public class StrStr {
	// based on kmp
	public int strStr(String haystack, String needle) {
		if (haystack == null || haystack.isEmpty()) {
			return needle == null || needle.isEmpty() ? 0 : -1;
		}
		if (needle == null || needle.isEmpty()) {
			return 0;
		}
		
		int[] next = prepare(needle);
		int i = 0;
		int j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		
		if (j == needle.length()) {
			// found!
			return i - j;
		} else {
			return -1;
		}
	}
	
	private int[] prepare(String pattern) {
		int L = pattern.length();
		int[] next = new int[L];
		int i = 0;
		int j = -1;
		next[0] = -1;
		while (i < L - 1) {
			if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
				next[++i] = ++j;
 			} else {
 				j = next[j];
 			}
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		StrStr s = new StrStr();
		System.out.print(s.strStr("", ""));
	}
}
