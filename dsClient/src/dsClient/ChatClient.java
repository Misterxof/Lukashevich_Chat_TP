package dsClient;

import java.net.MalformedURLException;
import java.net.URL;
 
public class ChatClient {
    private View view; 
    private Client model;
     
    public ChatClient() throws MalformedURLException{
        model = new Client(new URL("http://localhost:8080/Dschat/ChatServer"));
        view = new View(model);
        view.getFrame().setVisible(true);
    }
     
    public static void main(String[] args) throws MalformedURLException {
        new ChatClient();
    }
 
}