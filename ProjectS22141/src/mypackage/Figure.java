package mypackage;

import java.util.Scanner;

abstract class Shape{
    int widht;


    abstract void area();
}

class Square extends Shape{
   public Square(int widht){
       this.widht = widht;
   }
    @Override
    void area() {
        System.out.println(widht * widht);
    }
}
class Circle extends  Shape{

    public Circle(int widht){
        this.widht = widht;
    }
    @Override
    void area(){
        System.out.println(Math.PI*widht*widht);
    }
}

public class Figure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Square a = new Square(x);
        Circle b = new Circle(y);
        a.area();
        b.area();
    }
}
