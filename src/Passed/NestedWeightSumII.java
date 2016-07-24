package Passed;

public class NestedWeightSumII {
	int maxLevel = Integer.MIN_VALUE;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        dfs(nestedList, map, 0);
        
        Set<Integer> keyset = map.keySet();
        int sum = 0;
        for(Integer level : keyset) {
            List<Integer> list = map.get(level);
            for(Integer i : list) {
                sum += i * (maxLevel - level + 1);
            }
        }
        return sum;
    }
    
    void dfs(List<NestedInteger> nestedList, Map<Integer, List<Integer>> map, int level) {
        
        for(NestedInteger intlist : nestedList) {
            if (intlist.isInteger()) {
                if(map.containsKey(level)) {
                    map.get(level).add(intlist.getInteger());
                } else {
                    map.put(level, new ArrayList<Integer>());
                    map.get(level).add(intlist.getInteger());
                }
            } else {
                dfs(intlist.getList(), map, level+1);
            }
        }
        
        maxLevel = Math.max(maxLevel, level);
    }
}
