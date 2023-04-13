// MÉTODOS ABSTRATOS
/*	São métodos que não possuem implementação.
	Métodos precisam ser abstratos quando a classe é genérica demais
	para conter sua implementação.

	Se uma classe possuir pelo menos um método abstrato,
	então esta classe também é abstrata.
*/
// EXEMPLO
/*
Fazer um programa para ler os dados de N figuras (N fornecido pelo usuário),
e depois mostrar as áreas destas figuras na mesma ordem em que foram digitadas.
*/

package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import entities.enums.Color;
import entities.Shape;
import entities.Rectangle;
import entities.Circle;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();

		for (int i=1; i<n; i++) {
			Sytem.out.println("Shape #" + i + " data:")
			System.out.print("Rectangle or Circle (r/c)?");
			char ch = sc.next().chatAt(0);

			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());

			if (ch == 'r') {
				System.out.print("Width:" );
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				list.add(new Rectangle(color, width, height));

			} 
			else {
				System.out.print("Radius:" );
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius));
			}
		}

		System.out.println();
		System.out.println("SHAPE AREAS: ");
		for (Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}

		sc.close();
	}
}


// enum
package entites.enums;

public enum Color {
	BLACK,
	BLUE,
	RED;
}

// shape
package entites;

import entities.enums.Color;

public abstract class Shape {

	private Color color;

	public Shape() {

	}

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	// método abstrato
	public abstract double area();
}

// rectangle
package entites;

public abstract class Rectangle extends Shape {

	private Double width;
	private Double height;

	public Rectangle() {
		super();
	}

	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public abstract double area() {
		return width * height;
	}
}

// circle
package entites;

public abstract class Circle extends Shape {

	private Double radius;

	public Circle() {
		super();
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}


	@Override
	public abstract double area() {
		return Math.PI * radius * radius;
	}

}