import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mapa implements Resolucion, PersonajesCompletos,MapaDireccion{

    private JFrame ventana;
    private JPanel panelContenido;
    private JLabel Ijugador1;
    private JLabel Ijugador2;
    private JLabel nombreJugador1;
    private JLabel nombreJugador2;
    private JLabel fondomapa;
    private JLabel minimapa;
    private JButton mapa1;
    private JButton mapa2;
    private JButton mapa3;
    private JButton mapa4;
    private JButton Jugar;
    private ImageIcon imagen;
    private Icon icono;
    private int mapaID=0;
    private CrearBoton boton= new CrearBoton();
    private Audio cancion; 
    public Mapa(Jugador jugador1,Jugador jugador2)
    {
        cancion = new Audio("audios/mapa.wav",-8,-1);
        cancion.start();
        panelContenido=new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0,0,1920,1080);
        //nombre jugador 1
        nombreJugador1= new JLabel(jugador1.getNombre());
        nombreJugador1.setFont(new Font("ARIAL",0,30));
        nombreJugador1.setBounds(120,190,200,50);
        panelContenido.add(nombreJugador1);
        //nombre jugador 2
        nombreJugador2= new JLabel(jugador2.getNombre());
        nombreJugador2.setFont(new Font("ARIAL",0,30));
        nombreJugador2.setBounds(1620,190,200,50);
        panelContenido.add(nombreJugador2);
        //imagen del jugador seleccionado por el player 1
        Ijugador1= new JLabel();
        Ijugador1.setBounds(0,290,400,400);
        imagen= new ImageIcon(getClass().getResource(personajes_normal[jugador1.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(Ijugador1.getWidth(),Ijugador1.getHeight(),Image.SCALE_DEFAULT));
        Ijugador1.setIcon(icono);
        panelContenido.add(Ijugador1);
        //imagen del jugador seleccionado por el player 2
        Ijugador2= new JLabel();
        Ijugador2.setBounds(1500,290,400,400);
        imagen= new ImageIcon(getClass().getResource(personajes_normal[jugador2.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(Ijugador2.getWidth(),Ijugador2.getHeight(),Image.SCALE_DEFAULT));
        Ijugador2.setIcon(icono);
        panelContenido.add(Ijugador2);
        //visualizador del mapa a ver cual se usara
        minimapa = new JLabel();
        minimapa.setBounds(470,230,980,420);
        imagen= new ImageIcon(getClass().getResource(mapa_Nivel[mapaID]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(minimapa.getWidth(),minimapa.getHeight(),Image.SCALE_DEFAULT));
        minimapa.setIcon(icono);
        panelContenido.add(minimapa);

        mapa1= boton.disenoBoton(100,800,300,200,mapa_Chico[0],"/images/mapachicop.png","/images/mapachicor.png");
        panelContenido.add(mapa1);

        mapa2= boton.disenoBoton(430,800,300,200,mapa_Chico[1],"/images/mapachico2p.png","/images/mapachico2r.png");
        panelContenido.add(mapa2);

        mapa3= boton.disenoBoton(760,800,300,200,mapa_Chico[2],"/images/mapachico3p.png","/images/mapachico3r.png");
        panelContenido.add(mapa3);

        mapa4= boton.disenoBoton(1090,800,300,200,mapa_Chico[3],"/images/mapachico4p.png","/images/mapachico4r.png");
        panelContenido.add(mapa4);

        Jugar= boton.disenoBoton(1420,850,320,120,"/images/pjugar.png","/images/pjugar2.png","/images/pjugar3.png");
        panelContenido.add(Jugar);
        //fondo del mapa
        fondomapa = new JLabel();
        fondomapa.setBounds(0,0,1920,1080);
        imagen= new ImageIcon(getClass().getResource("/images/mapafondo.png"));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(fondomapa.getWidth(),fondomapa.getHeight(),Image.SCALE_DEFAULT));
        fondomapa.setIcon(icono);
        panelContenido.add(fondomapa);

        ventana=new JFrame("Matemagicas");
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(panelContenido);
        ventana.setSize(ancho,largo);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

        mapa1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                mapaID=0;
                imagen= new ImageIcon(getClass().getResource(mapa_Nivel[mapaID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(minimapa.getWidth(),minimapa.getHeight(),Image.SCALE_DEFAULT));
                minimapa.setIcon(icono); 
            }
        });

        mapa2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                mapaID=1;
                imagen= new ImageIcon(getClass().getResource(mapa_Nivel[mapaID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(minimapa.getWidth(),minimapa.getHeight(),Image.SCALE_DEFAULT));
                minimapa.setIcon(icono);
            }
        });
        mapa3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                mapaID=2;
                imagen= new ImageIcon(getClass().getResource(mapa_Nivel[mapaID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(minimapa.getWidth(),minimapa.getHeight(),Image.SCALE_DEFAULT));
                minimapa.setIcon(icono);
            }
        });
        mapa4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                mapaID=3;
                imagen= new ImageIcon(getClass().getResource(mapa_Nivel[mapaID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(minimapa.getWidth(),minimapa.getHeight(),Image.SCALE_DEFAULT));
                minimapa.setIcon(icono);
            }
        });
        Jugar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancion.detener_musica();
                ventana.dispose();
                Dificultad niveldificultad= new Dificultad(jugador1, jugador2, mapaID);   
            }
        });
    }
}