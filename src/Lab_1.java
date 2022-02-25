import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Lab_1 {
    public static void main(String[] args) {
        LinkedList<MemoryData> filled = new LinkedList<>();
        LinkedList<MemoryData> nonFilled = new LinkedList<>();

        var fff = new MemoryData(10, 40);

        filled.add(new MemoryData(60, 150));
        filled.add(new MemoryData(50, 150));
        filled.add(fff);
        filled.add(new MemoryData(400, 400));
        filled.add(new MemoryData(70, 150));
        filled.add(new MemoryData(80, 150));

        System.out.println(Arrays.toString(filled.toArray()));
        filled.remove(0);
        System.out.println(Arrays.toString(filled.toArray()));
        filled.remove(filled.getFirst());
        System.out.println(Arrays.toString(filled.toArray()));
        filled.remove(fff);
        System.out.println(Arrays.toString(filled.toArray()));





//        nonFilled.add(new MemoryData(4001, 9400));
//        nonFilled.add(new MemoryData(701, 9150));
//        nonFilled.add(new MemoryData(801, 9150));
//        nonFilled.add(new MemoryData(801, 9150));
//        nonFilled.add(new MemoryData(801, 9150));
//        System.out.println(Arrays.toString(nonFilled.toArray(filled.toArray())));


//        filled.print();
//
//        filled.print();
//
//        System.out.println(filled.getOne(5));
//        System.out.println(filled.getOne(1));
//        System.out.println(filled.getOne(4));
//        System.out.println(filled.getOne(40));
//        System.out.println(filled.getOne(6));


//        filled.remove(1);
//        filled.print();
    }

    private static <T> void print(LinkedList<T> list){
        for (var el : list) {
            System.out.println(el);
        }
    }
}

