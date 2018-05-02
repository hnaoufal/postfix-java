import java.util.*;

public class DividOperator implements Operator {
  private ArrayList<Double> operand = new ArrayList<Double>();
  private int valence = 2;

  @Override
  public void pushOperand(double a) {
    this.operand.add(a);
  }

  @Override
  public int getOperandCount() {
    return this.valence;
  }

  @Override
  public double calculate() {
    return add(this.operand.get(0), this.operand.get(1));
  }

  private double add(double a, double b) {
    double sum = 0;

    try {
      sum = a / b;
    } catch (Exception e) {
      System.err.println("Not allowed to divide with 0");
    }

    return sum;
  }

  @Override
  public String getOperandSymbol() {
    return "/";
  }

  public String operandSymbol() {
    return "/";
  }
}

