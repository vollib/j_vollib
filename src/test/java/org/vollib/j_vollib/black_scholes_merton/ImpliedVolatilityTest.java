package org.vollib.j_vollib.black_scholes_merton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 19/04/2017.
 */
public class ImpliedVolatilityTest {

    public static final double EPSILON = 0.00001;

    @Test
    public void testImplied_volatility() throws Exception {
        double S = 100, K = 100, sigma = 0.2, r = 0.01, t = 0.5, q = 0;
        char flag = 'c';

        double price = BlackScholesMerton.black_scholes_merton(flag, S, K, t, r, sigma, q);
        double iv = ImpliedVolatility.implied_volatility(price, S, K, t, r, q, flag);

        double expected_price = 5.87602423383;
        double expected_iv = 0.2;

        assertEquals(expected_price, price, EPSILON);
        assertEquals(expected_iv, iv, EPSILON);
    }
}