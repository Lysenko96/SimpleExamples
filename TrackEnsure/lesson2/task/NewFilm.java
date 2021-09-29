package te.lesson2.task;

public class NewFilm extends Film implements Type {

	private int countDay;

	NewFilm() {
	}

	NewFilm(int countDay) {
		this.countDay = countDay;
	}

	@Override
	public int countBonus(int countDay) {
		if (countDay < 3) {
			return countDay * 5;
		}
		return countDay;
	}

	@Override
	public int countMoney(int countDay) {
		return countDay * 3;
	}

	@Override
	public int countBonus() {
		if (countDay < 3) {
			return countDay * 5;
		}
		return countDay;
	}

	@Override
	public int countMoney() {
		return countDay * 3;
	}

	public int getCountDay() {
		return countDay;
	}

	public void setCountDay(int countDay) {
		this.countDay = countDay;
	}
}