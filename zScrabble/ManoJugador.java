package zScrabble;
import java.util.ArrayList;
/**
 * Esta clase gestiona la mano del jugador y sus atributos.
 * 
 * @author Jose David Valencia y Julián Andrés Romero
 */
public class ManoJugador
{
    private ArrayList<Letra> LetrasMano = new ArrayList<Letra>();
    private int puntajeMano=0;
    private int cantidadLetras=0;

    /**
     * Este método adiciona una letra a la mano del jugador
     */
    public void adicionarLetra(String sLetra)
    {
        int puntajeLetra=0;
        boolean encontrado = false;
        int posInferior = 0, posSuperior=LetrasMano.size()-1, posMedia = 0;
        int comparacion=0;

        if(LetrasMano.size()>0){        
            while (posInferior <= posSuperior){
                posMedia = (posInferior+posSuperior)/2;
                comparacion=(sLetra.toUpperCase()).compareTo(LetrasMano.get(posMedia).getDescripcion());
                
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
            LetrasMano.get(posMedia).incrementarCantidad();
            puntajeLetra = LetrasMano.get(posMedia).getPuntaje();
        }else{
            puntajeLetra = ValoresLetras.getValorLetra(sLetra);
            LetrasMano.add(new Letra(sLetra.toUpperCase(), puntajeLetra));
            //ordena LetrasMano por descripcion
            LetrasMano.sort(new OrdenarLetraDescripcion());            
        }

        cantidadLetras++;
        puntajeMano += puntajeLetra;        
    }
    
     /**
     * Este método devuelve un String con la mano del jugador
     */
    public String devolverMano()
    {    
        String mano = "";
        
        for(int i= 0; i<LetrasMano.size();i++){
            mano = mano + LetrasMano.get(i).getDescripcion() + ":" + LetrasMano.get(i).getCantidad() + ",";
        }
        
        mano = mano + "PuntajeMano:" + puntajeMano; 
        
        return mano;
    }
   
     /**
     * Este método devuelve el puntaje total de las letras del jugador
     */
    public int getPuntajeMano(){    
        return puntajeMano;
    }

     /**
     * Este método devuelve la cantidad de letras en la mano del jugador
     */
    public int getCantidadLetras(){    
        return cantidadLetras;
    }
    

     /**
     * Este método devuelve la cantidad de una misma Letra en la mano del jugador
     */
    public int getCantidadLetras(String sLetra){    
        
        int cantidad = 0;
        boolean encontrado = false;
        int posInferior = 0, posSuperior=LetrasMano.size()-1, posMedia = 0;
        int comparacion=0;

        if(LetrasMano.size()>0){        
            while (posInferior <= posSuperior){
                posMedia = (posInferior+posSuperior)/2;
                comparacion=(sLetra.toUpperCase()).compareTo(LetrasMano.get(posMedia).getDescripcion());
                
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
            cantidad = LetrasMano.get(posMedia).getCantidad();
        }
     
        return cantidad;
    }
}