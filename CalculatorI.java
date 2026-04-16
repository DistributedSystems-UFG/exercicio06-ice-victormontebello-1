import com.zeroc.Ice.Current;

public class CalculatorI implements Demo.Calculator {
    @Override
    public int add(int a, int b, Current current) {
        return a + b;
    }

    @Override
    public int multiply(int a, int b, Current current) {
        return a * b;
    }

    @Override
    public String describe(Current current) {
        return "Calculator object ready";
    }
}
