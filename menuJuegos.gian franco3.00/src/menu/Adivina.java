
package menu;

import java.util.Scanner;


public class Adivina {
    static Archivo FILE = new Archivo();
     public void ejecutar(String userName) {
         Vistas vista = new Vistas();
         Utilidades tools = new Utilidades();
        System.out.println("Bienvenido: " + userName);
        //traer de archivoin 
        int intentos = 3;
        int secreto = (int) (Math.random() * 10);
        System.out.println(secreto);
        //intentos = funcionalidadExtra(intentos, sc);
        String mens = "adivine un número";
        int user = vista.ingresoIntUsuario(mens);
        intentos = tools.manejoDeIntentos(intentos);
        while (tools.ingresoErroneo(user, secreto) && tools.aunTenga(intentos)) {
            ayudaUsuario(user, secreto);

            user = vista.ingresoIntUsuario(mens);
            intentos = tools.manejoDeIntentos(intentos);
        }
        if (user == secreto) {
            System.out.println("Ganaste!!!");
             int highScore = FILE.extractValueFromUserRegister(userName, MenuSwitch.keyAdivina);
            highScore++;
            System.out.println("Puntos: " + highScore);
            FILE.updateValueForUserRegister(userName, "adivina", 1);
        } else {
            System.out.println("se acabaron los intentos");
        }
    }
     private static void ayudaUsuario(int user, int secreto) {
        System.out.println("No, ese no es");

        if (user > secreto) {
            System.out.println("Te pasaste");
        } else {
            System.out.println("Te falta");
        }
    }
     private static int funcionalidadExtra(int intentos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantos intentos queres?");
        intentos = sc.nextInt();
        while (intentos < 1) {
            System.out.println("cuantos intentos queres?");
            intentos = sc.nextInt();
        }
        return intentos;
    }
   
}
