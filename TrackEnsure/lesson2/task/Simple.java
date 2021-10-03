package te.lesson2.task;

public class Simple extends Film {

	private int countDay;

	Simple() {
	}

	Simple(int countDay) {
		this.countDay = countDay;
	}

	@Override
	public int countBonus(int countDay) {
		return countDay;
	}

	@Override
	public int countBonus() {
		return countDay;
	}

	@Override
	public int countMoney(int countDay) {
		return countDay;
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