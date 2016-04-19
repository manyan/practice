package google;

public class Test {
	public boolean isMatch(String S, String P) {
		return isMatch(S.toCharArray(), 0, P.toCharArray(), 0);
	}
	
	private boolean isMatch(char[] S, int i, char[] P, int j) {
		// base case
		if (j == P.length) {
			return i == S.length;
		}
		
		// normal case, next char is not *
		if (j == P.length - 1 || P[j+1] != '*') {
			if (i < S.length && (P[j] == '.' || P[j] == S[i])) {
				return isMatch(S, i+1, P, j+1);
			} else {
				return false;
			}
		}
		
		// handle the next char is *, and we try to match as much as we can
		while (i < S.length && (S[i] == P[j] || P[j] == '.')) {
			if (isMatch(S, i, P, j+2)) {
				return true;
			}
			i++;
		}
		
		// longest * can go
		return isMatch(S, i, P, j+2);
	}
	
	// ? match any single char, * match any sequenece of chars
	public boolean wildcardMatching(String S, String P) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < S.length()) {
			if (j < P.length() && (P.charAt(j) == '?' || P.charAt(j) == S.charAt(i))) {
				j++;
				i++;
			} else if (j < P.length() && P.charAt(j) == '*') {
				star = j;
				j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		
		while (j < P.length() && P.charAt(j) == '*') {
			j++;
		}
		
		return j == P.length();
	}
}
