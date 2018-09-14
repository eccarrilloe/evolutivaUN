package test;

import unal.functions.Rastrigin;
import unal.optimization.HillClimbingPowerLaw;

class HillClimbingPowerLawTest {
  public static void main(String[] args) {
    double alpha = .9;
    int iterations = 1000;
    HillClimbingPowerLaw hillClimbing = new HillClimbingPowerLaw(alpha, iterations);

    Rastrigin f = new Rastrigin(2, 2);
    double[] result = hillClimbing.optimize(f);
    System.out.println(result[0] + " - " + result[1]);
  }
}
