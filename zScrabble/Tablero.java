package zScrabble;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*; //libreria de interfaces graficas       
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Clase de creacion de la interfaz grafica y los eventos
 * @author Jose David Valencia y Julián Andrés Romero
 */

public class Tablero implements ActionListener {
  

    Scanner in = new Scanner(System.in);
    Random random = new Random();
    JFrame frame = new JFrame(); 
    JPanel tittle_panel = new JPanel(); 
    JPanel button_panel = new JPanel();
    JPanel button_panel1 = new JPanel();
    JLabel textfield = new JLabel();
    //Creacion de botones
    JFrame frame1 = new JFrame(); 
    JButton[] buttons = new JButton[225]; //boton del tablero
    JButton[] buttons1 = new JButton[7];  //botones de abajo
    public JButton boton3; 
    public JButton boton2; 
    public JButton boton1;
    public JButton boton;
    boolean player1_turn = true;
    int resultados = 0; 
    int resultados1 = 0;
    
    
    Tablero(){
       
    }

    public void x(){
        
        //esto crea el logo de la aplicación 
        ImageIcon logo = null;
        java.net.URL imgURL = Tablero.class.getResource("logo.png");
        if (imgURL != null) {
           logo = new ImageIcon(imgURL);
           frame.setIconImage(logo.getImage());  
        } else {
           JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }    

    frame.setSize(1200,1200);  

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.getContentPane().setBackground(new Color(50,50,50)); 
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);

    textfield.setBackground(new Color(25,25,25)); 
    textfield.setForeground(new Color(25,255,0));
    textfield.setFont(new Font("Arial",Font.BOLD,72));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Scrabble.java");
    textfield.setOpaque(true);

    tittle_panel.setLayout(new BorderLayout());
    tittle_panel.setBounds(0,0,800,100);  //colores del titulo
    

    
    button_panel.setLayout(new GridLayout(15,15));
    button_panel.setBackground(new Color(150,150,150)); //Esto hace aparecer el resto del cuerpo 
    frame.add(button_panel);
    
    button_panel1.setLayout(new GridLayout(2,2));
    button_panel1.setBackground(new Color(150,150,150)); //Esto hace aparecer el resto del cuerpo 
    frame.add(button_panel1,BorderLayout.SOUTH);         //Esto hace que la parte button_panel este abajo

     for(int i=0;i<225;i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]); //Fuente original: MV Boli
        buttons[i].setFont(new Font("Arial", Font.BOLD,50)); 
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this); 
     }
    
     buttons1[0] = new JButton("Jugadas que se pueden hacer");
     button_panel1.add(buttons1[0]); //Fuente original: MV Boli
     buttons1[0].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[0].setFocusable(false);
     buttons1[0].addActionListener(this); 

     buttons1[1] = new JButton("Puntaje del Jugador 1");
     button_panel1.add(buttons1[1]); //Fuente original: MV Boli
     buttons1[1].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[1].setFocusable(false);
     buttons1[1].addActionListener(this); 
       
     buttons1[2] = new JButton("Puntaje del Jugador 2");
     button_panel1.add(buttons1[2]); //Fuente original: MV Boli
     buttons1[2].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[2].setFocusable(false);
     buttons1[2].addActionListener(this); 

     buttons1[3] = new JButton("Finalizar partida");
     button_panel1.add(buttons1[3]); //Fuente original: MV Boli
     buttons1[3].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[3].setFocusable(false);
     buttons1[3].addActionListener(this); 

     buttons1[4] = new JButton("Mano del Jugador 1");
     button_panel1.add(buttons1[4]); //Fuente original: MV Boli
     buttons1[4].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[4].setFocusable(false);
     buttons1[4].addActionListener(this); 

     buttons1[5] = new JButton("Mano del jugador 2");
     button_panel1.add(buttons1[5]); //Fuente original: MV Boli
     buttons1[5].setFont(new Font("Arial", Font.BOLD,20)); 
     buttons1[5].setFocusable(false); 
     buttons1[5].addActionListener(this); 

    tittle_panel.add(textfield);
    frame.add(tittle_panel,BorderLayout.NORTH); //Esto hace que el titulo vaya arriba
 

    boton2=new JButton("Turno del jugador 1 (Rojo)");
    frame.add(boton2,BorderLayout.WEST); 
    boton2.addActionListener(this);
    
    boton1=new JButton("Turno del jugador 2 (Azul)");
    frame.add(boton1,BorderLayout.EAST);
    boton1.addActionListener(this);
    }
 

    
    //--------------------------------------SEPARADOR-------------------------------------------

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==buttons1[0]){
            
            ValoresLetras.asignarValoresLetras();
            
            Diccionario unDiccionario = new Diccionario();
            unDiccionario.leerDiccionario("DiccionarioPrueba.txt");

            ManoJugador ManoUsuario = new ManoJugador();
            
            System.out.println("Ingresa la mano del Jugador");
            pedirLetrasJugador(ManoUsuario);
            
            ArrayList<Palabra> MejoresPalabras = unDiccionario.buscarPalabras(ManoUsuario , 10);
            
            System.out.println("");
            
            //Palabras sugeridas
            System.out.println("Las mejores palabras que puedes armar con tu mano son:");
            for (int i=0;i<MejoresPalabras.size();i++) {
                System.out.println(MejoresPalabras.get(i).getDescripcion() + " " + MejoresPalabras.get(i).getPuntaje());    
            }
        }
        
        if(e.getSource()==buttons1[1]){
            
            while(true){
                System.out.println("Ingresa tus puntos, y pon 0 cuando termines");
                int valores = in.nextInt();
                resultados += valores;

                if(valores == 0){
                    System.out.println("El jugador 1 lleva "+resultados+" puntos");
                    break;
                }
               }
            }
     
            if(e.getSource()==buttons1[2]){
                while(true){
                    System.out.println("Ingresa tus puntos, y pon 0 cuando termines de ingresarlos");
                    int valores1 = in.nextInt();
                    resultados1 += valores1;
    
                    if(valores1 == 0){
                        System.out.println("El jugador 2 lleva "+resultados1+" puntos");
                        break;
                    }
                   }
    
                }

                if(e.getSource()==buttons1[3]){
                  if(resultados>resultados1){
                      System.out.println("GANA EL JUGADOR 1");
                  }else{
                      System.out.println("GANA EL JUGADOR 2");
                  }
                    
                  System.exit(0);
                }
                
                //mano 1
                if(e.getSource()==buttons1[4]){
                    
                    System.out.println("Estas serán las letras de tu mano");
                    
                    Random r = new Random();

                      String letrasScrabble1 = "aaaaaaaaaaaaeeeeeeeeeeeeiiiiiillllnnnnnooooooooorrrrrssssssttttuuuuudddddggbbccccmmppfhhvyqjllñrrxzz";

                        for (int i = 0; i < 7; i++) {
                         System.out.println(letrasScrabble1.charAt(r.nextInt(letrasScrabble1.length())));
                        }
                        
                        //mano 2
                        if(e.getSource()==buttons1[5]){
                    
                            System.out.println("Estas serán las letras de tu mano");
                            
                            Random rr = new Random();
        
                              String letrasScrabble2 = "aaaaaaaaaaaaeeeeeeeeeeeeiiiiiillllnnnnnooooooooorrrrrssssssttttuuuuudddddggbbccccmmppfhhvyqjllñrrxzz";
        
                                for (int i = 0; i < 7; i++) {
                                 System.out.println(letrasScrabble2.charAt(rr.nextInt(letrasScrabble2.length())));
                                }
                            }
                }


        
        if (e.getSource()==boton1) {
            player1_turn=false;   //Boton que la da el turno al jugador 2
		}

        if (e.getSource()==boton2) {
            player1_turn=true;    //Boton que la da el turno al jugador 1
		}
        
        for(int i=0; i<225; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        textfield.setText("Turno del jugador 1 (rojo)");
                        
                        buttons[i].setForeground(new Color(255,0,0)); 
                        String letra = in.next();
                        buttons[i].setText(letra);    
                       
                    }
                    
                    
                }
                else{
                         if(buttons[i].getText()==""){
                            textfield.setText("Turno del jugador 2 (azul)");
                             buttons[i].setForeground(new Color(0,0,255));
                             String letra = in.next();
                             buttons[i].setText(letra);
                             //player1_turn=true;
                             
                          
                         }
                     }
                     
                }
               
            }
           
        }

        public void pedirLetrasJugador(ManoJugador ManoUsuario){
           
            String mano = in.next();
            
            for(int i=0;i<mano.length();i++){
                ManoUsuario.adicionarLetra(mano.substring(i, i+1));
            }
    
            System.out.println(ManoUsuario.devolverMano());
        }
}


