import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<Integer> unsortedList = new ArrayList<>(List.of(5, 3, 4, 1, 2));
        // List<Integer> res = Sort.insertionSort(unsortedList);
        // List<Integer> res = Sort.selectionSort(unsortedList);
        // List<Integer> res = Sort.bubbleSort(unsortedList);

        // List<Integer> res = Sort.mergeSort(unsortedList, 0, unsortedList.size());
        // System.out.println(res);

        // Sort.quickSort(unsortedList, 0, unsortedList.size());
        // System.out.println(unsortedList);

        List<Integer> sortedList = new ArrayList<>(List.of(1, 2, 3, 6, 8));
        int res = Search.binarySearch(sortedList, 6);
        System.out.println(res);
    }
}