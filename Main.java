public class Main {
  public static void main(String [] args) {
    AddOperator addDelimeter = new AddOperator();
    SubOperator substractDelimeter = new SubOperator();
    DividOperator divideDelimeter = new DividOperator();
    MultOperator multDelimeter = new MultOperator();

    Operator[] array = {addDelimeter, substractDelimeter, divideDelimeter, multDelimeter};

    Postfix postfixCalculator = new Postfix(array);

    System.out.println("Das Ergebnis ist: " + postfixCalculator.eval("4 3 52 5 + - *"));
  }
}

