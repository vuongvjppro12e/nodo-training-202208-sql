public class TryCatch {
    public static void main(String[] args) {
        int number = toNumber("34");
        System.out.println("number = "+number);

        number =toNumber("as");
        System.out.println("number ="+number);
    }

    private static int toNumber(String value) {
        try {
            Integer interger = Integer.parseInt(value);
            return interger.intValue();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }
}
