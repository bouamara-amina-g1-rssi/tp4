package tp4;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {//demarrer l'annuaire
        	LocateRegistry.createRegistry(1099);
            // Create an instance of the server implementation.
            ServerImpl serverImpl = new ServerImpl();

            // Bind the remote object to a name in the RMI registry.
            Naming.rebind("rmi://localhost:1099/ServerImpl", serverImpl);

            System.out.println("Server started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

