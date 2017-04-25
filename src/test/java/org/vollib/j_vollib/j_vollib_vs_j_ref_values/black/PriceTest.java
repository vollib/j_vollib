package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black;

import org.junit.Test;
import org.vollib.j_vollib.black.Black;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class PriceTest {

    private static final double EPSILON = 1e-12;
    private static final double F = 100, K = 90, sigma = 0.2, r = 0.02, t = 0.5;

    @Test
    public void test_black_put() {
        char flag = 'p';
        double price = Black.black(flag, F, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black.Black.black(flag, F, K, t, r, sigma);
        assertEquals(price, price_j_ref, EPSILON);
    }

    @Test
    public void test_black_call() {
        char flag = 'c';
        double price = Black.black(flag, F, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black.Black.black(flag, F, K, t, r, sigma);
        assertEquals(price, price_j_ref, EPSILON);
    }

}
