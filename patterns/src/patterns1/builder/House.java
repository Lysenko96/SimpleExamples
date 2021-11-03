package patterns.builder;

public class House {

	private HouseType houseType;
	private Floor floor;
	private Wall wall;
	private Roof roof;
	private Pool pool;

	public House(HouseType houseType, Floor floor, Wall wall, Roof roof, Pool pool) {
		this.houseType = houseType;
		this.floor = floor;
		this.wall = wall;
		this.roof = roof;
		this.pool = pool;
	}
	
	public HouseType getHouseType() {
		return houseType;
	}

	public Floor getFloor() {
		return floor;
	}

	public Wall getWall() {
		return wall;
	}

	public Roof getRoof() {
		return roof;
	}

	public Pool getPool() {
		return pool;
	}

	@Override
	public String toString() {
		return "House [houseType=" + houseType + ", floor=" + floor + ", wall=" + wall + ", roof=" + roof + ", pool="
				+ pool + "]";
	}
}