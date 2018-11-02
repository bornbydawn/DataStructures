public class Main{
    public static void main(String[] args) {
         int arr[] = {1,2,3,4,5,6,7,8,0};
        // MaxHeap maxHeap = new MaxHeap(arr);

        // maxHeap.insert(9);

        // System.out.println("max: " + maxHeap.extractMax());
        // maxHeap.sort();
        
        // for(int i = 0; i < maxHeap.count; i++){
        //     System.out.println(maxHeap.arr[i]);
        // }


        //MinHeap minHeap = new MinHeap(arr);

        //System.out.println("min: " + minHeap.extractMin());

        //minHeap.sort();

        //  for(int i = 0; i < minHeap.count; i++){
        //     System.out.println(minHeap.arr[i]);
        // }

        System.out.println(MaxHeap.kthSmallest(9, arr)); 

        System.out.println(MinHeap.kthSmallest(9, arr)); 

    }
}