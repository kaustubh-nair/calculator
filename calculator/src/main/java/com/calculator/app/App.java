package com.calculator.app;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;
import java.lang.Math;

public class App
{
    static Logger log = LogManager.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        int x=0;
        int b=0;
        int choice=0;
        while(true)
        {
            System.out.println( "Choose\n1. Square root\n2. Factorial\n3. Natural logarithm\n4. Power function\n0. Exit\n" );
            choice = scan.nextInt();
            if (choice == 0)
                break;
            if (choice != 4)
            {
                System.out.println( "Enter number" );
                x = scan.nextInt();
            }

            if (choice == 1)
                System.out.println("Square root of " + x + " is " + squareRoot(x) + " \n");
        }
    }
    public static double squareRoot(int number) {
        return Math.sqrt(number);
    }
}
