package mypackage;

import java.util.Scanner;
class Converter{
    static String toBinary(int i){
        String binary ="";
        while(i > 0){
            binary = (i%2) + binary;
            i /=2;
        }
        return binary;
    }
}

public class binaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println(Converter.toBinary(x));
    }
}
