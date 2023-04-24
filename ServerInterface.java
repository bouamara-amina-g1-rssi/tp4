package tp4;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface {
	 public int[][] calculate(String op, int[][] a, int[][] b) throws RemoteException;
	public String login(String id, String pass) throws RemoteException;
   
}
