package edu.codeknights.ai.p4a.mdp;


public class grid {
    public final int m;
    public final int n;
    private final String[][] Grid;
    private double[][] gridV;
    private String[][] gridA;

    public grid(String[][] input) {
        this.Grid = input;
        this.m = input.length;
        this.n = input[0].length;
        this.gridV = new double[m][n];
        this.gridA = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Grid[i][j].equals("-"))
                    gridV[i][j] = 0;
                if (Grid[i][j].equals("0"))
                    gridV[i][j] = 0;
                if (Grid[i][j].equals("-800"))
                    gridV[i][j] = -1;
                if (Grid[i][j].equals("1000"))
                    gridV[i][j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Grid[i][j].equals("-"))
                    gridA[i][j] = "-";
                if (Grid[i][j].equals("0"))
                    gridA[i][j] = "N";
                if (Grid[i][j].equals("-800"))
                    gridA[i][j] = "-1";
                if (Grid[i][j].equals("1000"))
                    gridA[i][j] = "1";
            }
        }
    }

    public String getstatev(int rowindex, int colindex) {
        return Grid[rowindex][colindex];
    }

    public void updateV(int rowIndex, int colIndex, double utility) {
        gridV[rowIndex][colIndex] = utility;
    }

    public double getV(int rowIndex, int colIndex) {
        return gridV[rowIndex][colIndex];
    }

    public void updateA(int rowInd, int colInd, action optimalpolicy) {
        gridA[rowInd][colInd] = optimalpolicy.getactString();
    }

    public void Printg() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Grid[i][j]);
                System.out.print(" ");
            }
            System.out.printf("%n");
        }
    }

    public void PrintgridV() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double d = gridV[i][j];
                d = Math.round(d * 100.0) / 100.0;
                System.out.print(d);
                System.out.print(" ");
            }
            System.out.printf("%n");
        }
    }

    public void PrintgridA() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(gridA[i][j]);
                System.out.print(" ");
            }
            System.out.printf("%n");
        }
    }

}
