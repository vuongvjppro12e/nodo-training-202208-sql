import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionOpEx5 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Predicate<Integer> tester = v -> v > 5;
        Consumer<Integer> myConsumer = n -> listOfIntegers.add(n);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Please input a number: ");
            int value = scanner.nextInt();
            if (value < 0){
                break;
            }
            if (tester.test(value)){
                myConsumer.accept(value);
            }
        }
        listOfIntegers.forEach(x -> System.out.print(x + "-"));
    }
    }

