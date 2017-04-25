package org.vollib.j_vollib.helper;

import org.junit.Test;
import org.vollib.j_lets_be_rational.NormalDistribution;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class HelperTest {

    @Test
    public void testHelperNormCdf() throws Exception {
        double z = 0.111;
        double lets_be_rational_value = NormalDistribution.norm_cdf(z);
        double apache_commons_maths_value = Helper.norm_cdf(z);
        assertEquals(lets_be_rational_value, apache_commons_maths_value, Constants.EPSILON);
    }

    @Test
    public void testNormCdf() throws Exception {
        double z = 0.302569738839;
        double actual = Helper.norm_cdf(z);
        double expected = 0.618891110513;
        assertEquals(expected, actual, 1e-12);

        z = 0.161148382602;
        actual = Helper.norm_cdf(z);
        expected = 0.564011732814;
        assertEquals(expected, actual, 1e-12);
    }

}