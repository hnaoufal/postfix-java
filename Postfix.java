import java.util.StringTokenizer;
import java.util.Stack;

public class Postfix {
  private Operator[] delimeters = null;

  Postfix(Operator[] operators) {
    this.delimeters = operators;
  }

  private String getTokenizerString() {
    // initialize token with whitespace
    String token = " ";

    for (Operator ops : this.delimeters) {
      token += ops.getOperandSymbol();
    }

    return token;
  }

  public double eval(String expr) {
    Stack<Operator> stack = new Stack();
    String givenDelimeters = this.getTokenizerString();
    StringTokenizer st = new StringTokenizer(expr, givenDelimeters, true);
    String temp;

    while(st.hasMoreTokens()) {
      temp = st.nextToken();

      // Filter Whitespcaes
      if (temp.indexOf(" ") == -1) {

        if (this.getTokenizerString().indexOf(temp) == -1) {
          try {
            double value = Double.parseDouble(temp) ;
            Operand operand = new Operand();

            operand.pushOperand(value);
            stack.push(operand);
          } catch ( Exception e ) {
            System.err.println("Ergebnis ist undefiniert: " + e);
          }
        } else {
          Operator actualOperator = this.calculateFunction(temp);
          Operand sumOperand = new Operand();
          int times = actualOperator.getOperandCount();
          double result = 0;


          for(int i = 0; i < times; i++) {
            Operand tmpOperand = new Operand();
            actualOperator.pushOperand(stack.pop().calculate());
          }

          result = actualOperator.calculate();
          sumOperand.pushOperand(result);

          stack.push(sumOperand);
        }
      }
    }

    return stack.pop().calculate();
  }

  private Operator calculateFunction(String a) {
    switch(a) {
      case("+"):
        AddOperator add = new AddOperator();
        return add;
      case("-"):
        SubOperator sub = new SubOperator();
        return sub;
      case("*"):
        MultOperator mult = new MultOperator();
        return mult;
      default:
        DividOperator div = new DividOperator();
        return div;
    }
  }
}

