import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Personajes implements ActionListener,Resolucion{

    private JLabel nombreJ;
    private JLabel personajes1;
    private String Nombre;
    private JTextField jugador1;
    private Icon icono;
    private ImageIcon imagen;
    private JButton atras;
    private JButton adelante;
    private JButton jugar;
    private String rutas[]= new String[4];
    private int personajeID=0;
    private int personajeID2=0;
    private JPanel contenidoPanel;
    private CrearBoton diseno= new CrearBoton();
    private JFrame ventana;
    Jugador player1 = new Jugador();
    Jugador player2 = new Jugador();
    private int playerID=1;
    Audio cancion = new Audio("audios/personaje.wav",-8,-1);
    public Personajes()
    {  
        ventana= new JFrame("Matemagicas");
        contenidoPanel= new JPanel();
        contenidoPanel.setLayout(null);
        contenidoPanel.setBounds(0,0,1920,1080);
        rutas[0]="/images/personaje.png";
        rutas[1]="/images/personaje2.png";
        rutas[2]="/images/personaje3.png";
        rutas[3]="/images/personaje4.png";
       personajes1= new JLabel();
       personajes1.setBounds(320,200,700,700);
       imagen= new ImageIcon(getClass().getResource("/images/personaje.png"));
       icono= new ImageIcon(imagen.getImage().getScaledInstance(personajes1.getWidth(),personajes1.getHeight(),Image.SCALE_DEFAULT));
       personajes1.setIcon(icono);
       contenidoPanel.add(personajes1);
        //textfield
        jugador1= new JTextField("jugador 1");
        jugador1.setBounds(483,930,600,50);
        jugador1.setFont(new Font("ARIAL",0,40));
        contenidoPanel.add(jugador1);
        //nombre de los personajes
        nombreJ = new JLabel();
        nombreJ.setBounds(120,897,1000,120);
        imagen= new ImageIcon(getClass().getResource("/images/nombre.png"));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(nombreJ.getWidth(),nombreJ.getHeight(),Image.SCALE_DEFAULT));
        nombreJ.setIcon(icono);
        contenidoPanel.add(nombreJ);
        //boton de atras
        atras = new JButton();
        atras=diseno.disenoBoton(200,500,100,100,"/images/atras.png","/images/atras2.png","/images/atras3.png");
        contenidoPanel.add(atras);
        //boton de adelante
        adelante = new JButton();
        adelante=diseno.disenoBoton(1100,500,100,100,"/images/adelante.png","/images/adelante2.png","/images/adelante3.png");
        contenidoPanel.add(adelante);
        //boton jugar
        jugar = new JButton();
        jugar=diseno.disenoBoton(1125,897,320,120,"/images/pjugar.png","/images/pjugar2.png","/images/pjugar3.png");
        contenidoPanel.add(jugar);

        //frame
          contenidoPanel.add(new Fondo("/images/fondo2.jpg"));
          ventana= new JFrame("Matemagicas");
          ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
          ventana.setResizable(false);
          ventana.setSize(ancho,largo);
          ventana.setLayout(null);
          ventana.setVisible(true);
          ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
          ventana.setContentPane(contenidoPanel);

        
        //eventos botones
          atras.addActionListener(this);
          adelante.addActionListener(this);
          jugar.addActionListener(new ActionListener(){
          
              @Override
              public void actionPerformed(ActionEvent e) {
                if(playerID==1)
                {
                    player1.setNombre(jugador1.getText());
                    player1.setPersonaje(personajes1);
                    jugador1.setText("jugador 2");
                    player1.setPersonajeid(personajeID);
                    playerID=2;
                }
                else if(playerID==2)
                {
                    player2.setNombre(jugador1.getText());
                    player2.setPersonaje(personajes1);
                    ventana.dispose();
                    player2.setPersonajeid(personajeID2);
                    cancion.detener_musica();
                    Mapa seleccion= new Mapa(player1,player2);
                    
                }
              }
          });
          cancion.start();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==atras)
        {
            if(personajeID==0)
            {
                personajeID=3;
                personajeID2=3;
                imagen= new ImageIcon(getClass().getResource(rutas[personajeID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(personajes1.getWidth(),personajes1.getHeight(),Image.SCALE_DEFAULT));
                personajes1.setIcon(icono);
            }
            else{
                personajeID--;
                personajeID2--;
                imagen= new ImageIcon(getClass().getResource(rutas[personajeID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(personajes1.getWidth(),personajes1.getHeight(),Image.SCALE_DEFAULT));
                personajes1.setIcon(icono);
            }
        }else if(e.getSource()==adelante)
        {
            if(personajeID==3)
            {
                personajeID=0;
                personajeID2=0;
                imagen= new ImageIcon(getClass().getResource(rutas[personajeID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(personajes1.getWidth(),personajes1.getHeight(),Image.SCALE_DEFAULT));
                personajes1.setIcon(icono);
            }
            else{
                personajeID++;
                personajeID2++;
                imagen= new ImageIcon(getClass().getResource(rutas[personajeID]));
                icono= new ImageIcon(imagen.getImage().getScaledInstance(personajes1.getWidth(),personajes1.getHeight(),Image.SCALE_DEFAULT));
                personajes1.setIcon(icono);
            }
        }//else if(e.getSource()==jugar)
        //{  
        //    System.exit(0);
       // }
    }

}