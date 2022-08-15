package Unit1;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(args[0]);
        Person person2 = new Person(args[1]);
        System.out.println("person 1's name is "+person1.getName());
        System.out.println("person 2's name is "+person2.getName());
    }
}
