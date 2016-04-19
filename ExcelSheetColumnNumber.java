package google;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
        	return 0;
        }
        
        int result = 0;
        int L = s.length();
        for (int i = 0; i < L; i++) {
        	result = result * 26 + (s.charAt(i) - 'A') + 1;
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("AC"));
	}
}
