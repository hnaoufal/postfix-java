import java.util.*;

public class Operand implements Operator {
  private double operand;

  @Override
  public void pushOperand(double a) {
    this.operand = a;
  }
  
  @Override
  public double calculate() {
    return this.operand;
  }

  @Override
  public int getOperandCount() {
    return 0;
  }

  @Override
  public String getOperandSymbol() {
    return "";
  }
}

