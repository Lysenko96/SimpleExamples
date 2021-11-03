package patterns.builder;

public class Main {

	public static void main(String[] args) {
		HouseBuilder builder = new HouseBuilder();
		House house = builder.setHouseType(HouseType.WITHOUT_POOL).setFloor(new Floor(11, 33)).setRoof(new Roof(14, 17))
				.setWall(Wall.CONCRETE).getHouse();
		System.out.println(house);
		house.getFloor().onWarm();
		house.getRoof().onOpenLoft();
		System.out.println(house);
	}
}
