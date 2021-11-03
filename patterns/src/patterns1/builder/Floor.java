package patterns.builder;

public class Floor {

	private int length;
	private int width;
	private boolean warm;

	public Floor(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public HouseBuilder onWarm() {
		warm = true;
		return HouseBuilder.HOUSEBUILDER;
	}

	public HouseBuilder offWarm() {
		warm = false;
		return HouseBuilder.HOUSEBUILDER;
	}

	public boolean isWarm() {
		return warm;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Floor [length=" + length + ", width=" + width + ", warm=" + warm + "]";
	}

}
