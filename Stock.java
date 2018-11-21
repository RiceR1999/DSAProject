/*

 * Purpose: Data Structure and Algorithms Final Project

 * Status: Complete and thoroughly tested

 * Last update: 11/21/18

 * Comment: Stock class which manages 

 * @author: Ryan Rice 

 * @version: 2018.11.21

 */
import java.util.ArrayList;

public class Stock {

	private ArrayList<Item> stock;
	
	/**
	 *Constructor for Stock class
	 *@param itemName 
	 */
	public Stock()
	{
		stock = new ArrayList<>();
	}
	
	/**
	 * Adds an item to the stock list
	 * @param item
	 */
	public void addItem(Item item)
	{
		stock.add(item);
	}
	/**
	 * Gets an item from stock list
	 * @param item
	 * @return item
	 */
	public Item getItem(Item item)
	{
		Item theItem = null;
		for(int x = 0; x < stock.size(); x++)
		{
			if(stock.get(x).equals(item))
			{
				theItem = stock.get(x);
			}
		}
		return theItem;
	}
	
	/**
	 * Removes a given item from stock list
	 * @param item
	 */
	public void removeItem(Item item)
	{
		boolean found = false;
		for(int x = 0; x < stock.size(); x++)
		{
			if(stock.get(x).getName().equals(item.getName()))
			{
				found = true;
				stock.remove(x);
				System.out.println("Item successfully removed!");
			}
		}
		if(found)
		{
			System.out.println("Item not found!");
		}
	}
	
	/**
	 * Overriding toString to fit our program
	 */
	public String toString()
	{
		String result = "|| ";
		for(Item guy: stock)
		{	
		
		 result += guy.getName() + ":" + guy.getCount() + "|| " ;
		
		}
		return result;
	}
	
	/**
	 * Accepts an index location to convert to string, allows for more functionality within the driver
	 * @param index
	 * @return string item
	 */
	public String toString(int index)
	{
		return stock.get(index).getName() + " || " + stock.get(index).getCount();
	}
}
