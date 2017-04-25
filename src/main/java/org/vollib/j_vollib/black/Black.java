package org.vollib.j_vollib.black;

import org.vollib.j_lets_be_rational.LetsBeRational;
import org.vollib.j_vollib.helper.Flag;

/**
 * Created by Maricris on 19/04/2017.
 */
public class Black {

    public static double black(char flag, double F, double K, double t, double r, double sigma) {
        double deflater = Math.exp(-r * t);
        return undiscounted_black(F, K, sigma, t, flag) * deflater;
    }

    public static double undiscounted_black(double F, double K, double sigma, double t, char flag) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.black(F, K, sigma, t, q);
    }

    public static double normalised_black(double x, double s, char flag) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.normalised_black(x, s, q);
    }

}
