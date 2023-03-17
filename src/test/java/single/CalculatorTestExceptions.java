package single;

import calculator.Calculator;
import io.qameta.allure.*;

import exception.DivisionByZero;
import exception.WrongFormat;
import exception.WrongInputOperation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Выбрасывание информационных сообщений об ошибках. Негативные тесты (Single)")
@Feature("Проверки выбрасывания сообщений о допущении ошибок")
@Owner("Иванов Иван Иванович")
public class CalculatorTestExceptions {

    private Calculator calculator;

    /**
     * Создаем новый экземпляр калькулятора для каждого теста
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Валидация при " "
     *
     * @throws WrongInputOperation исключение при null
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация при операции null")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация строки  =  ")
    @Description("Тест проверяет валидацию ввода оператора, при вводе null")
    public void testNullInputMathOperation() {
        calculator.setOperator(" ");
        calculator.validInPutOperation();
    }

    /**
     * Валидация при вводе 2-х операторах
     *
     * @throws WrongInputOperation исключение при недопустимой операции
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация при вводе 2-х операций в поле оператора")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация при вводе 2-х операций")
    @Description("Тест проверяет валидацию ввода оператора, при вводе 2-х операций")
    public void testValidateInputMathOperationTwoOperator() throws WrongInputOperation {
        calculator.setOperator("+*");
        calculator.validInPutOperation();
    }

    /**
     * Валидация при вводе несуществующей операции
     *
     * @throws WrongInputOperation исключение при недопустимой операции
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация при вводе оператора недоступной операции")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация при вводе оператора недоступной операции")
    @Description("Тест проверяет валидацию ввода оператора, при вводе недоступной операции")
    public void testValidateInputNoMatchMathOperation() throws WrongInputOperation {
        calculator.setOperator("%");
        calculator.validInPutOperation();
    }

    /**
     * Валидация при вводе в поле оператора строки нижним регистром
     *
     * @throws WrongInputOperation исключение при недопустимой операции
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация ввода оператора с латинскими символами в нижнем регистр")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода оператора с латинскими символами в нижнем регистре")
    @Description("Тест проверяет валидацию ввода оператора, при вводе оператора с латинскими символами в нижнем регистре")
    public void testValidateInputMathOperationStringLowCase() throws WrongInputOperation {
        calculator.setOperator("java");
        calculator.validInPutOperation();
    }

    /**
     * Валидация при вводе в поле оператора строки верхним регистром
     *
     * @throws WrongInputOperation исключение при недопустимой операции
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация ввода оператора с латинскими символами в вверхнем регистре")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода оператора с латинскими символами в вверхнем регистре")
    @Description("Тест проверяет валидацию ввода оператора, при вводе оператора с латинскими символами в вверхнем регистре")
    public void testValidateInputMathOperationStringHighCase() throws WrongInputOperation {
        calculator.setOperator("JAVA");
        calculator.validInPutOperation();
    }

    /**
     * Валидация при вводе в поле оператора строки верхним и нижним регистром
     *
     * @throws WrongInputOperation исключение при недопустимой операции
     */
    @Test(expectedExceptions = WrongInputOperation.class, description = "Валидация ввода оператора с латинскими символами в смешанном регистре")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода оператора с латинскими символами в смешанном регистре")
    @Description("Тест проверяет валидацию ввода оператора, при вводе оператора с латинскими символами в смешанном регистре")
    public void testValidateInputMathOperationStringHighAndLowCase() throws WrongInputOperation {
        calculator.setOperator("JavA");
        calculator.validInPutOperation();
    }

    /**
     * Проверка для выбрасывания исключения при делении на 0
     *
     * @throws DivisionByZero выводимое исключение при делении на 0
     */
    @Test(expectedExceptions = DivisionByZero.class, description = "Валидация при делении на 0")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода оператора с латинскими символами в вверхнем регистре")
    @Description("Тест проверяет валидацию ввода оператора, при вводе оператора с латинскими символами в вверхнем регистре")
    public void testDivisionByZeroOutPut() throws DivisionByZero {
        calculator.action(666, 0, "/");
    }

    /**
     * Проверка выброса исключении при вводе не числа в 1 положении
     */
    @Test(expectedExceptions = WrongFormat.class, description = "Валидация при вводе не числа в поле числа")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода не числа в 1 поле ввода числа")
    @Description("Тест проверяет валидацию ввода не числа, в 1 поле ввода числа")
    public void testWrongFormatOutPutWithFirstNumber() {
        calculator.setNumber1(Integer.valueOf("java"));
        calculator.setNumberInCal();
    }

    /**
     * Проверка выброса исключении при вводе не числа во 2 положении
     */
    @Test(expectedExceptions = WrongFormat.class, description = "Валидация при вводе не числа в поле числа")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация ввода не числа во 2 поле ввода числа")
    @Description("Тест проверяет валидацию ввода не числа, во 2 поле ввода числа")
    public void testWrongFormatOutPutWithSecondNumbers() {
        calculator.setNumber2(Integer.valueOf("java"));
        calculator.setNumberInCal();
    }
}