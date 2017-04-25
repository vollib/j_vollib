package org.vollib.j_vollib.black_scholes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 19/04/2017.
 */
public class BlackScholesTest {

    public static final double EPSILON = 0.000001;

    @Test
    public void testBlack_scholes_call() throws Exception {
        assertEquals(12.111581435, BlackScholes.black_scholes('c', 100, 90, 0.5, 0.01, 0.2), EPSILON);
    }

    @Test
    public void testBlack_scholes_put() throws Exception {
        assertEquals(1.66270456231, BlackScholes.black_scholes('p', 100, 90, 0.5, 0.01, 0.2), EPSILON);
    }

}