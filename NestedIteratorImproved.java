package google;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * Actually we do not need to flat the whole thing into stack, we can just keep a Iterator in stack
 * */
public class NestedIteratorImproved implements Iterator<Integer>{
	private Stack<Iterator<NestedInteger>> stack;
	private NestedInteger next = null;

	public NestedIteratorImproved(List<NestedInteger> nestedList) {
		stack = new Stack<Iterator<NestedInteger>>();
		stack.add(nestedList.iterator());
	}

	@Override
	public Integer next() {
		return next.getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().hasNext()) {
			stack.pop();
		}
		
		if (stack.isEmpty()) {
			return false;
		}
		
		next = stack.peek().next();
		if (next.isInteger()) {
			return true;
		}
		
		stack.push(next.getList().iterator());
		return hasNext();
	}

	public static interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(Integer.toBinaryString((int)Math.pow(4, i)));
		}
	}
}
