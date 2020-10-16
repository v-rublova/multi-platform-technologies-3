/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals;

import Calc.Signal_calculations;
import filework.Get_file;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author v.rublova
 */
public class Signals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Signal_calculations obj = new Signal_calculations();
        Get_file file_w = new Get_file();
        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        } else {
            if (Get_file.IfFilesAreGood(args)) {
                Integer byteRead;
                ArrayList<Integer> data = new ArrayList<Integer>();
                while ((byteRead = file_w.fin.read()) != -1) {
                    data.add(byteRead);
                }
                ///Main magic area///
                DataStorage storage = new DataStorage();
                storage.GetInfo(data);
                storage.Display();
                storage.FileOutput();
            } else {
                System.out.println("Some files are undetected.");
                System.exit(0);
            }
        }
    }

}
