package info.lysenko.anton.ex10;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.out.println(01);
        //try {
            new Main().init();
//            return;
//        } catch (Exception e){
//            e.printStackTrace();
//            return;
//        } finally {
//            System.out.println("finally");
//        }
    }

    public void init() throws Exception {
        throw new Exception();
    }
}
