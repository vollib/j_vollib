package org.vollib.j_vollib.j_ref.black.greeks;

import org.vollib.j_vollib.helper.NumericalGreeks;
import org.vollib.j_vollib.j_ref.black.Black;

/**
 * Created by Maricris on 23/04/2017.
 */
public class Numerical {

    private static NumericalGreeks.PricingFunction f = new NumericalGreeks.PricingFunction() {
        @Override
        public double call(char flag, double F, double K, double t, double r, double sigma, double b) {
            return Black.black(flag, F, K, t, r, sigma);
        }
    };

    private static double b = 0;

    public static double delta(char flag, double F, double K, double t, double r, double sigma) {
        return NumericalGreeks.delta(flag, F, K, t, r, sigma, b, f);
    }

    public static double theta(char flag, double F, double K, double t, double r, double sigma) {
        return NumericalGreeks.theta(flag, F, K, t, r, sigma, b, f);
    }

    public static double vega(char flag, double F, double K, double t, double r, double sigma) {
        return NumericalGreeks.vega(flag, F, K, t, r, sigma, b, f);
    }

    public static double rho(char flag, double F, double K, double t, double r, double sigma) {
        return NumericalGreeks.rho(flag, F, K, t, r, sigma, b, f);
    }

    public static double gamma(char flag, double F, double K, double t, double r, double sigma) {
        return NumericalGreeks.gamma(flag, F, K, t, r, sigma, b, f);
    }

}
