import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public String  reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    @Override
    public char minChar(String s){
        char c =s.charAt(0);
        for (int i = 1; i <s.length()  ; i++) {
            if(s.charAt(i) < c){
                c=s.charAt(i);
            }
        }
        return c;
    }
    @Override
    public String caseChanger(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isUpperCase(c)){
                res+=Character.toLowerCase(c);
            }else{
                res+=Character.toUpperCase(c);
            }
        }

        return res;
    }

}