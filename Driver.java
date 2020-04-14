
/*
 * Purpose: Data Structure and Algorithms Final Project
 * Status: Complete and thoroughly tested
 * Last update: 11/21/18
 * Comment: Driver class that deals with all of the user input/output and execution of methods
 * @author: Kristen Stansfield
 * @version: 2018.11.21
 */

import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException, InstantiationException, InstantiationException,
			ClassNotFoundException, IllegalAccessException {
		QueueRA<Customer> shoppingNames = new QueueRA<Customer>();
		QueueRA<Customer> checkoutNames = new QueueRA<Customer>();
		QueueRA line1 = new QueueRA();
		QueueRA line2 = new QueueRA();
		QueueRA express = new QueueRA();
		Stock stock = new Stock();
		Customer person;
		int numShopping = 0;
		int numCheckOutOne = 0;
		int numCheckOutTwo = 0;
		int numExpress = 0;
		Scanner s = new Scanner(System.in);
		// Start of the program
		System.out.println("Welcome to the Shopping Center!");
		System.out.println("");
		System.out.println("Please specify stock.");
		System.out.println("How many items do you have? ");
		Integer num = s.nextInt();
		System.out.println("Please specify restocking amount: ");
		Integer stockAmount = s.nextInt();
		int countStock = 0;
		while (countStock < num) {
			System.out.print(">>Enter item name: ");
			String itemName = s.next();
			// Adds item to the stock
			stock.add(0, itemName);
			System.out.print("How many " + itemName + "s?");
			Integer itemNum = s.nextInt();
			System.out.println(itemNum + " items of " + itemName + " have been placed in stock.");
			countStock++;
		}
		System.out.println(
				"Please select the checkout line that should check out customers first (regular1/regular2/express): ");
		String c = s.next();
		if (c.equals("express")) {

		} else if (c.equals("regular1")) {

		} else {

		}

		while (true) {
			System.out.println("Select from the following menu: ");
			System.out.println("0. Close the Shopping Center");
			System.out.println("1. Customer enters Shopping Center.");
			System.out.println("2. Customer picks an item and places it in the shopping cart.");
			System.out.println("3. Customer removes an item from the shopping cart.");
			System.out.println("4. Customer is done shopping. ");
			System.out.println("5. Customer checks out.");
			System.out.println("6. Print info about customers who are shopping.");
			System.out.println("7. Print info about customers in checkout lines");
			System.out.println("8. Print info about items at or below re-stocking level.");
			System.out.println("9. Reorder an item.");
			System.out.print("Make a menu selection now: ");

			Integer choice = s.nextInt();
			System.out.println(choice);
			switch (choice) {
			case 0:
				System.out.println("Goodbye...");
				System.exit(0);
				break;

			case 1:
				System.out.println("Enter customer name: ");
				String name = s.next();
				person = new Customer(name);
				shoppingNames.enqueue(person);
				numCustomers++;
				System.out.println("Customer " + name + " is now in the Shopping Center.");
				break;


			case 2:
				if (shoppingNames.isEmpty()) {
					System.out.println("No one is in the Shopping Center!");
				} else {
					System.out.println("Enter customer name: ");
					String addName = s.next();
					System.out.println("What item does " + addName + " want?");
					String itemName = s.next();
					boolean found = false;
					for (Customer cust : shoppingNames) {
						if (cust.getName().equalsIgnoreCase(addName)) {
							for(Item iteM:stock){
								if (iteM.getName().equals(itemName)) {
									found = true;
									cust.addToCart();
									iteM.decrementCount();
									for(Customer cust2: shoppingNames)
									{
										cust2.minIncrement();
									}
									System.out.println(cust.getName() + " now has " + cust.sizeOfCart()
											+ " items in their shopping cart");
						}
					}
					if(!found) {
						System.out.println("Item is not in the stock!");
					}
					}
				}
				}
				break;
					
			case 3:
					if (shoppingNames.isEmpty()) {
					System.out.println("No one is in the shopping center!");
				} else {
					System.out.println("Enter customer name: ");
					String removeName = s.next();
					// Remove item from the customer's shopping cart
					for(Customer cust: shoppingNames)
					{
						if(cust.getName().equalsIgnoreCase(removeName))
						{
							for(Customer cust2: shoppingNames)
							{
								cust2.minIncrement();
							}
							cust.removeFromCart();
							System.out.println("Customer " + removeName + " now has " + cust.sizeOfCart() + " items in their cart");
							break;
						}
					}
						System.out.println("Customer not found");
				}
				break;

		case 4:
				// The program picks the customer who has been shopping for the most amount of
				// time
				// (In order to simulate the passing of time, you should assume that every time
				// a customer places an item into or removes an item from the shopping cart, a
				// minute passes (for everybody in the Shopping Center))
				// and has greater than zero items in their shopping cart to enter the line.
				// The name of the customer is removed from the Shopping Queue and added to the
				// CheckOut Queue.
				// If the express line is twice as long as a regular line a customer with <=4 items will 
				//choose the shortest regular line for checkout instead.
				
				if (shoppingNames.isEmpty()) {
					System.out.println("No customers in the Shopping Center!");
				}
					else if (shoppingNames.peek().sizeOfCart()<=4) {
					//Customer goes into express lane
					System.out.println("After " + shoppingNames.peek().getMin() +" minutes in the shopping center, customer " + shoppingNames.peek().getName()
							+ " with " + shoppingNames.peek().sizeOfCart() + " items is now in the express checkout line");	
							express.enqueue(shoppingNames.peek());
							checkoutNames.enqueue(shoppingNames.peek());
							shoppingNames.dequeue();
							numExpress++;
							numShopping--;
						}
				 else if (numCheckOutOne < numCheckOutTwo) {
					 //Customer goes into line one
					 System.out.println("After " + shoppingNames.peek().getMin() +" minutes in the shopping center, customer " + shoppingNames.peek().getName()
								+ " with " + shoppingNames.peek().sizeOfCart() + " items is now in the first checkout line");	
					line1.enqueue(shoppingNames.peek());
					checkoutNames.enqueue(shoppingNames.peek());
					shoppingNames.dequeue();
					numCheckOutOne++;
					numShopping--;
					}
				 else {
					//customer goes into line 2
					System.out.println("After " + shoppingNames.peek().getMin() +" minutes in the shopping center, customer " + shoppingNames.peek().getName()
							+ " with " + shoppingNames.peek().sizeOfCart() + " items is now in the second checkout line");					
					line2.enqueue(shoppingNames.peek());
					checkoutNames.enqueue(shoppingNames.peek());
					shoppingNames.dequeue();
					numCheckOutTwo++;
				 }

					break;
					
					
			case 5:
				if (line1.isEmpty() && line2.isEmpty() && express.isEmpty()) {
					System.out.println("No customers are in any line!");
				} else {
					// Prompts the user if the first customer in the checkoutLine should check out
					// or keep shopping.
					//The line that should be checked out first is the line that was specified in the beginning
					//Customers check out in a fair manner: all three checkout lines take turns in checking out customers.  
					//If there is no customer in the line whose turn it is to check out a customer, 
					//then the next checkout line that has customers in line will check out the first customer in line
					
					if(!(line1.isEmpty())||c.equals("regular1")) {
					System.out.println("Should customer " + line1.peek().getName()
							+ " check out or keep on shopping? (Y/N)");
					String a = s.next();
					// If answer == "Y", the first customer in line1 checks out and
					// leaves the shopping center
					if (a.equals("Y")) {
						System.out.println(
								"Customer " + line1.peek().getName() + " is now leaving the shopping center.");
						checkoutNames.dequeue();
						line1.dequeue();
					} else {
						System.out.println("Customer " + line1.peek().getName() + " with "
								+ line1.peek().sizeOfCart() + " items returned to shopping");
						line1.peek().setMin(0);
						shoppingNames.enqueue(line1.peek());
						checkoutNames.dequeue();
						line1.dequeue();
					}
					}
					else if(!(line2.isEmpty())||c.equals("regular2")) {
						System.out.println("Should customer " + line2.peek().getName()
						+ " check out or keep on shopping? (Y/N)");
						String a = s.next();
						if (a.equals("Y")) {
							System.out.println(
									"Customer " + line2.peek().getName() + " is now leaving the shopping center.");
							checkoutNames.dequeue();
							line2.dequeue();
						} else {
							System.out.println("Customer " + line2.peek().getName() + " with "
									+ line2.peek().sizeOfCart() + " items returned to shopping");
							line2.peek().setMin(0);
							shoppingNames.enqueue(line2.peek());
							checkoutNames.dequeue();
							line2.dequeue();
						}
					}
					else if(!(express.isEmpty())||c.equals("express")){
						System.out.println("Should customer " + express.peek().getName()
								+ " check out or keep on shopping? (Y/N)");
								String a = s.next();
								if (a.equals("Y")) {
									System.out.println(
											"Customer " + express.peek().getName() + " is now leaving the shopping center.");
									checkoutNames.dequeue();
									express.dequeue();
								} else {
									System.out.println("Customer " + express.peek().getName() + " with "
											+ express.peek().sizeOfCart() + " items returned to shopping");
									express.peek().setMin(0);
									shoppingNames.enqueue(express.peek());
									checkoutNames.dequeue();
									express.dequeue();
								}
				}
				}
				
				break;
					
			case 6:
			{
				if (shoppingNames.isEmpty()) {
					System.out.println("No customers are in the Shopping Center!");
				} else {
				System.out.println("The following " + numShopping + " customers are in the shopping center:");
					for(Customer cust: shoppingNames)
					{
						System.out.println("Customer " + cust.getName() + " with " + cust.sizeOfCart() + " items for " +  cust.getMin() + " minutes.");
					}
				}
				break;
			}

			case 7:
				if (line1.isEmpty()) {
					System.out.println("No customers are in the first shopping line!");
				} else {
				System.out.println("The following " + numCheckOutOne + " customers are in the first checkout line: ");
					for(Customer cust: line1)
					{
						System.out.println(cust.getName()+" ");
					}
				}
				if (line2.isEmpty()) {
					System.out.println("No customers are in the second shopping line!");
				} else {
					System.out.println("The following " + numCheckOutTwo + " customers are in the second checkout line: ");
					for(Customer cust: line2)
					{
						System.out.println(cust.getName() + " ");
					}
				}
				if (express.isEmpty()) {
					System.out.println("No customers are in the express shopping line!");
				} else {
					System.out.println("The following " + numExpress + " customers are in the express checkout line: ");
					for(Customer cust: express)
					{
						System.out.println(cust.getName() + " ");
					}
				}
				break;

			case 8:
				if (stock.isEmpty()) {
					System.out.println("No items are in the stock!");
				} else {
					System.out.println("Items that are below stocking level: ");
						for(Item item:stock){
							if(item.getCount() < stockAmount)
								System.out.println(item.toString());
						}
					}
				
				break;
			case 9:
					
						
			System.out.println("Enter name of the reorder item: ");
				String item = s.next();
				// Go through the stock to see if that item is present. If it is, add more to
				// the stock
				// If it isn't in the stock, it can't be re-ordered.
				boolean found = false;
				for(Item iteM:stock)
				{
					if (iteM.getName().equals(item)) {
						found=true;
						System.out.println("Enter number of " + item + "s ");
						int itemNum = s.nextInt();
						iteM.setCount(itemNum);
						System.out.println("Stock now has " + itemNum + " more " + item + "s");
						//Add that amount of the item to the stock
					}
				}
				if(!found) {
					System.out.println("That item is not in the stock!");
				}

				break;
			default:
				System.out.println("Please enter a valid number.");
			}
		}
	}
}
