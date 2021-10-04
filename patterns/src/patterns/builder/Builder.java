package patterns.builder;

public interface Builder {
	
	HouseBuilder setHouseType(HouseType houseType);

	HouseBuilder setFloor(Floor floor);

	HouseBuilder setWall(Wall wall);

	HouseBuilder setRoof(Roof roof);

	HouseBuilder setPool(Pool pool);
}
