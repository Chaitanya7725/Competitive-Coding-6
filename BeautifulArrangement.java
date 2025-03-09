import java.util.HashSet;
import java.util.Set;

// TC: O(n) all numbers are traversed
// SC: O(n) set has been used

// Runs successfully on leetcode.
// General idea is to go through each permutation,
// Before calling the backtrack, the criteria is cross checked. hence the recursion will be reduced.
public class BeautifulArrangement {
    static int count;
    static Set<Integer> visited;

    public static void main(String[] args) {
        System.out.println(countArrangement(2)); // 2
        System.out.println(countArrangement(1)); // 1
        System.out.println(countArrangement(3)); // 3
    }

    public static int countArrangement(int n) {
        count = 0;
        visited = new HashSet<>();
        backtrack(n);
        return count;
    }

    private static void backtrack(int n) {
        // base
        if (visited.size() == n) {
            count++;
            return;
        }
        // logic
        int pos = visited.size() + 1;
        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                if (pos % i == 0 || i % pos == 0) {
                    visited.add(i);
                    backtrack(n);
                    visited.remove(i);
                }
            }
        }
    }

}
