/*
 * Name: Aidan Latham
 * Program: Binary Strings of "n" length
 * Methods: public static String[] createBinaryNumbersStringArray(int n)
 *          public static int countNumberOfGoodOutcomes(String[] arr, String string)
 *          public static void listGoodOutcomes(String[] arr, String string)
 * Description: Given a user input "n" and a binary substring, will list both the number of 
 *              binary strings of n length that do not contain that substring, and number of them.
 */

import java.util.Scanner;

public class Binary_Strings
{
    /*
     * createBinaryNumberStringArray: creates and returns a String array of all binary numbers 
     *                                of length "n" digits, starting at zero and up to 2^n - 1.
     * parameters: (int n)
     * return value: String[]
     * precondition: "n" must have an integer value
     * postcondition: none
     * 
     * 
     * This subroutine is essentially the most important part of this program. It generates binary
     * numbers by utilizing the typical approach used to convert from base 10 to binary by hand.
     * Essenitally, given a number, you look at the highest power of 2 that can be subracted from
     * that number without a negative difference. That power of 2 is the "n-powerth" digit of the
     * binary number. If the difference is not negative, that digit is "1". If it IS negative, that
     * digit is zero. And you do this all the way down until you get to 2^3,2^2,2^1, and finally
     * 2^0.
     * 
     * For example: Convert 314 to binary.
     *                    2^8 = 256, and 314 - 256 = 58. Put a "1" down. "1 _ _ _ _ _ _ _ _"
     *                    2^7 = 128, but 58 - 128 < 0. Put a "0" down. "1 0 _ _ _ _ _ _ _"
     *                    2^6 = 64, but 58 - 64 < 0. Put a "0" down. "1 0 0 _ _ _ _ _ _"
     *                    2^5 = 32, and 58 - 32 = 26. Put a "1" down. "1 0 0 1 _ _ _ _ _"
     *                    2^4 = 16, and 26 - 16 = 10. Put a "1" down. "1 0 0 1 1 _ _ _ _"
     *                    2^3 = 8, and 10 - 8 = 2. Put a "1" down. "1 0 0 1 1 1 _ _ _"
     *                    2^2 = 4, but 2 - 4 < 0. Put a "0" down. "1 0 0 1 1 1 0 _ _"
     *                    2^1 = 2, and 2 - 2 = 0. Put a "1" down. "1 0 0 1 1 1 0 1 _ "
     *                    2^0 = 1, but 0 - 1 < 0. Put a "zero" down. "1 0 0 1 1 1 0 1 0"
     *                    Final answer: 314 in binary is 100111010!
     *                    
     * Folling the same reasoning, we can also convert BACK to base 10, by corresponding
     * powers of 2 to each digit place in a binary number.
     * 
     * For example: Convert 1101001 to base 10.
     *                    List out the digits:   1    1    0    1    0    0    1
     *                    List out powers of 2: 2^6  2^5  2^4  2^3  2^2  2^1  2^0
     *                    If a "1" is present, add: 2^6 + 2^5 + 2^3 + 2^0
     *                                              64 + 32 + 8 + 1
     *                                            = 105
     *                    Final answer: 1101001 in base 10 is 105!                        
     *                                          
     */    
    public static String[] createBinaryNumbersStringArray(int n)
    {
        String[] arr;                           //create a temporary array of strings 
        arr = new String[(int)Math.pow(2,n)];   //to be returned of lenth 2^n
        for(int i = 0; i < Math.pow(2,n); i++)
        {
            char[] tempCharArr;         //create a temporary array of characters
            tempCharArr = new char[n];  //to hold the digits of a binary number
            int j = 0;  //initialize index for the character array
            int x = i;  //initialize value to be compared at each digit place of the binary number                                      
            for(int z = (int)Math.pow(2,n-1); z > 0; z /= 2)
            {                
                if(j == n)  //breaks out of the loop once the digit
                    break;  //maximum has been reached ("n", in this case)
                if(x - z >= 0)  //checks if each power of 2 goes into "x"
                {
                    tempCharArr[j] = '1';   //assigns a value of "1" to the jth digit slot    
                    x -= z; //subtracts zth power of two from "x"
                    j++;    //goes to the next digit slot for the character array     
                }    
                else
                {
                    tempCharArr[j] = '0';   //assigns a value of "0" to the jth digit slot
                    j++;    //goes to the next digit slot for the character array
                }
            }                                                            
            arr[i] = new String(tempCharArr);   //assigns each character array to a new memory location in the string array         
        }
        return arr; //returns the string array that holds all the binary numbers up to 2^n -1
    }
    
    /*
     * countNumberOfGoodOutcomes: given an array of binary numbers and a substring, will return
     *                            the number of strings that do not contain that substring.
     * parameters: (String[] arr, String string)
     * return value: int
     * precondition: "arr" and "string" must have values
     * postcondition: none;
     */
    public static int countNumberOfGoodOutcomes(String[] arr, String string)
    {
        int num = 0;    //initializes the number of "good" outcomes
        for(int i = 0; i < arr.length; i++)
            if(!arr[i].contains(string))    //checks if the binary string contains the string to be excluded
                num++;  //increases the number of "good" outcomes by 1
        return num; //returns the total number of "good" outcomes
    }    
    
    /*
     * listGoodOutcomes: given an array of binary numbers and a substring, will list the 
     *                   strings that do not contain that substring.
     * parameters: (String[] arr, String string)
     * return value: none
     * precondition: "arr" and "string" must have values
     * postcondition: none;
     */
    public static void listGoodOutcomes(String[] arr, String string)
    {
        int num = 1; //initializes the number of "good" outcomes being printed out
        for(int i = 0; i < arr.length; i++)
            if(!arr[i].contains(string))    //checks if the binary string contains the string to be excluded
            {
                System.out.printf("#%2d  ",num);    //prints out a number corresponding to the number of "good" outcomes
                System.out.println(arr[i]); //prints out the "good" outcome at the ith memory location of the string array
                num++;  //increases the number corresponding to the number of "good" outcomes
            }
        System.out.println("\n");                
    }       
    
    public static void main(String[] args)
    {
        Scanner input;                  //java syntax to be able to take in
        input = new Scanner(System.in); //input from the user
        System.out.println("Given 'n', this program will give the number of binary strings\n"
                            + "of 'n' length that do not contain an input substring.\n\n\n"); 
        while(true) //loop structure to keep the program running until the user ends it
        {
            int n;                          //creates the variables to be used
            String[] arrayOfBinaryNumbers;  //in the "main" method call
            String substringToExclude;      //of this program
            System.out.print("What is your 'n'? (Type '0' to end): ");
            n = input.nextInt();    //takes in the value of "n" from the user
            if(n == 0)
                break;  //breaks from the loop structure if the user inputs "0"               
            arrayOfBinaryNumbers = createBinaryNumbersStringArray(n);   //calls the function and assigns the value  
            System.out.print("What is the substring you're looking to exclude?: ");
            input.nextLine();   //clears the input variable (I think) *not sure why this NEEDS to happen, but it DOES*
            substringToExclude = input.nextLine();  //takes in the string to be excluded from the user
            System.out.print("\n");
            System.out.printf("The number of 'good' outcomes is: %d\n\n",countNumberOfGoodOutcomes(arrayOfBinaryNumbers, substringToExclude));
            listGoodOutcomes(arrayOfBinaryNumbers, substringToExclude);
            //last two lines both make function calls to the subroutines written in this program to
            //list the number of "good"outcomes and to list them out
            
        }
    }        
}            