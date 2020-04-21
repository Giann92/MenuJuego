
package menu;

public class Ppt {
     public void ejecutar(String user) {
         Vistas vista = new Vistas();
        System.out.println("Bienvenido: " + user);
       int highScore = 0;
        String[] ppt = {"piedra", "papel", "tijera"};
        int iRandom = (int) (Math.random() * ppt.length);
        String palabraSecreta = ppt[iRandom];

        String letra = vista.ingresoStringUsuario("piedra , papel o tijera ?");

        if (palabraSecreta.contains(letra)) {
            System.out.println("ganaste: ");
            highScore++;
            System.out.println("Tu puntos: " + highScore);
        } else {
            System.out.println("perdiste: " + palabraSecreta);
        }
     
    }
    
}
