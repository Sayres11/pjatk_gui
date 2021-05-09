package gui.w7.z13;

public class StringTask implements Runnable {
    enum TaskState {RUNNING, ABORTED, READY, CREATED}

    TaskState taskState;
    private String result = "";
    private static String enter;
    private static char[] en;
    int repeat;

    public StringTask(String enter, int repeat) {
        taskState = TaskState.CREATED;
        this.enter = enter;
        this.repeat = repeat;
        en = enter.toCharArray();
    }

    public void start() throws InterruptedException {
        new Thread(this).start();
        this.taskState = TaskState.RUNNING;
    }

    public void abort() {
        this.taskState = TaskState.ABORTED;
    }

    public String getResult() {
        return result;
    }

    public TaskState getState() {
        return this.taskState;
    }

    public boolean isDone() {
        if (this.taskState == TaskState.READY) {
            return true;
        } else if (this.taskState == TaskState.ABORTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (taskState != TaskState.READY) {
            for (int j = 0; j < repeat; j++) {
                for (int i = en.length - 1; i >= 0; i--) {
                    result = result + en[i];
                }
            }
            taskState = TaskState.READY;
        }
    }

    public String getTxt() {
        return enter;
    }
}
