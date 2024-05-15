import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        permute(nums, result, temp);
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result, List<Integer> comb) {
        if (comb.size() == nums.length){
            result.add(new ArrayList(comb)); 
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(comb.contains(nums[i])) continue;
                comb.add(nums[i]);
                permute(nums, result, comb);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
