/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v.rublova
 */
public class Signal_calculationsTest {

    private final ArrayList<Integer> data;

    public Signal_calculationsTest() {
        data = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(2);
                add(3);
                add(4);
            }
        };
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of dinamic_range_c method, of class Signal_calculations.
     */
    @Test
    public void testDinamic_range_c() {
        System.out.println("dinamic_range_c");
        int expResult = 4;
        int result = Signal_calculations.dinamic_range_c(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of energy_c method, of class Signal_calculations.
     */
    @Test
    public void testEnergy_c() {
        System.out.println("energy_c");
        int expResult = 55;
        int result = Signal_calculations.energy_c(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of average_power_c method, of class Signal_calculations.
     */
    @Test
    public void testAverage_power_c() {
        System.out.println("average_power_c");
        float expResult = 11;
        float result = Signal_calculations.average_power_c(data);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of average_value_c method, of class Signal_calculations.
     */
    @Test
    public void testAverage_value_c() {
        System.out.println("average_value_c");
        float expResult = 3;
        float result = Signal_calculations.average_value_c(data);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of dispersion_c method, of class Signal_calculations.
     */
    @Test
    public void testDispersion_c() {
        System.out.println("dispersion_c");
        float expResult = 2.0F;
        float result = Signal_calculations.dispersion_c(data);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of function method, of class Signal_calculations.
     */
    @Test
    public void testFunction() {
        System.out.println("function");
        int t_0 = 1;
        int t_n = 2;
        ArrayList<Double> expResult = new ArrayList<Double>() {
            {
                add(-1.5);
            }
        };
        ArrayList<Double> result = Signal_calculations.function(data, t_0, t_n);
        assertEquals(expResult, result);
    }

    /**
     * Test of func method, of class Signal_calculations.
     */
    @Test
    public void testFunc() {
        System.out.println("func");
        int t = 1;
        double expResult = -1.5;
        double result = Signal_calculations.func(data, t);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of correlation_interval method, of class Signal_calculations.
     */
    @Test
    public void testCorrelation_interval() {
        System.out.println("correlation_interval");
        double expResult = -0.08;
        double result = Signal_calculations.correlation_interval(data);
        assertEquals(expResult, result, 0.01);
    }

}
