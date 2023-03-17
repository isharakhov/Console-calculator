package parametrized;

import calculator.Calculator;
import exception.DivisionByZero;
import exception.WrongFormat;
import exception.WrongInputOperation;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Набор тестов для выдачи исключений с DataProvider
 */
@Epic("Операции калькулятора(Parametrized)")
@Feature("Все вычисление калькулятором(+,-,/,*)")
@Owner("Панина Нина Петровна")
public class CalculatorTestExceptionsDataProvider {

    private Calculator calculator;

    /**
     * Для создания нового эксземляра калькулятора
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Негативные тестовые данные для ввода в строку операции
     *
     * @return двумерный массив объектов (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestDataExceptionForOperationsNegative() {
        return new Object[][]{
                {" "},
                {""},
                {"+*"},
                {"%"},
                {"java"},
                {"JAVA"},
                {"JavA"},
                {"^"}
        };
    }

    /**
     * Тестовые данные для вычислений калькулятором
     *
     * @return двумерный массив объектов (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestAndExceptedDataForNumbers() {
        return new Object[][]{
                {666, 555, 1221, "+"},
                {666, 555, 111, "-"},
                {666, 555, 1, "/"},
                {666, 555, 369630, "*"}
        };
    }

    /**
     * Тестовые данные при делении на 0
     *
     * @return двумерный массив объектов (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestForExceptionDivisionByZero() {
        return new Object[][]{
                {666, 0, "/"}
        };
    }

    /**
     * Выкидывание исключения при ввводе недопустимых операций
     *
     * @param operation Вводимая операция
     */
    @Test(dataProvider = "getTestDataExceptionForOperationsNegative",
            expectedExceptions = WrongInputOperation.class,
            description = "Проверяет выпадает ли ошибка при вводе невалидного оператора")
    @Description("Тест проверяет выпадает ли ошибка при вводе невалидного оператора")
    @Severity(SeverityLevel.CRITICAL)
    public void putOperationsForException(String operation) {
        calculator.setOperator(operation);
        calculator.validInPutOperation();
    }

    /**
     * Выбрасывание исключения деления на 0
     *
     * @param number1  1 число
     * @param number2  2 число = 0
     * @param operator Операция = /
     */
    @Test(dataProvider = "getTestForExceptionDivisionByZero",
            expectedExceptions = DivisionByZero.class,
            description = "Деление на 0")
    @Description("Тест проверяет выпадает ли ошибка при делении на 0")
    @Severity(SeverityLevel.CRITICAL)
    public void divisionByZero(int number1, int number2, String operator) {
        calculator.action(number1, number2, operator);
    }

    /**
     * Метод для ввода срочки в поле числа
     *
     * @param number Вводимая строчка
     */
    @Test(dataProvider = "getTestDataExceptionForOperationsNegative",
            expectedExceptions = WrongFormat.class,
    description = "Ввод невалидных значений в числовое поле")
    @Description("Тест проверяет выпадает ли ошибка при вводе невалидных значений в числовое поле")
    @Severity(SeverityLevel.CRITICAL)
    public void testPutResultInDataProvider(String number) {
        calculator.setNumber1(Integer.valueOf(number));
        calculator.setNumberInCal();
    }
}