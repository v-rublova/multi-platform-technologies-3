/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filework;

/**
 *
 * @author v.rublova
 */
import java.io.*;

public class Get_file {

    public static FileInputStream fin;
    public static FileOutputStream fout;
    public static boolean IfFilesAreGood(String args[]) throws IOException {
        int i;
            try {
                fin = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println("Файл для ввода не найден");
                return false;
            }
        return true;
    }
}
