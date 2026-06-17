import java.util.*;

class Solution {
    // Helper function to check if a substring is a palindrome
    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Backtracking function to generate partitions
    private void func(int ind, String s, List<List<String>> ans, List<String> arr) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(arr)); // Create a copy of the current list
            return;
        }
        
        for (int j = ind; j < s.length(); j++) {
            if (check(s, ind, j)) {
                // Java's substring end index is exclusive: (start, end + 1)
                String substring = s.substring(ind, j + 1);
                arr.add(substring);
                
                func(j + 1, s, ans, arr);
                
                arr.remove(arr.size() - 1); // Backtrack (equivalent to pop_back())
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        func(0, s, ans, arr);
        return ans;
    }
}

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabaa";
        Solution sol = new Solution();
        List<List<String>> ans = sol.partition(s);
        
        // Printing the output
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println(); // New line for each unique partition setup
        }
    }
}