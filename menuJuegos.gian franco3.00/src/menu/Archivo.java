
package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static menu.MenuSwitch.keyAdivina;
import static menu.MenuSwitch.keyAhorcado;
import static menu.MenuSwitch.keyPPT;
import static menu.MenuSwitch.keyPassword;


public class Archivo {
     static String RUTA = System.getProperty("user.home")
            + File.separatorChar + "Documents"
            + File.separatorChar + "MenuData.txt";
     
     public int extractValueFromUserRegister(String userName, String key) {
        String archivo = readFile();
        int iNombre = archivo.indexOf(userName);
        int iClave = archivo.indexOf(key, iNombre);
        int iValue = iClave + key.length();
        int iComaClave = archivo.indexOf(",", iValue);
        return Integer.parseInt(archivo.substring(iValue, iComaClave));
     }

    public String readFile() {
        Scanner scanner = null;
        String text = "";
        try {
            File archivo = new File(RUTA);
            scanner = new Scanner(archivo);
            text = scanner.useDelimiter("\\A").next();
            scanner.close();
        } catch (FileNotFoundException e) {
            createFile(text, false);
        }
        return text;
    }

    public void createFile(String content, boolean append) {
        try {
            File archivo = new File(RUTA);
            archivo.createNewFile();

            FileWriter fw = new FileWriter(archivo, append);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(content);

            pw.close();
            fw.close();
        } catch (IOException ex) {
        }
    }

    public String extractUserRegister(String user) {
        String archivo = readFile();
        int iStart = archivo.indexOf(user) - "{nombre: ".length();
        int iEnd = archivo.indexOf("}", iStart);
        String register = archivo.substring(iStart, iEnd + 1);
        return register;
    }

    public void updateValueForUserRegister(String user, String key, int value) {
        String archivo = readFile();
        

        int password = extractValueFromUserRegister(user, keyPassword);
        int adivinaScore = extractValueFromUserRegister(user, keyAdivina);
        int ahorcadoScore = extractValueFromUserRegister(user, keyAhorcado);
        int pptScore =extractValueFromUserRegister(user, keyPPT);

        String actualRegister = extractUserRegister(user);
        switch (key) {
            case "clave":
                password = value;
                break;
            case "ahorcado":
                ahorcadoScore += value;
                break;
            case "adivina":
                adivinaScore += value;
                break;
            case "ppt":
                pptScore += value;
                break;
        }

        String newRegister = "{nombre: " + user + ",clave: " + password
                + ", highAdivina: " + adivinaScore
                + ", highAhorcado: " + ahorcadoScore
                + ",highP-P-T: " + pptScore + ",}";

        String newFile = archivo.replace(actualRegister, newRegister);
        createFile(newFile, false);
    }

    String extractValueFromUserRegister(String userName, int keyAdivina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
