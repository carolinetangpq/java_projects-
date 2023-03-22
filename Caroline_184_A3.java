//Full name: Caroline Tang 
//Full time 
//Declaration: It is my own work 

import java.util.Random;
import java.util.ArrayList; 
import java.util.Arrays; 

class Staff 
{
    //declare the instance variables 
    private static int SIZE = 8; 
    private String name; 
    private double [] score = new double [SIZE]; 

    public Staff(String name)
    {
        this.name = name;
        generateScore();
    }

    public String getName()
    {
        return name; 
    }

    private void generateScore()
    {
        Random rand = new Random(); 
        for (int i = 0; i < score.length; i++)
        {
            score[i] = rand.nextDouble() * 10.0; 
        }
    }
    
    public void printInfo()
    {
        System.out.printf("%s", name); 
        for (double mark : score) {
        System.out.printf("\t%.1f", mark); 
        }
        System.out.printf("\t%.2f%n", average());
    }

    private double highest()
    {
        int highest_i = 0; 
        for (int i = 1; i < score.length; i++) {
            if (score [i] > score[highest_i]) {
                highest_i = i; 
            }
        }

        return score[highest_i]; 
    }

    private double lowest() 
    {
        int lowest_i = 0; 
        for (int i = 1; i < score.length; i++) {
            if (score[i] < score[lowest_i]) {
                lowest_i = i; 
            }
        }
        return score[lowest_i]; 
    }

    public double average()
    {
        double sum = 0.0; 
        for (double mark : score) {
            sum += mark; 
        }

        sum = sum - lowest() - highest(); 
        double average = sum / (score.length - 2); 

        return average; 
    }

}

class Caroline_184_A3
{
    private static String [] nameArray = {"Heng 1", "Heng 2", "Heng 3", "Heng 4", 
                                                "Heng 5", "Heng 6", "Heng 7", "Heng 8"}; 
    
    private static Staff diamondAward(ArrayList <Staff> alist)
    {
        Staff diamondAward = alist.get (0); 

        for (Staff a : alist)
        {
            if (a.average() > diamondAward.average()) {
                diamondAward = a;
                
            } 

        }

        return diamondAward;
    } 

 
    
    private static Staff goldAward(ArrayList <Staff> alist)
    {
        Staff diamondStaff = diamondAward(alist);
        alist.remove(diamondStaff);
        Staff goldAward = alist.get(0); 

        for (Staff a : alist)
        {
            
            if ( a.average() > goldAward.average()) {
                goldAward = a; 
            }
            
        }

        return goldAward; 
    }

    
    private static Staff bronzeAward(ArrayList <Staff> alist)
    {
        Staff bronzeAward = alist.get(0);
        for (Staff a : alist)
        {
            if (a.average() < bronzeAward.average())
            bronzeAward = a; 
        }

        return bronzeAward; 
    }
    

    public static void main (String [] args)
    {
        //creating an empty object 
        ArrayList <Staff> alist = new ArrayList <Staff> ();

        //initializing the object 
        for (String a : nameArray ) {
            alist.add(new Staff(a));
        }

        System.out.printf("Name\t S1\t S2\t S3\t S4\t S5\t S6\t S7\t S8\tAverage\n");
        for (Staff a : alist) {
    
            a.printInfo();
        }

        System.out.printf("The result is %n");

        Staff diamondAward = diamondAward(alist);
        System.out.printf("Diamond teaching award: %s%n", diamondAward.getName());

        Staff goldAward = goldAward(alist);
        System.out.printf("Gold teaching award: %s%n", goldAward.getName());


        Staff bronzeAward = bronzeAward(alist);
        System.out.printf("Bronze teaching award: %s%n", bronzeAward.getName());
    

    }

}