package dsClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
 
class GetStuff extends TimerTask{
    private Client m;
    private View v;
     
    /**
     * @param m
     */
    public GetStuff(View v, Client m) {
        super();
        this.m = m;
        this.v = v;
    }
 
    @Override
    public void run() {
        String temp = m.getGet();
         
        v.getTextArea().setText(temp);
    }    
}
 
public class ChatController implements ActionListener{
    private View v;
    private Client m;
     
    /**
     * @param v
     * @param m
     */
    public ChatController(View v, Client m) {
        super();
        this.v = v;
        this.m = m;
         
        Timer timer = new Timer();
         
        
        timer.scheduleAtFixedRate(new GetStuff(v,m), 0, 1000);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("send")){ 
            m.sendPost(v.getNameField().getText(), v.getTypeField().getText()); 
        } 
    }
 
}