/*
 * Purpose: Data Structure and Algorithms Final Project
 * Status: Complete and thoroughly tested
 * Last update: 11/21/18
 * Comment: Customer class which manages customer name and shopping cart
 * @author: Ryan Rice 
 * @version: 2018.11.21
 */
public class Customer {
	
	private String name;
	private int cart;
	private int minPassed;
	
	/**
	 * Constructor for customer class
	 * @param name
	 */
	public Customer(String name)
	{
		this.name = name;
		this.cart = 0;
		this.minPassed = 0;
	}
	
	/**
	 * Accessor method that returns customer name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	public void minIncrement()
	{
		minPassed++;
	}
	
	public int getMin()
	{
		return minPassed;
	}
	
	public int sizeOfCart()
	{
		return cart;
	}
	/**
	 * Since our driver will not have the ability to access the array list of the customer sub class 
	 * we must create methods to do so
	 * @param item
	 */
	public void addToCart()
	{
		cart++;
	}
	
	/**
	 * Removes the first item in the list
	 */
	public void removeFromCart()
	{
		cart--;
	}

}
