package single;

import calculator.Calculator;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Набор тестов для проверки операций калькулятора
 */
@Epic("Операции калькулятора(Single)")
@Feature("Все вычисление калькулятором(+,-,/,*)")
@Owner("Пупкин Иван Анатольевич")
public class CalculatorTestOperations {

    private Calculator calculator;

    /**
     * Создаем новый экземпляр калькулятора для каждого теста
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Проверка +
     */
    @Test(description = "Операция сложения(+)")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка вычисления сложения")
    @Description("Тест проверяет совпадает ли результат сложения с ожидаемым")
    public void testPutOperationSumInCalculator() {
        int number1 = 666;
        int number2 = 555;
        String operation = "+";
        int result = calculator.action(number1, number2, operation);
        assertEquals(1221, result);
    }

    /**
     * Проверка -
     */
    @Test(description = "Операция вычитания(-)")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка вычисления вычитания")
    @Description("Тест проверяет совпадает ли результат вычитания с ожидаемым")
    public void testPutOperationDifferenceInCalculator() {
        int number1 = 666;
        int number2 = 555;
        String operation = "-";
        int result = calculator.action(number1, number2, operation);
        assertEquals(111, result);
    }

    /**
     * Проверка *
     */
    @Test(description = "Операция умножения(*)")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка вычисления умножения")
    @Description("Тест проверяет совпадает ли результат произведения с ожидаемым")
    public void testPutOperationMultiplicationInCalculator() {
        int number1 = 666;
        int number2 = 555;
        String operation = "*";
        int result = calculator.action(number1, number2, operation);
        assertEquals(369630, result);
    }

    /**
     * Проверка /
     */
    @Test(description = "Операция деления(/)")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка вычисления деления int значений")
    @Description("Тест проверяет совпадает ли результат деления с ожидаемым")
    public void testPutOperationDivisionInCalculator() {
        int number1 = 666;
        int number2 = 555;
        String operation = "/";
        int result = calculator.action(number1, number2, operation);
        assertEquals(1, result);
    }
}