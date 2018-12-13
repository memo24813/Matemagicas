import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;

public class CrearBoton{


    public JButton disenoBoton(int x,int y,int ancho,int largo,String rutaicono,String rutaPressed,String rutaRollover)
    {
        JButton boton;
        ImageIcon imagen;
        Icon icono;

        boton=new JButton();
        boton.setBounds(x,y,ancho,largo);
        boton.setBorder(null);
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);

        imagen= new ImageIcon(getClass().getResource(rutaicono));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(boton.getWidth(),boton.getHeight(),Image.SCALE_DEFAULT));
        boton.setIcon(icono);
        
        imagen= new ImageIcon(getClass().getResource(rutaPressed));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(boton.getWidth(),boton.getHeight(),Image.SCALE_DEFAULT));
        boton.setPressedIcon(icono);

        imagen= new ImageIcon(getClass().getResource(rutaRollover));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(boton.getWidth(),boton.getHeight(),Image.SCALE_DEFAULT));
        boton.setRolloverIcon(icono);

        return boton;
    }
}