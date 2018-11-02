//https://www.geeksforgeeks.org/insertion-sort/
class InsertionSort {

    public static void sort(int arr[]) {

        int arrLength = arr.length;
        int j;
        int temp;

        for (int i = 1; i < arrLength; i++) {

           
            j = i;
            temp = arr[j];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;

        }
    }

    public static void main(String[] args) {
        int arr[] = { 342, 46, 562, 23, 234, 656, 35, 324, 23, 4324, 3422, 324, 32432, 4234324, 32432, 4324324 };

        sort(arr);

        for (int var : arr) {
            System.out.println(var);

        }
    }
}