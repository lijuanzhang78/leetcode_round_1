package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        ArrayList<String> al = new ArrayList<String>();
        
        for(String[] ticket : tickets) {
            al = graph.get(ticket[0]);
            if (al == null) {
                al = new ArrayList<String>();
                graph.put(ticket[0],al);
            }
            al.add(ticket[1]);
        }
        
        for(ArrayList<String> arr : graph.values()) {
            Collections.sort(arr);
        }
        
        ArrayList<String> ans = new ArrayList<String>();
        dfs("JFK", graph, ans, tickets.length+1);
        return ans;
    }
    
    private boolean dfs(String curr, HashMap<String, ArrayList<String>> graph, ArrayList<String> ans, int n) {
        ans.add(curr);
        if (ans.size() >= n) {
            return true;
        }
//      containsKey is to determine if it is the end point
//      isEmpty is to determine if the adj list of some internal point is empty; to avoid repeated visiting the same node
        if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
            return false;
        }

//      ArrayList does not use length()! it uses size()!
        ArrayList<String> arrivals = graph.get(curr);
        for(int i=0; i<arrivals.size(); i++) {
            String arrival = graph.get(curr).remove(i);
            if (dfs(arrival, graph, ans, n)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            arrivals.add(i,arrival);
        }
        return false;
    }

}
