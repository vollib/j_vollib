package org.vollib.j_vollib;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Maricris on 23/04/2017.
 */
public class TestUtil {

    public static Map<String, List<Double>> loadTestData(){
        JSONObject jsonObject = null;
        try {
            jsonObject = loadJsonFile("test_data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, List<Double>> map = convertTestDataToMap(jsonObject);
        return map;
    }

    private static JSONObject loadJsonFile(String filename) throws IOException {
        InputStream inputStream = TestUtil.class.getResourceAsStream(filename);
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        }
        String jsonString = sb.toString();
        Object obj = JSONValue.parse(jsonString);
        return (JSONObject) obj;
    }

    private static Map<String, List<Double>> convertTestDataToMap(JSONObject jsonObject) {
        JSONArray index = (JSONArray)jsonObject.get("index");
        JSONArray data = (JSONArray)jsonObject.get("data");
        JSONArray columns = (JSONArray)jsonObject.get("columns");

        LinkedHashMap<String, List<Double>> map = new LinkedHashMap<>();
        for (int i = 0; i < columns.size(); i++) {
            String column = columns.get(i).toString();

            List<Double> values = new ArrayList<>();
            for (int j = 0; j < data.size(); j++) {
                JSONArray row = (JSONArray)data.get(j);
                Double value = Double.valueOf(row.get(i).toString());
                values.add(value);
            }

            map.put(column, values);
        }
        return map;
    }

    public static List<Double> linspace(double startValue, double endValue, int numElements) {
        double increment = (endValue-startValue) / (numElements-1);
        List<Double> doubles = IntStream.rangeClosed(0, numElements - 1).mapToDouble(i -> startValue + i * increment).boxed().collect(Collectors.toList());
        return doubles;
    }

    public static void toCsv(Map<String, String> values, String csvFilename) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilename), ',', CSVWriter.NO_QUOTE_CHARACTER);

        String[] mapKeys = values.keySet().toArray(new String[]{});
        String[] mapValues = values.values().toArray(new String[]{});

        writer.writeNext(mapKeys);
        writer.writeNext(mapValues);
        writer.close();
    }

    public static double diff_mean(List<Double> left, List<Double> right) {
        assert left.size() == right.size();
        DescriptiveStatistics abs_diff = new DescriptiveStatistics();
        for (int i = 0; i < left.size(); i++) {
            abs_diff.addValue(left.get(i) - right.get(i));
        }
        return abs_diff.getMean();
    }

}
