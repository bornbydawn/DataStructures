import java.util.*;

abstract class Heap {
    int arr[];
    int capacity;
    int count;
    int heapType;

    public Heap(int arr[], int heapType) {

        if (heapType != 1 && heapType != 0) {
            System.out.println("Invalid heapType given, give 0 for minHeap and 1 for maxHeap");
            return;
        }
        this.arr = arr;
        count = arr.length;
        this.capacity = arr.length;
        this.heapType = heapType;
    }

    public Heap(int arr[], int size, int heapType) {

        if (heapType != 1 && heapType != 0) {
            System.out.println("Invalid heapType given, give 0 for minHeap and 1 for maxHeap");
            return;
        }
        this.arr = arr;
        count = size;
        this.capacity = arr.length;
        this.heapType = heapType;
    }

    int getLeftChild(int i) {

        int leftChild = 2 * i + 1;
        if (leftChild >= this.count)
            return -1;
        return leftChild;
    }

    int getRightChild(int i) {
        int rightChild = 2 * i + 2;
        if (rightChild >= this.count)
            return -1;
        return rightChild;
    }

    int getParent(int i) {
        if (i <= 0 || i >= this.count)
            return -1;
        return (i - 1) / 2;
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void resizeHeap() {
        int arrNew[] = new int[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            arrNew[i] = this.arr[i];
        }
        this.capacity *= 2;
        this.arr = arrNew;
    }

}

class MaxHeap extends Heap {

    public MaxHeap(int arr[]) {
        super(arr, 1);
        heapify();
    }

    public MaxHeap(int arr[], int size) {
        super(arr, size, 1);
        heapify();
    }

    public void insert(int data) {
        if (this.count == this.capacity)
            resizeHeap();
        this.count++;
        int i = this.count - 1;
        while (i > 0 && data > this.arr[(i - 1) / 2]) {
            this.arr[i] = this.arr[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        this.arr[i] = data;
    }

    public void percolateDown(int i) {

        int leftChild = getLeftChild(i);
        int rightChild = getRightChild(i);

        int max = 0;
        if (leftChild != -1 && this.arr[leftChild] > arr[i])
            max = leftChild;
        else
            max = i;
        if (rightChild != -1 && this.arr[rightChild] > arr[max])
            max = rightChild;

        if (i != max) {
            swap(this.arr, i, max);
            // do the same again after swapping. note that the element which we sent down is
            // at max now;
            percolateDown(max);
        }
        // else this element already satisfies heap property
    }

    public void heapify() {

        for (int i = (this.count - 2) / 2; i >= 0; i--)
            percolateDown(i);
    }

    public int extractMax() {
        int max = this.arr[0];
        this.arr[0] = this.arr[this.count - 1];
        this.count--;
        percolateDown(0);

        return max;
    }

    public void sort() {
        int originalCount = this.count;
        while (this.count > 1) {
            swap(this.arr, 0, --this.count);
            // this.count--;
            percolateDown(0);
        }

        this.count = originalCount;
    }

    public static int kthSmallest(int k, int arr[]) {

        MaxHeap heap = new MaxHeap(arr, k);

        for (int i = k; i <= arr.length - 1; i++) {

            if (arr[i] < heap.arr[0]) {

                heap.swap(heap.arr, i, 0);
                heap.percolateDown(0);
            }

        }

        return heap.arr[0];

    }
}

class MinHeap extends Heap {

    public MinHeap(int arr[]) {

        super(arr, 0);
        heapify();
    }

    public void percolateDown(int i) {

        int leftChild = getLeftChild(i);
        int rightChild = getRightChild(i);

        int min = Integer.MAX_VALUE;

        if (leftChild != -1 && this.arr[leftChild] < this.arr[i])
            min = leftChild;
        else
            min = i;
        if (rightChild != -1 && this.arr[rightChild] < this.arr[min])
            min = rightChild;

        if (min != i) {
            swap(arr, i, min);
            percolateDown(min);
        }

    }

    public void heapify() {

        for (int i = (this.count - 2) / 2; i >= 0; i--)
            percolateDown(i);

    }

    // this will sort in descending order
    public void sort() {

        int originalCount = this.count;
        while (this.count > 1) {
            swap(arr, --this.count, 0);
            // this.count --;
            percolateDown(0);
        }

        this.count = originalCount;
    }

    public static int kthSmallest(int k, int arr[]){
        MinHeap minHeap = new MinHeap(arr);
        int kthSmallest = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
          kthSmallest =  minHeap.extractMin();
        }

        return kthSmallest;
    }

    public int extractMin() {
        int min = this.arr[0];

        this.arr[0] = this.arr[this.count - 1];
        this.count--;
        percolateDown(0);

        return min;
    }
}