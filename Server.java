import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            String host = args.length > 0 ? args[0] : "0.0.0.0";
            String port = args.length > 1 ? args[1] : "11000";

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                    "SimpleAdapter",
                    "default -h " + host + " -p " + port
            );

            adapter.add(new PrinterI(), Util.stringToIdentity("SimplePrinter"));
            adapter.add(new CalculatorI(), Util.stringToIdentity("SimpleCalculator"));
            adapter.activate();

            System.out.println("Server running on " + host + ":" + port);
            communicator.waitForShutdown();
        }
    }
}
