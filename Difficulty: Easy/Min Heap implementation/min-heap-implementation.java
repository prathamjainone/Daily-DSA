import java.util.ArrayList;

class minHeap {
    private ArrayList<Integer> heap;

    public minHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);
        heapUp(heap.size() - 1);
    }

    public void pop() {
        if (heap.isEmpty()) return;
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) heapDown(0);
    }

    public int peek() {
        return heap.isEmpty() ? -1 : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    private void heapUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(i) >= heap.get(p)) break;
            swap(i, p);
            i = p;
        }
    }

    private void heapDown(int i) {
        int size = heap.size();
        while (true) {
            int smallest = i;
            int l = 2 * i + 1, r = 2 * i + 2;

            if (l < size && heap.get(l) < heap.get(smallest)) smallest = l;
            if (r < size && heap.get(r) < heap.get(smallest)) smallest = r;

            if (smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}