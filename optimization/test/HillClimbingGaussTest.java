package test;

import unal.functions.Rastrigin;
import unal.optimization.HillClimbingGauss;

class HillClimbingGaussTest {
  public static void main(String[] args) {
    double sigma = .01;
    int iterations = 1000;
    HillClimbingGauss hillClimbing = new HillClimbingGauss(sigma, iterations);

    Rastrigin f = new Rastrigin(2, 2);
    double[] result = hillClimbing.optimize(f);
    System.out.println(result[0] + " - " + result[1]);
  }
}
