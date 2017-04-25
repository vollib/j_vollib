package org.vollib.j_vollib.j_ref.black;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatilityTest {

    private static final double EPSILON = 1.0e-11;

    @Test
    public void testImplied_volatility_put() throws Exception {
        double F = 101, K = 102, sigma = 0.2, t = 0.5, r = 0.01;
        char flag = 'p';

        double discounted_call_price = Black.black(flag, F, K, t, r, sigma);
        double expected_discounted_call_price = 6.20451158097;
        assertEquals(expected_discounted_call_price, discounted_call_price, EPSILON);

        double iv = ImpliedVolatility.implied_volatility(discounted_call_price, F, K, r, t, flag);
        double expected_iv = sigma;
        assertEquals(expected_iv, iv, 0.1);
    }

    @Test
    public void testImplied_volatility_call() throws Exception {
        double F = 100, K = 100, sigma = 0.2, t = 0.5, r = 0.02;
        char flag = 'c';

        double discounted_call_price = Black.black(flag, F, K, t, r, sigma);
        double expected_discounted_call_price = 5.5811067246;
        assertEquals(expected_discounted_call_price, discounted_call_price, EPSILON);

        double iv = ImpliedVolatility.implied_volatility(discounted_call_price, F, K, r, t, flag);
        double expected_iv = 0.2;
        assertEquals(expected_iv, iv, 0.1);
    }

}