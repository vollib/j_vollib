package org.vollib.j_vollib.j_ref.black;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class BlackTest {

    private static double EPSILON = 1e-12;

    @Test
    public void testBlack() throws Exception {
        double F = 100, K = 100, r = 0.02, t = 0.5, sigma = 0.2;
        char flag = 'c';
        assertEquals(5.5811067246048118, Black.black(flag, F, K, t, r, sigma), EPSILON);
    }

    @Test
    public void testBlack_call() throws Exception {
        double F = 620, K = 600, r = 0.05, sigma = 0.2, t = 0.5;
        assertEquals(44.1868533121, Black.black_call(F, K, t, r, sigma), 1e-11);
    }

    @Test
    public void testBlack_put() throws Exception {
        double F = 20, K = 20, r = 0.09, t = 4/12.0, sigma = 0.25;
        assertEquals(1.11664145656, Black.black_put(F, K, t, r, sigma), 1e-11);
    }

    @Test
    public void testD1() throws Exception {
        double F = 20, K = 20, r = 0.09, t = 4/12.0, sigma = 0.25;
        assertEquals(0.0721687836487, Black.d1(F, K, t, r, sigma), EPSILON);
    }

    @Test
    public void testD2() throws Exception {
        double F = 20, K = 20, r = 0.09, t = 4/12.0, sigma = 0.25;
        assertEquals(-0.0721687836487, Black.d2(F, K, t, r, sigma), EPSILON);
    }

}