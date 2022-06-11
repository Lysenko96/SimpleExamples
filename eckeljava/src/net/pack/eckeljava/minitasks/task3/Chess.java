package net.pack.eckeljava.minitasks.task3;

public class Chess {

}

class Game {
    Game(int i){
        System.out.println("Game");
    }

    @Override
    public String toString() {
        return "Game{}";
    }
}

class BoardGame extends Game{

    BoardGame(){
        super(3);
        System.out.println("3");
    }

    BoardGame(int i){
        super(i);
        System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println(new BoardGame());
        System.out.println("----");
        System.out.println(new Game(1));
    }

    @Override
    public String toString() {
        return "BoardGame{}";
    }
}
