public class Inversion {
    /*
     * Counts the number of inversions of a given permutation using
     * the Divide and Conquer paradigm.
     * 
     * @param n The length of the permutation.
     * 
     * @param perm A permutation of the elements [0, 1, ..., n-1]. 
     * That is, those elements 0,1,..., n-1 in some order.
     * 
     * @return The number of inversions of perm.
     */
    public static int countInversions(int n, int[] perm) {
        assert perm.length == n;
        return countInversions(perm, 0, n - 1);
    }

    private static int countInversions(int[] arr, int start, int stop) {
        int inversions = 0;
        if (start < stop) {
            int midpoint = (stop - start) / 2 + start;

            inversions += countInversions(arr, start, midpoint);
            inversions += countInversions(arr, midpoint + 1, stop);

            int[] temp = new int[arr.length];
            int i = start;
            int j = midpoint + 1;
            int curr = start;

            while (i <= midpoint && j <= stop) {
                if (arr[i] <= arr[j]) {
                    temp[curr++] = arr[i++];
                } else {
                    temp[curr++] = arr[j++];
                    inversions += (midpoint - i + 1);
                }
            }
            while (i <= midpoint) {
                temp[curr++] = arr[i++];
            }
            while (j <= stop) {
                temp[curr++] = arr[j++];
            }
            
            for (int p = start; p <= stop; p++) {
                arr[p] = temp[p];
            }
        }
        return inversions;
    }

    /*
     * If you want to write your own tests, put them here.
     */
    public static void main(String[] args) {

    }
}