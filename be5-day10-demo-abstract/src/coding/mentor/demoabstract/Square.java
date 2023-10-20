package coding.mentor.demoabstract;

public class Square extends Geometry{

	@Override
	public Double perimeter(Double longEdge, Double shortEdge) {
		Double perimeter = 4 * longEdge;
		System.out.println("perimeter square is: " + perimeter + " cm");
		return perimeter;
	}

	@Override
	public Double acreage(Double longEdge, Double shortEdge) {
		Double acreage = Math.pow(longEdge,2);
		Double rounding = (double) Math.round(acreage * 1000) / 1000;
		System.out.println("acreage square is: " + rounding + " cm2");
		return rounding;
	}

}
