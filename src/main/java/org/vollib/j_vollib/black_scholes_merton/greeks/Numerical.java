package org.vollib.j_vollib.black_scholes_merton.greeks;

import org.vollib.j_vollib.black_scholes_merton.BlackScholesMerton;
import org.vollib.j_vollib.helper.NumericalGreeks;

/**
 * Created by Maricris on 23/04/2017.
 */
public class Numerical {

    private static NumericalGreeks.PricingFunction f = new NumericalGreeks.PricingFunction() {
        @Override
        public double call(char flag, double S, double K, double t, double r, double sigma, double b) {
            return BlackScholesMerton.black_scholes_merton(flag, S, K, t, r, sigma, r-b);
        }
    };

    public static double delta(char flag, double S, double K, double t, double r, double sigma, double q) {
        double b = r - q;
        return NumericalGreeks.delta(flag, S, K, t, r, sigma, b, f);
    }

    public static double theta(char flag, double S, double K, double t, double r, double sigma, double q) {
        double b = r - q;
        return NumericalGreeks.theta(flag, S, K, t, r, sigma, b, f);
    }

    public static double vega(char flag, double S, double K, double t, double r, double sigma, double q) {
        double b = r - q;
        return NumericalGreeks.vega(flag, S, K, t, r, sigma, b, f);
    }

    public static double rho(char flag, double S, double K, double t, double r, double sigma, double q) {
        double b = r - q;
        return NumericalGreeks.rho(flag, S, K, t, r, sigma, b, f);
    }

    public static double gamma(char flag, double S, double K, double t, double r, double sigma, double q) {
        double b = r - q;
        return NumericalGreeks.gamma(flag, S, K, t, r, sigma, b, f);
    }

}
