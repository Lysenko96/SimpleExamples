package LessonsToInterview.OOPTest;
import LessonsToInterview.OOPTest.D;
public class NameGames extends GamesCompany {

    String showNameGames(String nameGames){
        return nameGames;
    }

    @Override
    void showNameLauncher() {
        setGameTitle("Steam");
        System.out.println(getGameTitle());
    }
}
