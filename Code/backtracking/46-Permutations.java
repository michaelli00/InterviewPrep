class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList(), 0, nums, new HashSet());
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> sublist, int k, int[] nums, Set<Integer> set) {
        if (sublist.size() == nums.length) {
            list.add(new ArrayList(sublist));
        }
        for(int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                sublist.add(nums[i]);
                set.add(nums[i]);
                backtrack(list, sublist, i + 1, nums, set);
                sublist.remove(sublist.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
