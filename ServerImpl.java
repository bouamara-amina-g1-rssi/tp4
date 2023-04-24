package tp4;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


	public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

	    class utilisateur implements java.io.Serializable {
	        public String id;
	        public String pass;
	        public utilisateur(String id,String pass) {
	            super();
	            this.id=id;
	            this.pass=pass;
	        }
	    }
	 
	    private static final long serialVersionUID = 1L;
	    private ArrayList<utilisateur> users = new ArrayList<>();

	    public ServerImpl() throws RemoteException {
	        super();
	        // Add some users
	        users.add(new utilisateur("Amina", "Amina"));
	        users.add(new utilisateur("asmaa", "kuoki"));
	        users.add(new utilisateur("adem", "adem"));
	    }
	   
	        
	    public String login(String id, String pass) throws RemoteException {
	        for (int i = 0; i < users.size(); i++) {
	            if (id.equals(users.get(i).id)) {
	                if (pass.equals(users.get(i).pass)) {
	                	 System.out.print("bienvenue ");
	                    return "Welcome";
	                } else {
	                    return "invalid password";
	                }
	            }
	        }
	        users.add(new utilisateur(id, pass));
	        System.out.print("bien enregistré ");
	        return "Welcome";
	    }

	    public int[][] calculate(String op, int[][] a, int[][] b) throws RemoteException {
	        int[][] result = null;
	        switch (op) {
	            case "+":
	                result = new int[a.length][a[0].length];
	                for (int i = 0; i < a.length; i++) {
	                    for (int j = 0; j < a[0].length; j++) {
	                        result[i][j] = a[i][j] + b[i][j];
	                    }
	                }
	                break;
	            case "-":
	                result = new int[a.length][a[0].length];
	                for (int i = 0; i < a.length; i++) {
	                    for (int j = 0; j < a[0].length; j++) {
	                        result[i][j] = a[i][j] - b[i][j];
	                    }
	                }
	                break;
	            case "*":
	                result = new int[a.length][b[0].length];
	                for (int i = 0; i < a.length; i++) {
	                    for (int j = 0; j < b[0].length; j++) {
	                        for (int k = 0; k < a[0].length; k++) {
	                            a[i][j]+=a[i][k]*b[k][j];      
	                    }
	            
	                    }}
	                 
	                    break;
	            default:
	            	return  result;
	         }
			return result;
	       }
	    }
	
			
	
	                        	
	                        	
	                        	
