package src;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}
