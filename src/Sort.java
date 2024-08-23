import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static List<Integer> insertionSort(List<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size(); i++) {
            int current = i;
            // gets the smallest element and inserts at current index
            while (current > 0 && unsortedList.get(current) < unsortedList.get(current - 1)) {
                int temp = unsortedList.get(current);
                // swaps current smaller element with the element before it
                unsortedList.set(current, unsortedList.get(current - 1));
                unsortedList.set(current - 1, temp);
                current--;
            }
        }
        return unsortedList;
    }

    public static List<Integer> selectionSort(List<Integer> unsortedList) {
        int n = unsortedList.size();
        for (int i = 0; i < n; i++) {
            // Assume the current position as minimum
            int minIndex = i;

            // Find the minimum element's index from the rest of the list
            for (int j = i; j < n; j++) {
                if (unsortedList.get(j) < unsortedList.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = unsortedList.get(i);

            // Swap the minimum element with the first element
            unsortedList.set(i, unsortedList.get(minIndex));
            unsortedList.set(minIndex, temp);
        }
        return unsortedList;
    }

    public static List<Integer> bubbleSort(List<Integer> unsortedList) {
        int n = unsortedList.size();
        // Iterate through all list elements in reversed order
        for (int i = n - 1; i >= 0; i--) {

            // Track whether a swap occurred in this pass
            boolean swapped = false;
            for (int j = 0; j < i; j++) {

                // Swap if the element found is greater than the next element
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                    swapped = true;
                }
            }

            // If no two elements were swapped, the list is sorted
            if (!swapped)
                return unsortedList;
        }
        return unsortedList;
    }

    public static List<Integer> mergeSort(List<Integer> unsortedList, int start, int end) {
        // Base case: A list of size 1 or 0 is already sorted
        if (end - start <= 1) {
            return unsortedList.subList(start, end);
        }

        // Split the list into left and right halves
        int midpoint = (start + end) / 2;
        List<Integer> leftList = mergeSort(unsortedList, start, midpoint);
        List<Integer> rightList = mergeSort(unsortedList, midpoint, end);

        ArrayList<Integer> resultList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;

        // Merge the sorted left and right lists with two pointers
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            if (leftPointer == leftList.size()) {  // If left list is empty, append element from right
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == rightList.size()) {  // If right list is empty, append element from left
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {  // Append smaller element from left
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else {  // Append smaller element from right
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }

        return resultList;
    }

    public static void quickSort(List<Integer> unsortedList, int start, int end) {
        // If segment is 1 or 0, it's sorted
        if (end - start <= 1)
            return;

        // Using last element as the pivot
        int pivot = unsortedList.get(end - 1);
        int startPtr = start, endPtr = end - 1;

        // Partitioning process
        while (startPtr < endPtr) {
            // Find the next element from the left that is larger than the pivot
            while (unsortedList.get(startPtr) < pivot && startPtr < endPtr) {
                startPtr++;
            }

            // Find the next element from the right that is smaller than or equal to the pivot
            while (unsortedList.get(endPtr) >= pivot && startPtr < endPtr) {
                endPtr--;
            }

            // Swap if pointers haven't met
            if (startPtr != endPtr) {
                int temp = unsortedList.get(startPtr);
                unsortedList.set(startPtr, unsortedList.get(endPtr));
                unsortedList.set(endPtr, temp);
            }
        }

        // Place pivot in its final position
        int temp = unsortedList.get(startPtr);
        unsortedList.set(startPtr, unsortedList.get(end - 1));
        unsortedList.set(end - 1, temp);

        // Sort left and right of the pivot
        quickSort(unsortedList, start, startPtr);
        quickSort(unsortedList, startPtr + 1, end);
    }
}
