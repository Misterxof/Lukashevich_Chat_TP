package dsClient;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
 
public class View {
    private JFrame frame;
    private JScrollPane scrollPane;
    private JTextField typeField;
    private JButton btnSend;
    private JTextArea textArea;
    private JTextField nameField;
    private JLabel lbNickname;
 
    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
 
    /**
     * @return the scrollPane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
 
    /**
     * @return the typeField
     */
    public JTextField getTypeField() {
        return typeField;
    }
 
    /**
     * @return the btnSend
     */
    public JButton getBtnSend() {
        return btnSend;
    }
 
    /**
     * @return the textArea
     */
    public JTextArea getTextArea() {
        return textArea;
    }
 
    /**
     * @return the nameField
     */
    public JTextField getNameField() {
        return nameField;
    }
 
    /**
     * @return the lbNickname
     */
    public JLabel getLbNickname() {
        return lbNickname;
    }
 
    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
 
    /**
     * @param scrollPane the scrollPane to set
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
 
    /**
     * @param typeField the typeField to set
     */
    public void setTypeField(JTextField typeField) {
        this.typeField = typeField;
    }
 
    /**
     * @param btnSenden the btnSenden to set
     */
    public void setBtnSend(JButton btnSend) {
        this.btnSend = btnSend;
    }
 
    /**
     * @param textArea the textArea to set
     */
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
 
    /**
     * @param nameField the nameField to set
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }
 
    /**
     * @param lbNickname the lbNickname to set
     */
    public void setLbNickname(JLabel lbNickname) {
        this.lbNickname = lbNickname;
    }
 
    /**
     * Create the application.
     */
    public View(Client m) {
        initialize(m);
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Client m) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][grow][]"));
         
        lbNickname = DefaultComponentFactory.getInstance().createLabel("Nickname:");
        frame.getContentPane().add(lbNickname, "cell 0 0,alignx trailing");
         
        nameField = new JTextField();
        nameField.setText("nameField");
        frame.getContentPane().add(nameField, "cell 1 0,growx");
        nameField.setColumns(10);
         
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane, "cell 0 1 2 1,grow");
         
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
         
        typeField = new JTextField();
        frame.getContentPane().add(typeField, "cell 0 2,growx");
        typeField.setColumns(10);
         
        btnSend = new JButton("Send");
        btnSend.setActionCommand("send");
        btnSend.addActionListener(new ChatController(this, m));
        frame.getContentPane().add(btnSend, "cell 1 2");
    }
}
