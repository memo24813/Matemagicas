import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;



import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Fondo extends JPanel{

    String direccion;
    public Fondo(String direccion)
    {
        this.direccion=direccion;
        setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    public void paintComponent(Graphics g)
    {
        ImageIcon dibujo = new ImageIcon(new ImageIcon(getClass().getResource(direccion)).getImage());
        g.drawImage(dibujo.getImage(),0,0,Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height,null);
    }
}