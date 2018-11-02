import java.util.*;

class Array {
    public static void main(String[] args) {

        int arr[] = {5, 4, 7, 8, 3};

        System.out.println(kthSmallest(arr, 0, arr.length - 1, 3));
        // int pivotedArr[] = { 7, 8, 1, 2, 3, 4, 5, 6 };

        // int reArrangeArr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        // reArrangeArr(reArrangeArr);

        // for (int var : reArrangeArr) {
        // System.out.println(var);
        // }

        // int sortedAPivotedrr[] = { 11, 13, 6, 8, 9, 10 };

        // findPairsWithSumRotated(sortedAPivotedrr, 19);
        // int sortedArr[] = { 1, 4, 6, 8, 10 };
        // findPairsWithSum(sortedArr, 16);

        // int zeroOneArray[] = { 1, 0, 0, 1, 1, 0, 0, 1, 1, 1 };

        // segregateZeroes(zeroOneArray);

        // for (int var : zeroOneArray) {
        // System.out.println(var);
        // }

        // int zeroOneTwoArray[] = { 1, 0, 0, 2, 1, 0, 2, 1, 2, 1 };

        // segregateZeroOneTwo(zeroOneTwoArray);

        // for (int var : zeroOneTwoArray) {
        // System.out.println(var);
        // }

        // System.out.println(findPivot(pivotedArr, 0, pivotedArr.length - 1));

        // System.out.println(searchInPivotedArray(pivotedArr, 4));

        // System.out.println(searchInPivotedArray(pivotedArr, 4, 0, pivotedArr.length -
        // 1));
        // rotateRight(arr, 2);

        // for (int var : arr) {
        // System.out.println(var);
        // }
    }

    static void reArrangeArr(int arr[]) {
        // for (int i = 0; i < arr.length; i++) {
        // if(arr[i] == -1 || arr[i] == i) continue;
        // else{
        // int x = arr[i];

        // while(arr[x] != -1 && arr[x] != x){
        // int y = arr[x];

        // arr[x] = x;

        // x = y;

        // }

        // arr[x] = x;

        // }

        // }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != -1)
                set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(i))
                arr[i] = i;
            else {
                arr[i] = -1;
            }
        }
    }

    // O(n) time, O(n) space
    static void findPairsWithSumHashSet(int arr[], int sum) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i]))
                System.out.println("x, y: " + (sum - arr[i]) + ", " + arr[i]);
            set.add(arr[i]);
        }
    }

    static void findPairsWithSumRotated(int arr[], int sum) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        int low = pivot + 1;
        int high = pivot;
        int n = arr.length;

        while (low != high) {

            if (arr[low] + arr[high] == sum) {

                System.out.println("x, y: " + (arr[low]) + ", " + arr[high]);
                low = (low + 1) % n;
                // return;

            } else if (arr[low] + arr[high] < sum) {
                low = (low + 1) % n;
            } else {
                high = (high + n - 1) % n;
            }
        }
    }

    static void findPairsWithSum(int arr[], int sum) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            if (arr[low] + arr[high] == sum) {
                System.out.println("x, y: " + (arr[low]) + ", " + arr[high]);
                return;
            } else if (arr[low] + arr[high] < sum) {
                low++;
            } else {
                high--;
            }

        }
    }

    static void reverse(int arr[], int start, int end) {

        int temp;
        while (start < end) {

            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void rotateLeft(int arr[], int d) {
        d = d - 1;
        if (d > 0) {

            reverse(arr, 0, d);
            reverse(arr, d + 1, arr.length - 1);
            reverse(arr, 0, arr.length - 1);
        }

    }

    static void rotateRight(int arr[], int d) {
        d = d - 1;
        if (d > 0) {

            System.out.println("here");
            reverse(arr, 0, arr.length - 1);
            reverse(arr, 0, d);
            reverse(arr, d + 1, arr.length - 1);
        }
    }

    static int binarySearch(int arr[], int low, int high, int element) {
        if (high < low)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == element)
            return mid;

        if (arr[mid] > element)
            return binarySearch(arr, low, mid - 1, element);

        else
            return binarySearch(arr, mid + 1, high, element);
    }

    static int findPivot(int[] arr, int low, int high) {

        if (low > high)
            return -1;
        if (high == low)
            return low;

        int mid = low + (high - low) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;

        if (mid > low && arr[mid - 1] > arr[mid])
            return mid - 1;

        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        else
            return findPivot(arr, mid + 1, high);
    }

    static int searchInPivotedArray(int arr[], int element) {

        int pivotPoint = findPivot(arr, 0, arr.length - 1);
        if (pivotPoint == -1)
            return binarySearch(arr, 0, arr.length - 1, element);

        if (arr[pivotPoint] == element)
            return pivotPoint;
        if (arr[0] <= element) {

            return binarySearch(arr, 0, pivotPoint - 1, element);
        } else {
            return binarySearch(arr, pivotPoint + 1, arr.length - 1, element);
        }

    }

    static int searchInPivotedArray(int arr[], int element, int low, int high) {
        if (high < low)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == element)
            return mid;
        // if first half is sorted
        if (arr[low] < arr[mid]) {

            if (element < arr[mid]) {
                return searchInPivotedArray(arr, element, low, mid - 1);
            }
            return searchInPivotedArray(arr, element, mid + 1, high);
        }

        // else second half must be sorted
        else {
            if (element > arr[mid]) {
                return searchInPivotedArray(arr, element, mid + 1, high);
            }
            return searchInPivotedArray(arr, element, low, mid - 1);
        }
    }

    static void segregateZeroes(int arr[]) {

        int low = 0;
        int high = arr.length - 1;

        while (true) {
            while (arr[low] == 0)
                low++;
            while (arr[high] == 1)
                high--;

            if (low < high) {
                arr[low] = 0;
                arr[high] = 1;
            } else {
                break;
            }

        }

    }

    static void swapArr(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void segregateZeroOneTwo(int arr[]) {

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swapArr(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swapArr(arr, mid, high);
                high--;
            }
        }

    }

    static int kthSmallest(int arr[], int l, int r, int k) {

        // k is smaller than the number oif
        if (k > 0 && k <= r + 1) {

            //int pos = partition(arr, l, r);
            int pos = randomPartition(arr, l, r);

            System.out.println("left: " + l + " r: " + r + " pos: " + pos);

            if (pos == k - 1)
                return arr[pos];

            if (pos > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            return kthSmallest(arr, pos + 1, r, k);




// if (k > 0 && k <= r - l + 1) {

        //       // If position is same as k
        //       if (pos-l == k-1)
        //       return arr[pos];

        //   // If position is more, recur for left subarray
        //   if (pos-l > k-1)
        //       return kthSmallest(arr, l, pos-1, k);

        //   // Else recur for right subarray
        //   return kthSmallest(arr, pos+1, r, k- (pos + 1) + l);
        }

        return Integer.MAX_VALUE;
    }

    static int partition(int arr[], int low, int high) {
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= arr[high]) {
                swapArr(arr, i, j);
                i++;
            }
        }
        swapArr(arr, i, high);

        return i;
    }

    static int randomPartition(int arr[], int l, int r){
        int arrayLength = r - l +1;

        int pivot = (int)(Math.random() * (arrayLength -1)); 
        System.out.println("left: " + l + " r: " + r + " pivot: " + pivot);
        swapArr(arr, l + pivot, r);
        return partition(arr, l, r);
    }

}