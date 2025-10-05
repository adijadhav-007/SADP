public class ThreadSafeSingletonDemo {

    public static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
            System.out.println("Singleton Instance Created");
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        public void showMessage(String threadName) {
            System.out.println("Hello from " + threadName + ", Singleton instance hashcode: " + this.hashCode());
        }
    }

    public static class SingletonTestRunnable implements Runnable {
        private String threadName;

        public SingletonTestRunnable(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage(threadName);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SingletonTestRunnable("Thread 1"));
        Thread t2 = new Thread(new SingletonTestRunnable("Thread 2"));
        Thread t3 = new Thread(new SingletonTestRunnable("Thread 3"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }
}

