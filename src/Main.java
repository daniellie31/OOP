import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Martabak> userOrder = new Vector<Martabak>();
	Vector<Martabak> orderList = new Vector<Martabak>();

	String type, adonan, name, size, extraTopping;
	int qty, choice, totalQty;
	double totalPrice;

	private void cls() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	private void menuCustomer(){
		int choose;
		do {
			System.out.println("\n+===================+");
			System.out.println("+     MENU LIST     +");
			System.out.println("+===================+");
			System.out.println("+ 1. Order Item     +");
			System.out.println("+ 2. View Order     +");
			System.out.println("+ 3. Cancel Order   +");
			System.out.println("+ 4. Payment        +");
			System.out.println("+ 5. Exit           +");
			System.out.println("+===================+");

			do {
				try {
					System.out.print("Choose >> ");
					choose = scan.nextInt();
				} catch (Exception e) {
					choose = 0;
				}
				scan.nextLine();
			} while (choose < 1 || choose > 5);
			cls();
			
			switch (choose) {
			case 1:
				orderItem();
				break;
			case 2:
				viewOrder();
				scan.nextLine();
				cls();
				break;
			case 3:
				cancelOrder();
				break;
			case 4:
				makePayment();
				break;
			case 5:
				break;
			}
		} while (choose != 5);
	}

	private void menuAdmin() {
		if(orderList.isEmpty()){
			System.err.println("SORRY TIDAK ADA ORDERAN BRO");
		}
		else{
			System.out.println(" Today's Order :");
			System.out.println("===============================================================================================");
			System.out.println("| No. | Martabak's Name               | Batter   | Size    | ExtraTopping | Qty | Income      |");
			System.out.println("===============================================================================================");
			totalPrice = 0; totalQty = 0;
			for (int i = 0; i < orderList.size(); i++) {
				System.out.printf("| %-3d | %-29s | %-8s | %-7s | %-12s | %-3d | %11.2f |\n", 
						(i + 1), 
						orderList.get(i).getName(), 
						orderList.get(i).getAdonan(), 
						orderList.get(i).getSize(),
						orderList.get(i).getExtraTopping(), 
						orderList.get(i).getQty(),
						(orderList.get(i).getPrice() * orderList.get(i).getQty()));
			
				totalPrice += (orderList.get(i).getPrice() * orderList.get(i).getQty());
				totalQty += orderList.get(i).getQty();
			}
				System.out.println("===============================================================================================");
				System.out.printf("| TOTAL                                                                   | %-3d | %11.2f |\n", totalQty, totalPrice);
				System.out.println("===============================================================================================");
			}
			System.out.println("\nPress any key to continue...");
			scan.nextLine();
			cls();
		}

	public Main() {
		int pilih = 0;
		do{
			System.out.println("\n==========================================");
			System.out.println("| ~ WELCOME TO MARTABAK TERANG BINTANG ~ |");
			System.out.println("==========================================");
			System.out.println("1. Admin                                  ");
			System.out.println("2. Customer                               ");
			System.out.println("3. Exit                                   ");
			System.out.println("==========================================");

			do {
				try {
					System.out.print("Choose >> ");
					pilih = scan.nextInt();
				} catch (Exception e) {
					pilih = 0;
				}
				scan.nextLine();
			} while (pilih < 1 || pilih > 3);
			cls();

			switch(pilih){
				case 1:
					menuAdmin();
					break;
				case 2:
					menuCustomer();
					break;
				case 3:
					System.exit(0);
			}
	}while(pilih != 3);
		
	}

	private void header() {
		System.out.println("=========================================================");
		System.out.println("| No. | Nama Martabak               | Regular | Large   |");
		System.out.println("=========================================================");
	}
	private void orderItem() {
		do {
			System.out.print("Jenis Martabak? [ Klasik | Buah ] : ");
			type = scan.nextLine();
		} while (!type.equals("Klasik") && !type.equals("Buah"));
		cls();

		if (type.equals("Klasik")) {
			System.out.println("                  MARTABAK MENU KLASIK                   ");
			header();
			System.out.println("|  1  | Martabak Coklat             | 25.000  | 32.000  |");
			System.out.println("|  2  | Martabak Keju               | 25.000  | 32.000  |");
			System.out.println("|  3  | Martabak Coklat Keju        | 35.000  | 42.000  |");
			System.out.println("|  4  | Martabak Kacang             | 25.000  | 32.000  |");
			System.out.println("|  5  | Martabak Coklat Keju Kacang | 38.000  | 45.000  |");
			System.out.println("=========================================================");
		} else {
			System.out.println("                   MARTABAK MENU BUAH                    ");
			header();
			System.out.println("|  1  | Martabak Kismis             | 32.000  | 39.000  |");
			System.out.println("|  2  | Martabak Pisang             | 32.000  | 39.000  |");
			System.out.println("|  3  | Martabak Durian             | 35.000  | 42.000  |");
			System.out.println("|  4  | Martabak Srikaya            | 36.000  | 43.000  |");
			System.out.println("|  5  | Martabak Jagung Keju        | 37.000  | 44.000  |");
			System.out.println("=========================================================");
		}

		do {
			try {
				System.out.print("\nWhich Martabak Would You Like to Order? [ 1 - 5 ] : ");
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = 0;
			}
			scan.nextLine();
		} while (choice < 1 || choice > 5);
		
		do {
			System.out.print("\nChoose the Batter? [ Original | Pandan ] : ");
			adonan = scan.nextLine();
		} while (!adonan.equals("Original") && !adonan.equals("Pandan"));

		do {
			System.out.print("\nMartabak Size? [ Regular | Large ] : ");
			size = scan.nextLine();
		} while (!size.equals("Regular") && !size.equals("Large"));

		do {
			System.out.print("\nExtra Topping? +5K [ Yes | No ] : ");
			extraTopping = scan.nextLine();
		} while (!extraTopping.equals("Yes") && !extraTopping.equals("No"));

		do {
			try {
				System.out.print("\nHow Many Servings? : ");
				qty = scan.nextInt();
			} catch (Exception e) {
				qty = 0;
			}
			scan.nextLine();
		} while (qty < 1);

		if (type.equals("Klasik")) {
			Martabak mk = new MartabakKlasik(type, adonan, size, extraTopping, qty, choice);
			// orderList.add(mk);
			userOrder.add(mk);
		} else {
			Martabak mb = new MartabakBuah(type, adonan, size, extraTopping, qty, choice);
			// orderList.add(mb);
			userOrder.add(mb);
		}

		System.out.println("\nYour order successfully added to the cart!! ~");
		scan.nextLine();
		cls();
	}

	private void viewOrder() {
		if (userOrder.isEmpty()) {
			System.err.println("SORRY TIDAK ADA ORDERAN BRO");
		} else {
			System.out.println(" YOUR ORDER :");
			System.out.println("=============================================================================================");
			System.out.println("| No. | Nama Martabak               | Adonan   | Size    | ExtraTopping | Qty | Price       |");
			System.out.println("=============================================================================================");
			totalPrice = 0; totalQty = 0;
			for (int i = 0; i < userOrder.size(); i++) {
				System.out.printf("| %-3d | %-27s | %-8s | %-7s | %-12s | %-3d | %11.2f |\n", 
						(i + 1), 
						userOrder.get(i).getName(), 
						userOrder.get(i).getAdonan(), 
						userOrder.get(i).getSize(),
						userOrder.get(i).getExtraTopping(), 
						userOrder.get(i).getQty(),
						(userOrder.get(i).getPrice() * userOrder.get(i).getQty()));
				totalPrice += (userOrder.get(i).getPrice() * userOrder.get(i).getQty());
				totalQty += userOrder.get(i).getQty();
			}
			System.out.println("=============================================================================================");
			System.out.printf("| TOTAL                                                                 | %-3d | %11.2f |\n", totalQty, totalPrice);
			System.out.println("=============================================================================================");
		}
	}

	private void cancelOrder() {
		int choose;
		if (userOrder.isEmpty()) {
			System.err.println("SORRY TIDAK ADA ORDERAN BRO");
		} else {
			viewOrder();
			do {
				try {
					System.out.print("Which one do you want to cancel? [ 1 - " + userOrder.size() + " ]: ");
					choose = scan.nextInt();
				} catch (Exception e) {
					choose = 0;
				}
				scan.nextLine();
			} while (choose < 1 || choose > userOrder.size());

			userOrder.remove(choose - 1);
			System.out.println("\nYour order has been canceled!! ~");
		}
		scan.nextLine();
		cls();
	}

	private void makePayment() {
		if (userOrder.isEmpty()) {
			System.err.println("SORRY TIDAK ADA ORDERAN BRO");
		} else {
			double cash;
			
			viewOrder();

			do {
				System.out.print("Cash : Rp ");
				cash = scan.nextDouble();
				scan.nextLine();
			} while (cash < totalPrice);

			if (cash > totalPrice) {
				System.out.printf("Change : Rp %.2f\n", (cash - totalPrice));
			}

			for (Martabak martabak : userOrder) {
				orderList.add(martabak);
			}
			
			userOrder.clear();
			System.out.println("ENJOY YOUR FOOD!! ~");
		}
		scan.nextLine();
		cls();
	}

	public static void main(String[] args) {
		new Main();
	}

}
