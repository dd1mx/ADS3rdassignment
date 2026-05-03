import java.util.*;
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> fruits = new BST<>();
        fruits.put(10, "Apple");
        fruits.put(5, "Banana");
        fruits.put(15, "Cherry");

        System.out.println("Size before delete: " + fruits.size());

        for (var elem : fruits.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        fruits.delete(5);
        System.out.println("\nSize after delete: " + fruits.size());

        for (var elem : fruits.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        System.out.println("\n--- Тест MyHashTable ---");

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(101);

        MyTestingClass testKey = new MyTestingClass(666, 777);
        Student testStudent = new Student("John Lennon", 3.8);

        table.put(testKey, testStudent);

        System.out.println("Check get(): " + table.get(testKey));
        System.out.println("Check contains(testStudent): " + table.contains(testStudent));
        System.out.println("Check getKey(): " + table.getKey(testStudent));

        System.out.println("Size before remove: " + table.size());
        Student removedValue = table.remove(testKey);
        System.out.println("Removed student: " + removedValue);
        System.out.println("Size after remove: " + table.size());
        System.out.println("get() after remove: " + table.get(testKey));

        System.out.println("\n--- Запуск теста с объектами Student ---");
        Random rand = new Random();

        for (int i = 1; i <= 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(100000), rand.nextInt(1000));
            Student student = new Student("Student " + i, 2.0 + (2.0 * rand.nextDouble()));

            table.put(key, student);
        }

        System.out.println("Размер таблицы: " + table.size());
        System.out.println("\n--- Статистика бакетов ---");
        table.printBucketSizes();
    }

}