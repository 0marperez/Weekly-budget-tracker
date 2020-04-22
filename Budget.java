//FileWriter writes over what already exists
//PrintWriter erases and then writes

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Budget {
    
    public static void main (String[]args) throws Exception{
        
        
        //Scanners for reading file and System.in
        Scanner scan = new Scanner(System.in);
        File data = new File("data.txt");
        Scanner scnr = new Scanner(data); 
        
        
        //Reading vars from file
        int incomeThisWeek = scnr.nextInt();
        int income = scnr.nextInt();
        int car = scnr.nextInt();
        int mom = scnr.nextInt();
        int gas = scnr.nextInt();
        int food = scnr.nextInt();
        int random = scnr.nextInt();
    
        int month = scnr.nextInt();
        int weekDay = scnr.nextInt();
                
        
        //Running the main menu for the first time
        int choice = mainMenu(weekDay, month, incomeThisWeek, income, car, mom, gas, food, random);
    
        //While the program is running(choice controls this)
        while(choice != 5){
            
            //What the user picked
            switch(choice){

                case 1:
                    
                    //Add Expense
                    int amount = 0;

                    System.out.println("1.Car Payment\n2.Mom\n3.Gas\n4.Food\n5.Random");                  
                    int expenseOption = scan.nextInt();

                    switch(expenseOption){

                        case 1:
                            System.out.println("Enter amount: ");
                            amount = scan.nextInt();
                            car+= amount;
                            income-= amount;
                            break;

                        case 2:
                            System.out.println("Enter amount: ");
                            amount = scan.nextInt();
                            mom+= amount;
                            income-= amount;
                            break;


                        case 3:
                            System.out.println("Enter amount: ");
                            amount = scan.nextInt();
                            gas+= amount;
                            income-= amount;
                            break;

                        case 4:
                            System.out.println("Enter amount: ");
                            amount = scan.nextInt();
                            food+= amount;
                            income-= amount;
                            break;
                            
                        case 5:
                            System.out.println("Enter amount: ");
                            amount = scan.nextInt();
                            random+= amount;
                            income-= amount;
                            break;

                    }
                    
                    break;

                case 2:
                    
                    //Add income
                    System.out.println("Enter amount: ");
                    amount = scan.nextInt();
                    incomeThisWeek += amount;
                    income += amount;
                    break;

                case 3:
                    
                    //Start new week
                    System.out.println("Is this a correction?");
                    String yesOrNo = scan.next();
                    
                    if(yesOrNo.equals("No") || yesOrNo.equals("N") || yesOrNo.equals("n") || yesOrNo.equals("no")){
                        
                        incomeThisWeek = 0;
                        income = 0;
                        car = 0;
                        mom = 0;
                        gas = 0;
                        food = 0;
                        random = 0;
                        month = 0;
                        weekDay = 0;
                        
                    }
                    
                    else{}
                    
                    System.out.println("What month will the week start in?");
                    month = scan.nextInt();
                    
                    System.out.println("What day will the new week start?");
                    weekDay = scan.nextInt();
                    break;
                    
                case 4:
                    
                    //Save
                    String variables = "";
                    
                    Integer.toString(incomeThisWeek);
                    variables += incomeThisWeek;
                    variables += "\n";
                    
                    Integer.toString(income);
                    variables += income;
                    variables += "\n";
                    
                    Integer.toString(car);
                    variables += car;
                    variables += "\n";
                    
                    Integer.toString(mom);
                    variables += mom;
                    variables += "\n";
                    
                    Integer.toString(gas);
                    variables += gas;
                    variables += "\n";
                    
                    Integer.toString(food);
                    variables += food;
                    variables += "\n";
                    
                    Integer.toString(random);
                    variables += random;
                    variables += "\n";
                    
                    Integer.toString(month);
                    variables += month;
                    variables += "\n";
                    
                    Integer.toString(weekDay);
                    variables += weekDay;
                    
                    
                    try{
            
                        PrintWriter writer = new PrintWriter(data);
                        writer.print(variables);
                        writer.close();
                
                    }
        
                    catch(Exception d){
            
                        System.out.print("Exceptioooooon!");
                        
                    }
                    
                    System.out.println("Data has been saved succesfully");
                    break;
                    
                case 5:
                    
                    //Exit
                    System.out.println("Goodbye");
                    break;

                default:
                    
                    //Invalid Input
                    System.out.println("Invalid input, please try again");
                    break;

            }
            
            choice = mainMenu(weekDay, month, incomeThisWeek, income, car, mom, gas, food, random);
            
        }
        
        System.out.println("Goodbye");
        
    }
    
    public static int mainMenu(int month, int weekDay, int incomeThisWeek, int income, int car, int mom, int gas, int food, int random){
        
        
        Scanner scan = new Scanner(System.in);
        int expenses = gas + car + food + random + mom;
        
        
        System.out.println("\n\n\tPay period begins " + month + "/" + weekDay + "/2020\n");
        System.out.println("=========================================");
        System.out.println("\nIncome\t\t\t\t$" + incomeThisWeek + "\nMoney left\t\t\t$" + income + "\nMoney Spent\t\t\t$" + expenses + "\n");
        System.out.println("=========================================");
        System.out.println("\nCar Payment\t\t\t$" + car + " / $120\nMom Payment\t\t\t$" + mom + " / $80\nGas\t\t\t\t$" + gas + " / $60\nFood\t\t\t\t$" + food + " / $40\nRandom shit\t\t\t$" + random + " / $60\n");
        System.out.println("=========================================");
        
        
        System.out.println("\n\t1.Add expense");
        System.out.println("\t2.Add income");
        System.out.println("\t3.Start new week");
        System.out.println("\t4.Save");
        System.out.println("\t5.Exit\n");
        
        
        int choice = scan.nextInt();
        return choice;
        
        
    }
    
    
}
