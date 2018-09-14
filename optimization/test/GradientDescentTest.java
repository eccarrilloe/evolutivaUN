package test;

import java.io.PrintWriter;
import java.io.IOException;

import unal.optimization.GradientDescent;
import unal.functions.*;

class GradientDescentTest {
  public static void main(String[] args) {
    int repeats = 30;
    double alpha = .005;
    int iterations = 1000;

    Rastrigin rastrigin = new Rastrigin(2, 2);
    Schwefel schwefel = new Schwefel(2);
    Griewank griewank = new Griewank(2);

    double[][][] results = new double[3][repeats][iterations + 1];
    GradientDescent gradDesc = new GradientDescent(alpha, iterations);

    for (int i = 0; i < repeats; i++) {
      double[] rastriginResults = gradDesc.optimize(rastrigin);
      double[] schwefelResults = gradDesc.optimize(schwefel);
      double[] griewankResults = gradDesc.optimize(griewank);

      for (int j = 0; j < results.length; j++) {
        results[0][i][j] = rastriginResults[j];
        results[1][i][j] = schwefelResults[j];
        results[2][i][j] = griewankResults[j];
      }
    }

    try {
      PrintWriter outRastrigin = new PrintWriter("results/GradientDescent/Rastrigin.txt", "UTF-8");
      PrintWriter outSchwefel = new PrintWriter("results/GradientDescent/Schwefel.txt", "UTF-8");
      PrintWriter outGriewank = new PrintWriter("results/GradientDescent/Griewank.txt", "UTF-8");
      for (int j = 0; j < iterations + 1; j++) {
        for (int i = 0; i < repeats; i++) {
          outRastrigin.print(results[0][i][j] + ";");
          outSchwefel.print(results[1][i][j] + ";");
          outGriewank.print(results[2][i][j] + ";");
        }
        outRastrigin.println();
        outSchwefel.println();
        outGriewank.println();
      }
      outRastrigin.close();
      outSchwefel.close();
      outGriewank.close();

      System.out.println("INFO: Files Generated Successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
