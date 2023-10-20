package coding.mentor.demoabstract;

public class Rectangle extends Geometry {

	@Override
	public Double perimeter(Double longEdge, Double shortEdge) {
		Double perimeter = ( longEdge + shortEdge ) * 2;
		System.out.println("perimeter rectangle is: " + perimeter + " cm");
		return perimeter;
	}

	@Override
	public Double acreage(Double longEdge, Double shortEdge) {
		Double acreage = longEdge * shortEdge;
		System.out.println("acreage rectangle is: " + acreage + " cm2");
		return acreage;
	}

}
