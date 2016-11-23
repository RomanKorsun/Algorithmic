package searching.klargest;

/**
 * Created by Roman Korsun on 07.07.2016.
 */
public class KLargestFinder {

    private void swap(int[] array, int firstInd, int secondInd) {
        int temp = array[firstInd];
        array[firstInd] = array[secondInd];
        array[secondInd] = temp;
    }

    /**
     * Finds of k-th largest value
     * @param array - array of values
     * @param k - value that has to be found
     * @return k-th lagrest value
     */
    public int findKthLargest(int[] array, int k) {

        int largest = array[0];

        for (int i = 0; i < k; i++) {
            largest = array[0];
            int largestPosition = 0;
            for (int j = 1; j <= array.length-i-1; j++) {
                if(array[j] > largest) {
                    largest = array[j];
                    largestPosition = j;
                }
            }
            swap(array, array.length-i-1,largestPosition);
        }
        return largest;
    }
}
