import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Font;
import javax.swing.Timer;
public class Pelea implements Resolucion,MapaDireccion,PersonajesCompletos,Canciones {

    JFrame ventana;
    JPanel panelContenido;
    JLabel fondo_Mapa;
    JLabel fondo;
    ImageIcon imagen;
    Icon icono;

    JLabel nombrep1;
    JLabel nombrep2;
    JLabel personajeicono1;
    JLabel personajeicono2;
    JLabel vidap1;
    JLabel vidap2;
    JLabel aciertosp1;
    JLabel aciertosp2;
    JLabel poderp1;
    JLabel poderp2;

    //labels para operaciones
    //jugador1
    JLabel o1p1;
    JLabel signop1;
    JLabel o2p1;
    JLabel igualp1;
    JLabel opcionp1[]= new JLabel[3];
    Operaciones operacionesp1;
    int rp1;

    //jugador2 fonts 50
    JLabel o1p2;
    JLabel signop2;
    JLabel o2p2;
    JLabel igualp2;
    JLabel opcionp2[]= new JLabel[3];
    Operaciones operacionesp2;
    int rp2;

    JLabel personajeanimado;
    JLabel personajeanimado2;

    JLabel ataquep1;
    JLabel ataquep2;
    JLabel explosionp1;
    JLabel explosionp2;
    JLabel cortep1;
    JLabel cortep2;

   private int jugador;
   private int habilidad;
   Audio cancion;
    public Pelea(Jugador jugador1,Jugador jugador2,int mapaID,char operador)
    {
        cancion = new Audio(canciones_Mapa[mapaID],2,-1);
        cancion.start();

        panelContenido= new JPanel();
        panelContenido.setBounds(0,0,1920,1080);
        panelContenido.setLayout(null);
        //ataques
        ataquep1= new JLabel();
        ataquep1.setBounds(0,0,1920,640);
        panelContenido.add(ataquep1);

        explosionp1= new JLabel();
        explosionp1.setBounds(0,0,1920,640);
        panelContenido.add(explosionp1);

        cortep1= new JLabel();
        cortep1.setBounds(0,0,1920,640);
        panelContenido.add(cortep1);
        
        ataquep2= new JLabel();
        ataquep2.setBounds(0,0,1920,640);
        panelContenido.add(ataquep2);

        explosionp2= new JLabel();
        explosionp2.setBounds(0,0,1920,640);
        panelContenido.add(explosionp2);

        cortep2= new JLabel();
        cortep2.setBounds(0,0,1920,640);
        panelContenido.add(cortep2);
        //jugadores
        personajeanimado = new JLabel();
        personajeanimado.setBounds(0,0,1920,640);
        imagen= new ImageIcon(getClass().getResource(personajes_peleaEstatico[jugador1.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado.getWidth(),personajeanimado.getHeight(),Image.SCALE_DEFAULT));
        personajeanimado.setIcon(icono);
        panelContenido.add(personajeanimado);

        personajeanimado2 = new JLabel();
        personajeanimado2.setBounds(0,0,1920,640);
        imagen= new ImageIcon(getClass().getResource(personajes_peleaEstatico2[jugador2.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado2.getWidth(),personajeanimado2.getHeight(),Image.SCALE_DEFAULT));
        personajeanimado2.setIcon(icono);
        panelContenido.add(personajeanimado2);

        //operaciones player 1
        operacionesp1= new Operaciones();
        rp1=operacionesp1.generaOperacion(operador);

        o1p1= new JLabel(String.valueOf(operacionesp1.getNumero1()));
        o1p1.setBounds(150,780,200,60);
        o1p1.setFont(new Font("ARIAL",0,80));
        panelContenido.add(o1p1);

        o2p1= new JLabel(String.valueOf(operacionesp1.getNumero2()));
        o2p1.setBounds(450,780,200,60);
        o2p1.setFont(new Font("ARIAL",0,80));
        panelContenido.add(o2p1);

        igualp1= new JLabel("=??");
        igualp1.setBounds(650,780,200,60);
        igualp1.setFont(new Font("ARIAL",0,80));
        panelContenido.add(igualp1);
                    //respuestas
                    opcionp1[0]= new JLabel();
                    opcionp1[0].setBounds(180,965,150,60);
                    opcionp1[0].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp1[0]);
                    opcionp1[1]= new JLabel();
                    opcionp1[1].setBounds(490,965,150,60);
                    opcionp1[1].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp1[1]);
                    opcionp1[2]= new JLabel();
                    opcionp1[2].setBounds(800,965,150,60);
                    opcionp1[2].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp1[2]);

        //operaciones player 2
        operacionesp2= new Operaciones();
        rp2=operacionesp2.generaOperacion(operador);

        o1p2= new JLabel(String.valueOf(operacionesp2.getNumero1()));
        o1p2.setBounds(1115,780,200,60);
        o1p2.setFont(new Font("ARIAL",0,80));
        panelContenido.add(o1p2);

        o2p2= new JLabel(String.valueOf(operacionesp2.getNumero2()));
        o2p2.setBounds(1415,780,200,60);
        o2p2.setFont(new Font("ARIAL",0,80));
        panelContenido.add(o2p2);

        igualp2= new JLabel("=??");
        igualp2.setBounds(1615,780,200,60);
        igualp2.setFont(new Font("ARIAL",0,80));
        panelContenido.add(igualp2);
                    //respuestas
                    opcionp2[0]= new JLabel();
                    opcionp2[0].setBounds(1144,965,150,60);
                    opcionp2[0].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp2[0]);

                    opcionp2[1]= new JLabel();
                    opcionp2[1].setBounds(1454,965,150,60);
                    opcionp2[1].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp2[1]);

                    opcionp2[2]= new JLabel();
                    opcionp2[2].setBounds(1770,965,150,60);
                    opcionp2[2].setFont(new Font("ARIAL",0,80));
                    panelContenido.add(opcionp2[2]);
                Operacion(operador);

        //signo
        signop1= new JLabel(String.valueOf(operador));
        signop1.setBounds(360,780,50,50);
        signop1.setFont(new Font("ARIAL",0,80));
        panelContenido.add(signop1);

        signop2= new JLabel(String.valueOf(operador));
        signop2.setBounds(1325,780,50,50);
        signop2.setFont(new Font("ARIAL",0,80));
        panelContenido.add(signop2);

        //personajes nombres y vida e iconos
        personajeicono1 = new JLabel();
        personajeicono1.setBounds(66,0,112,71);
        imagen= new ImageIcon(getClass().getResource(personajes_icono[jugador1.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeicono1.getWidth(),personajeicono1.getHeight(),Image.SCALE_DEFAULT));
        personajeicono1.setIcon(icono);
        panelContenido.add(personajeicono1);

        nombrep1= new JLabel(jugador1.getNombre());
        nombrep1.setFont(new Font("ARIAL",0,30));
        nombrep1.setBounds(300,0,200,40);
        //254
        panelContenido.add(nombrep1);

        vidap1= new JLabel(String.valueOf(jugador1.getVida()));
        vidap1.setFont(new Font("ARIAL",0,30));
        vidap1.setBounds(300,48,100,30);
        panelContenido.add(vidap1);

        aciertosp1= new JLabel(String.valueOf(jugador1.getAciertos()));
        aciertosp1.setFont(new Font("ARIAL",0,30));
        aciertosp1.setBounds(620,48,100,30);
        panelContenido.add(aciertosp1);

        poderp1= new JLabel(String.valueOf(jugador1.getPoder()));
        poderp1.setFont(new Font("ARIAL",0,30));
        poderp1.setBounds(620,8,100,30);
        panelContenido.add(poderp1);

        personajeicono2 = new JLabel();
        personajeicono2.setBounds(1060,0,112,71);
        imagen= new ImageIcon(getClass().getResource(personajes_icono[jugador2.getPersonajeid()]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeicono2.getWidth(),personajeicono2.getHeight(),Image.SCALE_DEFAULT));
        personajeicono2.setIcon(icono);
        panelContenido.add(personajeicono2);

        nombrep2= new JLabel(jugador2.getNombre());
        nombrep2.setFont(new Font("ARIAL",0,30));
        nombrep2.setBounds(1298,0,200,40);
        panelContenido.add(nombrep2);

        vidap2= new JLabel(String.valueOf(jugador2.getVida()));
        vidap2.setFont(new Font("ARIAL",0,30));
        vidap2.setBounds(1296,48,100,30);
        panelContenido.add(vidap2);

        aciertosp2= new JLabel(String.valueOf(jugador2.getAciertos()));
        aciertosp2.setFont(new Font("ARIAL",0,30));
        aciertosp2.setBounds(1612,48,100,30);
        panelContenido.add(aciertosp2);

        poderp2= new JLabel(String.valueOf(jugador2.getPoder()));
        poderp2.setFont(new Font("ARIAL",0,30));
        poderp2.setBounds(1612,8,100,30);
        panelContenido.add(poderp2);

        //fondos
        fondo= new JLabel();
        fondo.setBounds(0,0,1920,1080);
        imagen = new ImageIcon(getClass().getResource("/images/juego.png"));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        panelContenido.add(fondo);

        fondo_Mapa= new JLabel();
        fondo_Mapa.setBounds(0,0,1920,640);
        imagen= new ImageIcon(getClass().getResource(mapa_Grande[mapaID]));
        icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo_Mapa.getWidth(),fondo_Mapa.getHeight(),Image.SCALE_DEFAULT));
        fondo_Mapa.setIcon(icono);
        panelContenido.add(fondo_Mapa);

        ventana= new JFrame("Matemagicas");
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(panelContenido);
        ventana.setSize(ancho,largo);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        
        class Ataques implements Runnable{

            public  void run()
            {
                
                if(jugador==1){
                    Audio corte = new Audio("audios/espada.wav",6,1);
                    
                    corte.start();
                    for(int i=1; i<=18; i++)
                    {
                        imagen= new ImageIcon(getClass().getResource(personajes_pelea[jugador1.getPersonajeid()]+i+".png"));
                        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado.getWidth(),personajeanimado.getHeight(),Image.SCALE_DEFAULT));
                        personajeanimado.setIcon(icono);
                        if(i<=11)
                        {
                            imagen= new ImageIcon(getClass().getResource(personajes_habilidad[0]+i+".png"));
                            icono= new ImageIcon(imagen.getImage().getScaledInstance(ataquep1.getWidth(),ataquep1.getHeight(),Image.SCALE_DEFAULT));
                            ataquep1.setIcon(icono);
                        }
                    }
                        if(habilidad==2)
                        {
                            Audio chidori = new Audio("audios/corte.wav",6,3);
                            chidori.start();
                            for(int i=1; i<=45; i++)
                            {
                            imagen= new ImageIcon(getClass().getResource(personajes_habilidad[1]+i+".png"));
                            icono= new ImageIcon(imagen.getImage().getScaledInstance(explosionp1.getWidth(),explosionp1.getHeight(),Image.SCALE_DEFAULT));
                            explosionp1.setIcon(icono);
                            }
                            habilidad=0;
                            chidori.detener_musica();
                        }else if(habilidad==1)
                        {
                            Audio explosion = new Audio("audios/explosion.wav",6,3);
                            explosion.start();
                            for(int i=1; i<=31; i++)
                            {
                            imagen= new ImageIcon(getClass().getResource(personajes_habilidad[2]+i+".png"));
                            icono= new ImageIcon(imagen.getImage().getScaledInstance(cortep1.getWidth(),cortep1.getHeight(),Image.SCALE_DEFAULT));
                            cortep1.setIcon(icono);
                            }
                            habilidad=0;
                            explosion.detener_musica();
                        }
                        imagen= new ImageIcon(getClass().getResource(personajes_peleaEstatico[jugador1.getPersonajeid()]));
                        icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado.getWidth(),personajeanimado.getHeight(),Image.SCALE_DEFAULT));
                        personajeanimado.setIcon(icono);
                        corte.detener_musica();
                }else if (jugador==2){
                       Audio corte2 = new Audio("audios/espada.wav",6,1);
                        corte2.start();
                        for(int i=1; i<=18; i++)
                        {
                            imagen= new ImageIcon(getClass().getResource(personajes_pelea2[jugador2.getPersonajeid()]+i+".png"));
                            icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado2.getWidth(),personajeanimado2.getHeight(),Image.SCALE_DEFAULT));
                            personajeanimado2.setIcon(icono);
                            if(i<=11)
                            {
                                imagen= new ImageIcon(getClass().getResource(personajes_habilidad2[0]+i+".png"));
                                icono= new ImageIcon(imagen.getImage().getScaledInstance(ataquep2.getWidth(),ataquep2.getHeight(),Image.SCALE_DEFAULT));
                                ataquep2.setIcon(icono);
                            }
                        }
                            if(habilidad==2)
                            {
                                Audio chidori2 = new Audio("audios/corte.wav",6,3);
                                chidori2.start();
                                for(int i=1; i<=45; i++)
                                {
                                imagen= new ImageIcon(getClass().getResource(personajes_habilidad2[1]+i+".png"));
                                icono= new ImageIcon(imagen.getImage().getScaledInstance(explosionp2.getWidth(),explosionp2.getHeight(),Image.SCALE_DEFAULT));
                                explosionp2.setIcon(icono);
                                }
                                habilidad=0;
                                chidori2.detener_musica();
                            }else if(habilidad==1)
                            {
                                Audio explosion2 = new Audio("audios/explosion.wav",6,3);
                                explosion2.start();
                                for(int i=1; i<=31; i++)
                                {
                                imagen= new ImageIcon(getClass().getResource(personajes_habilidad2[2]+i+".png"));
                                icono= new ImageIcon(imagen.getImage().getScaledInstance(cortep2.getWidth(),cortep2.getHeight(),Image.SCALE_DEFAULT));
                                cortep2.setIcon(icono);
                                }
                                habilidad=0;
                                explosion2.detener_musica();
                            }
                            imagen= new ImageIcon(getClass().getResource(personajes_peleaEstatico2[jugador2.getPersonajeid()]));
                            icono= new ImageIcon(imagen.getImage().getScaledInstance(personajeanimado2.getWidth(),personajeanimado2.getHeight(),Image.SCALE_DEFAULT));
                            personajeanimado2.setIcon(icono);
                            corte2.detener_musica();
                    }     
            }

        }
        
        ventana.addKeyListener(new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e) {

            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                              //primer jugador
        if(e.VK_A==e.getKeyCode())
        {
            if(operacionesp1.getResultado()==Integer.parseInt(opcionp1[0].getText()))
            {
                jugador=1;
                Thread pelea= new Thread(new Ataques());
                pelea.start();

                jugador1.dar_Aciertos(1);
                jugador1.dar_Poder(1);
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
                aciertosp1.setText(String.valueOf(jugador1.getAciertos()));
                poderp1.setText(String.valueOf(jugador1.getPoder()));
                
            }
            else
            {
                jugador1.quitar_Vida(2);
                vidap1.setText(String.valueOf(jugador1.getVida()));
            }
            rp1=operacionesp1.generaOperacion(operador);
            o1p1.setText(String.valueOf(operacionesp1.getNumero1()));
            o2p1.setText(String.valueOf(operacionesp1.getNumero2()));
            Operacion(operador); 
        }
        else if(e.VK_S==e.getKeyCode())
        {
            if(operacionesp1.getResultado()==Integer.parseInt(opcionp1[1].getText()))
            {
                jugador=1;
                Thread pelea= new Thread(new Ataques());
                pelea.start();

                jugador1.dar_Aciertos(1);
                jugador1.dar_Poder(1);
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
                aciertosp1.setText(String.valueOf(jugador1.getAciertos()));
                poderp1.setText(String.valueOf(jugador1.getPoder()));
            }
            else
            {
                jugador1.quitar_Vida(2);
                vidap1.setText(String.valueOf(jugador1.getVida()));
            }  
            rp1=operacionesp1.generaOperacion(operador);
            o1p1.setText(String.valueOf(operacionesp1.getNumero1()));
            o2p1.setText(String.valueOf(operacionesp1.getNumero2()));
            Operacion(operador);           
        }
        else if(e.VK_D==e.getKeyCode())
        {
            if(operacionesp1.getResultado()==Integer.parseInt(opcionp1[2].getText()))
            {
                jugador=1;
                Thread pelea= new Thread(new Ataques());
                pelea.start();

                jugador1.dar_Aciertos(1);
                jugador1.dar_Poder(1);
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
                aciertosp1.setText(String.valueOf(jugador1.getAciertos()));
                poderp1.setText(String.valueOf(jugador1.getPoder()));
            }
            else
            {
                jugador1.quitar_Vida(2);
                vidap1.setText(String.valueOf(jugador1.getVida()));
            }
            rp1=operacionesp1.generaOperacion(operador);
            o1p1.setText(String.valueOf(operacionesp1.getNumero1()));
            o2p1.setText(String.valueOf(operacionesp1.getNumero2()));
            Operacion(operador); 
        }
        else if(e.VK_Q==e.getKeyCode())
        {
          if(jugador1.getPoder()>=2)
          {
            jugador=1;
            habilidad=1;
            Thread pelea= new Thread(new Ataques());
            pelea.start();

            jugador2.quitar_Vida(5);
            jugador1.quitar_Poder(2);
            poderp1.setText(String.valueOf(jugador1.getPoder()));
            vidap2.setText(String.valueOf(jugador2.getVida()));
          }  
        }
        else if(e.VK_W==e.getKeyCode())
        {
            if(jugador1.getPoder()>=10)
            {
              jugador=1;
              habilidad=2;
              Thread pelea= new Thread(new Ataques());
              pelea.start();

              jugador2.quitar_Vida(25);
              jugador1.quitar_Poder(10);
              poderp1.setText(String.valueOf(jugador1.getPoder()));
              vidap2.setText(String.valueOf(jugador2.getVida()));
            }  
        }
        //segundo jugador
        else if(e.VK_J==e.getKeyCode())
        {
            if(operacionesp2.getResultado()==Integer.parseInt(opcionp2[0].getText()))
            {
                jugador=2;
                Thread peleap2= new Thread(new Ataques());
                peleap2.start();

                jugador2.dar_Aciertos(1);
                jugador2.dar_Poder(1);
                jugador1.quitar_Vida(2);
                vidap1.setText(String.valueOf(jugador1.getVida()));
                aciertosp2.setText(String.valueOf(jugador2.getAciertos()));
                poderp2.setText(String.valueOf(jugador2.getPoder()));
            }
            else
            {
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
            }
            rp2=operacionesp2.generaOperacion(operador);
            o1p2.setText(String.valueOf(operacionesp2.getNumero1()));
            o2p2.setText(String.valueOf(operacionesp2.getNumero2()));
            Operacion(operador); 
        }
        else if(e.VK_K==e.getKeyCode())
        {
            if(operacionesp2.getResultado()==Integer.parseInt(opcionp2[1].getText()))
            {   
                jugador=2;
                Thread peleap2= new Thread(new Ataques());
                peleap2.start();

            jugador2.dar_Aciertos(1);
            jugador2.dar_Poder(1);
            jugador1.quitar_Vida(2);
            vidap1.setText(String.valueOf(jugador1.getVida()));
            aciertosp2.setText(String.valueOf(jugador2.getAciertos()));
            poderp2.setText(String.valueOf(jugador2.getPoder()));
            }
            else
            {
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
            }
            rp2=operacionesp2.generaOperacion(operador);
            o1p2.setText(String.valueOf(operacionesp2.getNumero1()));
            o2p2.setText(String.valueOf(operacionesp2.getNumero2()));
            Operacion(operador); 
        }
        else if(e.VK_L==e.getKeyCode())
        {
            if(operacionesp2.getResultado()==Integer.parseInt(opcionp2[2].getText()))
            {
                jugador=2;
                Thread peleap2= new Thread(new Ataques());
                peleap2.start();
            jugador2.dar_Aciertos(1);
            jugador2.dar_Poder(1);
            jugador1.quitar_Vida(2);
            vidap1.setText(String.valueOf(jugador1.getVida()));
            aciertosp2.setText(String.valueOf(jugador2.getAciertos()));
            poderp2.setText(String.valueOf(jugador2.getPoder()));
            }
            else
            {
                jugador2.quitar_Vida(2);
                vidap2.setText(String.valueOf(jugador2.getVida()));
            }
            rp2=operacionesp2.generaOperacion(operador);
            o1p2.setText(String.valueOf(operacionesp2.getNumero1()));
            o2p2.setText(String.valueOf(operacionesp2.getNumero2()));
            Operacion(operador); 
        }
        else if(e.VK_U==e.getKeyCode())
        {
            if(jugador2.getPoder()>=2)
            {
                jugador=2;
                habilidad=1;
                Thread peleap2= new Thread(new Ataques());

                peleap2.start();
              jugador1.quitar_Vida(5);
              jugador2.quitar_Poder(2);
              poderp2.setText(String.valueOf(jugador2.getPoder()));
              vidap1.setText(String.valueOf(jugador1.getVida()));
            }  
        }
        else if(e.VK_I==e.getKeyCode())
        {
            if(jugador2.getPoder()>=10)
            {
                jugador=2;
                habilidad=2;
                Thread peleap2= new Thread(new Ataques());
                peleap2.start();

              jugador1.quitar_Vida(25);
              jugador2.quitar_Poder(10);
              poderp2.setText(String.valueOf(jugador2.getPoder()));
              vidap1.setText(String.valueOf(jugador1.getVida()));
            } 
        }     
           if(jugador1.getVida()<1 || jugador2.getVida()<1)
            {
                
                JOptionPane.showMessageDialog(null,"El juego ha terminado.");
                ventana.dispose();
                cancion.detener_musica();
                Ganador ganador = new Ganador(jugador1, jugador2, mapaID);
            }
        }
        
        });

    }

    private void Operacion(char operacion)
    {
        switch(operacion)
        {
            case '+':
            //jugador 1
            if(rp1==0)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()+1));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()-3));
            }
            else if(rp1==1)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()-1));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()+3));
            }else if(rp1==2)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()+1));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()-4));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()));
            }
            //jugador 2
            if(rp2==0)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()+1));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()-3));
            }
            else if(rp2==1)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()-1));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()+3));
            }else if(rp2==2)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()+1));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()-4));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()));
            }
            break;

            case '-':
                        //jugador 1
                        if(rp1==0)
                        {
                            opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()));
                            opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()+1));
                            opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()-3));
                        }
                        else if(rp1==1)
                        {
                            opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()-1));
                            opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()));
                            opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()+3));
                        }else if(rp1==2)
                        {
                            opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()+1));
                            opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()-4));
                            opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()));
                        }
                        //jugador 2
                        if(rp2==0)
                        {
                            opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()));
                            opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()+1));
                            opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()-3));
                        }
                        else if(rp2==1)
                        {
                            opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()-1));
                            opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()));
                            opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()+3));
                        }else if(rp2==2)
                        {
                            opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()+1));
                            opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()-4));
                            opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()));
                        }
            break;

            case 'x':
            //jugador 1
            if(rp1==0)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()+5));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()-4));
            }
            else if(rp1==1)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()-3));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()+1));
            }else if(rp1==2)
            {
                opcionp1[0].setText(String.valueOf(operacionesp1.getResultado()+4));
                opcionp1[1].setText(String.valueOf(operacionesp1.getResultado()-1));
                opcionp1[2].setText(String.valueOf(operacionesp1.getResultado()));
            }
            //jugador 2
            if(rp2==0)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()+3));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()-1));
            }
            else if(rp2==1)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()-3));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()+1));
            }else if(rp2==2)
            {
                opcionp2[0].setText(String.valueOf(operacionesp2.getResultado()+2));
                opcionp2[1].setText(String.valueOf(operacionesp2.getResultado()-3));
                opcionp2[2].setText(String.valueOf(operacionesp2.getResultado()));
            }
            break;
        }

    }
}