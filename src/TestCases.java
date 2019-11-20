import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCases {
    public static void main(String[] args) {
        int arr[] = {12, 8, 11, 14, 15, 16, 13, 10};
        System.out.println(nthSmallest3(arr, 5));
//        System.out.println(min2(arr));
    }

    static int nthSmallest(int arr[], int n) {
        if (n > arr.length)
            System.out.println("Please enter valid input");
        for (int index = 0; index < arr.length; index++) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[index] > arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr[n - 1];
    }

    static int nthSmallest1(int arr[], int n) {
        if (n > arr.length)
            System.out.println("Please enter valid input");
        int index = 0;
        boolean isAllSorted = false;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] > arr[i] && i == index + 1) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            } else if (arr[index] > arr[i]) {
                int temp = arr[index];
                arr[index] = arr[i];
                int j = 1;
                int temp1 = 0;
                while (j <= i) {
                    if (j == 1) {
                        arr[index + j] = temp;
                    } else {
                        arr[index + j] = temp1;
                    }
                    temp1 = arr[index + j];
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        if (isAllSorted)
            return arr[n - 1];
        else
            return nthSmallest(arr, n);
    }

    static int min2(int arr[]) {
        int min = arr[0];
        int min2 = arr[1];

        if (min2 < min) {
            min = min2;
            min2 = min;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < min) {
                min2 = min;
                min = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }

        return min2;
    }

    static int nthSmallest3(int arr[], int n) {
        int start = 0;
        int end = arr.length - 1;
        int arrNew[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                arrNew[start] = arr[i];
                start++;
            } else {
                arrNew[end] = arr[i];
                end--;
            }

        }
        System.out.println(Arrays.toString(arrNew));
        if (arrNew.length == 1) {
            return arrNew[start];

        } else if (n > start && arrNew.length > start) {
            return nthSmallest3(Arrays.copyOfRange(arrNew, start, arrNew.length), n - start);
        } else if (n <= start && start > 1) {
            return nthSmallest3(Arrays.copyOfRange(arrNew, 0, arrNew.length), n);
        } else {
            return arrNew[start - 1];
        }
    }


    static int nthLargest(int arr[], int n) {
        int start = 0;
        int end = arr.length - 1;
        int arrNew[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                arrNew[start] = arr[i];
                start++;
            } else {
                arrNew[end] = arr[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(arrNew));
        if (n <= start) {
            return nthLargest(Arrays.copyOfRange(arrNew, 0, start), n);
        } else if (n > start && arrNew.length > n) {
            return nthLargest(Arrays.copyOfRange(arrNew, start, arrNew.length), n - start);
        } else {
            return arrNew[start];
        }
    }


    static int nthSmallestOrLargest(int arr[], int n, boolean isLargest) {
        int start = 0;
        int end = arr.length - 1;
        int arrNew[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isLargest) {
                if (arr[i] > arr[index]) {
                    arrNew[start] = arr[i];
                    start++;
                } else {
                    arrNew[end] = arr[i];
                    end--;
                }
            } else {
                if (arr[i] < arr[index]) {
                    arrNew[start] = arr[i];
                    start++;
                } else {
                    arrNew[end] = arr[i];
                    end--;
                }
            }
        }

        System.out.println(Arrays.toString(arrNew));
        if (n > start && arrNew.length > n) {
            return nthSmallest3(Arrays.copyOfRange(arrNew, start, arrNew.length), n - start);
        } else if (n <= start) {
            if (!isLargest)
                start++;
            return nthSmallest3(Arrays.copyOfRange(arrNew, 0, start), n);
        } else {
            return arrNew[start];
        }
    }

}
