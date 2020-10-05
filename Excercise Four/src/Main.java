//2020 Thomas Wessel

public class Main {

    public static void main(String[] args) {
        System.out.println(power(3,18));
        System.out.println(power(9,5));
        System.out.println(power(4,15));
        System.out.println(power(2,11));
        System.out.println(power(1,99));
        System.out.println(power(6,3));
        System.out.println(power(7,7));
        System.out.println(power(9,9));
        System.out.println(power(3,12));
    }

    private static int power(int x, int y){
        if(y == 1){
            return x;
        }else if(y % 2 == 0){
            return power(x*x, y/2);
        }else{
            return x * power(x*x, y/2);
        }
    }
}
