package org.vollib.j_vollib.black;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 19/04/2017.
 */
public class ImpliedVolatilityTest {

    static final double EPSILON = 0.00001;

    @Test
    public void testImplied_volatitlity() throws Exception {
        double F = 100, K = 100, sigma = 0.2, t = 0.5, r = 0.02;
        char flag = 'c';

        double discounted_call_price = Black.black(flag, F, K, t, r, sigma);
        double iv = ImpliedVolatility.implied_volatility(discounted_call_price, F, K, r, t, flag);

        double expected_price = 5.5811067246;
        double expected_iv = 0.2;

        assertEquals(expected_price, discounted_call_price, EPSILON);
        assertEquals(expected_iv, iv, EPSILON);

    }

    @Test
    public void testImplied_volatility_of_discounted_option_price() throws Exception {
        double F = 100, K = 100, sigma = 0.2, t = 0.5, r = 0.02;
        char flag = 'c';

        double discounted_call_price = Black.black(flag, F, K, t, r, sigma);
        double iv = ImpliedVolatility.implied_volatility_of_discounted_option_price(discounted_call_price, F, K, r, t, flag);

        double expected_price = 5.5811067246;
        double expected_iv = 0.2;

        assertEquals(expected_price, discounted_call_price, EPSILON);
        assertEquals(expected_iv, iv, EPSILON);
    }

    @Test
    public void testNormalised_implied_volatility() throws Exception {
        double beta_call = Black.normalised_black(0.0, 0.2, 'c');
        double beta_put = Black.normalised_black(0.1, 0.23232323888, 'p');
        double normalized_b76_iv_call = ImpliedVolatility.normalised_implied_volatility(beta_call, 0.0, 'c');
        double normalized_b76_iv_put = ImpliedVolatility.normalised_implied_volatility(beta_put, 0.1, 'p');

        double expected_price_call = 0.0796556745541;
        double expected_iv_call = 0.2;

        assertEquals(expected_price_call, beta_call, EPSILON);
        assertEquals(expected_iv_call, normalized_b76_iv_call, EPSILON);

        double expected_price_put = 0.0509710222785;
        double expected_iv_put = 0.23232323888;

        assertEquals(expected_price_put, beta_put, EPSILON);
        assertEquals(expected_iv_put, normalized_b76_iv_put, EPSILON);
    }

    @Test
    public void testNormalised_implied_volatility_limited_iterations() throws Exception {

        double beta_call = Black.normalised_black(0.0, 0.2, 'c');
        double beta_put = Black.normalised_black(0.1, 0.23232323888, 'p');
        double normalized_b76_iv_call = ImpliedVolatility.normalised_implied_volatility_limited_iterations(beta_call, 0.0, 'c', 1);
        double normalized_b76_iv_put = ImpliedVolatility.normalised_implied_volatility_limited_iterations(beta_put, 0.1, 'p', 1);

        double expected_price_call = 0.0796556745541;
        double expected_iv_call = 0.2;

        assertEquals(expected_price_call, beta_call, EPSILON);
        assertEquals(expected_iv_call, normalized_b76_iv_call, EPSILON);

        double expected_price_put = 0.0509710222785;
        double expected_iv_put = 0.23232323888;

        assertEquals(expected_price_put, beta_put, EPSILON);
        assertEquals(expected_iv_put, normalized_b76_iv_put, EPSILON);
    }

    @Test
    public void testImplied_volatility_of_undiscounted_option_price() throws Exception {
        double F = 100, K = 100, sigma = 0.2, t = 0.5;
        char flag = 'c';

        double undiscounted_call_price = Black.undiscounted_black(F, K, sigma, t, flag);
        double iv = ImpliedVolatility.implied_volatility_of_undiscounted_option_price(undiscounted_call_price, F, K, t, flag);

        double expected_price = 5.6371977797;
        double expected_iv = 0.2;

        assertEquals(expected_price, undiscounted_call_price, EPSILON);
        assertEquals(expected_iv, iv, EPSILON);
    }

    @Test
    public void testImplied_volatility_of_undiscounted_option_price_limited_iterations() throws Exception {
        double F = 100, K = 100, sigma = 0.232323232, t = 0.5;
        char flag = 'c';

        double price = Black.undiscounted_black(F, K, sigma, t, flag);
        double iv = ImpliedVolatility.implied_volatility_of_undiscounted_option_price_limited_iterations(
                price, F, K, t, flag, 1);

        double expected_price = 6.54635543387;
        double expected_iv = 0.232323232;

        assertEquals(expected_price, price, EPSILON);
        assertEquals(expected_iv, iv, EPSILON);
    }
}