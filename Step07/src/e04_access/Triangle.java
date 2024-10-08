package e04_access;

public class Triangle {
	private int width;
	private int height;

	private Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public double triangleArea() {
		return width * height / 2.0;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + ", triangleArea()=" + triangleArea() + "]";
	}

		
	
}


