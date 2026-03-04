public class NumberPrinterThread extends Thread {
    private final String threadName;

    public NumberPrinterThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 8; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
}
