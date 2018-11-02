import java.util.*;
import javafx.util.Pair;

class PairOfPairComparator implements Comparator<Pair<Integer, Pair<Integer, Integer>>> {

    public int compare(Pair<Integer, Pair<Integer, Integer>> pair1, Pair<Integer, Pair<Integer, Integer>> pair2) {

        return pair1.getKey().compareTo(pair2.getKey());
    }

}

class MergeKArrays {
    public static void main(String[] args) {

        int arr[][] = { { 2, 6, 12 }, { 1, 9 }, { 23, 34, 90, 2000 } };

        ArrayList<Integer> result = mergeKArrays(arr);

        System.out.println("Merged array is");
        result.forEach(k -> System.out.print(k + " "));

    }

    static ArrayList<Integer> mergeKArrays(int[][] arr) {

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<Pair<Integer, Pair<Integer, Integer>>>(
                50, new PairOfPairComparator());

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair<Integer, Pair<Integer, Integer>>(arr[i][0], new Pair<Integer, Integer>(i, 0)));
        }

        while (!pq.isEmpty()) {

            Pair<Integer, Pair<Integer, Integer>> pair = pq.poll();

            int i = pair.getValue().getKey();
            int j = pair.getValue().getValue();

            result.add(pair.getKey());

            if (j + 1 < arr[i].length) {
                pq.add(new Pair<Integer, Pair<Integer, Integer>>(arr[i][j + 1], new Pair<Integer, Integer>(i, j + 1)));
            }
        }

        return result;

    }
}