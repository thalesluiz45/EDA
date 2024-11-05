package sort;

public class MergeSort {

    public static int[] mergeSort(int[] array, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
        return array;
    }

    public static int[] merge(int[] array, int first, int mid, int last) {
        int n1 = mid - first + 1;
        int n2 = last - mid;

        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            l[i] = array[first + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = array[mid + 1 + j];
        }
        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = first; k <= last; k++) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 4, 9, 1};
        int[] sort = mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}