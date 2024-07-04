package perf.ipr.ui.service;

public interface InputService {
    void fillAndCheck(String name, String value);
    void fillInput(String name, String value);
    void checkFilledInput(String name, String value);
}
