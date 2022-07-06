package asm2;

/**
* Product class
*/
public class Product {
	
	public String bcode;
	public String title;
	public int quantity;
	public double price;
	
	/**
	 * Default constructor
	 */
	public Product() {

	}

	/**
	 * Constructor method to initialize a product
	 *
	 * @param bcode    Product's bar code
	 * @param title    Product's title
	 * @param quantity Product's quantity
	 * @param price    Product's price
	 */
	public Product(String bcode, String title, int quantity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Convert this product to String for printing
	 */
	@Override
	public String toString() {
		return this.bcode + " | " + this.title +  " | " + this.quantity + " | " + this.price;
	}
}
