public class Throwable {
    public static void main(String[] args) {
        System.out.println("number = "+toNumber(args[0]));

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

       int SaiSoException;{
        String value = "";
        try{
            Integer integer = Integer.parseInt(value);
        }catch(NumberFormatException e){
            try {
                throw new SaiSoException(value);
            } catch (Throwable.SaiSoException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public static class SaiSoException extends Exception{
        private String so;
        public SaiSoException(String value){
            this.so=value;
        }
        public String getMessage(){
            return "gia tri" +so+" khong phai la so";
        }
    }

}
