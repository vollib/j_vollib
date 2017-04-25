package org.vollib.j_vollib.j_ref.black;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.vollib.j_vollib.helper.Helper;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(double price, double F, double K, double r, double t, char flag) {
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double sigma) {
                return price - Black.black(flag, F, K, t, r, sigma);
            }
        };

        return Helper.brent(f);
    }

}
