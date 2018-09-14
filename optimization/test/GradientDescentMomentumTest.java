package test;

import unal.functions.Rastrigin;
import unal.optimization.GradientDescentMomentum;

class GradientDescentMomentumTest {
  public static void main(String[] args) {
    double alpha = .005;
    double miu = .2;
    int iterations = 1000;
    GradientDescentMomentum gradient = new GradientDescentMomentum(alpha, miu, iterations);

    Rastrigin f = new Rastrigin(2, 2);
    double[] result = gradient.optimize(f);
    System.out.println(result[0] + " - " + result[1]);
  }
}
