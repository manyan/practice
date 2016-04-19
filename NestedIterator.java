package google;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	private Stack<NestedInteger> stack;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<NestedInteger>();
		addToStack(nestedList);
	}
	
	private void addToStack(List<NestedInteger> nestedList) {
		for (int i = nestedList.size()-1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().isInteger()) {
			addToStack(stack.pop().getList());
		}
		
		return !stack.isEmpty();
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
}
