import java.util.Scanner;

public class Lab_1 {
    private static final Memory rom = new Memory();

    public static void main(String[] args) {
        LinkedList<MemoryData> filled = new LinkedList<>();
        LinkedList<MemoryData> nonFilled = new LinkedList<>();

        var fff = new MemoryData(10, 401);

        MemoryData[] array = {
                new MemoryData(10, 160),
                new MemoryData(20, 170),
                new MemoryData(30, 180),
                new MemoryData(40, 190),
                new MemoryData(50, 200)
        };

        filled.add(new MemoryData(60, 190));
        filled.add(new MemoryData(50, 155));
        filled.add(fff);
        filled.add(new MemoryData(400, 400));
        filled.add(new MemoryData(70, 120));
        filled.add(new MemoryData(80, 160));

//        filled.print();


//        var test = new Memory();

//        test.memInfo();
//        test.allocate(150);
//        test.memInfo();


//        filled.clear();
//        filled.print();
//        filled.addAll(List.of(array));
//        filled.print();
//        filled.sort();
//        filled.remove(0);
//        filled.print();
//        filled.remove(fff);
//        filled.print();

//        System.out.println(filled.getOne(2));


//        for (var el : filled) {
//            System.out.println(el.getClass());
//        }


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


        userInterface();

    }

    public static void userInterface() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("//////////////////////////////////////");
            System.out.println("1. View info about memory");
            System.out.println("2. Allocate some space");
            System.out.println("3. Free up space");
            System.out.println("4. Exit");
            System.out.print("Choose the command: ");
            String command = scanner.next();
            switch (command) {
                case "1":
                    rom.memInfo();
                    break;
                case "2":
                    System.out.println("------------------------");
                    System.out.print("Enter size of space, what you want to allocate: ");
                    rom.allocate(scanner.nextInt());
                    System.out.println("------------------------");
                    break;
                case "3":
                    System.out.println("------------------------");
                    System.out.print("Enter size of space, what you want to free up: ");
                    rom.freeUp(scanner.nextInt());
                    System.out.println("------------------------");
                    break;
                case "4":
                    scanner.close();
                    return;
                default:
                    System.out.println("Wrong command, please try again");
            }
        }
    }
}

