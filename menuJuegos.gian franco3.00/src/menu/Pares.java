
package menu;

public class Pares {
     public void ejecutar() {
        int[] numeros = new int[100];
        for (int i = 0; i < 100; i++) {
            numeros[i] = (int) (Math.random() * 10);
        }
        for (int i = 0; i < 100; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i]);
            }
        }
    }
}
