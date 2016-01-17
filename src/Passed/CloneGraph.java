package Passed;

public class CloneGraph {
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null) {
	            return null;
	        }
	        
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	        map.put(node,copy);
	        helper(node,map);
	        
	        return copy;
	    }
	    
	    private void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
	        for(int i = 0; i < node.neighbors.size(); i++) {
	            UndirectedGraphNode  curr = node.neighbors.get(i);
	            if(!map.containsKey(curr)) {
	                UndirectedGraphNode copy = new UndirectedGraphNode(curr.label);
	                map.put(curr,copy);
	                helper(curr, map);
	            }
	            map.get(node).neighbors.add(map.get(curr));
	        }
	    }
}
