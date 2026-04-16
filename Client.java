import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            String host = args.length > 0 ? args[0] : "127.0.0.1";
            String port = args.length > 1 ? args[1] : "11000";

            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h " + host + " -p " + port);
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            printer.printString("Hello from Goiania!");
            System.out.println("Upper: " + printer.toUpper("hello ice"));
            System.out.println("Length: " + printer.stringLength("hello ice"));
            System.out.println("Repeat: " + printer.repeat("ice-", 3));

            ObjectPrx calculatorBase = communicator.stringToProxy("SimpleCalculator:default -h " + host + " -p " + port);
            Demo.CalculatorPrx calculator = Demo.CalculatorPrx.checkedCast(calculatorBase);
            if (calculator != null) {
                System.out.println("Calculator description: " + calculator.describe());
                System.out.println("2 + 5 = " + calculator.add(2, 5));
                System.out.println("3 * 4 = " + calculator.multiply(3, 4));
            } else {
                System.out.println("Calculator object not available on server.");
            }

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
