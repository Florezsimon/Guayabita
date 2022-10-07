package guayabita;

import javax.swing.*;
import java.util.ArrayList;

public class Guayabita {

    private int pote;
    private int dado;
    private int turno;


    private ArrayList<Jugador> jugadores;


// clase jugador
    Jugador jugadoruno = new Jugador();
    Jugador jugadordos = new Jugador();


// constructor
public Guayabita(){
    this.pote = 0;
    this.dado = 0;
    this.turno = 0;
}


// menu inicial
    public void menu(){
    // inicia el array
        jugadores = new ArrayList<Jugador>();
        int opcion = 0;
        // iniciar




        do{
            opcion = JOptionPane.showOptionDialog(null,
                    "--bienvenido al juego de la guayabita---"+ "\n" + " ¿que deseas hacer?", " Guayabita",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(getClass().getResource("GuayabaP.png")), new String[]{"Jugar", "ver instrucciones"},
                    null);
        }
        if(opcion ==0){
            jugadoruno.creaJugador();
            jugadoruno.crearPote();
            jugadores.add(jugadoruno);
            jugadordos.creaJugador();
            jugadordos.crearPote();
            jugadores.add(jugadordos);

        }
        else if (opcion ==1){
            JOptionPane.showMessageDialog(null,
                         "--------------Instrucciones-----\n El juego de la guayabita\n"+"Si el jugador saca 1 o 6 pierde la posibilidad de apostr y por ende\\n\"r\n"
                                                     +"                                                                                              +\"cede el turno al otro jugador.\\n\\n"
                                                     +"                                                                                              + \"Si por el contrario saca un numero del 2 al 5 tiene la posibilidad de apostar por\\n\\n"
                                                     +"                                                                                              + \"el pote que hay en juego, Si elige que no quiere apostar cede su turno, pero si\\n"
                                                     +"                                                                                              + \"quiere hacerlo el juego le debe permitir ingresar el monto por el que desea\\n"
                                                     +"                                                                                              + \"apostar y luego tirar nuevamente el dado.\\n\\n"
                                                     +"                                                                                              + \"El jugador puede apostar por la totalidad del pote o por una parte(por ejemplo,\\n"
                                                     +"                                                                                              + \"Si el pote es de $1200 el jugador puede apostar $1200 o un valor inferior");
        }












    }



}
