import javax.swing.JLabel;

public class Jugador{

    private String nombre;
    private int aciertos=0;
    private int vida=100;
    private int poder=0;
    private JLabel personaje;
    private JLabel personaje_Miniatura;
    private int personajeid;

    public void dar_Aciertos(int aciertos)
    {
        this.aciertos+=aciertos;
    }
    public void dar_Poder(int poder)
    {
        this.poder+=poder;
    }
    public void quitar_Vida(int puntos_Vida)
    {
        this.vida-=puntos_Vida;
    }
    public void quitar_Poder(int puntos_Poder)
    {
        this.poder-=puntos_Poder;
    }
    /**
     * @return the personajeid
     */
    public int getPersonajeid() {
        return personajeid;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @return the aciertos
     */
    public int getAciertos() {
        return aciertos;
    }
    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }
    /**
     * @return the poder
     */
    public int getPoder() {
        return poder;
    }
    /**
     * @return the personaje
     */
    public JLabel getPersonaje() {
        return personaje;
    }
    /**
     * @return the personaje_Miniatura
     */
    public JLabel getPersonaje_Miniatura() {
        return personaje_Miniatura;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @param aciertos the aciertos to set
     */
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
    /**
     * @param poder the poder to set
     */
    public void setPoder(int poder) {
        this.poder = poder;
    }

    /**
     * @param personaje the personaje to set
     */
    public void setPersonaje(JLabel personaje) {
        this.personaje = personaje;
    }
    /**
     * @param personaje_Miniatura the personaje_Miniatura to set
     */
    public void setPersonaje_Miniatura(JLabel personaje_Miniatura) {
        this.personaje_Miniatura = personaje_Miniatura;
    }
    /**
     * @param personajeid the personajeid to set
     */
    public void setPersonajeid(int personajeid) {
        this.personajeid = personajeid;
    }
}