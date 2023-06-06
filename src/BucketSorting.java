import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BucketSorting {

    public List<Integer> sort(List<Integer> initialList) {
        final int numberOfBuckets = (int) Math.sqrt(initialList.size());
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = findMax(initialList);

        for (int i : initialList) {
            buckets.get(hash(i, max, numberOfBuckets)).add(i);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();

        for (List<Integer> bucket : buckets) {
            bucket.sort(comparator);
        }

        List<Integer> sortedArray = new LinkedList<>();

        for (List<Integer> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

        return sortedArray;
    }

    private int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

    private int findMax(List<Integer> input) {
        int m = Integer.MIN_VALUE;
        for (int i : input) {
            m = Math.max(i, m);
        }
        return m;
    }

}
