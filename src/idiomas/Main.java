package idiomas;
import java.awt.*;
import javax.swing.*;

public class Main{
    
    public static void main(String[] args) {
        JFrame frame =new JFrame("Pruebas");
        
        
        
        frame.setLayout(new BorderLayout());
        frame.add(BorderLayout.NORTH,new Language());
        
        
        frame.add(new JLabel(msg.verMensaje("Despedida")));
        
        
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}