package zScrabble;
import java.util.ArrayList;
/**
 * Esta clase es la colección de las letras con su puntaje. 
 * 
 * @author Jose David Valencia y Julián Andrés Romero
 */
public class ValoresLetras
{
    public static ArrayList<Letra> LetrasBase = new ArrayList<Letra>(); 
    public static int letrasAbecedario;
    
    /**
     * Asignar el valor a la Letra.
     */
    public static void asignarValoresLetras(){
        LetrasBase.add(new Letra ("A",1));
        LetrasBase.add(new Letra ("B",3));        
        LetrasBase.add(new Letra ("C",3));
        LetrasBase.add(new Letra ("D",2));        
        LetrasBase.add(new Letra ("E",1));
        LetrasBase.add(new Letra ("F",4));
        LetrasBase.add(new Letra ("G",2)); 
        LetrasBase.add(new Letra ("H",1));
        LetrasBase.add(new Letra ("I",4));
        LetrasBase.add(new Letra ("J",8));
        LetrasBase.add(new Letra ("K",10));
        LetrasBase.add(new Letra ("L",1));
        LetrasBase.add(new Letra ("M",3));
        LetrasBase.add(new Letra ("N",1));
        LetrasBase.add(new Letra ("O",1));
        LetrasBase.add(new Letra ("P",3));
        LetrasBase.add(new Letra ("Q",5));
        LetrasBase.add(new Letra ("R",1));
        LetrasBase.add(new Letra ("S",1));
        LetrasBase.add(new Letra ("T",1));
        LetrasBase.add(new Letra ("U",1));
        LetrasBase.add(new Letra ("V",4));
        LetrasBase.add(new Letra ("W",10));
        LetrasBase.add(new Letra ("X",8));
        LetrasBase.add(new Letra ("Y",4));
        LetrasBase.add(new Letra ("Z",10));
        LetrasBase.add(new Letra ("Ñ",8));        
        
        letrasAbecedario = LetrasBase.size();
        
    }
    
    /**
     * Este método retorna el puntaje que tiene una letra.
     */
    public static int getValorLetra(String sLetra){
        int valorLetra=0;     
        boolean encontrado = false;
        int posInferior = 0, posSuperior=LetrasBase.size()-1, posMedia = 0;
        int comparacion=0;
        

        if(LetrasBase.size()>0){        
            while (posInferior <= posSuperior){
                posMedia = (posInferior+posSuperior)/2;
                comparacion=(sLetra.toUpperCase()).compareTo(LetrasBase.get(posMedia).getDescripcion());
                
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
            valorLetra = LetrasBase.get(posMedia).getPuntaje();    
        }else{
            //System.out.println("La letra" + sLetra + "no fue encontrada");
            System.out.println("");
        }
        
        return valorLetra;
    }
}