
package menu;

public class Calculadora {

    public void ejecutar(String nombreUsuario) {
        Vistas vista = new Vistas();
        int op;
        System.out.println("copado " + nombreUsuario + "!, vamos a jugar...");
        System.out.println("ingresa dos numeros y elije que hacer");
        double num1 = vista.ingresoDoubleUsuario("num1");
        System.out.println("num 2: ");
        double num2 = vista.ingresoDoubleUsuario("num2");
        do {
           String [] opciones = { "salir","sumar", "restar", "dividir" };
            
            op = vista.ShowMenu(opciones);
            double resultado = -1;
            boolean ok = true;
            switch (op) {
                case 0:
                    System.out.println("chau, gracias por jugar");
                    ok = false;
                    break;
                case 1:
                    resultado = sumar(num1, num2);
                    break;
                case 2:
                    resultado = restar(num1, num2);
                    break;
                case 3:
                    if (num2 != 0) {
                        resultado = dividir(num1, num2);
                    } else {
                        System.out.println("no se puede dividir por cero");
                        ok = false;
                    }
                    break;
            }
            if (ok) {
                System.out.println("el resultado es : " + resultado);
            }
        } while (op != 0);
    }

    private static double sumar(double num1, double num2) {
        double res = num1 + num2;
        return res;
    }

    private static double restar(double num1, double num2) {
        double res = num1 - num2;
        return res;
    }

    private static double dividir(double num1, double num2) {

        return num1 / num2;
    }

}
