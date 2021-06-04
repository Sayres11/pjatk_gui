package gui.w1;

public class S22141 {

    public static void main(String[] args) {

        ZProstokat zp[] = {
                new ZProstokat(4, 'a', 'e'),        // konstruktor z 3 parametrami
                new ZProstokat(5, 3, '*', '+'),   // konstruktor z 4 parametrami
                new ZProstokat(1, 2, 'a', 'a'),
                new ZProstokat(3, 3, '+', 'x'),
                new ZProstokat(1, 2, 'x', 'y'),
                new ZProstokat(3, 4, '^', '$')


        };

        for (ZProstokat z : zp)
            try {
                z.rysuj();
            } catch (ZProstokatException e) {
                System.out.println(e.getMessage());
            }
    }
}

class ZProstokat {
    private int w, h;
    private char b;
    private char i;
    private static int pr = 1;
    private static int kw = 1;
    private int num;
    private int num2;

    public ZProstokat(int w, int h, char b, char i) {
        this.w = w;
        this.h = h;
        this.b = b;
        this.i = i;
        if (w == h || h == 0) {
            num2 = kw++;
        } else {
            num = pr++;
        }
    }

    public ZProstokat(int w, char b, char i) {
        this(w, w, b, i);


    }

    void draw() throws ZProstokatException {

        for (int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                if (w <= 0 || h <= 0) {
                    throw new ZProstokatException("Błędny prostokąt!");
                } else if (w == 1 || h == 1) {
                    throw new ZProstokatException("Błędny prostokąt!");
                } else if (k == 0 || j == 0 || j == w - 1 || k == h - 1) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(b + " ");
                }
            }
            System.out.println();
        }
    }
    //     J J J J
    //     0 1 2 3       0 1 2
    //K  0 x x x x     0 x x x
    //K  1 x y y x     1 x + x
    //K  2 x y y x     2 x x x
    //K  3 x x x x

    public void rysuj() throws ZProstokatException {
        if (w <= 0 || h <= 0) {
            System.out.println("Prostokąt " + num + " rozmiaru " + w + " x " + h);
        } else if (w == 1 || h == 1) {
            System.out.println("Prostokąt " + num + " rozmiaru " + w + " x " + h);
        } else if (w == h || h == 0) {
            h = w;
            System.out.println("Kwadrat " + num2 + " rozmiaru " + w + " x " + h + ", " + b + " = " + (w + h - 4) + ", " + i + " = " + (w * 2 + h * 2 - 4));
        } else {
            System.out.println("Prostokąt " + num + " rozmiaru " + w + " x " + h + ", " + b + " = " + (w + h - 5) + ", " + i + " = " + (w * 2 + h * 2 - 4));
        }
        draw();
    }
}


class ZProstokatException extends Exception {
    public ZProstokatException(String message) {
        super(message);
    }
}
