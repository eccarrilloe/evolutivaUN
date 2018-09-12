package unal.optimization;

import unal.functions.OptimizableFunction;

public interface Optimizable {
  public double[] optimize(OptimizableFunction f);
}
