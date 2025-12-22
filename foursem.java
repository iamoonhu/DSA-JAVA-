import java.util.*;

public class foursem {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        long T = target;   // ✅ convert target to long

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int low = j + 1;
                int high = n - 1;

                while (low < high) {
                    long sum = (long) nums[i] + nums[j] + nums[low] + nums[high];

                    if (sum == T) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                    else if (sum < T) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(nums, -294967296));
    }
}

