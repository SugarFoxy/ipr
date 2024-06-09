package perf.ipr.ui.servise;

public interface InputService {

    void fillAndCheck(String name, String value);
    void fillInput(String name, String value);
    void checkFilledInput(String name, String value);
}
