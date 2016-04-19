package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	public class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null) {
			return null;
		}
		
		if (map.containsKey(node)) {
			return map.get(node);
		}
		
		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
		map.put(node, cloned);
		for (UndirectedGraphNode adj : node.neighbors) {
			if (map.containsKey(adj)) {
				cloned.neighbors.add(map.get(adj));
			} else {
				cloned.neighbors.add(cloneGraph(adj, map));
			}
		}
		
		return cloned;
	}
}
