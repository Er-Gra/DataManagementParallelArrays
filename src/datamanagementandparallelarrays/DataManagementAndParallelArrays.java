/*
 * May 21st, 2020
 * Erika Graham
 * Program that helps user get an overall grade from various assignments for a whole course or courses.
 */
package datamanagementandparallelarrays;

import java.util.Scanner;

public class DataManagementAndParallelArrays {

  
    
    public static double overallMark(int marks[],int numberOfMarks){ //int 1 and 2 are marks[0] and [1]
        //calculations and for loop to calculate the overall grade
        double overallGrade = 0;
        int nextGrade = marks[0] + marks[1];
        for (int i = 2; i < numberOfMarks; i++){
            nextGrade = nextGrade + marks[i];
        }
        overallGrade = (double)nextGrade / (double)numberOfMarks;
        //rounding
        overallGrade = overallGrade * 100;
        overallGrade = Math.round(overallGrade);
        overallGrade = overallGrade / 100;
        
        return overallGrade;
    }
    
    public static void main(String[] args) {
        Scanner keyedInput = new Scanner (System.in);
        //declaring variables
        String userInput; 
        int numberOfMarks = 0;
        int choices = 0; //storage for user's choices, controls menu
        double overallGrade = 0; //storage for the overall grade of all entered assignments/subjects
        boolean valid = false; //helps with try-catch
        
        while (valid == false){ //prompts user for initial information
            System.out.println("Enter the number of assignments or subjects you want to calculate your marks from: ");
            userInput = keyedInput.nextLine();
            System.out.println("");
            
            try {//loop checks if information is valid (user has to enter an integer)
                numberOfMarks = Integer.parseInt(userInput);
                valid = true;// if value entered is an integer, user advances to next question
            } catch (NumberFormatException NFE){//if value entered is not an integer the loop repeats
                System.out.println("Sorry, that's not a valid input.");
                System.out.println("");
            }
        }
        //declare parallel arrays
        String assignmentName [] = new String [numberOfMarks];
        int marks [] = new int [numberOfMarks];
        
        //prompt to user to enter some names to indentify their assignments/subjects
        System.out.println("---* INITIAL DATA ENTRY *---");
        for (int i = 0; i < numberOfMarks; i++){
            System.out.println("");
            System.out.println("Enter the name of the subject/assignment " + (i+1) + ": ");
            assignmentName[i]= keyedInput.nextLine();
            
            valid = false;
            while (valid == false){ //prompts user for their marks in percentages
                System.out.println("Enter the grade of the assignments in percentage(%) form for "+assignmentName[i]+": ");
                userInput = keyedInput.nextLine();

                try {// checks if infomrmation is valid (user has to enter an integer)
                    marks[i] = Integer.parseInt(userInput);
                    valid = true;// if value entered is an integer it gets stored in the array
                } catch (NumberFormatException NFE){//if value entered is not an integer the loop repeats
                    System.out.println("Sorry, that's not a valid input.");
                }
            }
        }
        
        //display a menu to the user with options
        while (choices != 3){
            valid = false;
            
            while (valid==false){
                //menu for user interaction
                System.out.println("");
                System.out.println("----------------------- Menu -----------------------");
                System.out.println("1... Output original data");
                System.out.println("2... Output overall grade");
                System.out.println("3... Exit");
                System.out.println("Enter you choice: ");
                userInput = keyedInput.nextLine();
                System.out.println("");
                
                try {
                    choices = Integer.parseInt(userInput);
                    valid = true;
                } catch (NumberFormatException NFE){//if value entered is not an integer the loop repeats
                    System.out.println("Sorry, that's not a valid input.");
                }
            }
        
                if (choices == 1){ //outputs information entered previously
                    for(int i = 0; i < numberOfMarks;i++){
                        System.out.println("Your mark for "+assignmentName[i]+" is: "+marks[i]);
                    }
                } else if (choices == 2){
                    //calls the method overallCalc() to calculate the overall percentage
                    overallGrade = overallMark(marks,numberOfMarks);
                    System.out.println("Your overall grade is: "+ overallGrade);
                } else if (choices == 3){
                    System.out.println("You've closed the program successfully");
                }
        }        
            
            
        
        
        //end of the program
    }
}
