package org.vollib.j_vollib.j_ref;

import org.junit.Test;
import org.vollib.j_vollib.TestUtil;
import org.vollib.j_vollib.j_ref.black_scholes_merton.greeks.Analytical;
import org.vollib.j_vollib.j_ref.black_scholes_merton.greeks.Numerical;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.vollib.j_vollib.TestUtil.diff_mean;

/**
 * Created by Maricris on 23/04/2017.
 */
public class BlackScholesMertonGreeksTest {

    private static final double EPSILON = 0.001;
    private static final int TEST_SIZE = 10;

    private static Map<String, List<Double>> testData = initTestData();
    private static final double S = 100;
    private static final double q = 0;

    public static Map<String, List<Double>> initTestData() {
        List<Double> Ks = TestUtil.linspace(20, 200, TEST_SIZE);
        List<Double> ts = TestUtil.linspace(0.01, 2, TEST_SIZE);
        List<Double> rs = TestUtil.linspace(0, 0.2, TEST_SIZE);
        List<Double> sigmas = TestUtil.linspace(0.1, 0.5, TEST_SIZE);

        Map<String, List<Double>> map = new LinkedHashMap<>();
        map.put("K", Ks);
        map.put("t", ts);
        map.put("r", rs);
        map.put("sigma", sigmas);

        return map;
    }

    @Test
    public void test_theta() {
        List<Double> analyticalList = new ArrayList<>();
        List<Double> numericalList = new ArrayList<>();

        for (char flag : new char[]{'c', 'p'}) {
            for (int i = 0; i < TEST_SIZE; i++) {
                double K = testData.get("K").get(i);
                double t = testData.get("t").get(i);
                double r = testData.get("r").get(i);
                double sigma = testData.get("sigma").get(i);

                double analytical = Analytical.theta(flag, S, K, t, r, sigma, q);
                double numerical = Numerical.theta(flag, S, K, t, r, sigma, q);

                analyticalList.add(analytical);
                numericalList.add(numerical);
            }
        }

        assertTrue(diff_mean(analyticalList, numericalList) < EPSILON);
    }

    @Test
    public void test_delta() {
        List<Double> analyticalList = new ArrayList<>();
        List<Double> numericalList = new ArrayList<>();

        for (char flag : new char[]{'c', 'p'}) {
            for (int i = 0; i < TEST_SIZE; i++) {
                double K = testData.get("K").get(i);
                double t = testData.get("t").get(i);
                double r = testData.get("r").get(i);
                double sigma = testData.get("sigma").get(i);

                double analytical = Analytical.delta(flag, S, K, t, r, sigma, q);
                double numerical = Numerical.delta(flag, S, K, t, r, sigma, q);

                analyticalList.add(analytical);
                numericalList.add(numerical);
            }
        }

        assertTrue(diff_mean(analyticalList, numericalList) < EPSILON);
    }

    @Test
    public void test_gamma() {
        List<Double> analyticalList = new ArrayList<>();
        List<Double> numericalList = new ArrayList<>();

        for (char flag : new char[]{'c', 'p'}) {
            for (int i = 0; i < TEST_SIZE; i++) {
                double K = testData.get("K").get(i);
                double t = testData.get("t").get(i);
                double r = testData.get("r").get(i);
                double sigma = testData.get("sigma").get(i);

                double analytical = Analytical.gamma(flag, S, K, t, r, sigma, q);
                double numerical = Numerical.gamma(flag, S, K, t, r, sigma, q);

                analyticalList.add(analytical);
                numericalList.add(numerical);
            }
        }

        assertTrue(diff_mean(analyticalList, numericalList) < EPSILON);
    }

    @Test
    public void test_vega() {
        List<Double> analyticalList = new ArrayList<>();
        List<Double> numericalList = new ArrayList<>();

        for (char flag : new char[]{'c', 'p'}) {
            for (int i = 0; i < TEST_SIZE; i++) {
                double K = testData.get("K").get(i);
                double t = testData.get("t").get(i);
                double r = testData.get("r").get(i);
                double sigma = testData.get("sigma").get(i);

                double analytical = Analytical.vega(flag, S, K, t, r, sigma, q);
                double numerical = Numerical.vega(flag, S, K, t, r, sigma, q);

                analyticalList.add(analytical);
                numericalList.add(numerical);
            }
        }

        assertTrue(diff_mean(analyticalList, numericalList) < EPSILON);
    }

    @Test
    public void test_rho() {
        List<Double> analyticalList = new ArrayList<>();
        List<Double> numericalList = new ArrayList<>();

        for (char flag : new char[]{'c', 'p'}) {
            for (int i = 0; i < TEST_SIZE; i++) {
                double K = testData.get("K").get(i);
                double t = testData.get("t").get(i);
                double r = testData.get("r").get(i);
                double sigma = testData.get("sigma").get(i);

                double analytical = Analytical.rho(flag, S, K, t, r, sigma, q);
                double numerical = Numerical.rho(flag, S, K, t, r, sigma, q);

                analyticalList.add(analytical);
                numericalList.add(numerical);
            }
        }

        assertTrue(diff_mean(analyticalList, numericalList) < EPSILON);
    }

}
