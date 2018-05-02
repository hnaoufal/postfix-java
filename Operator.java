interface Operator {
  double calculate();
  void pushOperand(double a);
  int getOperandCount();
  String getOperandSymbol();
}
