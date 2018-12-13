import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
public class Ganador implements MapaDireccion,Resolucion, PersonajesCompletos{


    JLabel fondo;
    JLabel personaje;
    JLabel fondoGanador;
    JLabel nombre;
    ImageIcon imagen;
    Icon icono;
    JFrame ventana;
    JPanel panelContenido;
    JButton menuPrincipal;
    CrearBoton diseno = new CrearBoton();
    Audio cancion;
    public Ganador(Jugador jugador1,Jugador jugador2,int mapaID)
    {
        cancion = new Audio("audios/ganador.wav",-8,-1);
        cancion.start();
        panelContenido= new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0,0,1920,1080);
        
        menuPrincipal= diseno.disenoBoton(1155,828,746,218,"/images/menuinicial.png","/images/menuinicialp.png","/images/menuinicialr.png");
        panelContenido.add(menuPrincipal);
        nombre= new JLabel();

        if(jugador1.getVida()>0)
        {
            nombre.setText(jugador1.getNombre());
            personaje = new JLabel();
            personaje.setBounds(600,230,700,700);
            imagen = new ImageIcon(getClass().getResource(personajes_normal[jugador1.getPersonajeid()]));
            icono = new ImageIcon(imagen.getImage().getScaledInstance(personaje.getWidth(),personaje.getHeight(),Image.SCALE_DEFAULT));
            personaje.setIcon(icono);
            
        }
        else
        {
            nombre.setText((jugador2.getNombre()));
            personaje = new JLabel();
            personaje.setBounds(600,230,700,700);
            imagen = new ImageIcon(getClass().getResource(personajes_normal[jugador2.getPersonajeid()]));
            icono = new ImageIcon(imagen.getImage().getScaledInstance(personaje.getWidth(),personaje.getHeight(),Image.SCALE_DEFAULT));
            personaje.setIcon(icono);
        }
        nombre.setFont(new Font("ARIAL",0,80));
        nombre.setBounds(766,25,400,100);
        nombre.setForeground(Color.BLACK);
        panelContenido.add(nombre);


        fondoGanador = new JLabel();
        fondoGanador.setBounds(0,0,1920,1080);
        imagen = new ImageIcon(getClass().getResource("images/ganador.png"));
        icono = new ImageIcon(imagen.getImage().getScaledInstance(fondoGanador.getWidth(),fondoGanador.getHeight(),Image.SCALE_DEFAULT));
        fondoGanador.setIcon(icono);
        panelContenido.add(fondoGanador);
        panelContenido.add(personaje);
        

        fondo= new JLabel();
        fondo.setBounds(0,0,1920,1080);
        imagen = new ImageIcon(getClass().getResource(mapa_Completo[mapaID]));
        icono = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
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


        menuPrincipal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ventana.dispose();
                cancion.detener_musica();
                Pantalla_inicial juego = new Pantalla_inicial();
            }
        });
    }
}