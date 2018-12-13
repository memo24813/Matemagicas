public class Operaciones{

  private  int numero1;
  private  int numero2;
  private  int resultado;
  private  int min=2;
  private  int max=9;

    public int generaOperacion(char operacion)
    {
        int inciso;
        switch(operacion)
        {
            case '+':
            numero1=min + (int)(Math.random() * max);
            numero2=min + (int)(Math.random() * max);
            resultado=numero1+numero2;
            break;

            case '-':
            numero1=min + (int)(Math.random() * max);
            numero2=min + (int)(Math.random() * max);
            resultado=numero1-numero2;
            break;

            case 'x':
            numero1=min + (int)(Math.random() * max);
            numero2=min + (int)(Math.random() * max);
            resultado=numero1*numero2;
            break;
        }
        inciso=(int)(Math.random() * 3);
        return inciso;

    }
    /**
     * @return the numero1
     */
    public int getNumero1() {
        return numero1;
    }
    /**
     * @return the numero2
     */
    public int getNumero2() {
        return numero2;
    }
    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }
    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }
    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}