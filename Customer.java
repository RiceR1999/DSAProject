/*

 * Purpose: Data Structure and Algorithms Final Project

 * Status: Complete and thoroughly tested

 * Last update: 11/21/18

 * Comment: Customer class which manages customer name and shopping cart

 * @author: Ryan Rice

 * @version: 2018.11.21

 */
import java.util.ArrayList;
public class Customer {
	
	private String name;
	private ArrayList<String> cart;
	
	/**
	 * Constructor for customer class
	 * @param name
	 */
	public Customer(String name)
	{
		this.name = name;
		this.cart = new ArrayList<>();
	}
	
	/**
	 * Accessor method that returns customer name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Since our driver will not have the ability to access the array list of the customer sub class 
	 * we must create methods to do so
	 * @param item
	 */
	public void addToCart(String item)
	{
		cart.add(item);
	}
	
	/**
	 * Finds and removes a given shopping cart item
	 * @param item
	 */
	public void removeFromCart(String item)
	{
		boolean found = false;
		for(int x = 0; x < cart.size(); x++)
		{
			if(cart.get(x).equals(item))
			{
				found = true;
				cart.remove(x);
				System.out.println("Item successfully removed!");
			}
		}
		if(found)
		{
			System.out.println("Item not found!");
		}
	}
	
	/**
	 * Finds and returns a given item
	 * @param item
	 */
	public String getFromCart(String item)
	{
		String theString = "";
		boolean found = false;
		for(int x = 0; x < cart.size(); x++)
		{
			if(cart.get(x).equals(item))
			{
				found = true;
				theString = cart.get(x);
			}
		}
		return theString;
	}
}
