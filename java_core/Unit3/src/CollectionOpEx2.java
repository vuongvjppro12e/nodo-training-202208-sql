import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CollectionOpEx2 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value!");
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: " + listOfIntegers.get(listOfIntegers.size() - 1));
            listOfIntegers.forEach(x -> System.out.print(x + "-"));
        };
        myConsumer.accept(12);
    }
}
