package org.vollib.j_vollib.black_scholes;

import org.vollib.j_vollib.black.Black;

/**
 * Created by Maricris on 19/04/2017.
 */
public class BlackScholes {

    public static double black_scholes(char flag, double S, double K, double t, double r, double sigma) {
        double deflater = Math.exp(-r * t);
        double F = S / deflater;
        return Black.undiscounted_black(F, K, sigma, t, flag) * deflater;
    }

}
