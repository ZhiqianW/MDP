package edu.codeknights.ai.p4a.mdp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MDP {

    public static void main(String[] args) {

        String[][] g = readFiles("gridA.1.csv");
        if (g == null) {
            System.out.println("Empty Grid!");
            return;
        }
        grid testg = new grid(g);
        double epsilon = 1e-4;
        double difference = Double.POSITIVE_INFINITY;
        while (difference > epsilon) {
            double t1 = testg.getV(0, 0);
            for (int i = 0; i < testg.m; i++) {
                for (int j = 0; j < testg.n; j++) {
                    if ("0".equals(testg.getstatev(i, j))) {
                        state tests = new state(i, j, testg);
                        policy testp = new policy(tests);
                        testp.valueIteration();
                    }
                }
            }
            double t2 = testg.getV(0, 0);
            difference = Math.abs(t2 - t1);
        }
        System.out.println("This is the Optimal Utility (V*)");
        System.out.println("-------------------------------------------");
        testg.PrintgridV();
        System.out.println("");
        System.out.println("This is the Optimal Policy of Action (pi*)");
        System.out.println("-------------------------------------------");
        testg.PrintgridA();
    }

    private static String[][] readFiles(String file) {
        try {
            // read file
            InputStream inputStream = MDP.class.getClassLoader().getResourceAsStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            StringBuilder builder = new StringBuilder();
            try (Reader reader = new BufferedReader(inputStreamReader)) {
                int c;
                while ((c = reader.read()) != -1) {
                    builder.append((char) c);
                }
            }

            // extract matrix
            String string = builder.toString();
            String[] rows = string.split("\r");
            String[][] mtx = new String[rows.length][rows[0].split(",").length];
            for (int i = 0; i < rows.length; i++) {
                String[] nums = rows[i].trim().split(",");
                System.arraycopy(nums, 0, mtx[i], 0, nums.length);
            }
            return mtx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
