package org.vollib.j_vollib.black_scholes.greeks;

import org.vollib.j_vollib.black_scholes.BlackScholes;
import org.vollib.j_vollib.helper.NumericalGreeks;

/**
 * Created by Maricris on 22/04/2017.
 */
public class Numerical {

    private static NumericalGreeks.PricingFunction f = new NumericalGreeks.PricingFunction() {
        @Override
        public double call(char flag, double S, double K, double t, double r, double sigma, double b) {
            return BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        }
    };

    public static double delta(char flag, double S, double K, double t, double r, double sigma) {
        double b = r;
        return NumericalGreeks.delta(flag, S, K, t, r, sigma, b, f);
    }

    public static double theta(char flag, double S, double K, double t, double r, double sigma) {
        double b = r;
        return NumericalGreeks.theta(flag, S, K, t, r, sigma, b, f);
    }

    public static double vega(char flag, double S, double K, double t, double r, double sigma) {
        double b = r;
        return NumericalGreeks.vega(flag, S, K, t, r, sigma, b, f);
    }

    public static double rho(char flag, double S, double K, double t, double r, double sigma) {
        double b = r;
        return NumericalGreeks.rho(flag, S, K, t, r, sigma, b, f);
    }

    public static double gamma(char flag, double S, double K, double t, double r, double sigma) {
        double b = r;
        return NumericalGreeks.gamma(flag, S, K, t, r, sigma, b, f);
    }

}
