/*
 * Name: Aidan Latham
 * Program: Binary String of length 'n' - w/out "10" 
 * Description: Given an input value,'n', will return the number
 *              of "good" outcomes, and will list them
 */

import java.util.Scanner;

public class Binary_N_10
{
    /*
     * createString: returns an array of characters with 
     *               'i' amount of ones of 'n' length.
     * parameters: (int i)
     * return value: char[]
     * precondition: 'n' must have a value
     * postcondition: none
     */
    
    public static char[] createString(int i, int n)
    {
        char[] binaryString;
        String output;
        binaryString = new char[n];
        for(int z = 0; z < n-i; z++)
            binaryString[z] = '0';                                                
        for(int z = n-1; z >= n-i; z--)
            binaryString[z] = '1';               
        return binaryString; 
    }       
    public static void main(String[] args)
    {
        System.out.println("Given 'n', this program will give the number of binary strings\nof 'n' length that do not contain the substring '10'\n");         
        Scanner input;
        input = new Scanner(System.in);        
        int n;
        while(true)
        {
            System.out.print("What is your 'n'? (Type '0' to end): ");
            n = input.nextInt();          
            if(n == 0)
                break;
            System.out.printf("\nThe number of 'good' strings is %d.\n\n\n",n+1); 
            for(int i = 0; i < n+1; i++)
            {
                System.out.printf("#%d  ",i+1);
                System.out.println(createString(i,n));
            }
            System.out.println("\n");    
        }
    }
}