package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Product #" +i + "data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			
			if (type == 'c') {
				Product product = new Product(name, price);
				list.add(product);
			}
			else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				UsedProduct usedProduct = new UsedProduct(name, price, date);
				list.add(usedProduct);
			}
			else {
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				ImportedProduct importedProduct = new ImportedProduct(name, price, customFee);
				list.add(importedProduct);
			}
			System.out.println();
			System.out.println("PRICE TAGS:");
			for (Product prod : list) {
				System.out.println(prod.priceTag());
			}
		}
		sc.close();
	}
	
}
