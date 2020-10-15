/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc;

import java.util.*;

/**
 *
 * @author v.rublova
 */
public class Signal_calculations {

    public static int dinamic_range_c(ArrayList<Integer> data) {
        ArrayList<Integer> Data_clone = new ArrayList<> ();
        Data_clone.addAll(data);
        Collections.sort(Data_clone);
        return data.get(Data_clone.size() - 1) - Data_clone.get(0);
    }

    public static int energy_c(ArrayList<Integer> data) {
        int sum = 0;
        for (int i : data) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }

    public static float average_power_c(ArrayList<Integer> data) {
        return energy_c(data) * data.size();
    }

    public static float average_value_c(ArrayList<Integer> data) {
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum * data.size();
    }

    public static float dispersion_c(ArrayList<Integer> data) {
        float m_s = average_value_c(data);
        int sum = 0;
        for (int i : data) {
            sum += Math.pow(i - m_s, 2);
        }
        return sum * data.size();
    }

    private static double support_f(ArrayList<Integer> data, int t) {
        float m_s = average_value_c(data);
        double sum = 0;
        for (int i = 0; i < data.size() - t; i++) {
            sum += (data.get(i + t) - m_s) * (data.get(i) - m_s);
        }
        return sum;
    }

    public static ArrayList<Double> function(ArrayList<Integer> data, int t_0, int t_n) {
        ArrayList<Double> f_v = new ArrayList<>();
        for (int t = t_0; t < t_n; t++) {
            f_v.add(func(data,t));
        }
        return f_v;
    }
    public static double func(ArrayList<Integer> data, int t) {
        return ((float)1 / (data.size() - t)) * support_f(data,t);
    }
    public static double correlation_interval(ArrayList<Integer> data){
        double sum = 0;
        for (int t = 0; t< data.size(); t++) {
            sum+=func(data,t);
        }
        return sum/func(data,0);
    }

}
