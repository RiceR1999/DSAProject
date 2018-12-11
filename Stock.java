

/*
 * Purpose: Data Structure and Algorithms Final Project
 * Status: Complete and thoroughly tested
 * Last update: 11/21/18
 * Comment: Stock class which manages 
 * @author: Ryan Rice 
 * @version: 2018.11.21
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Stock implements Iterable<Item> {

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
	 * returns size of stock array list
	 * @return size
	 */
	public int getSize()
	{
		return stock.size();
			
	}
	
	/**
	 * checks to see if array list is empty
	 * @return true/false
	 */
	public boolean isEmpty()
	{
		return stock.isEmpty();
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
	
	/**
	 * Override of the iterator method to since we declared an array list in the class and 
	 * have no access to for each / iterator outside of the class
	 * @return it
	 */
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> it = new Iterator<Item>() {

            private int currentIndex = 0;

            /**
             * Checks to see if there is a next index in the list
             */
            @Override
            public boolean hasNext() {
                return currentIndex < stock.size() && stock.get(currentIndex) != null;
            }
            
            /**
             * returns the next item in the list
             * @return Item
             */
            @Override
            public Item next() {
                return stock.get(currentIndex++);
            }
            
            /**
             * remove, we have no use for this method so we left it undefined
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
	}
