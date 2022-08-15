public class MathExample {
    public static void main(String[] args) {
        int i = 4;
        int j = -8;
        double x = 47.1;
        double y = 1.79;
        System.out.println("| "+j+" | is "+Math.abs(j));
        System.out.println("| "+x+" | is "+Math.abs(x));

        System.out.println(x+" is approximately "+Math.round(x));
        System.out.println("the celiling of "+i+" is "+Math.ceil(i));
        System.out.println("the celiling of "+y+" is "+Math.ceil(y));
        System.out.println("the celiling of "+x+" is "+Math.floor(x));
        System.out.println("min("+x+","+y+") is"+ Math.min(x,y));

        System.out.println("PI is: "+Math.PI);
        double angle = 45.0*2.0*Math.PI/360.0;
        System.out.println("cos("+angle+") is "+Math.cos(angle));
        double values =0.707;
        System.out.println("acos ("+values+") is "+Math.acos(values));

        System.out.println("exp(0,0) is "+Math.exp(0.0));
        System.out.println("log(10,0) is "+Math.log(10.0));
        System.out.println("exp(2.0,2.0) is "+Math.pow(2.0,2.0));
        System.out.println("here's one random number: "+Math.random());
    }

}
