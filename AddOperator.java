import java.util.*;

public class AddOperator implements Operator {
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

  @Override
  public String getOperandSymbol() {
    return "+";
  }

  private double add(double a, double b) {
    return a + b;
  }
}

