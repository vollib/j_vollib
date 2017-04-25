package org.vollib.j_vollib.j_ref.black_scholes_merton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatilityTest {

    private static final double EPSILON = 1e-12;

    @Test
    public void testImplied_volatility() throws Exception {
        double S = 100, K = 100, sigma = 0.2, r = 0.01, t = 0.5, q = 0.02;

        double price_call = BlackScholesMerton.black_scholes_merton('c', S, K, t, r, sigma, q);
        double iv_call = ImpliedVolatility.implied_volatility(price_call, S, K, t, r, q, 'c');
        double expected_price_call = 5.350452896345668;
        double expected_iv_call = 0.20000000000000018;
        assertEquals(expected_price_call, price_call, EPSILON);
        assertEquals(expected_iv_call, iv_call, EPSILON);

        sigma = 0.3;
        double price_put = BlackScholesMerton.black_scholes_merton('p', S, K, t, r, sigma, q);
        double iv_put = ImpliedVolatility.implied_volatility(price_put, S, K, t, r, q, 'p');
        double expected_price_put = 8.634365624535329;
        double expected_iv_put = 0.3;
        assertEquals(expected_price_put, price_put, EPSILON);
        assertEquals(expected_iv_put, iv_put, EPSILON);

        double price_call_2 = BlackScholesMerton.black_scholes_merton('c', S, K, t, r, sigma, q);
        double iv_call_2 = ImpliedVolatility.implied_volatility(price_put, S, K, t, r, q, 'c');
        double expected_price_call_2 = 8.138101080183908;
        double expected_iv_call_2 = 0.3178352937414786;
        assertEquals(expected_price_call_2, price_call_2, EPSILON);
        assertEquals(expected_iv_call_2, iv_call_2, EPSILON);

    }

}