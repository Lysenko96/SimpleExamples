package patterns.builder;

public class Pool {

	private int length;
	private int width;
	private boolean dropWater;

	public Pool(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public void onDropWater() {
		dropWater = true;
	}

	public void offDropWater() {
		dropWater = false;
	}

	public boolean isDropWater() {
		return dropWater;
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
		return "Pool [length=" + length + ", width=" + width + ", dropWater=" + dropWater + "]";
	}
	
	
}