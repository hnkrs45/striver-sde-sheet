import java.util.*;

class Solution {

    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            return Double.compare(r2, r1);
        }
    }

    public double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, new ItemComparator());

        int curWeight = 0;
        double finalvalue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalvalue += (arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalvalue;
    }
    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        
        int n = 3, weight = 50;
        Item[] arr = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
        Solution obj = new Solution();
        double ans = obj.fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is: " + String.format("%.2f", ans));
    }
}