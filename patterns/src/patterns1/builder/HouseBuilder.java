package patterns.builder;

public class HouseBuilder implements Builder {

	private HouseType houseType;
	private Floor floor;
	private Wall wall;
	private Roof roof;
	private Pool pool;
	public static final HouseBuilder HOUSEBUILDER = new HouseBuilder();

	@Override
	public HouseBuilder setHouseType(HouseType houseType) {
		this.houseType = houseType;
		return this;
	}

	@Override
	public HouseBuilder setFloor(Floor floor) {
		this.floor = floor;
		return this;
	}

	@Override
	public HouseBuilder setWall(Wall wall) {
		this.wall = wall;
		return this;
	}

	@Override
	public HouseBuilder setRoof(Roof roof) {
		this.roof = roof;
		return this;
	}

	@Override
	public HouseBuilder setPool(Pool pool) {
		this.pool = pool;
		return this;
	}

	public House getHouse() {
		return new House(houseType, floor, wall, roof, pool);
	}

}
