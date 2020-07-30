class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> sublist = new ArrayList();
        sublist.add(0);
        backtrack(list, sublist, 0, graph, new HashSet());
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> sublist, int k, int[][] graph, Set<Integer> set) {
        if (k == graph.length - 1) {
            list.add(new ArrayList(sublist));
            return;
        } else {
            for (int n : graph[k]) {
                if (!set.contains(n)) {
                    sublist.add(n);
                    set.add(n);
                    backtrack(list, sublist, n, graph, set);
                    set.remove(n);
                    sublist.remove(sublist.size() - 1);
                }
            }
        }
    }
}
