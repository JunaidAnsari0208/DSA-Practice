import java.util.ArrayList;

public class UnionOfTwoArraysWithDupes {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                addIfNew(ans, a[i]);
                i++;
            } else if (b[j] < a[i]) {
                addIfNew(ans, b[j]);
                j++;
            } else { // a[i] == b[j]
                addIfNew(ans, a[i]);
                i++;
                j++;
            }
        }

        while (i < n1) {
            addIfNew(ans, a[i]);
            i++;
        }

        while (j < n2) {
            addIfNew(ans, b[j]);
            j++;
        }

        return ans;
    }

    // helper to avoid adding duplicates
    private static void addIfNew(ArrayList<Integer> list, int num) {
        if (list.isEmpty() || list.get(list.size() - 1) != num)
            list.add(num);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 3, 5, 6};

        System.out.println(findUnion(a, b)); // ✅ [1, 2, 3, 4, 5, 6]
    }
}
