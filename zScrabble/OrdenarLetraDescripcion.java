package zScrabble;
import java.util.Comparator;
/**
 * Esta clase sirve para ordenar una colección de 
 * letras por su descripción.
 * 
 * @author Jose David Valencia 
 */
public class OrdenarLetraDescripcion implements Comparator<Letra>
{
    @Override
    public int compare(Letra unaLetra, Letra otraLetra) {
        return unaLetra.getDescripcion().compareToIgnoreCase(otraLetra.getDescripcion());
    }
}
