package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.lang.reflect.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckingAccountTest {

    private final String PACKAGE_NAME = "com.techelevator";
    private final String BANK_ACCOUNT_CLASS_NAME = "BankAccount";
    private final String CHECKING_ACCOUNT_CLASS_NAME = "CheckingAccount";
    private static Class<?> checkingAccountClass;

    @Before
    public void Initialize() {
        try {
            checkingAccountClass = Class.forName(PACKAGE_NAME + "." + CHECKING_ACCOUNT_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            fail(e.getMessage() + " class could not be found. Have you declared it yet? Make sure the class name is '" + CHECKING_ACCOUNT_CLASS_NAME + "' and the package name is '" + PACKAGE_NAME + "'.");
        }
    }

    @Test
    public void test01_ClassWellFormed() {
        String wellFormedCheck = classWellFormedCheck();
        if (!wellFormedCheck.isEmpty()) {
            fail(wellFormedCheck);
        }
    }

    @Test
    public void test02_HappyPath_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        String wellFormedCheck = classWellFormedCheck();
        if (!wellFormedCheck.isEmpty()) {
            fail(CHECKING_ACCOUNT_CLASS_NAME + " is not well formed. The test01_ClassWellFormed tests must pass first.\r\n\t" + wellFormedCheck);
        }

        // Assert constructors set fields
        String testAccountHolderName = "Tester Testerson";
        String testAccountNumber = "CHK:1234";
        int testBalance = 100;

        // Two arg constructor
        Constructor<?> twoArgConstructor = SafeReflection.getConstructor(checkingAccountClass, String.class, String.class);
        Object twoArgInstance = twoArgConstructor.newInstance(testAccountHolderName, testAccountNumber);

        Method twoArgGetAccountHolderName = twoArgInstance.getClass().getMethod("getAccountHolderName");
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " constructor " + CHECKING_ACCOUNT_CLASS_NAME + "(String, String) does not correctly set the field accountHolderName.",
                testAccountHolderName, twoArgGetAccountHolderName.invoke(twoArgInstance));
        Method twoArgGetAccountNumber = twoArgInstance.getClass().getMethod("getAccountNumber");
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " constructor " + CHECKING_ACCOUNT_CLASS_NAME + "(String, String) does not correctly set the field accountNumber.",
                testAccountNumber, twoArgGetAccountNumber.invoke(twoArgInstance));

        // Three arg constructor
        Constructor<?> threeArgConstructor = SafeReflection.getConstructor(checkingAccountClass, String.class, String.class, int.class);
        Object threeArgInstance = threeArgConstructor.newInstance(testAccountHolderName, testAccountNumber, testBalance);

        Method threeArgGetAccountHolderName = threeArgInstance.getClass().getMethod("getAccountHolderName");
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " constructor " + CHECKING_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field accountHolderName.",
                testAccountHolderName, threeArgGetAccountHolderName.invoke(threeArgInstance));
        Method threeArgGetAccountNumber = threeArgInstance.getClass().getMethod("getAccountNumber");
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " constructor " + CHECKING_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field accountNumber.",
                testAccountNumber, threeArgGetAccountNumber.invoke(threeArgInstance));
        Method threeArgGetBalance = threeArgInstance.getClass().getMethod("getBalance");
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " constructor " + CHECKING_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field balance.",
                testBalance, threeArgGetBalance.invoke(threeArgInstance));

        // Assert withdraw decreases balance
        Method withdraw = threeArgInstance.getClass().getMethod("withdraw", int.class);
        int withdrawParamValue = 22;
        int withdrawExpectedReturnValue = testBalance - withdrawParamValue;
        Object withdrawActualReturnValue = withdraw.invoke(threeArgInstance, withdrawParamValue);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: " + testBalance + ", withdraw: " + withdrawParamValue + ", new balance should be " + withdrawExpectedReturnValue + ".",
                withdrawExpectedReturnValue, withdrawActualReturnValue);
    }

    @Test
    public void test03_EdgeCase_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        String wellFormedCheck = classWellFormedCheck();
        if (!wellFormedCheck.isEmpty()) {
            fail(CHECKING_ACCOUNT_CLASS_NAME + " is not well formed. The test01_ClassWellFormed tests must pass first.\r\n\t" + wellFormedCheck);
        }

        Constructor<?> threeArgConstructor = SafeReflection.getConstructor(checkingAccountClass, String.class, String.class, int.class);
        Method deposit = SafeReflection.getMethod(checkingAccountClass, "deposit", int.class);
        Method withdraw = SafeReflection.getMethod(checkingAccountClass, "withdraw", int.class);
        Method getBalance = SafeReflection.getMethod(checkingAccountClass, "getBalance");

        // Assert 1 dollar under 0 balance allows overdraft and assesses fee
        Object checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, 101);
        Object balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 100, withdraw: 101, new balance should be -11 (-1 is greater than -100, 10 fee incurred).", -11, balance);

        // Assert 10 dollar above -100 balance allows overdraft and assesses fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, 190);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 100, withdraw: 190, new balance should be -100 (-90 is greater than -100, 10 fee incurred).", -100, balance);

        // Assert 1 dollar above -100 balance allows overdraft and assesses fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, 199);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 100, withdraw: 199, new balance should be -109 (-99 is greater than -100, 10 fee incurred).", -109, balance);

        // Assert withdraw that would make -100 balance denies overdraft and doesn't assess fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, 200);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 100, withdraw: 200, overdraft should be denied (100 - 200 >= -100) and balance remains at 100.", 100, balance);

        // Assert withdraw that would make 0 balance does not incur fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, 100);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 100, withdraw: 100, new balance should be 0. No fee incurred because balance is not less than 0.", 0, balance);

        // Assert can't deposit a negative amount
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        deposit.invoke(checkingAccount, -10);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " deposit method fails to prevent negative deposit amount. Starting balance: 100, deposit: -10, balance should remain at 100.", 100, balance);

        // Assert can't withdraw a negative amount
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(checkingAccount, -10);
        balance = getBalance.invoke(checkingAccount);
        assertEquals(CHECKING_ACCOUNT_CLASS_NAME + " withdraw method fails to prevent negative withdraw amount. Starting balance: 100, withdraw: -10, balance should remain at 100.", 100, balance);
    }

    private String classWellFormedCheck() {
        // Assert class exists
        if (checkingAccountClass == null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " class not found. Have you declared it yet? Make sure the class name is '" + CHECKING_ACCOUNT_CLASS_NAME + "' and the package name is '" + PACKAGE_NAME + "'.";
        }

        if (Modifier.isAbstract(checkingAccountClass.getModifiers())) {
            return CHECKING_ACCOUNT_CLASS_NAME + " class must not be abstract. Remove the 'abstract' modifier on " + CHECKING_ACCOUNT_CLASS_NAME + ".";
        }

        // Assert CheckingAccount extends BankAccount
        Class<?> superclass = checkingAccountClass.getSuperclass();
        if (!superclass.getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must extend " + BANK_ACCOUNT_CLASS_NAME + ".";
        }

        // Assert constructors exist
        try {
            Constructor<?> twoArgConstructor = checkingAccountClass.getConstructor(String.class, String.class);
        } catch (NoSuchMethodException e) {
            return CHECKING_ACCOUNT_CLASS_NAME + " does not have the required two argument constructor "
                    + CHECKING_ACCOUNT_CLASS_NAME + "(String, String). Make sure access for the constructor is public.";
        }
        try {
            Constructor<?> threeArgConstructor = checkingAccountClass.getConstructor(String.class, String.class, int.class);
        } catch (NoSuchMethodException e) {
            return CHECKING_ACCOUNT_CLASS_NAME + " does not have the required three argument constructor "
                    + CHECKING_ACCOUNT_CLASS_NAME + "(String, String, int). Make sure access for the constructor is public.";
        }

        // Assert override methods are present -- whether they work is confirmed in other test methods
        Method withdrawMethod = SafeReflection.getMethod(checkingAccountClass, "withdraw", int.class);
        if (!withdrawMethod.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + CHECKING_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must override " + BANK_ACCOUNT_CLASS_NAME + " withdraw(int) method. Make sure access for the method is public.";
        }

        // Assert BankAccount fields are NOT redefined in CheckingAccount
        Field accountHolderNameField = SafeReflection.getDeclaredField(checkingAccountClass, "accountHolderName");
        if (accountHolderNameField != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine the field accountHolderName.";
        }
        Field accountNumberField = SafeReflection.getDeclaredField(checkingAccountClass, "accountNumber");
        if (accountNumberField != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine the field accountNumber.";
        }
        Field balanceField = SafeReflection.getDeclaredField(checkingAccountClass, "balance");
        if (balanceField != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine the field balance.";
        }

        // Assert BankAccount getters/setters are NOT redefined in CheckingAccount
        Method accountHolderNameGetter = SafeReflection.getMethod(checkingAccountClass, "getAccountHolderName");
        if (!accountHolderNameGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine getter getAccountHolderName().";
        }
        Method accountHolderNameSetter = SafeReflection.getMethod(checkingAccountClass, "setAccountHolderName", String.class);
        if (accountHolderNameSetter != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not define setter setAccountHolderName(String).";
        }

        Method accountNumberGetter = SafeReflection.getMethod(checkingAccountClass, "getAccountNumber");
        if (!accountNumberGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine getAccountNumber().";
        }
        Method accountNumberSetter = SafeReflection.getMethod(checkingAccountClass, "setAccountNumber", String.class);
        if (accountNumberSetter != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not define setter setAccountNumber(String).";
        }

        Method balanceGetter = SafeReflection.getMethod(checkingAccountClass, "getBalance");
        if (!balanceGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine getter getBalance().";
        }
        Method balanceSetter = SafeReflection.getMethod(checkingAccountClass, "setBalance", int.class);
        if (balanceSetter != null) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not define setter setBalance(int).";
        }

        // Assert BankAccount methods are NOT redefined in CheckingAccount
        Method depositMethod = SafeReflection.getMethod(checkingAccountClass, "deposit", int.class);
        if (!depositMethod.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return CHECKING_ACCOUNT_CLASS_NAME + " must not redefine deposit(int).";
        }

        return "";
    }
}
