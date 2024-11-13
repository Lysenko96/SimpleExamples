package pos.websocket;

import models.db.ArticlesCheckOpen;
import models.db.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pos.common.AbstractModuleCore;
import pos.dynamic.DynamicModuleImpl;

@SpringBootApplication
public class GuiWebSocket extends AbstractModuleCore {

    private static DynamicModuleImpl db;
    private static DynamicModuleImpl logic;
    private static DynamicModuleImpl auth;
    private static DynamicModuleImpl gui;

    public void initModule() {
        main(new String[]{});
        db = (DynamicModuleImpl) core().getModule("DB");
        logic = (DynamicModuleImpl) core().getModule("POSLOGIC");
        auth = (DynamicModuleImpl) core().getModule("AUTH");
        gui = (DynamicModuleImpl) core().getModule("GUI");
        System.out.println("#########DBINNER");
        System.out.println(db);
        System.out.println("#########LOGIC");
        System.out.println(logic);
        System.out.println("#########AUTH");
        System.out.println(auth);
        System.out.println("###########GUI");
        System.out.println(gui);
    }

    public void checkCardNumber(String cardnumber, String login, String password) {
        if (cardnumber == null) {
            checkMethodExists(gui, "setUserNameLogin");
            gui.call("setUserNameLogin", login);
            checkMethodExists(gui, "setPasswordLogin");
            gui.call("setPasswordLogin", password);
            checkMethodExists(auth, "checkCardNumber");
            auth.call("checkCardNumber");
        } else {
            checkMethodExists(auth, "checkCardNumber");
            auth.call("checkCardNumber", cardnumber);
        }

    }

    public void confirmAge(int customerAge) {
        checkMethodExists(gui, "getInputNumber");
        gui.call("getInputNumber", String.valueOf(customerAge), "Введіть вік покупця");
    }

    public User checkUserReaderData(String cardnumber) {
        checkMethodExists(db, "checkUserReaderData");
        return (User) db.call("checkUserReaderData", cardnumber);
    }

    public User checkUserData(String login, String password) {
        checkMethodExists(db, "checkUserData");
        return (User) db.call("checkUserData", login, password);
    }

    public ArticlesCheckOpen searchArticle(String eventData) {
        checkMethodExists(logic, "searchArticleSuper");
        return (ArticlesCheckOpen) logic.call("searchArticleSuper", eventData);
    }

    void checkMethodExists(DynamicModuleImpl module, String methodName) {
        if (module == null) {
            System.out.println("###Module == null");
        } else {
            System.out.println("###module.getModuleName()");
            System.out.println(module.getModuleName());
            if (!module.isMethodExist(methodName)) System.out.println("###isMethodNotExist");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(GuiWebSocket.class);
    }
}