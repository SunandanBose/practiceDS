import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(candidates, target, result, temp, 0);
        return result;
    }

    public void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start) {
        if (target == 0)
            result.add(new ArrayList(temp));
        else if (target > 0) {
            for(int i = start; i < candidates.length; i++) {
                if(candidates[i] <= target) {
                    temp.add(candidates[i]);
                    combinationSum(candidates, target - candidates[i], result, temp, i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
