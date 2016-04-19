package google;

import java.util.ArrayList;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddressesNew(String s) {
		ArrayList<String> result = new ArrayList<String>();
		restore(s, 0, 0, result, "");
		return result;
	}
	
	private void restore(String s, int p, int part, ArrayList<String> result, String cur) {
		if (p == s.length() && part == 4) {
			result.add(cur.substring(1));
			return;
		}
		
		int remainLength = s.length()-p+1;
		if (remainLength > (4-part) * 3 || remainLength < 4-part) {
			return;
		}
		
		int sum = 0;
		for (int i = p; i < s.length(); i++) {
			sum = sum * 10 + (s.charAt(i) - '0');
			if (sum == 0) {
				restore(s, i+1, part+1, result, cur + ".0");
				break;
			}
			
			if (1 <= sum && sum <= 256) {
				restore(s, i+1, part+1, result, cur + "." + sum);
			}
		}
	}
	
	
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new  ArrayList<String>();
        restoreIpAddresses(s, 0, 0, "", result);
        return result;
    }
    
    private void restoreIpAddresses(String s, int p, int part, String cur, ArrayList<String> result) {
        if (p == s.length() && part == 4) {
            result.add(cur.substring(1));
            return;
        }
        
        // sanity check
        if (part > 4 || p >= s.length() || s.length() - p < 4 - part || s.length() - p > 3*(4-part)) {
            return;
        }
        
        int sum = 0;
        for (int i = p; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum <= 255) {
                restoreIpAddresses(s, i+1, part+1, cur + "." + sum, result);
            }
            if (sum == 0) {
                break;
            }
        }
    }
}
