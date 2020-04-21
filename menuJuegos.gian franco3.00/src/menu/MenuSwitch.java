
package menu;

import java.util.Scanner;


public class MenuSwitch {

    static Vistas vista = new Vistas();
    static Archivo file = new Archivo();
    static String keyPassword = "clave: ";
    static String keyAhorcado = "highAhorcado: ";
    static String keyAdivina = "highAdivina: ";
    static String keyPPT = "highP-P-T: ";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilidades tools = new Utilidades();
        //Archivo file = new Archivo();
        // TODO code application logic here
        String archivo = file.readFile();
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Bienvenido");
        do {
            nombre = vista.ingresoStringUsuario("Su nombre:");
        } while (nombre.isEmpty());
        if (archivo.contains(nombre)) {
            if (tools.login(nombre)) {
                menu(nombre);
            } else {
                System.out.println("chau");
            }
        } else {
            System.out.println("No existe en la base de datos, ingrese una nueva contraseña");
            String password = vista.ingresoStringUsuario("Su clave");
            String template = "{nombre: " + nombre + ", clave: " + password
                    + ", " + keyAdivina + "0"
                    + ", " + keyAhorcado + "0"
                    + keyPPT + "0,}";
            file.createFile(template, true);
        }
    }

    private static void menu(String user) {
        Programas programa = new Programas();

        int option;
        do {
            String[] lista ={
                "salir","adivina","calculos","mostrar pares","ahorcado","p-p-t","score"
            };

            option = vista.ShowMenu(lista);

            switch (option) {
                case 0:
                    break;
                case 1:
                    programa.juego.adivina.ejecutar(user);
                    break;
                case 2:
                    programa.calculadora.ejecutar(user);
                    break;
                case 3:
                    programa.pares.ejecutar();
                    break;
                case 4:
                    programa.juego.ahorcado.ejecutar(user);
                    break;
                case 5:
                    programa.juego.ppt.ejecutar(user);
                    break;
                case 6:
                    vista.ShowScore(user);
                    break;
                default:
                    System.out.println("elija un num del menu, por favor");
                    break;
            }

        } while (option != 0);
        System.out.println("gracias por jugar");
    }
}
