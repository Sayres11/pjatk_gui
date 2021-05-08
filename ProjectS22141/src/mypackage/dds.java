package mypackage;

public class dds {
    public static void main(String[] args) {

        int arr [][]= new int[5][];

        for(int i = 0; i < arr.length; i++)
            arr[i] = new int[(int)Math.random()+1];

        for(int i = 0; i < arr.length; i++)
            if(i%2 == 0)
                System.out.print(13 + " ");
            else
                System.out.print(arr[i]+" ");
    }
}
