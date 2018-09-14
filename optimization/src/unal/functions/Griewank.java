package unal.functions;

public class Griewank implements OptimizableFunction {

  private int d;
  private double limit;

  public Griewank(int d) {
    this.d = d;
    this.limit = 200;
  }

  public double f(double[] x) {
    double result = 1.0;
    double minusCos = 1.0;

    for (int i = 0; i < x.length; i++) {
      result += Math.pow(x[i], 2) / 4000;
      minusCos *= Math.cos(x[i] / Math.sqrt(i + 1));
    }

    result -= minusCos;

    return result;
  }

  public double[] gradient(double[] x) {
    double[] result = new double[this.d];

    for (int i = 0; i < result.length; i++) {
      result[i] = 1.0 + (x[i] / 2000);
      double minusCos = 1.0;

      for (int j = 0; j < x.length; j++) {
        if (i != j) {
          minusCos *= Math.cos(x[i] / Math.sqrt(i + 1));
        } else {
          minusCos *= Math.sin(x[i] / Math.sqrt(i + 1)) / Math.sqrt(i + 1);
        }
      }

      result[i] += minusCos;
    }


    return result;
  }

  public double[] getInitialPoint() {
    return new double[]{0.0};
  }

  public static void main(String[] args) {
    Griewank gr = new Griewank(2);
    double[] x = new double[]{100, 100};
    double res = gr.f(x);
    System.out.println(res);
  }
}
