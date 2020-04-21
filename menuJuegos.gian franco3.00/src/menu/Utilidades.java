
package menu;

public class Utilidades {

    public boolean ingresoErroneo(int userElection, int sysElection) {
        return userElection != sysElection;
    }

    public int manejoDeIntentos(int intentos) {
        System.out.println("intentos: " + intentos);
        intentos = intentos - 1;
        return intentos;
    }

    public boolean aunTenga(int intentos) {
        return intentos > 0;
    }

    public boolean login(String user) {
        Archivo archivo = new Archivo();
        Vistas vista = new Vistas();
        //lectura de archivo
        String mens = "ingrese su contraseña";
        int intentos = 3;
        int password = archivo.extractValueFromUserRegister(user, "clave: ");
        int passystem = (password);
        int userPass = vista.ingresoIntUsuario(mens);
        intentos = manejoDeIntentos(intentos);
        while (ingresoErroneo(userPass, passystem) && aunTenga(intentos)) {
            userPass = vista.ingresoIntUsuario(mens);
            intentos = manejoDeIntentos(intentos);
        }
        return userPass==passystem;
    }
}
