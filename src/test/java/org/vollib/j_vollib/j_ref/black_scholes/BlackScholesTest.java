package org.vollib.j_vollib.j_ref.black_scholes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class BlackScholesTest {

    public static final double EPSILON = 0.000001;

    @Test
    public void testBlack_scholes_call() throws Exception {
        assertEquals(12.111581435, BlackScholes.black_scholes('c', 100, 90, 0.5, 0.01, 0.2), EPSILON);
    }

    @Test
    public void testBlack_scholes_put() throws Exception {
        assertEquals(1.66270456231, BlackScholes.black_scholes('p', 100, 90, 0.5, 0.01, 0.2), EPSILON);
    }


    @Test
    public void testD1() throws Exception {
        double S = 42, K = 40, r = 0.10, sigma = 0.20, t = 0.5;
        assertEquals(0.7693, BlackScholes.d1(S, K, t, r, sigma), 0.0001);
    }

    @Test
    public void testD2() throws Exception {
        double S = 42, K = 40, r = 0.10, sigma = 0.20, t = 0.5;
        assertEquals(0.6278, BlackScholes.d2(S, K, t, r, sigma), 0.0001);
    }
}