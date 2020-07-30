class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList(), 0, nums);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> sublist, int k, int[] nums) {
        list.add(new ArrayList(sublist));
        for (int i = k; i < nums.length; i++) {
            sublist.add(nums[i]);
            backtrack(list, sublist, i + 1, nums);
            sublist.remove(sublist.size() - 1);
        }
    }
}
