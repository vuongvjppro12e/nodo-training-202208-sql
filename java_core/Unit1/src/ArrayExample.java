public class ArrayExample {
    public static void main(String[] args) {
        float [] values = {4.5f,5.5f};
        float total =0;
        for (float value: values){
         total += value;
        }
        System.out.println("The total value of array is "+total);

        float max = values[0];
        for (float i:values){
            if (max < values[(int) i]) max =values[(int) i];
        }
        System.out.println("Gia tri lon nhat = "+ max);
    }
}
