package zScrabble;
/**
 * Esta clase se encarga de dar la bienvenida por pantalla al usuario.
 * 
 * @author Julián Andrés Romero 
 */
public class Bienvenida
{
    public void bienvenida(){
        System.out.println("Bienvenido a Scrabble.java!");
        System.out.println("Por favor, lee las reglas para que puedas jugar sin problemas.");
        System.out.println("");
        System.out.println("Esta es la puntuacion que otorgan las letras:");
        System.out.println("<> A,E,H,L,N,O,R,S,T,U = 1 punto");
        System.out.println("<> D,G, = 2 puntos");
        System.out.println("<> B,C,M,P = 3 puntos");
        System.out.println("<> F,I,V,Y = 4 puntos");
        System.out.println("<> Q = 5 puntos");
        System.out.println("<> J,X,Ñ = 8 puntos");
        System.out.println("<> K,W,Z = 10 puntos");
        System.out.println("");
        System.out.println("");
        System.out.println("En este Scrabble no se utilizan las letras 'LL','RR' o 'CH', en su lugar se deben utilizar");
        System.out.println("dos L, dos R o una C junto con una H.");
        System.out.println("");
        System.out.println("En esta version son validas las palabras con tilde, sin embargo no se pueden ingresar tildes en el juego en ningun momento");
        System.out.println("");
    }
}