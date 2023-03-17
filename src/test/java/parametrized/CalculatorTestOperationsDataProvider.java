package parametrized;

import calculator.Calculator;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Epic("Операции калькулятора(Parametrized)")
@Feature("Все вычисление калькулятором(+,-,/,*)")
@Owner("Сидоров Сидр Сидорович")
public class CalculatorTestOperationsDataProvider {

    private Calculator calculator;

    /**
     * Создание экземпляра калькулятора
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Тестовые данные для калькулятора
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
     * Проверка выполнения операций калькулятором
     */
    @Test(dataProvider = "getTestAndExceptedDataForNumbers",
            description = "Проверка вычислений калькулятором, путем сравнения с вычислений и ожидаемым ответом")
    @Description("Тест проверяет совпадает ли результат вычисления с ожидаемым")
    @Severity(SeverityLevel.CRITICAL)
    public void testPutResultInDataProvider(int number1, int number2, int result, String operator) {
        assertEquals(calculator.action(number1, number2, operator), result);
    }
}