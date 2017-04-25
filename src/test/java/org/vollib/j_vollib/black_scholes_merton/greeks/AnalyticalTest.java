package org.vollib.j_vollib.black_scholes_merton.greeks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class AnalyticalTest {

    private static final double EPSILON = 1e-11;

    @Test
    public void testDelta() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, q = 0, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.521601633972, Analytical.delta(flag, S, K, t, r, sigma, q), EPSILON);
    }

    @Test
    public void testTheta() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, q = 0, sigma = 0.2;

        double annual_theta_call = Analytical.theta('c', S, K, t, r, sigma, q) * 365;
        assertEquals(-4.30538996455, annual_theta_call, EPSILON);

        double annual_theta_put = Analytical.theta('p', S, K, t, r, sigma, q) * 365;
        assertEquals(-1.8530056722, annual_theta_put, EPSILON);
    }

    @Test
    public void testGamma() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, q = 0, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.0655453772525, Analytical.gamma(flag, S, K, t, r, sigma, q), EPSILON);
    }

    @Test
    public void testVega() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, q = 0, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.121052427542, Analytical.vega(flag, S, K, t, r, sigma, q), EPSILON);
    }

    @Test
    public void testRho() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, q = 0, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.089065740988, Analytical.rho(flag, S, K, t, r, sigma, q), EPSILON);
    }

}