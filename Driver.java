import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException,InstantiationException,InstantiationException,ClassNotFoundException,IllegalAccessException   {
		QueueRA<Customer> shoppingNames = new QueueRA<Customber>();
		QueueRA<Customber> checkoutNames = new QueueRA<Customber>();
		ListArrayBased<Stock>stock= new ListArrayBased<Stock>();
		
		Scanner s = new Scanner(System.in);
	   //Start of the program
	   System.out.println("Wlecome to the Shopping Center!");
	   System.out.println("");
	   System.out.println("Please specify stock.");
	   System.out.println("How many items do you have? ");
	   Integer num = s.nextInt();
	   int countStock=0;
	   while(countStock<num) {
		  System.out.print(">>Enter item name: ");
          String itemName = s.next();
          //Adds item to the stock
          stock.add(0, itemName);
          System.out.print("How many " + itemName + "s?");
          Integer itemNum = s.nextInt();
          System.out.println(itemNum + " items of " + itemName + " have been placed in stock.");
          countStock++;
          
	   }
       System.out.println("Please select the checkout line that should check out customers first (regular1/regular2/express): ");
       String c = s.next();
       if(c.equals("express")) {
       
       }
       else if(c.equals("regular1")) {
    	   
       }
       else {
    	   
       }

     while(true) {
     System.out.println("Select from the following menu: ");
     System.out.println("0. Close the Shopping Center");
     System.out.println("1. Customer enters Shoppint Center.");
     System.out.println("2. Customer picks an item and places it in the shopping cart.");
     System.out.println("3. Customer removes an itm from the shoppint cart.");
     System.out.println("4. Customer is done shopping. ");
     System.out.println("5. Customer checks out.");
     System.out.println("6. Print info about customers who are shopping.");
     System.out.println("7. Print info about customers in checkout lines");
     System.out.println("8. Print info about items at or below re-stocking level.");
     System.out.println("9. Reorder an item.");
     System.out.print("Make a menu selection now: ");

     Integer choice = s.nextInt();
     System.out.println(choice);
     switch(choice) {
     case 0:
     	System.out.println("Goodbye...");
 	    System.exit(0);
     	break;
     	
     case 1:
     	System.out.println("Enter customer name: ");
     	String name = s.nextLine();
     	//Add customer to the shoppingNames Queue
     	System.out.println("Customer " + name + " is now in the shopping center.");
             break;
             
     case 2:
         System.out.println("Enter customer name: ");
      	 String addName = s.nextLine();
      	 System.out.println("What item does " + addName + " want?");
      	 String itemName = s.nextLine();
            break;
            
     case 3:
	 System.out.println("Enter customer name: ");
    	 String removeName = s.nextLine();
    	 //Remove item from the customer's shopping cart
    	 System.out.println("Customer " + removeName + " now has ");
         break; 
             
     case 4:
     	
             break;
     case 5:
    	//Prompts the user if the first customer in the checkoutLine should check out or keep shopping.
     	System.out.println("Should customer " + shoppingNames.peek() + " check out or keep on shopping? (Y/N)");
     	String a = s.nextLine();
     	//If answer == "Y", the first customer in the checkoutLine checks out and leaves the shopping center
     	if(a.equals("Y")) {
     		System.out.println("Customer " + shoppingNames.peek() + " is now leaving the shopping center.");
     		shoppingNames.dequeue();
     	}
     	else {
     		
     	}
             break;
     case 6:
    	if(shoppingNames.isEmpty()) {
    		System.out.println("No customers are in the Shopping Center!");
    	}
    	else {
     	System.out.println("Customers who are shopping: " + shoppingNames.toString());
    	}
     	break;
     	
      case 7: 
    	 if(line1.isEmpty()) {
     		System.out.println("No customers are in the first shopping line!");
     	}
    	 if(line2.isEmpty()) {
      		System.out.println("No customers are in the second shopping line!");
      	}
    	 if(express.isEmpty()) {
      		System.out.println("No customers are in the express shopping line!");
      	}
    	System.out.println("The following (num) customers are in the first checkout line : " + line1.toString());
    	System.out.println("The following (num) customers are in the second checkout line : " + line2.toString());
    	System.out.println("The following (num) customers are in the express checkout line : " + line2.toString());
     	break;
     	
     case 8:
    	if(stock.isEmpty()) {
      		System.out.println("No items are in the stock!");
      	}
    	else {
    		
     	System.out.println("Items that are at or below re-stocking level: ");
    	 }
     	break;
     	
     case 9:
      	System.out.println("Enter name of the item that you would like to re-order.");
      	String item = s.next();
      	stock.add(0,item);
      	System.out.println("Enter number of " + item + "s ");
      	int itemNum = s.nextInt();
      	System.out.println("Stock now has " + itemNum + item + "s");
      	break;
     	
     default :
	  	  System.out.println("Please enter a valid number.");
}
}
}
}
