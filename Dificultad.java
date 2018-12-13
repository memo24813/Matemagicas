import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Image;

import javax.swing.Icon;

public class Dificultad implements Resolucion{
    JFrame ventana;
    JPanel panelContenido;
    JButton dificultad1;
    JButton dificultad2;
    JButton dificultad3;
    JButton jugar;
    JLabel fondo;
    ImageIcon imagen;
    Icon icono;
    CrearBoton boton= new CrearBoton();
    Audio cancion = new Audio("audios/operaciones.wav",-8,-1);
    public Dificultad(Jugador jugador1,Jugador jugador2,int mapaID)
    {
        cancion.start();
        panelContenido= new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0,0,1920,1080);
        
        dificultad1 = boton.disenoBoton(160,470,350,200,"/images/suma.png","/images/sumap.png","/images/sumar.png");
        panelContenido.add(dificultad1);

        dificultad2 = boton.disenoBoton(760,470,350,200,"/images/resta.png","/images/restap.png","/images/restar.png");
      //  dificultad2.setBounds(760,470,350,200);
        panelContenido.add(dificultad2);

        dificultad3 = boton.disenoBoton(1380,470,350,200,"/images/multiplicacion.png","/images/multiplicacionp.png","/images/multiplicacionr.png");
        //dificultad3.setBounds(1380,470,350,200);
        panelContenido.add(dificultad3);
        fondo= new JLabel();
        fondo.setBounds(0,0,1920,1080);
        imagen= new ImageIcon(getClass().getResource("/images/dificilfondo.png"));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        panelContenido.add(fondo);
        ventana= new JFrame("Matemagicas");
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(panelContenido);
        ventana.setSize(ancho,largo);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

        dificultad1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); 
                cancion.detener_musica();
                Pelea juego= new Pelea(jugador1,jugador2,mapaID,'+');  
            }
        });

        dificultad2.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();  
                cancion.detener_musica();
                Pelea juego= new Pelea(jugador1,jugador2,mapaID,'-');  
            }
        });

        dificultad3.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); 
                cancion.detener_musica(); 
                Pelea juego= new Pelea(jugador1,jugador2,mapaID,'x');  
            }
        });
    }
}