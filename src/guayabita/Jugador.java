package guayabita;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Jugador {


    private String nameJugador;
    private int poteJugador;



    // se valida que si sea un numero

    public static boolean Esnumero(String cadena){

        try{
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){

            return false;
        }
    }

    public String creaJugador(){
        do{
            this.nameJugador = (String) JOptionPane.showInputDialog(null, "ingrese el nombre del jugador", "nombre", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("GuayabaP.png")), null,null);

        }while((this.nameJugador == null)|| this.nameJugador.trim().isEmpty());


        return this.nameJugador;
    }



// desarrollo del pote
    public int crearPote(){

        String convertPote;


        do{
        convertPote = (String)(JOptionPane.showInputDialog(null, " ingrese el pote de"+ this.nameJugador, "nombre",JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("GuayabaP.png")),null,null ));

            {
                if(Jugador.Esnumero(convertPote)){
                    this.poteJugador = Integer.parseInt(convertPote);

                 }
            }

        }while(this.poteJugador <=100);

        return  this.poteJugador;

    }

    public String getNameJugador() {
        return nameJugador;
    }

    public void setNameJugador(String nameJugador) {
        this.nameJugador = nameJugador;
    }

    public int getPoteJugador() {
        return poteJugador;
    }

    public void setPoteJugador(int poteJugador) {
        this.poteJugador = poteJugador;
    }









}

