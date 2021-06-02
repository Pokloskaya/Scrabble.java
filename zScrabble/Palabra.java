package zScrabble;
import java.util.ArrayList;
/**
 * Esta es la clase palabra,se utiliza para controlar
 * la longitud, el puntaje y la disponibilidad de 
 * una palabra.
 * @author Jose David Valencia y Julián Andrés Romero
 */
public class Palabra
{
    private ArrayList<Letra> LetrasPalabra = new ArrayList<Letra>();
    private String descripcion;
    private boolean disponible;
    private int longitud;
    private int puntajePalabra;
    
    /**
     * Constructor
     * Recibe un String de la palabra e inicializa 
     * el objeto.
     * @param palabra El string que almacena
     */
    public Palabra(String palabra){
        descripcion = palabra;
        longitud = palabra.length();
        disponible=true;
        puntajePalabra=0;
        
        for(int i=0;i<longitud;i++){
            adicionarLetra(palabra.substring(i, i+1));
        }       
    }
    
    /**
     * Este método retorna el valor del atributo descripción.
     */
    public String getDescripcion(){
        return descripcion;
    }
    
    /**
     * Este método retorna la disponibilidad de la palabra en el juego.
     */
    public boolean getDisponible(){
        return disponible;
    }

    /**
     * Este método retorna el puntaje de la palabra en el juego.
     */
    public int getPuntaje(){
        return puntajePalabra;
    }

    /**
     * Este método adiciona las letras a un arreglo.
     */
    private void adicionarLetra(String sLetra)
    {
        int puntajeLetra=0;
        boolean encontrado = false;
        int posInferior = 0, posSuperior=LetrasPalabra.size()-1, posMedia = 0;
        int comparacion=0;

        if(LetrasPalabra.size()>0){        
            while (posInferior <= posSuperior){
                posMedia = (posInferior+posSuperior)/2;
                comparacion=(sLetra.toUpperCase()).compareTo(LetrasPalabra.get(posMedia).getDescripcion());
                
                if (comparacion == 0){
                    encontrado = true;
                    break;
                }
                
                //Cuando la letra ingresada es menor que la letra que está en la posición media del arreglo
                if (comparacion < 0) {
                    posSuperior = posMedia - 1;
                }
                
                //Cuando la letra ingresada es mayor que la letra que está en la posición media del arreglo
                if (comparacion > 0){
                    posInferior = posMedia + 1;
                }
            } 
        }
        
        if (encontrado==true) {
            LetrasPalabra.get(posMedia).incrementarCantidad();
            puntajeLetra = LetrasPalabra.get(posMedia).getPuntaje();
        }else{
            puntajeLetra = ValoresLetras.getValorLetra(sLetra);
            LetrasPalabra.add(new Letra(sLetra.toUpperCase(), puntajeLetra));
            //ordena LetrasPalabra por descripcion
            LetrasPalabra.sort(new OrdenarLetraDescripcion());
        }

        puntajePalabra += puntajeLetra;   
    }
    
     /**
     * Este método devuelve un String con las letras de la Palabra
     */
    public String devolverLetras()
    {    
        String sletras = "";
        
        for(int i= 0; i<LetrasPalabra.size();i++){
            sletras = sletras + LetrasPalabra.get(i).getDescripcion() + ":" + LetrasPalabra.get(i).getCantidad() + ",";
        }
        
        sletras = sletras + "PuntajePalabra:" + puntajePalabra; 
        
        return sletras;
    }
    
     /**
     * Este método devuelve la cantidad de letras de la palabra
     */
    public int getLongitud(){    
        return longitud;
    }

     /**
     * Este método devuelve la cantidad de letras diferentes que tiene la palabra
     */
    public int getCantidadLetras(){    
        return LetrasPalabra.size();
    }
    
     /**
     * Este método devuelve la enesima letras diferente que tiene la palabra
     */
    public Letra getLetraEnesima(int i){    
        return LetrasPalabra.get(i);
    }
}
