
package menu;

import java.util.Arrays;

public class Ahorcado {

    Archivo FILE = new Archivo();

    public void ejecutar(String userName) {
        Vistas vista = new Vistas();
        System.out.println("copado " + userName + "!, vamos a jugar...");
        int intentos = 6;
        String[] diccionario = {"julepe", "mono", "coco", "moco", "jodeme", "mansion", "mension"};
        int iRandom = (int) (Math.random() * diccionario.length);
        String palabraSecreta = diccionario[iRandom];
        String[] palabraToArray = palabraSecreta.split("");
        String[] rayitas = new String[palabraSecreta.length()];
        for (int i = 0; i < rayitas.length; i++) {
            rayitas[i] = "-";
        }
        //System.out.println("-<" + palabraSecreta);
        mostrarPalabraAdivinada(rayitas);
        while (!Arrays.equals(rayitas, palabraToArray) && intentos > 0) {
            String letra = vista.ingresoStringUsuario("adivine una letra");

            if (palabraSecreta.contains(letra)) {
                for (int i = 0; i < palabraToArray.length; i++) {
                    if (letra.equals(palabraToArray[i])) {
                        rayitas[i] = letra;
                    }
                }
            } else {
                intentos--;
                dibujar(intentos);
                System.out.println("le quedan " + intentos + " intentos");
            }
            mostrarPalabraAdivinada(rayitas);
        }
        if (intentos == 0) {
            System.out.println("se acabaron los intentos");
        } else {
            System.out.println("ganaste!!");
            int highScore = 20 * intentos;
            FILE.extractValueFromUserRegister(userName, MenuSwitch.keyAhorcado);
            System.out.println("Puntos: " + highScore);
            FILE.updateValueForUserRegister(userName, "ahorcado",highScore);

        }
    }

    private static void dibujar(int i) {
        System.out.println("te quedan " + i + " intentos");
        switch (i) {
            case 6:
                System.out.println(" ---------------------");
                for (int j = 0; j < 15; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 5:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                for (int j = 0; j < 10; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 4:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 3:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / |   ");
                System.out.println(" |                 /   |   ");
                System.out.println(" |                /    |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 2:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 1:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    /  ");
                System.out.println(" |                   /      ");
                System.out.println(" |                  /       ");
                for (int j = 0; j < 2; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;

            case 0:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | X  X  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    / \\");
                System.out.println(" |                   /   \\  ");
                System.out.println(" |                  /     \\ ");
                for (int j = 0; j < 2; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                System.out.println("GAME OVER");
                break;
        }
    }

    private static void mostrarPalabraAdivinada(String[] rayitas) {
        for (int i = 0; i < rayitas.length; i++) {
            System.out.print(rayitas[i]);
        }
        System.out.println("");
    }
}
