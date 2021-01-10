package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		OrderItem orderItem = null;

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine();
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus),
				new Client(clientName, clientEmail, birthDate));
		System.out.print("How many items to this order ? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter " + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productname = sc.nextLine();
			System.out.print("Product price: ");
			double productprice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			orderItem = new OrderItem(productQuantity, productprice, new Product(productname, productprice));
			order.addItem(orderItem);

		}

		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		;

		System.out.println("ORDER items: ");

		order.toString2();

		System.out.print("Total price: $" + String.format("%.2f%n", order.total()));
		sc.close();
	}

}
