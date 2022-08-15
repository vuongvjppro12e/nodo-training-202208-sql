package Unit1;

public class SwitchExample {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
    switch (value){
        case 0:
            System.out.println("non");
            break;
        case 1:
            System.out.println("ngon");
            break;
        default:
            System.out.println("defaul");
            break;
    }
    }
}
