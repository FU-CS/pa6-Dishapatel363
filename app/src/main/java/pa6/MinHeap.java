package pa6;

// Uncomment the following class to get started

public class MinHeap implements Heap {
    private int[] data;   
    private int size;     
    private int maxCapacity; 

    public MinHeap(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
        this.maxCapacity = capacity;
    }

    public void insert(int element) {
        if (size == maxCapacity) {
            System.out.println("Heap is full. Cannot insert element.");
            return;
        }

        data[size] = element;
        int i = size;
        size++;
        int parentIndex = (i - 1) / 2;
        while (i > 0 && data[i] < data[parentIndex]) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = (i - 1) / 2;
        }
    }

    @Override
    public int delete() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete element.");
            return -1; // Return a sentinel value indicating an error
        }

        int rootValue = data[0];

        data[0] = data[size - 1];
        size--;

        minHeapify(0);

        return rootValue;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1; 
        }
        return data[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void minHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < size && data[left] < data[smallest]) {
            smallest = left;
        }

        if (right < size && data[right] < data[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
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
        MinHeap heap = new MinHeap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.print(); 

        System.out.println(heap.delete()); 
        heap.print(); 
    }
}
