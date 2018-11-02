class QuickSort{


    public static void quicksort(int arr[], int low, int high){

        if(low < high){
            int partition = partition(arr, low, high);

            quicksort(arr, low, partition - 1);
            quicksort(arr, partition + 1, high);
        }
    }


    public static int partition(int arr[], int low, int high){


        int pivot = arr[high];

        int i = low;

        for(int j = low; j < high ; j++){

            if(arr[j] <= pivot){
                
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);

        return i;
        
    }

    public static void swap(int arr[], int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }


    public static void main(String[] args) {
        int arr[] = {342,46,562,23,234,656,35,324,23,4324,3422,324,32432,4234324,32432,4324324};

        quicksort(arr, 0, arr.length - 1);

        for (int var : arr) {
            System.out.println(var);
            
        }
    }
}