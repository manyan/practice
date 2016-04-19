package google;

/*
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

 * */
public class WildcardMatchingLeetCodeVersion {
	public boolean isMatch(String s, String p) {
	    if (s == null || p == null) return false;
	    return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
	}

	private boolean isMatch(char[] s, int i, char[] p, int j) {
		// base case
	    if (j == p.length) return i == s.length;
	    // normal case, where the next of j is not *
	    if (j == p.length - 1 || p[j + 1] != '*') {
	        if (i < s.length && (p[j] == '.' || s[i] == p[j])) {
	            return isMatch(s, i + 1, p, j + 1);
	        } else {
	            return false;
	        }
	    }
	    
	    // deal with special case, which the following of j is *
	    // and the current j match the current i, try to match as far as we can
	    while (i < s.length && (p[j] == '.' || s[i] == p[j])) {
	        if (isMatch(s, i, p, j + 2)) return true;
	        i++;
	    }
	    
	    // means we start match again from the j+2, and the first digit of S that dose not match the current j
	    return isMatch(s, i, p, j + 2);
	}
	
	public static void main(String[] args) {
		WildcardMatchingLeetCodeVersion w = new WildcardMatchingLeetCodeVersion();
		System.out.println(w.isMatch("aab", "c*a*b"));
	}
}
