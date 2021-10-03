package te.lesson2.task;

public class Child extends Film {

	private int countDay;

	Child() {
	}

	Child(int countDay) {
		this.countDay = countDay;
	}

	@Override
	public int countBonus(int countDay) {
		return countDay * 2;
	}

	@Override
	public int countMoney(int countDay) {
		return countDay;
	}

	@Override
	public int countBonus() {
		return countDay * 2;
	}

	@Override
	public int countMoney() {
		return countDay;
	}

	public int getCountDay() {
		return countDay;
	}

	public void setCountDay(int countDay) {
		this.countDay = countDay;
	}
}