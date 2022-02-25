public class Lab_1 {
    public static void main(String[] args) {
        LinkedList<MemoryData> filled = new LinkedList<>();

        filled.add(new MemoryData(60, 150));
        filled.add(new MemoryData(50, 150));
        filled.add(new MemoryData(10, 40));
        filled.add(new MemoryData(400, 400));
        filled.add(new MemoryData(70, 150));
        filled.add(new MemoryData(80, 150));
        filled.print();

        filled.print();

        System.out.println(filled.getOne(5));
        System.out.println(filled.getOne(1));
        System.out.println(filled.getOne(4));
        System.out.println(filled.getOne(40));
        System.out.println(filled.getOne(6));


//        filled.remove(1);
//        filled.print();
    }
}

