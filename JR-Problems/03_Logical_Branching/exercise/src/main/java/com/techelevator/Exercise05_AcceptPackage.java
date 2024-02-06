package com.techelevator;

public class Exercise05_AcceptPackage {

    /*
    Scamper Shipping Company specializes in small, local deliveries.
    The problems below ask you to implement logic if they can accept a package for delivery.

    Note: all weights are in pounds, and all dimensions are in inches.
     */

    // You can use these constants in your solutions.
    private final int MAX_WEIGHT_POUNDS = 40;
    private final int MAX_CUBIC_INCHES = 10_368;
    private final int MAX_DIMENSION_INCHES = 66;

    /*
    Scamper Shipping accepts packages as long as they are 40 pounds or less.
    Implement the logic to determine if Scamper Shipping accepts a package based on the weight provided.

    Examples:
    acceptPackage(20) ➔ true
    acceptPackage(40) ➔ true
    acceptPackage(50) ➔ false
     */
    public boolean acceptPackage(int weightPounds) {
        return false;
    }

    /*
    Scamper Shipping delivers packages by hand, and some packages can be awkward to carry.
    Scamper decides that in addition to the package being no more than 40 pounds, they must also limit its size.
    Scamper won't deliver packages greater than 10,368 cubic inches. 

    Implement the logic to determine if Scamper Shipping accepts a package based on the weight, length, width, and height provided.
    NOTE: You calculate cubic inches by multiplying the length, width, and height.

    Examples:
    acceptPackage(20, 36, 24, 12) ➔ true
    acceptPackage(40, 42, 30, 18) ➔ false
    acceptPackage(50, 36, 24, 12) ➔ false
     */
    public boolean acceptPackage(int weightPounds, int lengthInches, int widthInches, int heightInches) {
        return false;
    }

    /*
    All was well until a customer showed up with a 16-foot garden hose laid out straight in a 2x2x194 inch shipping box.
    The package was less than the weight and cubic inches restrictions, but at over 16 feet long,
    it couldn't fit in the van, and they needed to tie it to the roof. So, they added another rule.

    In addition to weighing no more than 40 pounds and not more than four cubic feet,
    no single dimension can be greater than five and a half feet (66 inches) without paying a surcharge.

    Implement the logic to determine if Scamper Shipping accepts a package based on
    the weight, length, width, and height provided, as well as if they've paid the surcharge.

    Examples:
    acceptPackage(20, 36, 24, 12) ➔ true
    acceptPackage(40, 66, 10, 10) ➔ false
    acceptPackage(50, 36, 24, 12) ➔ false
     */
    public boolean acceptPackage(int weightPounds, int lengthInches, int widthInches, int heightInches, boolean isSurchargePaid) {
        return false;
    }
}
