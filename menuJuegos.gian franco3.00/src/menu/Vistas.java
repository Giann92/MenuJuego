
package menu;

import java.util.Scanner;
import javax.swing.JOptionPane;
import static menu.MenuSwitch.file;
import static menu.MenuSwitch.keyAdivina;
import static menu.MenuSwitch.keyAhorcado;
import static menu.MenuSwitch.keyPPT;


public class Vistas {

    Archivo file = new Archivo();


    public String ingresoStringUsuario(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }


    public int ingresoIntUsuario(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    public double ingresoDoubleUsuario(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }

    public int ShowMenu(String[] lista) {
        Object choice = JOptionPane.showInputDialog(null,
                "Seleccione Un juego",
                "MENU",
                JOptionPane.QUESTION_MESSAGE,
                null,
                lista,
                "seleccione");
        int option = getChoiceIndex(choice, lista);
        return option;
    }

    private static int getChoiceIndex(Object choice, Object[] choices) {
        if (choice != null) {
            for (int i = 0; i < choices.length; i++) {
                if (choice.equals(choices[i])) {
                    return i;

                }
            }
        }
        return -1;
    }

    public void showMenuCalculos() {
        System.out.println("***CALCULOS***");
        System.out.println("* 0-salir     *");
        System.out.println("* 1-sumar     *");
        System.out.println("* 2-restar    *");
        System.out.println("* 3-dividir   *");
        System.out.println("**************");

    }

    public void ShowScore(String userName) {
        System.out.println("puntajes final: ");

        int adivinaScore = file.extractValueFromUserRegister(userName, keyAdivina);
        int ahorcadoScore = file.extractValueFromUserRegister(userName, keyAhorcado);
        int pptScore = file.extractValueFromUserRegister(userName, keyPPT);

        System.out.println(keyAdivina + adivinaScore);
        System.out.println(keyAhorcado + ahorcadoScore);
        System.out.println(keyPPT + pptScore);
    }
}
