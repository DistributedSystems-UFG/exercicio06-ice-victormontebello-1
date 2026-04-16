import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {
    @Override
    public void printString(String s, Current current) {
        System.out.println(s);
    }

    @Override
    public String toUpper(String s, Current current) {
        return s.toUpperCase();
    }

    @Override
    public int stringLength(String s, Current current) {
        return s.length();
    }

    @Override
    public String repeat(String s, int times, Current current) {
        return s.repeat(Math.max(0, times));
    }
}
