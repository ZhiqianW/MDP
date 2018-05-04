package edu.codeknights.ai.p4a.mdp;

public class grid {
  public final int m;
  public final int n;
  private final String[][] Grid;
  private final double[][] gridV;
  private final String[][] gridA;

  public grid(final String[][] input) {
    Grid = input;
    m = input.length;
    n = input[0].length;
    gridV = new double[m][n];
    gridA = new String[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (Grid[i][j].equals("-")) {
          gridV[i][j] = 0;
        }
        if (Grid[i][j].equals("0")) {
          gridV[i][j] = 0;
        }
        if (Grid[i][j].equals("-800")) {
          gridV[i][j] = -800;
        }
        if (Grid[i][j].equals("1000")) {
          gridV[i][j] = 1000;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (Grid[i][j].equals("-")) {
          gridA[i][j] = "-";
        }
        if (Grid[i][j].equals("0")) {
          gridA[i][j] = "N";
        }
        if (Grid[i][j].equals("-800")) {
          gridA[i][j] = "-1";
        }
        if (Grid[i][j].equals("1000")) {
          gridA[i][j] = "1";
        }
      }
    }
  }

  public String getstatev(final int rowindex, final int colindex) {
    return Grid[rowindex][colindex];
  }

  public void updateV(final int rowIndex, final int colIndex, final double utility) {
    gridV[rowIndex][colIndex] = utility;
  }

  public double getV(final int rowIndex, final int colIndex) {
    return gridV[rowIndex][colIndex];
  }

  public void updateA(final int rowInd, final int colInd, final action optimalpolicy) {
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
        if (d == 0.0) {
          System.out.print("-");
        }
        else {
          System.out.print(d);
        }
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
