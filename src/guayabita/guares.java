package guayabita;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class guares {


    private int pote;
    private String lanzamiento;
    private Jugador jugadorp;



    //objeto clase jugador
    Jugador jugador = new Jugador();

    //constructor}


   public guares(int pote, String lanzamiento){
       super();
       this.pote = pote;
       this.lanzamiento = lanzamiento;
   }



       public void menu(){
           int opcion = JOptionPane.showOptionDialog(null,
                   "-------bienvenido al juego de la guayabita---"+"\n" + " ¿que deseas hacer?" , "guayabita",
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                   new ImageIcon(getClass().getResource("GuayabaP.png")), new String []{"jugar", "ver instrucciones"},
                   null);

           if (opcion == 0){

               jugador.creaJugador();

           }
           else if (opcion ==1){
               JOptionPane.showMessageDialog(null, "------------instrucciones--------------\n El juego de la guayabita");
               menu();
           }

       }

       public void jugar(){
       int numero;

       int validador = 0;
       int opcion = 0;



       if ( validador ==0){

           this.pote = 200;
           jugador.setPoteJugador1(jugador.getPoteJugador()-100);
           jugador.setPoteJugador2(jugador.getPoteJugador()-100);
           System.out.println(jugador.getPoteJugador1());
           System.out.println(jugador.getJugador2());
           System.out.println(this.pote);
           validador++;


           opcion = JOptionPane.showConfirmDialog(null, jugador.getJugador1()+ ", el pote actual es de"+ this.pote+"¿Deseas lanzar el dado?",
                   "lanzamiento", JOptionPane.YES_NO_OPTION);
           System.out.println(opcion);{

           }



       }
       if (opcion == 0) {
           numero = (int) (Math.random() * 6) + 1;
           if (numero == 1) {
               JOptionPane.showConfirmDialog(null, jugador.getJugador1() + " ese es tu dado\n" +
                               " deseas hacer una apuesta", "lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                       new ImageIcon(getClass().getResource("uno.png")));
           } else if (numero == 2) {
               JOptionPane.showConfirmDialog(null, jugador.getJugador1() + "ese es tu dado\n"
                               + " deseas hacer una apuesta", "lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                       new ImageIcon(getClass().getResource("dos.png")));
           } else if (numero == 3) {
               JOptionPane.showConfirmDialog(null, jugador.getJugador1() + " este es tu dado\n"
                               + " deseas hacer una apuesta", " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                       new ImageIcon(getClass().getResource("tes.png")));
           } else if (numero == 4) {
               JOptionPane.showConfirmDialog(null, jugador.getJugador1() + " ese es tu dado\n"
                               + " deseas hacer una apuesta", " lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                       new ImageIcon(getClass().getResource("cuatro.png")));
           } else if (numero == 5) {
               JOptionPane.showConfirmDialog(null, jugador.getJugador1)
           } else if (numero == 6) {

               JOptionPane.showConfirmDialog(null, jugador.getJugador1() + "ese es tu dado\n"
                               + " deseas hacer una apuesta", "lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                       new ImageIcon(getClass().getResource("seis.png")));
           }

       }
       if(opcion == 1){
           System.out.println("ingre");
       }


   }


}
