package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		Map<Character, List<Character>> map = generateMapping();
		List<String> result = new LinkedList<String>();
		letterCombinations(digits, 0, result, "", map);
		return result;
	}
	
	private void letterCombinations(String digits, int p, List<String> result, String solution, Map<Character, List<Character>> map) {
		if (p == digits.length()) {
			if (!solution.isEmpty()) {
				result.add(solution);
			}
			return;
		}
		
		char cur = digits.charAt(p);
		List<Character> chars = map.get(cur);
		for (char c : chars) {
			letterCombinations(digits, p+1, result, solution + c, map);
		}
	}
	
	private Map<Character, List<Character>> generateMapping() {
		Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
		List<Character> tmp = new LinkedList<Character>();
		tmp.add('a');
		tmp.add('b');
		tmp.add('c');
		map.put('2', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('d');
		tmp.add('e');
		tmp.add('f');
		map.put('3', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('g');
		tmp.add('h');
		tmp.add('i');
		map.put('4', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('j');
		tmp.add('k');
		tmp.add('l');
		map.put('5', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('m');
		tmp.add('n');
		tmp.add('o');
		map.put('6', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('p');
		tmp.add('q');
		tmp.add('r');
		tmp.add('s');
		map.put('7', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('t');
		tmp.add('u');
		tmp.add('v');
		map.put('8', tmp);
		
		tmp = new LinkedList<Character>();
		tmp.add('w');
		tmp.add('x');
		tmp.add('y');
		tmp.add('z');
		map.put('9', tmp);
		
		tmp = new LinkedList<Character>();
		map.put('0', tmp);
		
		tmp = new LinkedList<Character>();
		map.put('1', tmp);
		
		return map;
	}
}
