public class Memory {
    private final int MAX_CAPACITY = 512;
    private int memoryLeft = MAX_CAPACITY;
    private final LinkedList<MemoryData> filled = new LinkedList<>();
    private final LinkedList<MemoryData> empty = new LinkedList<>();

    public Memory() {
        empty.add(new MemoryData(0, memoryLeft));
    }

    private void defrag() {
        MemoryData prev;
        MemoryData current;
        LinkedList<MemoryData> fragmented = new LinkedList<>();
        for (int i = 1; i < empty.size(); i++) {
            prev = empty.getOne(i - 1);
            current = empty.getOne(i);
            if (current != null && (current.getAddress() + current.getData()) == (prev.getAddress())) {
                current.setData(current.getData() + prev.getData());
                empty.remove(i);
                empty.remove(i - 1);
                empty.add(current);
                i = 0;
            }
        }
    }

    public void memInfo() {
        System.out.println("*************************************");
        System.out.println("Filled peaces of memory");
        filled.print();
        System.out.println("Empty peaces of memory");
        empty.print();
        System.out.printf("Free space: %sb\n", memoryLeft);
        System.out.println("*************************************");
    }

    /**
     * Method used for allocating some space in memory
     * 
     * @param size Integer
     * @return false if doesn't have any space in memory
     */
    public boolean allocate(int size) {
        if(size > memoryLeft) return false;
        for (var el : empty) {
            if(el.getData() >= size){
                empty.remove(el);
                empty.add(new MemoryData(el.getAddress(), size));
                empty.add(new MemoryData(el.getAddress() + size, el.getData() - size));
                memoryLeft -= size;
                filled.add(new MemoryData(el.getAddress(), size));
                defrag();
                return true;
            }
        }
        return false;
    }

    public void freeUp(int size) {
        boolean flag = false;
        for (var el : filled) {
            if (!flag && el.getData() == size) {
                filled.remove(el);
                empty.add(el);
                memoryLeft += size;
                defrag();
                return;
            }
        }
    }

}
