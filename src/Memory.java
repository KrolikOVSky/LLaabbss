public class Memory<T extends Comparable<T>> {
    private final int MAX_CAPACITY = 512;
    private int memoryLeft = MAX_CAPACITY;
    LinkedList<T> filled = new LinkedList<T>();
    LinkedList<T> empty = new LinkedList<T>();

    public void memInfo() {
        System.out.println("Filled peaces of memory");
        filled.print();
        System.out.println("Empty peaces of memory");
        empty.print();
    }

    public int allocate(int size) {
        if (memoryLeft < size) return -1;
        for (var el : filled) {

        }
        return 0;
    }

    public void freeUp(int size) {

    }

    public int getMemoryLeft() {
        return memoryLeft;
    }

    public void setMemoryLeft(int memoryLeft) {
        this.memoryLeft = memoryLeft;
    }
}
