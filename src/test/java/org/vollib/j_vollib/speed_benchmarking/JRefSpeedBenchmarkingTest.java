package org.vollib.j_vollib.speed_benchmarking;

import org.junit.Test;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;
import org.vollib.j_vollib.j_ref.black.ImpliedVolatility;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static org.vollib.j_vollib.TestUtil.linspace;
import static org.vollib.j_vollib.TestUtil.toCsv;

/**
 * Created by Maricris on 25/04/2017.
 */
public class JRefSpeedBenchmarkingTest {

    @Test
    public void test_run() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum, IOException {
        LinkedHashMap<String, String> results = new LinkedHashMap<>();
        results.put("","0");

        for (Double d : linspace(2, 6, 10)) {
            int n = Double.valueOf(Math.pow(10, d)).intValue();
            List<Double> K = linspace(145, 150, n);
            double price = 0.001;
            double F = 100;
            char flag = 'c';
            double r = 0.01;
            double t = 0.5;

            long start = System.currentTimeMillis();
            for (Double k : K) {
                ImpliedVolatility.implied_volatility(price, F, k, r, t, flag);
            }
            long end = System.currentTimeMillis();
            double seconds = Double.valueOf(end - start)/1000.0;
            System.out.printf("%d calls in %f seconds\n", K.size(), seconds);

            results.put(String.valueOf(n), String.valueOf(seconds));

        }

        toCsv(results, "j_vollib.j_ref_results.csv");
    }

}
