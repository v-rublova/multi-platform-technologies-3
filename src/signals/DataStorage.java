/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals;

import Calc.Signal_calculations;
import filework.Get_file;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author v.rublova
 */
public class DataStorage {

    public int dinamic_range;
    public int energy;
    public float average_power;
    public float average_value;
    public float dispersion;
    public ArrayList<Double> function;
    public double correlation_interval;

    public DataStorage() {
        dinamic_range = 0;
        energy = 0;
        average_power = 0;
        average_value = 0;
        dispersion = 0;
        function = new ArrayList<>();
        correlation_interval = 0;

    }

    public void GetInfo(ArrayList<Integer> data) {
        this.dinamic_range = Signal_calculations.dinamic_range_c(data);
        this.energy = Signal_calculations.energy_c(data);
        this.average_power = Signal_calculations.average_power_c(data);
        this.average_value = Signal_calculations.average_value_c(data);
        this.dispersion = Signal_calculations.dispersion_c(data);
        this.function = Signal_calculations.function(data, 0, 10000);
        this.correlation_interval = Signal_calculations.correlation_interval(data);
    }

    public void Display() {
        System.out.println("Dinamic range = " + dinamic_range);
        System.out.println("Energy = " + energy);
        System.out.println("Average power = " + average_power);
        System.out.println("Average value = " + average_value);
        System.out.println("Dispersion = " + dispersion);
        System.out.println("Autocoorelation function values:");
        for (int i = 0; i < function.size(); i++) {
            System.out.print(function.get(i) + " ");
        }
        System.out.println("\nCorrelation interval = " + correlation_interval);
    }

    public void FileOutput() throws IOException {
        try ( DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(Get_file.fout))) {
            outStream.writeUTF(Integer.toString(this.dinamic_range));
            outStream.writeUTF(Integer.toString(this.energy));
            outStream.writeUTF(Float.toString(this.average_power));
            outStream.writeUTF(Float.toString(this.average_value));
            outStream.writeUTF(Float.toString(this.dispersion));
            for (int i = 0; i < function.size(); i++) {
                outStream.writeUTF(Double.toString(function.get(i)));
            }
            outStream.close();
        }

        Get_file.Terminate();
    }

}
