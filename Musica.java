import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

public class Musica extends Thread implements Runnable
{
 private String cancion;
 private int inicio;
	public Musica(String cancion, int inicio)
	{
		this.cancion=cancion;
		this.inicio=inicio;
		
	}


	public void run() {
		
		com.sun.javafx.application.PlatformImpl.startup(()->{});
	    MediaPlayer musica;
		Media song00 = new Media(new File(cancion).toURI().toString());
		musica = new MediaPlayer(song00);
		musica.setVolume(.30);
		musica.setCycleCount(inicio);
		musica.play();
		musica.autoPlayProperty();

	}

	
}