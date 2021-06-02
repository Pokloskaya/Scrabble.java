package zScrabble;
import javax.swing.JOptionPane;

public class Main {

        public static void main(String[] args) {

            JOptionPane.showMessageDialog(null,  "Bienvenido a Scrabble.java! \n"
            + "Por favor, lee las reglas para que puedas jugar sin problemas. \n"
            + "\n"
            + "Esta es la puntuacion que otorgan las letras: \n"
            + "<> A,E,H,L,N,O,R,S,T,U = 1 punto \n"
            + "<> D,G, = 2 puntos\n"
            + "<> B,C,M,P = 3 puntos"
            + "<> F,I,V,Y = 4 puntos \n"
            + "<> Q = 5 puntos \n"
            + "<> J,X,Ñ = 8 puntos \n"
            + "<> K,W,Z = 10 puntos \n"
            + "\n"
            + "En este Scrabble no se utilizan las letras 'LL','RR' o 'CH', en su lugar se deben utilizar \n"
            + "dos L, dos R o una C junto con una H. \n"
            + "\n"
            + "En esta version son validas las palabras con tilde, sin embargo no se pueden ingresar tildes en el juego en ningun momento \n"
            + "\n"
            );
            
            Bienvenida b = new Bienvenida();
            b.bienvenida();
            
            Tablero x= new Tablero();
            x.x();
        }
    
}
