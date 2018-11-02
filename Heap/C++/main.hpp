//heap_type = 1, Max_Heap
//heap_type = 2, Min_Heap

typedef struct Heap{

    int *arr;
    int capacity;
    int count;
    int heap_type;
}Heap;

int LeftChild(Heap *, int);
int RightChild(Heap *, int);
void SwapData(Heap **, int , int );
void InsertMinHeap(Heap *, int );

int GetMaximum(Heap *);
int GetMinimum(Heap *);
int ExtractMin(Heap *);
int Parent(Heap *, int);
Heap * MinHeapFromArray(int *, int);
void MaxHeapify(Heap *, int );
void MinHeapify(Heap *, int );
Heap *CreateHeap(int , int );

void HeapSort(int *, int);
Heap* BuildHeap(int *, int );
