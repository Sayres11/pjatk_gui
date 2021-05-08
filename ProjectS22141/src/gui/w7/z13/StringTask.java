package gui.w7.z13;

public class StringTask implements Runnable {

    enum casee {RUNNING, ABORTED, READY}
    String sss;
    char[] ss;
    int aaa;

    public StringTask(String sss, int aaa) {
        this.sss = sss;
        this.aaa = aaa;
        ss = sss.toCharArray();
    }

    public void start() {
        try {
            sss.toCharArray();
            for (int j = 0; j < aaa; j++) {
                for (int i = ss.length ; i > ss.length; i--) {
                    sss = sss + ss[i];
                    System.out.println(ss[i]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abort() {

    }

    public String getResult() {
        return sss.toString();
    }

    public casee getState() {
        return casee.RUNNING;
    }

    public boolean isDone() {
        return true;
    }

    @Override
    public void run() {

    }

    public CharSequence getTxt() {
        return sss.toString();
    }
}
