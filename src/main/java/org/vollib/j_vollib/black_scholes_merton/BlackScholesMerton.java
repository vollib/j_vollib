package org.vollib.j_vollib.black_scholes_merton;

import org.vollib.j_lets_be_rational.LetsBeRational;
import org.vollib.j_vollib.helper.Flag;

/**
 * Created by Maricris on 19/04/2017.
 */
public class BlackScholesMerton {

    public static double black_scholes_merton(char flag, double S, double K, double t, double r, double sigma, double q) {
        double F = S * Math.exp((r-q) * t);
        double deflater = Math.exp(-r * t);
        return LetsBeRational.black(F, K, sigma, t, Flag.valueOf(flag).doubleValue()) * deflater;
    }
}
