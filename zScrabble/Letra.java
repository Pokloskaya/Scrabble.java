package zScrabble;

public class Letra
{
    String descripcion;
    int puntaje;
    int cantidad;
    /**
     * Constructor
     * Recibe la letra y el puntaje y los asigna.
     * 
     * @param cLetra El string que almacena
     * @param iPuntaje El puntaje de la letra
     */
    public Letra(String cLetra, int iPuntaje){
        descripcion=cLetra;
        puntaje=iPuntaje;
        cantidad=1;
    }
    
    /**
     * Este método retorna el valor de descripción.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Este método retorna el valor del puntaje.
     */
    public int getPuntaje(){
        return puntaje;
    }

    /**
     * Este método incrementa la cantidad de la letra.
     */
    public void incrementarCantidad(){
        cantidad++;
    }

    /**
     * Este método retorna la cantidad de la letra.
     */
    public int getCantidad(){
        return cantidad;
    }
}
