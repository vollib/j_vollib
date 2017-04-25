package org.vollib.j_vollib.helper;


import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by Maricris on 19/04/2017.
 */
public class Helper {

    public static double forward_price(double S, double t, double r) {
        return S/Math.exp(-r*t);
    }

    public static double norm_cdf(double x) {
        return new NormalDistribution().cumulativeProbability(x);
    }

    public static double norm_pdf(double x) {
        return org.vollib.j_lets_be_rational.Constants.ONE_OVER_SQRT_TWO_PI * Math.exp(-0.5 * x * x);
    }
}
