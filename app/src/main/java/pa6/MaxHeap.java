package pa6;

// Uncomment the following class to get started
// Implement all methods in the Heap interface

public class MaxHeap implements Heap {
    private int[] data; 
    private int size; 
    private int maxCapacity; 


    public MaxHeap (int capacity){
        this.data = new int[capacity]; 
        this.size = 0; 
        this.maxCapacity = capacity; 
    }

    public void insert(int element){
        if (size == maxCapacity){
            System.out.println("error");
            return;
        }

        data[size] = element; 
        int i = size; 
        size++; 

        int parentIndex = (i - 1 )/2; 
        while (i > 0 && data[i] > data[parentIndex]){
            swap(i, parentIndex); 
            i = parentIndex; 
            parentIndex = (i-1)/2; 
        }
    }

    public int delete() {
        if (size == 0) {
            System.out.println("error.");
            return -1; 
        }

        int rootValue = data[0];

        data[0] = data[size - 1];
        size--;

        maxHeapify(0);

        return rootValue;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1; 
        }
        return data[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void maxHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && data[left] > data[largest]) {
            largest = left;
        }

        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int[] heapSort(int[] array) {
        return array;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.print(); 
        System.out.println(heap.delete()); 
        heap.print(); 
    }

}
