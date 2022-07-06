package asm2;

import java.util.Scanner;

public class AS2_Main {
	
	 public static void showMenu() {
		   
		   System.out.println();
		   System.out.println("Choose one of this options:");
		   System.out.println("Product list:");
		   System.out.println("1. Load data from file and display");
		   System.out.println("2. Input & add to the end.");
		   System.out.println("3. Display data");
		   System.out.println("4. Save product list to file.");
		   System.out.println("5. Search by ID");
		   System.out.println("6. Delete by ID");
		   System.out.println("7. Sort by ID.");
		   System.out.println("8. Convert to Binary");
		   System.out.println("9. Load to stack and display");
		   System.out.println("10. Load to queue and display.");
		   System.out.println("0. Exit");
		   System.out.println();
	}
	 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		OperationToProduct op = new OperationToProduct();
		MyList list = new MyList();
		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();
		Product p = new Product();
		
		while(true) {
			showMenu();
			System.out.print("Choice = ");
			choice = sc.nextInt();
			System.out.println();
			
			if (choice == 0) {
				System.out.println("Good bye , have a nice day!");
				break;
			}
			switch(choice) {
				case 1:
					op.getAllItemsFromFile("data.txt", list);
					break;
				case 2:
					op.addLast(list);
					break;
				case 3:
					op.displayAll(list);
					break;
				case 4:					
					op.writeAllItemsToFile("data.txt", list);
					break;
				case 5:
					op.searchByCode(list);
					break;
				case 6:
					op.deleteByCode(list);
					System.out.println("Deleted!");
				    System.out.println();
					break;
				case 7:
					op.sortByCode(list);
					break;
				case 8:
					Node<Product> pro = list.head;
					System.out.println("Quantity = " + pro.info.quantity + " => " + op.convertToBinary(pro.info.quantity));
					break;
				case 9:
					op.getAllItemsFromFile("data.txt", stack);
					op.displayStack(stack);
					break;
				case 10:
					op.getAllItemsFromFile("data.txt", queue);
					op.displayQueue(queue);
					break;
				default:
					System.out.println("**Invalid choice. Try again.**");		
			}
			
		}
	}
}
