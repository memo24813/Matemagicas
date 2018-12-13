import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Pantalla_inicial implements ActionListener, Resolucion{

    static final long serialVersionUID=1;
    private JButton jugar;
    private JButton salir;
    private JButton creditos;
    private JButton easter;
    private int easterc=0;
    ImageIcon imagen;
    Icon icono;
    private JLabel fondo;
    private JPanel panelContenido;
    private JFrame ventana;
    private CrearBoton diseno= new CrearBoton();
    Audio cancion = new Audio("audios/inicio.wav",-8,-1);
          // Thread cancion = new Thread(new Musica("audios/inicio.mp3",-1));
    
        public Pantalla_inicial()
        {
            panelContenido= new JPanel();
            panelContenido.setLayout(null);
            panelContenido.setBounds(0,0,ancho,largo);
            //easter egg
            easter= new JButton();
            easter.setBounds(1790,859,120,100);
            easter.setBorder(null);
            easter.setOpaque(false);
            easter.setContentAreaFilled(false);
            easter.setBorderPainted(false);
            panelContenido.add(easter);
            //boton jugar
            jugar= new JButton();
            jugar=diseno.disenoBoton(1420,295,500,170,"/images/jugar.png","/images/jugar2.png","/images/jugar3.png");
            panelContenido.add(jugar);
            //boton creditos
            creditos=new JButton();
            creditos.setBounds(1420,475,500,170);
            creditos=diseno.disenoBoton(1420,475,500,170,"/images/creditos.png","/images/creditos2.png","/images/creditos3.png");
            panelContenido.add(creditos);
            //boton salir
            salir=new JButton();
            salir=diseno.disenoBoton(1420,655,500,170,"/images/salir.png","/images/salir2.png","/images/salir3.png");
            panelContenido.add(salir);
            
            //fondo
           fondo = new JLabel();
           fondo.setBounds(0,0,1920,1080);
           imagen= new ImageIcon(getClass().getResource("/images/fondo.jpg"));
           icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
           fondo.setIcon(icono);
           //add(fondo);
           panelContenido.add(fondo);
           //ventana
            ventana= new JFrame("Matemagicas");
            ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
            ventana.setResizable(false);
            ventana.add(panelContenido);
            ventana.setSize(ancho,largo);
            ventana.setLayout(null);
            ventana.setVisible(true);
            ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());


            jugar.addActionListener(this);
            creditos.addActionListener(this);
            salir.addActionListener(this);
            easter.addActionListener(this);
            cancion.start();
        }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jugar)
            {
                cancion.detener_musica();
                ventana.dispose();
                
                Personajes Seleccion=new Personajes();           
            }
            else if(e.getSource()==creditos)
            {
                JOptionPane.showMessageDialog(null,"Matemagicas\nCreador: Gutierrez Soto Guillermo Eugenio\nProfesor: J. Reyes Juarez");
            }
            else if(e.getSource()==salir)
            {
                JOptionPane.showMessageDialog(null,"Gracias por jugar.");
                System.exit(0);
            }
            else if(e.getSource()==easter)
            {
                if(easterc==0)
                {
                    imagen= new ImageIcon(getClass().getResource("/images/fondoe.jpg"));
                    icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
                    fondo.setIcon(icono);
                    easterc=1;
                }else if(easterc==1)
                {
                    imagen= new ImageIcon(getClass().getResource("/images/fondo.jpg"));
                    icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
                    fondo.setIcon(icono);
                    easterc=0;
                }
            }
        }

        public void mapa()
        {
            JFrame ventana;
        ventana=new JFrame("Matemagicas");
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setResizable(false);
       // ventana.add(panelContenido);
        ventana.setSize(ancho,largo);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        }
}