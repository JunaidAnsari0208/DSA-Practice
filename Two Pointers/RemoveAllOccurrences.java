public class RemoveAllOccurrences {
    static int removeElement(int[] arr, int ele) {
        int l = 0;
        int r = 0;

        // iterate till l scans the whole array
        while (l < arr.length) {
            if (arr[l] != ele) { // keep non-ele elements
                arr[r] = arr[l];
                r++; // move "write" pointer
            }
            l++; // always move "read" pointer
        }

        return r; // new length
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 2, 2, 4, 2};
        int ele = 2;
        System.out.println(removeElement(arr, ele));
    }
}
