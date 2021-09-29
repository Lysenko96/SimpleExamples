package te.lesson2.task;

public class Film implements Type {

	private Type type;
	private int countDay;

	public Film() {
	}

	public Film(Type type) {
		this.type = type;
	}

	@Override
	public Type change(Type type) {
		return type;
	}

	public Film(Type type, int countDay) {
		this.type = type;
		this.countDay = countDay;
	}

	@Override
	public int countBonus() {
		return type.countBonus(countDay);
	}

	@Override
	public int countMoney() {
		return type.countMoney(countDay);
	}

	@Override
	public int countBonus(int countDay) {
		return type.countBonus(countDay);
	}

	@Override
	public int countMoney(int countDay) {
		return type.countMoney(countDay);
	}

}
