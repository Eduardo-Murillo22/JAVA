package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.lang.reflect.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SavingsAccountTest {

    private final String PACKAGE_NAME = "com.techelevator";
    private final String BANK_ACCOUNT_CLASS_NAME = "BankAccount";
    private final String SAVINGS_ACCOUNT_CLASS_NAME = "SavingsAccount";
    private static Class<?> savingsAccountClass;

    @Before
    public void Initialize() {
        try {
            savingsAccountClass = Class.forName(PACKAGE_NAME + "." + SAVINGS_ACCOUNT_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            fail(e.getMessage() + " class could not be found. Have you declared it yet? Make sure the class name is '" + SAVINGS_ACCOUNT_CLASS_NAME + "' and the package name is '" + PACKAGE_NAME + "'.");
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
            fail(SAVINGS_ACCOUNT_CLASS_NAME + " is not well formed. The test01_ClassWellFormed tests must pass first.\r\n\t" + wellFormedCheck);
        }

        // Assert constructors set fields
        String testAccountHolderName = "Tester Testerson";
        String testAccountNumber = "CHK:1234";
        int testBalance = 200;

        // Two arg constructor
        Constructor<?> twoArgConstructor = SafeReflection.getConstructor(savingsAccountClass, String.class, String.class);
        Object twoArgInstance = twoArgConstructor.newInstance(testAccountHolderName, testAccountNumber);

        Method twoArgGetAccountHolderName = twoArgInstance.getClass().getMethod("getAccountHolderName");
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " constructor " + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String) does not correctly set the field accountHolderName.",
                testAccountHolderName, twoArgGetAccountHolderName.invoke(twoArgInstance));
        Method twoArgGetAccountNumber = twoArgInstance.getClass().getMethod("getAccountNumber");
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " constructor " + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String) does not correctly set the field accountNumber.",
                testAccountNumber, twoArgGetAccountNumber.invoke(twoArgInstance));

        // Three arg constructor
        Constructor<?> threeArgConstructor = SafeReflection.getConstructor(savingsAccountClass, String.class, String.class, int.class);
        Object threeArgInstance = threeArgConstructor.newInstance(testAccountHolderName, testAccountNumber, testBalance);

        Method threeArgGetAccountHolderName = threeArgInstance.getClass().getMethod("getAccountHolderName");
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " constructor " + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field accountHolderName.",
                testAccountHolderName, threeArgGetAccountHolderName.invoke(threeArgInstance));
        Method threeArgGetAccountNumber = threeArgInstance.getClass().getMethod("getAccountNumber");
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " constructor " + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field accountNumber.",
                testAccountNumber, threeArgGetAccountNumber.invoke(threeArgInstance));
        Method threeArgGetBalance = threeArgInstance.getClass().getMethod("getBalance");
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " constructor " + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String, int) does not correctly set the field balance.",
                testBalance, threeArgGetBalance.invoke(threeArgInstance));

        // Assert withdraw decreases balance
        Method withdraw = threeArgInstance.getClass().getMethod("withdraw", int.class);
        int withdrawParamValue = 25;
        int withdrawExpectedReturnValue = testBalance - withdrawParamValue;
        Object withdrawActualReturnValue = withdraw.invoke(threeArgInstance, withdrawParamValue);
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: " + testBalance + ", withdraw: " + withdrawParamValue + ", new balance should be " + withdrawExpectedReturnValue + ".",
                withdrawExpectedReturnValue, withdrawActualReturnValue);
    }

    @Test
    public void test03_EdgeCase_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        String wellFormedCheck = classWellFormedCheck();
        if (!wellFormedCheck.isEmpty()) {
            fail(SAVINGS_ACCOUNT_CLASS_NAME + " is not well formed. The test01_ClassWellFormed tests must pass first.\r\n\t" + wellFormedCheck);
        }

        Constructor<?> threeArgConstructor = SafeReflection.getConstructor(savingsAccountClass, String.class, String.class, int.class);
        Method deposit = SafeReflection.getMethod(savingsAccountClass, "deposit", int.class);
        Method withdraw = SafeReflection.getMethod(savingsAccountClass, "withdraw", int.class);
        Method getBalance = SafeReflection.getMethod(savingsAccountClass, "getBalance");

        // Assert withdrawal of 50 dollars from 200 allows withdrawal but no fee
        Object savingsAccount = threeArgConstructor.newInstance("", "", 200);
        withdraw.invoke(savingsAccount, 50);
        Object balance = getBalance.invoke(savingsAccount);
        assertEquals(SAVINGS_ACCOUNT_CLASS_NAME + " withdraw method fails to decrease balance by correct amount. Starting balance: 200, withdraw: 50, new balance should be 150 (200 - 50 = 150).", 150, balance);

        // Assert withdrawal of 51 dollars from 200 allows withdrawal and assesses fee
        savingsAccount = threeArgConstructor.newInstance("", "", 200);
        withdraw.invoke(savingsAccount, 51);
        balance = getBalance.invoke(savingsAccount);
        assertEquals("SavingsAccount withdraw method fails to decrease balance by correct amount. Starting balance: 200, withdraw: 51, new balance should be 147 (200 - (51 + 2 fee) = 147).", 147, balance);

        // Assert withdrawal of 198 dollars from 200 allows withdrawal and assesses fee
        savingsAccount = threeArgConstructor.newInstance("", "", 200);
        withdraw.invoke(savingsAccount, 198);
        balance = getBalance.invoke(savingsAccount);
        assertEquals("SavingsAccount withdraw method fails to decrease balance by correct amount. Starting balance: 200, withdraw: 198, new balance should be 0 (200 - (198 + 2 fee) = 0).", 0, balance);

        // Assert withdrawal of 199 dollars from 200 denies withdrawal but no fee
        savingsAccount = threeArgConstructor.newInstance("", "", 200);
        withdraw.invoke(savingsAccount, 199);
        balance = getBalance.invoke(savingsAccount);
        assertEquals("SavingsAccount withdraw method fails to decrease balance by correct amount. Starting balance: 200, withdraw: 199, overdraft should be denied (200 - (199 + 2 fee) < 0) and balance remains 200.", 200, balance);

        // Assert can't deposit a negative amount
        savingsAccount = threeArgConstructor.newInstance("", "", 100);
        deposit.invoke(savingsAccount, -10);
        balance = getBalance.invoke(savingsAccount);
        assertEquals("SavingsAccount deposit method fails to prevent negative deposit amount. Starting balance: 100, deposit: -10, balance should remain at 100.", 100, balance);

        // Assert can't withdraw a negative amount
        savingsAccount = threeArgConstructor.newInstance("", "", 100);
        withdraw.invoke(savingsAccount, -10);
        balance = getBalance.invoke(savingsAccount);
        assertEquals("SavingsAccount withdraw method fails to prevent negative withdraw amount. Starting balance: 100, withdraw: -10, balance should remain at 100.", 100, balance);
    }

    private String classWellFormedCheck() {
        // Assert class exists
        if (savingsAccountClass == null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " class not found. Have you declared it yet? Make sure the class name is '" + SAVINGS_ACCOUNT_CLASS_NAME + "' and the package name is '" + PACKAGE_NAME + "'.";
        }

        if (Modifier.isAbstract(savingsAccountClass.getModifiers())) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " class must not be abstract. Remove the 'abstract' modifier on " + SAVINGS_ACCOUNT_CLASS_NAME + ".";
        }

        // Assert SavingsAccount extends BankAccount
        Class<?> superclass = savingsAccountClass.getSuperclass();
        if (!superclass.getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must extend " + BANK_ACCOUNT_CLASS_NAME + ".";
        }

        // Assert constructors exist
        try {
            Constructor<?> twoArgConstructor = savingsAccountClass.getConstructor(String.class, String.class);
        } catch (NoSuchMethodException e) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " does not have the required two argument constructor "
                    + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String). Make sure access for the constructor is public.";
        }
        try {
            Constructor<?> threeArgConstructor = savingsAccountClass.getConstructor(String.class, String.class, int.class);
        } catch (NoSuchMethodException e) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " does not have the required three argument constructor "
                    + SAVINGS_ACCOUNT_CLASS_NAME + "(String, String, int). Make sure access for the constructor is public.";
        }

        // Assert override methods are present -- whether they work is confirmed in other test methods
        Method withdrawMethod = SafeReflection.getMethod(savingsAccountClass, "withdraw", int.class);
        if (!withdrawMethod.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + SAVINGS_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must override " + BANK_ACCOUNT_CLASS_NAME + " withdraw(int) method. Make sure access for the method is public.";
        }

        // Assert BankAccount fields are NOT redefined in SavingsAccount
        Field accountHolderNameField = SafeReflection.getDeclaredField(savingsAccountClass, "accountHolderName");
        if (accountHolderNameField != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine the field accountHolderName.";
        }
        Field accountNumberField = SafeReflection.getDeclaredField(savingsAccountClass, "accountNumber");
        if (accountNumberField != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine the field accountNumber.";
        }
        Field balanceField = SafeReflection.getDeclaredField(savingsAccountClass, "balance");
        if (balanceField != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine the field balance.";
        }

        // Assert BankAccount getters/setters are NOT redefined in SavingsAccount
        Method accountHolderNameGetter = SafeReflection.getMethod(savingsAccountClass, "getAccountHolderName");
        if (!accountHolderNameGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine getter getAccountHolderName().";
        }
        Method accountHolderNameSetter = SafeReflection.getMethod(savingsAccountClass, "setAccountHolderName", String.class);
        if (accountHolderNameSetter != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not define setter setAccountHolderName(String).";
        }

        Method accountNumberGetter = SafeReflection.getMethod(savingsAccountClass, "getAccountNumber");
        if (!accountNumberGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine getAccountNumber().";
        }
        Method accountNumberSetter = SafeReflection.getMethod(savingsAccountClass, "setAccountNumber", String.class);
        if (accountNumberSetter != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not define setter setAccountNumber(String).";
        }

        Method balanceGetter = SafeReflection.getMethod(savingsAccountClass, "getBalance");
        if (!balanceGetter.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine getter getBalance().";
        }
        Method balanceSetter = SafeReflection.getMethod(savingsAccountClass, "setBalance", int.class);
        if (balanceSetter != null) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not define setter setBalance(int).";
        }

        // Assert BankAccount methods are NOT redefined in SavingsAccount
        Method depositMethod = SafeReflection.getMethod(savingsAccountClass, "deposit", int.class);
        if (!depositMethod.getDeclaringClass().getName().equals(PACKAGE_NAME + "." + BANK_ACCOUNT_CLASS_NAME)) {
            return SAVINGS_ACCOUNT_CLASS_NAME + " must not redefine deposit(int).";
        }

        return "";
    }
}
