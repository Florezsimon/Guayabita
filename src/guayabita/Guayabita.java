package guayabita;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
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
    public Guayabita() {
        this.pote = 0;
        this.dado = 0;
        this.turno = 0;
    }


    // menu inicial
    public void menu() {
        // inicia el array
        jugadores = new ArrayList<Jugador>();
        int opcion = 0;
        // iniciar


        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "--bienvenido al juego de la guayabita---" + "\n" + " ¿que deseas hacer?", " Guayabita",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(getClass().getResource("GuayabaP.png")), new String[]{"Jugar", "ver instrucciones"},
                    null);

            if (opcion == 0) {
                jugadoruno.creaJugador();
                jugadoruno.crearPote();
                jugadores.add(jugadoruno);
                jugadordos.creaJugador();
                jugadordos.crearPote();
                jugadores.add(jugadordos);

            } else if (opcion == 1) {
                JOptionPane.showMessageDialog(null,
                        "--------------Instrucciones-----\n El juego de la guayabita\n" + "Si el jugador saca 1 o 6 pierde la posibilidad de apostr y por ende\\n\"r\n"
                                + "                                                                                              +\"Cede el turno al otro jugador.\\n\\n"
                                + "                                                                                              + \"Si por el contrario saca un numero del 2 al 5 tiene la posibilidad de apostar por\\n\\n"
                                + "                                                                                              + \"El pote que hay en juego, Si elige que no quiere apostar cede su turno, pero si\\n"
                                + "                                                                                              + \"Quiere hacerlo el juego le debe permitir ingresar el monto por el que desea\\n"
                                + "                                                                                              + \"Apostar y luego tirar nuevamente el dado.\\n\\n"
                                + "                                                                                              + \"El jugador puede apostar por la totalidad del pote o por una parte(por ejemplo,\\n"
                                + "                                                                                              + \"Si el pote es de $1200 el jugador puede apostar $1200 o un valor inferior"
                                + "                                                                                              + \"Debe controlar que el jugador si cuente con el valor de la apuesta que desea\\n"
                                + "                                                                                              + \" realizar. \\n\n"
                                + "                                                                                              +\"Si el jugador saca un numero mayor al que saco en la tirada anterior entonces\\n\""
                                + "                                                                                              +\"Se lleva el dinero del pote( la parte que aposto). Si por el contrario el jugador\\n"
                                + "                                                                                              + \"Saca un numero igual o inferior entonces tendra que entregar lo que aposto al\\n"
                                + "                                                                                              +\"Pote y asi se ira aumentando.\\n\n"
                                + "                                                                                              + \"Si despues de una jugada el pote queda en $0, el juego vuelve a comenzar con \\n"
                                + "                                                                                              +\"$200 ( ambos jugadores aportan de a $100).\\n\\n"
                                + "                                                                                              +\"Despues de esto al otro jugador se le pregunta si desea lanzar el dado y\\n"
                                + "                                                                                              +\"Comienza de nuevo el juego.\\n\n"
                                + "                                                                                              +\"El juego termina cuando uno de los dos jugadores no tenga dinero suficioente\\n"
                                + "                                                                                              +\"Para iniciar una nueva ronda.\n"
                                + "");

                menu();
            }


        } while (opcion == -1);
        juego();

    }

    // juego es llamado desde el menu, crea el pote inicial
    public void juego() {

        this.pote = 200;
        jugadores.get(0).setPoteJugador(jugadores.get(0).getPoteJugador() - 100);
        jugadores.get(1).setPoteJugador(jugadores.get(1).getPoteJugador() - 100);

        segundoLanzar(this.dado);

    }


    // primer lanzamiento

    public int lanzar() {
        int apuesta = 0;

        int opcion = 0;


        if (this.turno % 2 == 0) {
            opcion = JOptionPane.showConfirmDialog(null,
                    jugadores.get(this.turno % 2).getNameJugador() + ", el pote actua es de" + this.pote
                            + "¿deseas lanzar el apuesta",
                    "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("GuayabaP.png")));

            {
                // valida la opcion elegida por el jugador
                if (opcion == 0) {

                    // random para el dado
                    this.dado = (int) (Math.random() * 6) + 1;


                    // validador de datos
                    if (this.dado == 1) {

                        JOptionPane.showConfirmDialog(null, jugadores.get(0).getNameJugador()
                                        + " con este dado no puedes apostar....\nPasa el turno",
                                "Lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                                new ImageIcon(getClass().getResource("uno.png")));
                        this.turno++;

                    } else if (this.dado == 2) {
                        apuesta = JOptionPane.showConfirmDialog(null, jugadores.get(0).getNameJugador() + "ese es tu dado\n"
                                        + "¿deseas hacer la apuesta?",
                                "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                                new ImageIcon(getClass().getResource("dos.png")));
                    } else if (this.dado == 3) {
                        apuesta = JOptionPane.showConfirmDialog(null,
                                jugadores.get(0).getNameJugador() + "ese es tu dado\n",
                                "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                                new ImageIcon(getClass().getResource("tres.png")));

                    } else if (this.dado == 4) {
                        apuesta = JOptionPane.showConfirmDialog(null,
                                jugadores.get(0).getNameJugador() + "Ese es tu dado\n"
                                        + "¿Deseas hacer una apuesta?",
                                "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                                new ImageIcon(getClass().getResource("cuatro.png")));
                    } else if (this.dado == 5) {
                        apuesta = JOptionPane.showConfirmDialog(null,
                                jugadores.get(0).getNameJugador() + "este es tu dado\""
                                        + "¿Deseas hacer una apuesta",
                                " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                                new ImageIcon(getClass().getResource("cinco.png")));

                    } else if (this.dado == 6) {
                        JOptionPane.showConfirmDialog(null, jugadores.get(0).getNameJugador()
                                        + ". con este dado no puedes apostar...\nPasa el turno",
                                "lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                                new ImageIcon(getClass().getResource("seis.png")));
                    }

                } else
                    System.exit(1);
            }
        }

        //valida el turno
        if (this.turno % 2 == 1) {
            opcion = JOptionPane.showConfirmDialog(null,
                    jugadores.get(this.turno % 2).getNameJugador() + ", el pote actual es de " + this.pote
                            + " deseas lanzar el apuesta",
                    "lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("GuayabaP.png")));
        }
        if (opcion == 0) {
            // random para sacar el dado
            this.dado = (int) (Math.random() * 6) + 1;

            // valida el dado
            if (this.dado == 1) {
                JOptionPane.showConfirmDialog(null,
                        jugadores.get(1).getNameJugador()
                                + " con ese dado no puedes apostar.....\nPasa el turno",
                        " lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                        new ImageIcon(getClass().getResource("uno.png")));

                this.turno++;
            } else if (this.dado == 2) {
                apuesta = JOptionPane.showConfirmDialog(null,
                        jugadores.get(1).getNameJugador() + " . Este es ti dado \n\n"
                                + " ¿deseas hacer una apuesta?",
                        " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                        new ImageIcon(getClass().getResource("dos.png")));
            } else if (this.dado == 3) {
                apuesta = JOptionPane.showConfirmDialog(null,
                        jugadores.get(1).getNameJugador() + " Este es tu dado\n\n"
                                + "¿ deseas hacer una apuesta?",
                        " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                        new ImageIcon(getClass().getResource("tres.png")));
            } else if (this.dado == 4) {
                apuesta = JOptionPane.showConfirmDialog(null,
                        jugadores.get(1).getNameJugador() + " . Este es tu dado\n\n"
                                + "¿deseas hacer una apuesta?",
                        " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                        new ImageIcon(getClass().getResource("cuatro.png")));
            } else if (this.dado == 5) {
                apuesta = JOptionPane.showConfirmDialog(null,
                        jugadores.get(1).getNameJugador() + ". Este es tu dado \n\n"
                                + "¿deseas hacer una apuesta?",
                        " Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                        new ImageIcon(getClass().getResource("cinco.png")));
            } else if (this.dado == 6) {
                apuesta = JOptionPane.showConfirmDialog(null,
                        jugadores.get(0).getNameJugador()
                                + " con este dado no puedes apostar....\nPasa el turno",
                        " lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                        new ImageIcon(getClass().getResource("seis.png")));

                this.turno++;
            }
        } else
            System.exit(1);

        return apuesta;
    }


    // lanzamiento por segunda vez

    public int segundoLanzar(int azar) {
        int restar = 0;

        // mientras el pote sea >0 y los jugadores tengan dinero

        while (this.pote > 0 && jugadores.get(this.turno % 2).getPoteJugador() >= 0) {
            restar = apuesta();
            azar = this.dado;

            // dado del segundo lanzamiento

            this.dado = (int) (Math.random() * 6) + 1;


            // compara el dado anterior con el nuevo
            if (this.dado < azar && restar != 0) {
                if (this.dado == 1) {
                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + " . El dado que has sacado es menor o igual al anterior....\n Has perdido",
                            " perder", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("uno.png")));
                } else if (this.dado == 2) {
                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + ", El dado que has sacado es menor o igual anterior....\n Has perdido",
                            "Perder", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("dos.png")));
                } else if (this.dado == 3) {
                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + ". El dado que has sacado es menor o igual que el anterior.....\n Has perdido",
                            "Perder", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("tres.png")));
                } else if (this.dado == 4) {

                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + " . El dado que has sacado es menor o igual al anterior.....\n Has perdido",
                            "Perder", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("cuatro.png")));
                } else if (this.dado == 5) {
                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + " . El dado que has sacado es mayor al anterior....\n Has ganado",
                            "Ganar", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("cinco.png")));
                } else if (this.dado == 6) {
                    JOptionPane.showConfirmDialog(null,
                            jugadores.get(this.turno % 2).getNameJugador()
                                    + ". El dado que has sacado es mayor al anterior.....\n Has ganado",
                            " Ganar", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION,
                            new ImageIcon(getClass().getResource("seis.png")));
                }
                sumar(restar);
            }
            if (jugadores.get(this.turno % 2).getPoteJugador() == 0) {
                break;

            }
        }
        if (this.pote == 0) {
            juego();


        }
        return azar;
    }


    public int apuesta() {
        String convertPote = "";
        int restar = 0;
        int valor = 0;
        int apuesta = 0;
        apuesta = lanzar();

        if ((apuesta == 0) && this.dado > 1 && this.dado < 6) {
            do {
                convertPote = (String) JOptionPane.showInputDialog(null,
                        "Ingresa lo que deseas apostar, " + jugadores.get(this.turno % 2).getNameJugador(), "Apuesta",
                        JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("GuayabaP.png")), null, null);


                if (Jugador.Esnumero(convertPote)) {
                    restar = Integer.parseInt(convertPote);
                    valor = jugadores.get(this.turno % 2).getPoteJugador() - restar;
                }

            } while (valor < 0 || (this.pote - restar) < 0);
            {
            }
            if (apuesta == 1) {
                this.turno++;
            }
            return restar;
        }


    }
    public void Restar(int restar){
        this.pote = (restar)+ this.pote;

        restar = jugadores.get(this. turno % 2).getPoteJugador() - restar;
        jugadores.get(this.turno %2).setPoteJugador(restar);
        JOptionPane.showConfirmDialog(null,
                          jugadores.get(this.turno % 2).getNameJugador()+ " tu dinero actual es"
                                                 +  jugadores.get(this.turno % 2).getPoteJugador(),
                                                   " Ganancias", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                                  new ImageIcon(getClass().getResource("dinero.png")));
        this.turno ++;
    }

    public void sumar(int sumar){

        this.pote = this.pote -sumar;

        sumar = jugadores.get(this.turno % 2).getPoteJugador() + sumar;
        jugadores.get(this.turno % 2).setPoteJugador(sumar);


        JOptionPane.showConfirmDialog(null,
                         jugadores.get(this.turno %2).getNameJugador()+ " . Tu dinero actual es"
                                                + jugadores.get(this.turno % 2).getPoteJugador(),
                                  " Ganancias", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                   new ImageIcon(getClass().getResource("dinero.png")));

                   this.turno++;


    }


}

