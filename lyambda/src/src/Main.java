package src;

public class Main {

    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener erListener = System.out::println;
        Worker worker = new Worker(listener,erListener);
        worker.start();
    }
}
