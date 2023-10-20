package coding.mentor.demoabstract;

import java.util.Scanner;
 
public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input long egde in cm: ");
		Double longEgde = input.nextDouble();
		System.out.println("Input short egde in cm: ");
		Double shortEgde = input.nextDouble();
		
		Geometry geometry = Geometry.getGeometry(longEgde, shortEgde);
		geometry.perimeter(longEgde, shortEgde);
		geometry.acreage(longEgde, shortEgde);
		
	}
	

}


