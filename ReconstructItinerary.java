package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	// basically, its Eulier path
	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
		for (String[] ticket : tickets) {
			String from = ticket[0];
			String to = ticket[1];
			if (!graph.containsKey(from)) {
				graph.put(from, new PriorityQueue<String>());
			}
			graph.get(from).add(to);
		}
		
		List<String> result = new LinkedList<String>();
		topologicSort(graph, "JFK", result);
		return result;
	}
	
	// just go for topologic sort
	public void topologicSort(Map<String, PriorityQueue<String>> graph, String from, List<String> result) {
		PriorityQueue<String> tos = graph.get(from);
		while (!tos.isEmpty()) {
			String to = tos.poll();
			topologicSort(graph, to, result);
		}
		
		result.add(0, from);
	}
}
