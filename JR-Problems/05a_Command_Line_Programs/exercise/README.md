# Command-line programs exercise

The purpose of this exercise is to allow you to practice and reinforce the skills you've learned related to building command-line applications. In this exercise, you'll create command-line applications that:

* Convert a temperature from one unit of measure to another.
* Convert a length from one unit of measure to another.
* Calculate and display the Fibonacci sequence for a given number.
* Convert a series of numbers from decimal to binary.

## Learning objectives

After completing this exercise, you'll understand:

* How to create command-line applications.
* How to prompt and accept user input in a command-line application.
* How to write output to the console in a command-line application.

## Evaluation criteria and functional requirements

* The project must not have any build errors.
* Appropriate variable names and data types.
* The input and output match what's stated in the following requirements.

### Temperature conversion

The Fahrenheit to Celsius conversion formula is:

    temperatureCelsius = (temperatureFahrenheit - 32) / 1.8

The Celsius to Fahrenheit conversion formula is:

    temperatureFahrenheit = temperatureCelsius * 1.8 + 32

Write a command-line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or (F)ahrenheit. Convert the temperature to the other scale, and display both temperatures to the console. Round the result **down** to the nearest whole number.

In order to write this program, you need to know how to compare one string to another. In this case, you want to see if the string entered by the user is equal to `"C"` or `"F"`.

You can compare one string to another using `equals()`, a pre-defined method of the `String` class:

```java
if (str1.equals(str2)) {
    System.out.print("The strings are equal");
}
```

An upcoming lesson provides more information about string comparison.

#### Expected output

```
Please enter the temperature: 58
Is the temperature in (C)elsius, or (F)ahrenheit? F
58F is 14C.
```

### Linear conversion

Write a program that converts meters to feet and vice-versa.

The foot to meter conversion formula is:

    m = f * 0.3048

The meter to foot conversion formula is:

    f = m * 3.2808399

Write a command-line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet. Convert the length to the other scale, and display both measurements to the console. Round the result **down** to the nearest whole number. Use constants for the conversion factors (the amounts to multiply by).

#### Expected output

```
Please enter the length: 58
Is the measurement in (m)eters, or (f)eet? f
58f is 17m.
```

### Fibonacci

The Fibonacci numbers are the integers in the following sequence:

    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...

By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two:

```
0 + 1 = 1
1 + 1 = 2
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
...
```

Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.

#### Expected output

```
Please enter a number: 17

0, 1, 1, 2, 3, 5, 8, 13
```

If the input is a number that appears in the Fibonacci sequence, print the sequence up to *and including* that number:

```
Please enter a number: 34

0, 1, 1, 2, 3, 5, 8, 13, 21, 34
```

The Fibonacci sequence always starts with 0 and 1. If the input is 0 or a negative number, print "0, 1":

```
Please enter a number: 0

0, 1
```

If the input is 1, print "0, 1, 1":

```
Please enter a number: 1

0, 1, 1
```

### Decimal to binary

Write a command-line program which prompts the user for a series of decimal integer values separated by spaces. Display each decimal integer along with its equivalent binary value.

You can convert a decimal number to its binary equivalent by repeatedly dividing the number by two. Prepend the remainder of this division (either a 0 or a 1) to the solution string (see the Tips and Tricks section to learn how to *prepend* a value to a string). The process ends when division of the value by two yields a zero.

For example, convert 8 to its binary equivalent of "1000":

![Image version of conversion table](img/ConvertBinary.png)

| **Value** | **Value / 2** | **Remainder** | **Solution String** |
|:---------:|:-------------:|:-------------:|:-------------------:|
|     8     |       4       |       0       |         "0"         |
|     4     |       2       |       0       |        "00"         |
|     2     |       1       |       0       |       "000"         |
|     1     |       0       |       1       |    **"1000"**       |


Try repeating the process yourself to convert 19 to "10011", its binary equivalent.

| **Value** | **Value / 2** | **Remainder** | **Solution String** |
|:---------:|:-------------:|:-------------:|:-------------------:|
|     19    |               |               |                     |
|           |               |               |                     |
|           |               |               |                     |
|           |               |               |                     |
|           |               |               |   **"10011"**       |


#### Expected output

```
Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
```

## Getting started

1. Open the exercise project in IntelliJ.
2. For each exercise, navigate to the corresponding Java file, and provide the code needed to fulfill the requirements in the `main()` method.
3. Run the application to verify that it works as expected.

## Tips and tricks

* Many people have solved the Fibonacci sequence in many different ways. In fact, this may even come up during a technical interview. Rather than looking at the solutions that already exist, try to solve this problem on your own. If you do borrow a solution, take the time to understand what the code is actually doing.
* The algorithm used to solve the decimal to binary conversion requires you to *prepend* each new digit to the cumulative string. *Prepend* means "add to the front."

The following code illustrates the difference between appending a new digit and prepending a new digit:

```java
cumulativeString = cumulativeString + newDigit; // appends newDigit (adds it to the end)
cumulativeString = newDigit + cumulativeString; // prepends newDigit (adds it to the beginning)
```

* Take the time to review each of the tasks for the expected output, as well as the text you must use to prompt the user for information. Try to get this to match the specification as closely as possible when working through the exercise.
