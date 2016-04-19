package google;

// best explanation so far: https://kevinclcn.gitbooks.io/leetcodejava/content/006_zigzag_conversion.html
public class ZigZag {
	public String convert(String s, int nRows) {
		if (s == null || s.isEmpty() || s.length() <= nRows || nRows == 1) {
			return s;
		}
		
		int step = 2 * (nRows - 1);
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < nRows; row++) {
			int next = step - 2*row;
			for (int i = row; i < s.length(); i += step) {
				sb.append(s.charAt(i));
				if (next > 0 && next < step && i + next < s.length()) {
					sb.append(s.charAt(i + next));
				}
			}
		}
		
		return sb.toString();
	}
}
