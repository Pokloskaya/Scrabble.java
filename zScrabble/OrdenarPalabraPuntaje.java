package zScrabble;
import java.util.Comparator;
/**
 * Esta clase sirve para ordenar una colección de palabras por su puntaje de mayor a menor.
 * 
 * @author Jose David Valencia 
 */
public class OrdenarPalabraPuntaje implements Comparator<Palabra>
{
    @Override
    public int compare(Palabra unaPalabra, Palabra otraPalabra) {
        return (otraPalabra.getPuntaje() - unaPalabra.getPuntaje());
    }
}