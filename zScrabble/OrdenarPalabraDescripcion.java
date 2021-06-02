package zScrabble;
import java.util.Comparator;
/**
 * Esta clase sirve para ordenar una colección de 
 * palabras por su descripción.
 * 
 * @author Jose David Valencia 
 */
public class OrdenarPalabraDescripcion implements Comparator<Palabra>
{
    @Override
    public int compare(Palabra unaPalabra, Palabra otraPalabra) {
        return unaPalabra.getDescripcion().compareToIgnoreCase(otraPalabra.getDescripcion());
    }
}
