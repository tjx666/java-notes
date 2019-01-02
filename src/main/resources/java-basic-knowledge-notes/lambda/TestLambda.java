

class D {
    public boolean isOddFirst;
}

class OutThread implements Runnable {
    private int type;
    private D d;

    public OutThread(int type, D d) {
        d.isOddFirst = Math.random() > 0.5 ? true : false;
        this.type = type;
        this.d = d;
    }

    @Override
    public void run() {
        if (this.type == 1) {
            for (int i = 1; i <= 9; i += 2) {
                System.out.print(i);
            }
        } else  {
            for (int i = 2; i <= 8; i += 2) {
                System.out.print(i);
            }
        }
    }
}

public class TestLambda {
    public static void main(String[] args) {
        D d = new D();

        OutThread ot1 = new OutThread(1, d);
        OutThread ot2 = new OutThread(2, d);

        if (d.isOddFirst) {
            ot1.run();
            ot2.run();
        } else {
            ot2.run();
            ot1.run();
        }
    }
}
