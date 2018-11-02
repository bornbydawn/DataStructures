class SelectionSort{

    public static void sort(int arr[]){

        int arrLength = arr.length;
        int minIndex = 0;
        int temp;

        for(int i = 0; i < arrLength - 1; i++){

            minIndex = i;
            for(int j = i+1; j < arrLength; j++){

                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    public static void main(String[] args) {
        int arr[] = {342,46,562,23,234,656,35,324,23,4324,3422,324,32432,4234324,32432,4324324};

        sort(arr);

        for (int var : arr) {
            System.out.println(var);
            
        }
    }
}