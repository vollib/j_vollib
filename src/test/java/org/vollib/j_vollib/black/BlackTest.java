package org.vollib.j_vollib.black;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.vollib.j_vollib.helper.Constants.EPSILON;

/**
 * Created by Maricris on 19/04/2017.
 */
public class BlackTest {

    @Test
    public void testBlack() throws Exception {
        double F = 100;
        double K = 100;
        double sigma = 0.2;
        char flag = 'c';
        double r = 0.02;
        double t = 0.5;

        double actual = Black.black(flag, F, K, t, r, sigma);
        double expected = 5.5811067246048118;

        assertEquals(expected, actual, EPSILON);
    }


    @Test
    public void testBlack_call() throws Exception {
        double F = 620, K = 600, r = 0.05, sigma = 0.2, t = 0.5;
        assertEquals(44.1868533121, Black.black('c', F, K, t, r, sigma), 1e-11);
    }

    @Test
    public void testBlack_put() throws Exception {
        double F = 20, K = 20, r = 0.09, t = 4/12.0, sigma = 0.25;
        assertEquals(1.11664145656, Black.black('p', F, K, t, r, sigma), 1e-11);
    }

    @Test
    public void testUndiscountedBlack() throws Exception {
        double F = 100;
        double K = 100;
        double sigma = 0.2;
        char flag = 'c';
        double t = 0.5;

        double actual = Black.undiscounted_black(F, K, sigma, t, flag);
        double expected = 5.637197779701664;

        assertEquals(expected, actual, EPSILON);
    }

    @Test
    public void testNormalisedBlack() throws Exception {
        double F = 100;
        double K = 95;
        double x = Math.log(F / K);
        double t = 0.5;
        double v = 0.3;
        double s = v * Math.sqrt(t);

        assertEquals(0.061296663817558904, Black.normalised_black(x, s, 'p'), EPSILON);
        assertEquals(0.11259558142181655, Black.normalised_black(x, s, 'c'), EPSILON);
    }
}