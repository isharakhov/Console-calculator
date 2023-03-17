package calculator;

import exception.DivisionByZero;
import exception.WrongFormat;
import exception.WrongInputOperation;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    Integer number1;
    Integer number2;
    String operator = null;

    public Integer getNumber1() {
        return number1;
    }
    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }
    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.startCalculator();
    }

    private void startCalculator() {
        do {
            setNumberInCal();
            validInPutOperation();
            int result = action(number1, number2, operator); //Присваиваем result результат выполнения операций в классе operations
            System.out.println("Результат операции = " + result); //Выводим результат на экран
            continuation();
        } while (true);
    }

    public void setNumberInCal() {
        try {
            if (number1 == null) {
                System.out.print("Введите первое число: ");
                number1 = scanner.nextInt();
                if (number2 == null) {
                    System.out.print("Введите второе число: ");
                    number2 = scanner.nextInt();
                }
            }else{
                throw new WrongFormat("Вы ввели не число. Попробуйте еще раз");
            }
        } catch (WrongFormat e) {
            System.out.println(e.getMessage());
            setNumberInCal();
        }
    }

    public void validInPutOperation() {
        System.out.print("Введите операцию: ");
        if (operator == null) {
            operator = Calculator.scanner.next();
        }
        if (!operator.matches("([+]|[-]|[*]|[/])")) {
            throw new WrongInputOperation("Калькулятор не знает такой операции. Повторите ввод");
        }
    }

    public int action(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                if (number2 == 0) throw new DivisionByZero("На ноль делить нельзя");
                return number1 / number2;
            case "*":
                return number1 * number2;
            default:
                throw new WrongInputOperation("Вы ввели неправильную операцию");
        }
    }

    public void continuation() {
        System.out.println("Желаете продолжить? (да,нет)");
        String yesOrNot;
        yesOrNot = Calculator.scanner.next();
        if (yesOrNot.equals("да")) {
            startCalculator();
        } else {
            if (yesOrNot.equals("нет")) {
                System.exit(0);
            } else {
                throw new WrongFormat("Такого варианта нет");
            }
        }
    }
}