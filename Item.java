/*

 * Purpose: Data Structure and Algorithms Final Project

 * Status: Complete and thoroughly tested

 * Last update: 11/21/18

 * Comment: Basic item class that defines a stock item

 * @author: Ryan Rice

 * @version: 2018.11.21

 */
public class Item {

	private String itemName;
	private int itemCount;
	
	/**
	 * Constructor for the item class
	 * @param itemName
	 * @param itemCount
	 */
	public Item(String itemName, int itemCount)
	{
		this.itemName = itemName;
		this.itemCount = itemCount;
	}
	
	/**
	 * Mutator that sets item count
	 * @param count
	 */
	public void setCount(int count)
	{
		this.itemCount = count;
	}
	
	/**
	 * Accessor that gets item count
	 * @return itemCount
	 */
	public int getCount()
	{
		return itemCount;
	}
	
	/**
	 * Accessor that gets item name
	 * @return itemName
	 */
	public String getName()
	{
		return itemName;
	}
}
