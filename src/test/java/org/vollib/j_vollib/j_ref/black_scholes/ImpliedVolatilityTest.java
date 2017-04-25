package org.vollib.j_vollib.j_ref.black_scholes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatilityTest {

    private static final double EPSILON = 1e-9;

    @Test
    public void testImplied_volatility_call() throws Exception {
        double S = 100, K = 100, sigma = 0.2, r = 0.01, t = 0.5;
        char flag = 'c';

        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double expected_price = 5.87602423383;
        assertEquals(expected_price, price, EPSILON);

        double iv = ImpliedVolatility.implied_volatility(price, S, K, t, r, flag);
        double expected_iv = 0.2;
        assertEquals(expected_iv, iv, EPSILON);
    }

    @Test
    public void testImplied_volatility_put() throws Exception {
        double S = 100.0, K = 1000.0, t = 0.5, r = 0.05, sigma = 0.3;
        char flag = 'p';

        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double expected_price = 875.309912028;
        assertEquals(expected_price, price, EPSILON);

        double iv = ImpliedVolatility.implied_volatility(price, S, K, t, r, flag);
        double expected_iv = 0.0;
        assertEquals(expected_iv, iv, EPSILON);
    }

}