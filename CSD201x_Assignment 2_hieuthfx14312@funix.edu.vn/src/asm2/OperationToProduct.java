 package asm2;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* This class manages all functions relate to the product
*/
public class OperationToProduct {

	/**
	 * Searching and returning the index of product p in the list. If not found
	 * return -1.
	 *
	 * @param p    Product for searching
	 * @param list The Linked List
	 * @return The index of product p in the list
	 */
	public int index(Product p, MyList<Product> list) {
		
		Node<Product> current = list.head;
		
		if (list.head == null) {
			return -1;
		}
		
		int search = -1;
		int index = 0;
		while (current != null) {
			if (current.info.bcode.equalsIgnoreCase(p.bcode)) {
				search = index;
			} else {
				index++;
				current = current.next;
			}
		}						
		return search;
	}

	/**
	 * Creating and returning a product with info input from keyboard.
	 *
	 * @return The product
	 */
	public Product createProduct() {
		Scanner sc = new Scanner(System.in);	
		System.out.print("Input new ID: ");
		String bcode = sc.nextLine();
		
		System.out.print("Input Product's Name: ");
		String title = sc.nextLine();
		
		System.out.print("Input Product's quantity: ");
		int quantity = sc.nextInt();
		
		System.out.print("Input Product's price: ");
		double price = sc.nextDouble();
		
		Product p = new Product(bcode, title, quantity, price);
		
		return p;
	}

	/**
	 * Reading all products from the file and insert them to the list at tail.
	 *
	 * @param fileName The file name of the file
	 * @param list     The Linked List contains all products that read from file
	 */
	public void getAllItemsFromFile(String fileName, MyList<Product> list) {
		System.out.println("ID |  Title   | Quantity | price\r\n" + "--------------------------------");
		String thisLine;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
				String[] productInfo = thisLine.split("\\|");
				Product newProduct = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
				list.insertToTail(newProduct);
			}
			System.out.println();
			System.out.println("Successfully!");
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Something wrong");
		}
	}

	/**
	 * Reading all products from the file and insert them to the stack.
	 *
	 * @param fileName The file name of the file
	 * @param stack     The Stack contains all products that read from file
	 */
	public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
		String thisLine;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((thisLine = br.readLine()) != null) {				
				String[] productInfo = thisLine.split("\\|");
				Product newProduct = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
				stack.push(newProduct);
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Something wrong");
		}
	}

	/**
	 * Reading all products from the file and insert them to the queue.
	 *
	 * @param fileName The file name of the file
	 * @param queue     The Queue contains all products that read from file
	 */
	public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
		String thisLine;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((thisLine = br.readLine()) != null) {		
				String[] productInfo = thisLine.split("\\|");
				Product newProduct = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
				queue.push(newProduct);
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Something wrong");
		}
	}

	/**
	 * Adding a product to the list, info of the product input from keyboard.
	 *
	 * @param list The Linked list
	 */
	public void addLast(MyList<Product> list) {
		Node<Product> newNode =  list.head;
		list.insertToTail(createProduct());
	}

	/**
	 * Printing all prodcuts of the list to console screen
	 *
	 * @param list
	 */
	public void displayAll(MyList<Product> list) {
		Node<Product> current = list.head;
		System.out.println("ID |  Title   | Quantity | price\r\n" + "--------------------------------");

		if (list.head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			System.out.print(current.info.bcode + " | " + current.info.title + " | " + current.info.quantity + " | " + current.info.price + "\n");
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * Printing all prodcuts of the stack to console screen
	 *
	 * @param list
	 */
	public void displayStack(MyStack<Product> stack) {
		Node<Product> current = stack.head;
		System.out.println("ID |  Title   | Quantity | price\r\n" + "--------------------------------");
		
		if (stack.head == null) {
            System.out.printf("Stack is  empty!!");
            return;
        } else {
            while (current != null) {
            	System.out.print(current.info.bcode + " | " + current.info.title + " | " + current.info.quantity + " | " + current.info.price + "\n");
            	current = current.next;
            }
        System.out.println();
        System.out.println("Successfully! ");
        }
    }
	
	/**
	 * Printing all prodcuts of the queue to console screen
	 *
	 * @param list
	 */
	public void displayQueue(MyQueue<Product> queue) {
		Node<Product> current = queue.head;
		System.out.println("ID |  Title   | Quantity | price\r\n" + "--------------------------------");
		
		if (queue.head == null) {
            System.out.printf("Stack is  empty!!");
            return;
        } else {
            while (current != null) {
            	System.out.print(current.info.bcode + " | " + current.info.title + " | " + current.info.quantity + " | " + current.info.price + "\n");
            	current = current.next;
            }
        System.out.println();
        System.out.println("Successfully! ");
        }
    }

	/**
	 * Writing all products from the list to the file
	 *
	 * @param fileName Input file name
	 * @param list     Input Linked list
	 */
	public void writeAllItemsToFile(String fileName, MyList<Product> list) {
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			Node<Product> current = list.head;
			
			if(current == null) {
				System.out.println("List is empty");
			}
			while(current != null) {
				bw.write(current.info.toString());
				bw.newLine();
				current = current.next;
			}
			bw.close();
			fw.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}	
		System.out.println("Successfully!");
		System.out.println();
	}

	/**
	 * Searching product by ID input from keyboard.
	 *
	 * @param list
	 */
	public void searchByCode(MyList<Product> list) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the IDto search= ");
		String search = sc.nextLine();
				
		Node<Product> current = list.head;
		
		if (list.head == null) {
			System.out.println("List Empty!");
		}
		
		int index = 0;
		
		while (current != null) {
			if (current.info.bcode.trim().equalsIgnoreCase(search.trim())) {
				index++;
				System.out.print("Result: "+ current.info.bcode + " | " + current.info.title + " | " + current.info.quantity + " | " + current.info.price + "\n");
				break;
			} else {
				current = current.next;
			}
		}
		if (index == 0) {
			System.out.println("Not found");
		}
	}

	/**
	 * Deleting first product that has the ID input from keyboard from the list.
	 *
	 * @param list
	 */
	public void deleteByCode(MyList<Product> list) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the bcode to delete = ");
	    String key = sc.nextLine();
	    
	    Node<Product> del  = list.head;
	    
	    if(del == null){
	        System.out.println("List is empty!!");
	    } else {
	    	Node<Product> pre  = null;
	    	
	    	//finh del, pre 
	    	while(del != null){
	    		if(del.info.bcode.trim().equalsIgnoreCase(key.trim())){
	    	        break;
	    	    }
	    		pre = del;
	    		del = del.next;
	    	}
	    	
	    	if(del == null){
	    		System.out.println("Not found");
	    	} else {
	    		// delete head
	    		if(del == list.head){
	    			list.head = list.head.next;
	    	        del.next = null;
	    	        del = null;
	    		} else if(del.next == null){ //delete tail
	    			list.tail = pre;
	    	        pre.next = null;
	    	        del = null;
	    	    } else { //delete node
	    	        pre.next = del.next;
	    	        del.next = null;	    	    
	    	        del = null; 
	    	    }
	    	}
	    }  
	}

	/**
	 * Sorting products in linked list by ID
	 *
	 * @param list The Linked list
	 */
	public void sortByCode(MyList<Product> list) {
		Node<Product> current = list.head, index = null;
		
		String id;
		String tit;
		int quan;
		double pric;
		
		if (list.head == null) {
			return;
		} else {
			while(current != null) {
				index = current.next;
				
				while(index != null) {
					if (current.info.bcode.trim().compareTo(index.info.bcode.trim()) > 0) {
						id = current.info.bcode;
                        current.info.bcode = index.info.bcode;
                        index.info.bcode = id;
                        
                        tit = current.info.title;
                        current.info.title = index.info.title;
                        index.info.title = tit;
                        
                        quan = current.info.quantity;
                        current.info.quantity = index.info.quantity;
                        index.info.quantity = quan;
                        
                        pric = current.info.price;
                        current.info.price = index.info.price;
                        index.info.price = pric;      
					}
					
					index = index.next;
				}
				current = current.next;
			}
		}
		System.out.println("Successfully! ");
		System.out.println();			
	}

	/**
	 * Adding new product to head of Linked List. The info input from keyboard.
	 *
	 * @param list The linked list
	 */
	public void addFirst(MyList<Product> list) {

	}

	/**
	 * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
	 * @param i Input decimal number
	 * @return a integer numbers
	 */
	public int convertToBinary(int i) {
		if (i == 0)
            return 0;
             
        else
         
        return (i % 2 + 10 *
        		convertToBinary(i / 2));
	}

	/**
	 * Deleting the product at position
	 *
	 * @param list The Linked List
	 * @param pos  The position of product to be deleted
	 */
	public void deleteAtPosition(MyList<Product> list, int pos) {

	}
}