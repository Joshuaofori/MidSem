import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 * Class read from user takes the input of the user from the ocmmand line .
 * stores the user inputed data into a file
 * the stored data is also formatted as a 3*3 array
 *
 * */
public class ReadFromUser {
    int count = 0;//counts the number of inputs the user must do NB only nine
    int x=1;      //helps in the formatting of the user input in an matrix form stored in a file

    public String takeInput(){//method that performs the taking from user and storing to file
        try{//handling any unexpected error
            System.out.println("please enter the odd numbers");//promts the user to input the numbers
            Scanner input=new Scanner(System.in);
            File file=new File("ourdata.txt");
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            while(count!=9) {//checks the number of user input not to be below nine and more than nine
                String inputting=input.next();//inputting take the input.next which is the scanner object user inputs to
                if(Integer.parseInt(inputting)%2!=1){//checks if the inputted is and odd number
                    System.out.println("please the input must be an odd number");
                     inputting=input.next();
                }
                bufferedWriter.write(inputting);//if the input is an odd number it writes
                /**
                 * formats the stored data in a matrix form
                 */
                if(x==3){
                    bufferedWriter.newLine();
                x=0;}
                else
                bufferedWriter.write(" ");

                count++;
                x++;
            }
            bufferedWriter.close();//closes the writer
        }
        catch (IOException e){//exception is handled
            e.getMessage();
        }
        return "ourdata.txt";
}}
