import java.util.*;

class Solution {
    public List<Integer> maxMeetings(int[] start, int[] end) {
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new int[]{end[i], start[i], i + 1}); 
        }
        meetings.sort(Comparator.comparingInt(a -> a[0]));
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        for (int[] m : meetings) {
            if (m[1] > lastEnd) { 
                result.add(m[2]); 
                lastEnd = m[0];   
            }
        }
        return result;
    }
}

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        Solution sol = new Solution();
        List<Integer> res = sol.maxMeetings(start, end);

        for (int idx : res) {
            System.out.print(idx + " ");
        }
    }
}
