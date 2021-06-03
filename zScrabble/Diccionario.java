package zScrabble;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * Esta clase es la colección de palabras ordenada alfabéticamente. 
 * 
 * @author Jose David Valencia y Julián Andrés Romero
 */
public class Diccionario
{

    //private Palabra ListaPalabras;
    private ArrayList<Palabra> PalabrasDiccionario = new ArrayList<Palabra>();
    
    /**
     * Este método lee un archivo y crea la colección de palabras.
     * 
     * @param nombreArchivo Es el nombre del archivo que contiene
     *                      las palabras que se van a cargar.
     */
    public void leerDiccionario(String nombreArchivo) {
       int contador= 0;
        try {
        
            Scanner in = new Scanner(new File(nombreArchivo));
            while(in.hasNext()) {
                String j = in.next();
                PalabrasDiccionario.add(new Palabra(j));
                contador++;
            }
            
            //ordena ListaPalabras por descripcion
            PalabrasDiccionario.sort(new OrdenarPalabraDescripcion());
            
            //Este for imprime el diccionario 
            /*for (int i=0;i<PalabrasDiccionario.size();i++) {
                System.out.println(PalabrasDiccionario.get(i).getDescripcion() + " " + PalabrasDiccionario.get(i).devolverLetras());    
            }*/
            
        } catch(FileNotFoundException e) {
            System.out.println("Ese archivo no se encuentra");
        }
    }

    /**
     * Este método busca las palabras en el diccionario que se pueden formar con las letras del arreglo y devuelve las n mejor puntuadas.
     * 
     * @param LetrasABuscar Es el arreglo de Letras a buscar y debe estar ordenado alfabéticamente.
     * @param nMejores Es el número de palabras que se van a retornar.
     */
    public ArrayList<Palabra> buscarPalabras(ManoJugador ManoUsuario, int nMejores) {
        ArrayList<Palabra> PosiblesPalabras= new ArrayList<Palabra>();
        ArrayList<Palabra> MejoresPalabras= new ArrayList<Palabra>();
        int j= 0;
        Palabra unaPalabra;
        Letra unaLetra;
        int nCantidad= 0;
        for(int i=0;i<PalabrasDiccionario.size();i++){
        
            unaPalabra = PalabrasDiccionario.get(i);
            if((unaPalabra.getPuntaje() <= ManoUsuario.getPuntajeMano()) &&
                unaPalabra.getLongitud() <= ManoUsuario.getCantidadLetras()){
                    
                    for(j=0;j<unaPalabra.getCantidadLetras();j++){
                        unaLetra = unaPalabra.getLetraEnesima(j);
                        if(unaLetra.getCantidad() > ManoUsuario.getCantidadLetras(unaLetra.getDescripcion())){
                            break;
                        }
                    }
                    
                    if(j == unaPalabra.getCantidadLetras()){
                        PosiblesPalabras.add(unaPalabra);
                    }                    
            }
        }        
 
        //ordena ListaPalabras por descripcion
        PosiblesPalabras.sort(new OrdenarPalabraPuntaje());

        nCantidad=PosiblesPalabras.size();
        if(nCantidad > nMejores){
            nCantidad=nMejores;    
        }

        //Copia la n mejores palabras a otro arreglo
        for(int i=0;i<nCantidad; i++){
            MejoresPalabras.add(new Palabra(PosiblesPalabras.get(i).getDescripcion()));
        
        }
        
        return MejoresPalabras;
    }
}

