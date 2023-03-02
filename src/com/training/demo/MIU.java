package com.training.demo;

import java.util.Arrays;

public class MIU {

    public static void main(String[] args) {
//        1
        int n = -80;
        System.out.println("num: "+ n + " and Answer: "+isDigitFactorable(n));

//        2
        int[] a11 = {0, 0, 0, 0};
        int[] a21 = {4, 3, 2, 1};
        int[] a31 = {8, 0};
        int[] a41 = {6};
        int[] a51 = {0, -1, -1, -4};
        int[] a61 = {-1};
        System.out.println(decodeNumber(a11)); // output: 1234
        System.out.println(decodeNumber(a21)); // output: 5555
        System.out.println(decodeNumber(a31)); // output: 92
        System.out.println(decodeNumber(a41)); // output: 7
        System.out.println(decodeNumber(a51)); // output: 1120
        System.out.println(decodeNumber(a61)); // output: 0
        System.out.println(decodeNumber(new int[]{1, 2, 3})); // output: -1

//        3
        int[] a1 = {8, 3};
        int[] f1 = {2, 1, 1};
        System.out.println(Arrays.toString(filterArray(a1, f1))); // [8, 3]

        int[] a2 = {8, 3};
        int[] f2 = {2, 0, 1};
        System.out.println(Arrays.toString(filterArray(a2, f2))); // [3]

        int[] a3 = {8, 3};
        int[] f3 = {2, 1, 0};
        System.out.println(Arrays.toString(filterArray(a3, f3))); // [8]

        int[] a4 = {8, 3};
        int[] f4 = {2, 0, 0};
        System.out.println(Arrays.toString(filterArray(a4, f4))); // []

        int[] a5 = {8, 3, -12};
        int[] f5 = {2, 1, 1};
        System.out.println(Arrays.toString(filterArray(a5, f5))); // [8, 3]

        int[] a6 = {1, 2};
        int[] f6 = {3, 1, 1, 1};
        System.out.println(filterArray(a6, f6)); // null

        int[] a7 = {1, 2};
        int[] f7 = {3, 1, 1, 0};
        System.out.println(filterArray(a7, f7)); // null

        int[] a8 = {1, 0, 3, -2};
        int[] f8 = {4, 0, 1, 0, 1};
        System.out.println(Arrays.toString(filterArray(a8, f8)));

    }



//    1. A number, greater than zero, is said to be digit-factorable if the product of its non-zero digits divides the number evenly.
//    So 7035 is digit-factorable because the product of its non-zero digits is 105 (7*3*5) and 105 divides 7035
//    with no remainder (7035 = 67*105). Write a function named isDigitFactorable that returns 1 if its argument
//    is digit-factorable, otherwise it returns 0.
//
//    The signature of the function is
//    int isDigitFactorable(int n)
    public static int isDigitFactorable(int n) {
//        solution 1 explanation
//        The function takes an integer num as input.
//        Inside the function, we first convert the integer num to a string, then get its characters as an IntStream.
//        For each character, we map it to its numeric value using Character::getNumericValue.
//                We then filter out any zero digits using the filter method.
//        Finally, we reduce the remaining digits using the reduce method, multiplying them together to get the product.
//        As before, we check if the product is non-zero and if it divides the original number num evenly (i.e., no remainder).
//        If so, we return 1, indicating that the number is digit-factorable. Otherwise, we return 0.


//        int product = String.valueOf(num).chars()
//                .map(Character::getNumericValue)
//                .filter(digit -> digit != 0)
//                .reduce(1, (a, b) -> a * b);
//        return (product != 0 && num % product == 0) ? 1 : 0;

//        solution 2 explanation
//        Explanation:

//        The function takes an integer n as input.
//        Inside the function, we first check if n is greater than 0. If it is not, we return 0 to indicate that the number is not digit-factorable.
//                If n is greater than 0, we initialize two variables: product to 1 (to accumulate the product of non-zero digits)
//                and num to n (to keep track of the remaining digits to process).
//        We then enter a loop that iterates as long as num is greater than 0.
//        In each iteration of the loop, we extract the least significant digit of num using the modulus operator %.
//        If the digit is not zero, we multiply it with the current value of product. We then divide num by 10
//        to remove the least significant digit and continue with the next digit.
//                After the loop, we check if n is evenly divisible by product. If it is, we return 1 to indicate that the number is digit-factorable.
//                Otherwise, we return 0.
//        Note: The function assumes that the input number n is an integer, and it does not handle any exceptions that may arise from invalid input.

        if (n <= 0) {
            return 0; // number must be greater than 0
        }
        int product = 1;
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                product *= digit;
            }
            num /= 10;
        }
        return (n % product == 0) ? 1 : 0;
    }






//    2. A number can be encoded as an array as follows. The first digit of the number (the most significant digit)
//    is decremented by 1 and stored as the first element of the array. The second digit of the number
//    is decremented by 2 and stored as the second element of the array, and so on. So, the number 430 is encoded as {3, 1, -3}
//    because
//        4-1 = 3
//        3-2 = 1
//        0-3 = -3
//    Write a function named decodeNumber that takes an array of integers that is the encoding of a number
//    (as described in the previous paragraph) and returns the number that was encoded. If the encoding is illegal,
//    return -1. What is an illegal encoding? That is your job to figure out! Please include a comment in your answer
//    describing what constitutes an illegal encoding.

    public static int decodeNumber(int[] encoding) {

//        Explanation:
//
//        The function takes an array of integers a as input and returns an integer as output.
//        The variable n stores the length of the array a.
//        The variable result is used to accumulate the decoded number.
//        In each iteration of the loop, the digit variable is computed by adding the i-th element of the array a with i+1.
//        This gives us the original digit that was encoded.
//                If the digit is out of range (less than 0 or greater than 9), then the encoding is illegal and the function returns -1.
//        Otherwise, the digit is added to the result by multiplying the result by 10 and adding the digit.
//        After all the digits have been decoded, the final result is returned.

        int n = encoding.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (encoding[i] < -(n - i) || encoding[i] > 9 - (n - i)) {  // check if digit is out of range
                return -1; // illegal encoding
            }
            num += (encoding[i] + (n - i - 1)) * Math.pow(10, n - i - 1);
        }
        return num;
    }

//    3. A filter is an array of integers that begins with the length of the filter followed by elements that are 0 or 1.
//    For example, {3, 0, 1, 0} is a filter (note the length of a filter is one less than the length of the array that represents the filter).
//    A filter is used to return a sub-array of an array. A one in the filter indicates that the corresponding array element
//    should be included in the result, a zero in the filter indicates that it should not be. So the array {1, 2, 3, 4, 8}
//    when filtered with {4, 0, 1, 1, 0} becomes {2, 3} because the elements of the array that correspond to the 1
//    elements of the filter are 2 and 3. Here is what is going on visually:
//
//    {1, 2, 3, 4, 8}  (array to be filtered)
//    {4, 0, 1, 1, 0}     (filter)
//    {2, 3}        (result)
//    The elements 1 and 4 do not appear in the result because the corresponding filter elements are 0.
//    And the 8 (the 5th element of the array) does not appear in the result because the filter only has four filtering elements.
//
//    Write a method named filterArray that takes an array and a filter as arguments and returns a filtered sub-array.
//    If the size of the filter is greater than the number of elements in the array, return null.

    public static int[] filterArray(int[] arr, int[] filter) {
        int filteredSize = 0;
        for (int i = 0; i < filter.length; i++) {
            if (filter[i] == 1) {
                filteredSize++;
            }
        }
        if (filteredSize > arr.length) {
            return null;
        }
        int[] filteredArr = new int[filteredSize];
        int j = 0;
        for (int i = 0; i < arr.length && j < filteredSize; i++) {
            if (filter[j] == 1) {
                filteredArr[j] = arr[i];
                j++;
            }
        }
        return filteredArr;
    }

}
