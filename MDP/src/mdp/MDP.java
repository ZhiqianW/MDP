/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdp;

import java.io.File;
import java.util.Scanner;


public class MDP {

    public static void main(String[] args) {
        
        String[][] g = readFiles("F:\\GWU\\AI\\Project 4\\gridA.1.csv");
        grid testg = new grid(g);
        //testg.Printg();
        //testg.PrintgridV();
        //state tests = new state(0, 4, testg);
        //policy testp = new policy(tests);
        //testp.valueIteration();
        //testg.PrintgridV();
        double epsilon = 1e-4;
        double difference = Double.POSITIVE_INFINITY;
        while (difference > epsilon) {
            double t1 = testg.getV(0, 0);
            for (int i = 0; i < testg.m; i++) {
                for (int j = 0; j < testg.n; j++) {
                    if (testg.getstatev(i, j).equals("0")) {
                        state tests = new state(i, j, testg);
                        policy testp = new policy(tests);
                        testp.valueIteration();
                    }
                }
            }
            double t2 = testg.getV(0, 0);
            difference = Math.abs(t2-t1);
        }
        System.out.println("This is the Optimal Utility (V*)");
        System.out.println("-------------------------------------------");
        testg.PrintgridV();
        System.out.println("");
        System.out.println("This is the Optimal Policy of Action (pi*)");
        System.out.println("-------------------------------------------");
        testg.PrintgridA();
        
        
        




        //state tests3 = new state(2, 5, testg);
        //reward testr = new reward(tests3);
        //transition testt = new transition(tests, testa);
        
        
        /*System.out.println("-----");
        System.out.println(tests.getstateV());
        tests.updateV(0.11);
        System.out.println(tests.getstateV());
        System.out.println(testg.getV(2, 4));
        
        System.out.println("-----");
        System.out.println(tests.getstateValue());
        System.out.println(tests.checkwall());
        System.out.println(testt.getp()[0]);
        System.out.println(testt.getnextstates()[1].getstateValue());
        System.out.println(testr.getreward());
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
            System.out.print(g[i][j]);
            System.out.print(" ");
            }
            System.out.printf("%n");
        }*/

        
    }
    
        public static String[][] readFiles(String file) {
        try {
            File f = new File(file);
            Scanner Rs = new Scanner(f);
            Scanner Cs = new Scanner(f);
            int Rctr = 0;
            int Cctr = 0;
            String Rdata = Cs.next();
            String[] RdataArr = Rdata.split(",");
            Cctr = RdataArr.length;
            while (Rs.hasNext()) {
                Rctr++;
                Rs.next();
            }
            String[][] mtx = new String[Rctr][Cctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < Rctr; i++) {
                String data = s1.next();
                String[] values = data.split(",");
                for (int j = 0; j < Cctr; j++) {
                    mtx[i][j] = values[j];
                }
            }
            return mtx;
        }
        catch(Exception e){
            return null;
        }
    }
    
}
