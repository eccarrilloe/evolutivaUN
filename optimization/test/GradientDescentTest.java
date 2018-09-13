package test;

import unal.functions.Rastrigin;
import unal.optimization.GradientDescent;

class GradientDescentTest {
  public static void main(String[] args) {
    double alpha = .005;
    int iterations = 1000;
    GradientDescent gradient = new GradientDescent(alpha, iterations);

    Rastrigin f = new Rastrigin(2, 2);
    double[] result = gradient.optimize(f);
    System.out.println(result[0] + " - " + result[1]);
  }
}
