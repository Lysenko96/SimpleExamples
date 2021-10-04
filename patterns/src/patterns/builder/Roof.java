package patterns.builder;

public class Roof {

	private int length;
	private int width;
	private boolean openLoft;

	public Roof(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public HouseBuilder onOpenLoft() {
		openLoft = true;
		return HouseBuilder.HOUSEBUILDER;
	}

	public HouseBuilder offOpenLoft() {
		openLoft = false;
		return HouseBuilder.HOUSEBUILDER;
	}

	public boolean isOpenLoft() {
		return openLoft;
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
		return "Roof [length=" + length + ", width=" + width + ", openLoft=" + openLoft + "]";
	}

}
