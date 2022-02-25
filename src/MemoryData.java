public class MemoryData implements Comparable<MemoryData> {
    private int address;
    private int data;
    final String FORMAT = "|%s|%s|";

    public MemoryData(int address, int data) {
        this.address = address;
        this.data = data;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, address, data);
    }

    @SuppressWarnings("UseCompareMethod")       //todo delete ignoring
    @Override
    public int compareTo(final MemoryData memoryData) {
        if (this.data < memoryData.getData()) return -1;
        if (this.data > memoryData.getData()) return 1;
        return 0;
    }

}