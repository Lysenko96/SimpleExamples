package LessonsToInterview.OOPTest;

 class GamesCompany {

    private String gameTitle;

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
        String showNameCompany (String nameCompany){
            return nameCompany;
        }
        void showNameLauncher () {
        setGameTitle("Battle.net");
            System.out.println(getGameTitle());
        }
}
