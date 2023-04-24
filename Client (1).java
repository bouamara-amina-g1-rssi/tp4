package tp4;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	 class utilisateur implements java.io.Serializable {
	        public String id;
	        public String pass;
	        public utilisateur(String id,String pass) {
	            super();
	            this.id=id;
	            this.pass=pass;
	        }
	    }
    public static void main(String[] args) {
    	
    	
        try {
        	
            String serverURL = "rmi://localhost:1099/ServerImpl";
            //stub 
            ServerInterface server = (ServerInterface) Naming.lookup(serverURL);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            String response = server.login(username, password);
            System.out.println(response);

            if (response.startsWith("Welcome")) {
                System.out.println("Select an operation (+, -, *):");
                String op = scanner.nextLine();

                System.out.println("Enter matrix A (comma-separated values):");
                int[][] a = readMatrix(scanner);

                System.out.println("Enter matrix B (comma-separated values):");
                int[][] b = readMatrix(scanner);

                int[][] result = server.calculate(op, a, b);
                System.out.println("Result:");
                printMatrix(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] lines = scanner.nextLine().split(";");
        int[][] matrix = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            matrix[i] = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

