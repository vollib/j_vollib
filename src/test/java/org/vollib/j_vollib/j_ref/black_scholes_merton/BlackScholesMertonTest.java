package org.vollib.j_vollib.j_ref.black_scholes_merton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class BlackScholesMertonTest {

    @Test
    public void testBlack_scholes_merton() throws Exception {
        double S = 100, K = 95, q = 0.05, t = 0.5, r = 0.1, sigma = 0.2;

        double p_published_value = 2.4648;
        double p_calc = BlackScholesMerton.black_scholes_merton('p', S, K, t, r, sigma, q);

        assertEquals(p_published_value, p_calc, 0.0001);
    }

    @Test
    public void testD1() throws Exception {
        double S = 100, K = 95, q = 0.05, t = 0.5, r = 0.1, sigma = 0.2;
        assertEquals(0.6102, BlackScholesMerton.d1(S, K, t, r, sigma, q), 0.0001);
    }

    @Test
    public void testD2() throws Exception {
        double S = 100, K = 95, q = 0.05, t = 0.5, r = 0.1, sigma = 0.2;
        assertEquals(0.4688, BlackScholesMerton.d2(S, K, t, r, sigma, q), 0.0001);
    }

}