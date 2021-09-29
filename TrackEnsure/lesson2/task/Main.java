package te.lesson2.task;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private List<Film> films = new ArrayList<>();

	private int bones;
	private int money;

	public static void main(String[] args) {
		int personalBones = 0;
		int personalMoney = 0;
		boolean f = false;
		Main main = new Main();
		List<Film> films = main.getFilms();
		NewFilm newFilm = new NewFilm(4);
		for (int i = 1; i <= newFilm.getCountDay(); i++) {
			if (i < 3) {
				personalBones = newFilm.countBonus(i);
				personalMoney = newFilm.countMoney(i);
				System.out.println("pB: " + personalBones);
				System.out.println("pM: " + personalMoney);
			}
			if (i >= 3 && !f) {
				Type simple = newFilm.change(new Simple(newFilm.getCountDay() - (i - 1)));
				personalBones += simple.countBonus();
				personalMoney += simple.countMoney();
				System.out.println("pB: " + personalBones);
				System.out.println("pM: " + personalMoney);
				f = true;
			}
		}

		films.add(new Simple(3));
		films.add(new Child(2));
		films.add(new NewFilm(2));
		films.add(new NewFilm(4));
		for (Film movie : films) {
			System.out.println(movie.getClass().getSimpleName() + " bones: " + movie.countBonus());
			System.out.println(movie.getClass().getSimpleName() + " money: " + movie.countMoney());
		}
	}

	public List<Film> getFilms() {
		return films;
	}

	public int getBones() {
		return bones;
	}

	public void setBones(int bones) {
		this.bones = bones;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
