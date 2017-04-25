package org.vollib.j_vollib.j_ref.black_scholes.greeks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class AnalyticalTest {

    @Test
    public void testDelta() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.522, Analytical.delta(flag, S, K, t, r, sigma), 0.01);
    }

    @Test
    public void testTheta() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;

        double expected_call_annual_theta_text_book = -4.31;
        double actual_call = Analytical.theta('c', S, K, t, r, sigma) * 365;
        assertEquals(expected_call_annual_theta_text_book, actual_call, 0.01);

        double expected_put_annual_theta_text_book = -1.8530056722;
        double actual_put = Analytical.theta('p', S, K, t, r, sigma) * 365;
        assertEquals(expected_put_annual_theta_text_book, actual_put, 0.000001);
    }

    @Test
    public void testGamma() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.066, Analytical.gamma(flag, S, K, t, r, sigma), 0.01);
    }

    @Test
    public void testVega() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.121, Analytical.vega(flag, S, K, t, r, sigma), 0.01);
    }

    @Test
    public void testRho() throws Exception {
        double S = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        assertEquals(0.0891, Analytical.rho(flag, S, K, t, r, sigma), 0.0001);
    }

}