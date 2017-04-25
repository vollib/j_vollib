package org.vollib.j_vollib.j_ref.black;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;

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

        UnivariateSolver solver = new BrentSolver(1e-15, 1e-15);
        return solver.solve(1000, f, 1e-12, 100);
    }

}
