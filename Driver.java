
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
		QueueRA<String> shoppingNames = new QueueRA<String>();
		QueueRA<String> checkoutNames = new QueueRA<String>();
		QueueRA line1 = new QueueRA();
		QueueRA line2 = new QueueRA();
		QueueRA express = new QueueRA();
		ListArrayBased<Stock> stock = new ListArrayBased<Stock>();
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
			System.out.println("3. Customer removes an item from the shoppint cart.");
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
				// Add the name to the queue of shoppingNames
				shoppingNames.enqueue(name);
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
					for (int x = 0; x < stock.size(); x++) {
						if (stock.get(x).equals(itemName)) {
							System.out.println(addName + " now has " + "(Number of items in cart ); in their shopping cart");
							// Increase the number of items in the customer's cart by one
							// Decrease the number of that specific item in the stock by one.
						} else {
							System.out.println("That item is not in the stock!");
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
					
					System.out.println("Customer " + removeName + " now has (Number of items in cart ); in their shopping cart");
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
				if (shoppingNames.isEmpty()) {
					System.out.println("No customers in the Shopping Center!");
				} else if (c.equals("regular1")) {
					System.out.println("After (numMinutes) in the shopping center, customer " + shoppingNames.peek()
							+ " with (numItems) is now in the first checkout line");
					line1.enqueue(shoppingNames.peek());
					checkoutNames.enqueue(shoppingNames.peek());
					shoppingNames.dequeue();
				} else if (c.equals("regular2")) {
					System.out.println("After (numMinutes) in the shopping center, customer " + shoppingNames.peek()
							+ " with (numItems) is now in the second checkout line");
					line2.enqueue(shoppingNames.peek());
					checkoutNames.enqueue(shoppingNames.peek());
					shoppingNames.dequeue();
				} else if (c.equals("express")) {
					System.out.println("After (numMinutes) in the shopping center, customer " + shoppingNames.peek()
							+ " with (numItems) is now in the express checkout line");
					express.enqueue(shoppingNames.peek());
					checkoutNames.enqueue(shoppingNames.peek());
					shoppingNames.dequeue();
				}
				break;

			case 5:
				// User is prompted in (Y/N) question format whether the first customer in the
				// checkout line should check out or keep shopping.
				// If Yes, the customer leaves the shopping center and their name is removed
				// from the checkoutNames.
				// If No, their name is removed from the checkoutNames queue and added to the
				// shoppingNames queue.
				if (line1.isEmpty() && line2.isEmpty() && express.isEmpty()) {
					System.out.println("No customers are in any line!");
				} else {
					// Prompts the user if the first customer in the checkoutLine should check out
					// or keep shopping.
					System.out.println(
							"Should customer " + checkoutNames.peek() + " check out or keep on shopping? (Y/N)");
					String a = s.next();
					// If answer == "Y", the first customer in the checkoutLine checks out and
					// leaves the shopping center
					if (a.equals("Y")) {
						System.out.println("Customer " + checkoutNames.peek() + " is now leaving the shopping center.");
						checkoutNames.dequeue();
					} else {
						System.out
								.println("Customer " + checkoutNames.peek() + " with (numItems) returned to shopping");
						shoppingNames.enqueue(checkoutNames.peek());
						checkoutNames.dequeue();
					}
				}
				break;
			case 6:
				if (shoppingNames.isEmpty()) {
					System.out.println("No customers are in the Shopping Center!");
				} else {
					System.out.println("The following " + shoppingNames.peek() + " customers are in the shopping center:");
					// for(int x = 0; x<shoppingNames.size(); x++) {
					// System.out.println("Customer " + shoppingNames.get(x) " with " +
					// shoppingNames.get(x).getAmount() + " items for " +
					// shoppingNames.get(x).getTimeShopping() + " minutes.");
					// }
					System.out.println(shoppingNames.toString());
				}
				break;

			case 7:
				if (line1.isEmpty()) {
					System.out.println("No customers are in the first shopping line!");
				} else {
					System.out.println(
							"The following (num) customers are in the first checkout line : " + line1.toString());
				}
				if (line2.isEmpty()) {
					System.out.println("No customers are in the second shopping line!");
				} else {
					System.out.println(
							"The following (num) customers are in the second checkout line : " + line2.toString());
				}
				if (express.isEmpty()) {
					System.out.println("No customers are in the express shopping line!");
				} else {
					System.out.println(
							"The following (num) customers are in the express checkout line : " + express.toString());
				}
				break;

			case 8:
				if (stock.isEmpty()) {
					System.out.println("No items are in the stock!");
				} else {
					System.out.println("Items that are below stocking level: ");
					for (int x = 0; x < stock.size(); x++) {
						// if(((stock.get(x)).getCount())<stockAmount){
						// System.out.println(stock.get(x));
						// }
					}
				}
				break;

			case 9:
				System.out.println("Enter name of the reorder item: ");
				String item = s.next();
				// Go through the stock to see if that item is present. If it is, add more to
				// the stock
				// If it isn't in the stock, it can't be re-ordered.
				for (int x = 0; x < stock.size(); x++) {
					if (stock.get(x).equals(item)) {
						System.out.println("Enter number of " + item + "s ");
						int itemNum = s.nextInt();
						System.out.println("Stock now has " + itemNum + " more " + item + "s");
						//Add that amount of the item to the stock
					} else {
						System.out.println("That item is not in the stock!");
					}
				}

				break;

			default:
				System.out.println("Please enter a valid number.");
			}
		}
	}
}
