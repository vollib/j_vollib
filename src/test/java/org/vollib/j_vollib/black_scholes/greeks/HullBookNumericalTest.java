package org.vollib.j_vollib.black_scholes.greeks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class HullBookNumericalTest {

    private static double EPSILON = 0.00001;

    private static double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
    private static char flag = 'c';

    @Test
    public void testDelta() throws Exception {
        assertEquals(
                0.521601633972,
                Numerical.delta(flag, S, K, t, r, sigma),
                EPSILON
        );
    }

    @Test
    public void testTheta() throws Exception {
        assertEquals(
                -4.30538996455,
                Numerical.theta(flag, S, K, t, r, sigma) * 365,
                0.01
        );
    }

    @Test
    public void testGamma() throws Exception {
        assertEquals(
                0.0655453772525,
                Numerical.gamma(flag, S, K, t, r, sigma),
                EPSILON
        );
    }

    @Test
    public void testVega() throws Exception {
        assertEquals(
                0.121052427542,
                Numerical.vega(flag, S, K, t, r, sigma),
                EPSILON
        );
    }

    @Test
    public void testRho() throws Exception {
        assertEquals(
                0.089065740988,
                Numerical.rho(flag, S, K, t, r, sigma),
                EPSILON
        );
    }

}
