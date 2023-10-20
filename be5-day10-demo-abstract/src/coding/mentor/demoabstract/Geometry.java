package coding.mentor.demoabstract;

public abstract class Geometry {
	static final int RECTANGLE = 1;
	static final int SQUARE = 2;

	public abstract Double perimeter(Double longEdge, Double shortEdge);

	public abstract Double acreage(Double longEdge, Double shortEdge);

	public static  Geometry getGeometry(Double longEgde, Double shortEgde ) {
		int getGeometry = RECTANGLE;
		if(longEgde.equals(shortEgde)) {
			getGeometry = SQUARE;
		}
		switch (getGeometry) {
		case RECTANGLE:
			return new Rectangle();
		case SQUARE:
			return new Square();
		}
		return null;
	}
}
