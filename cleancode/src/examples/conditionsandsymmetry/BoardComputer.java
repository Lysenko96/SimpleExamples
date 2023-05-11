package examples.conditionsandsymmetry;

import java.util.Objects;

public class BoardComputer {

    private CruiseControl cruiseControl;

    void authorize(User user) {
        Objects.requireNonNull(user);
        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return; // end method
        }
        if (user.isAstronaut()) cruiseControl.grantAccess(user);
        else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }

}

class CruiseControl {

    public void grantAccess(User user) {
        if (user.isAstronaut()) System.out.println(user + " get access");
        else if (user.isUnknown()) System.out.println(user + " no access");
    }

    public void grantAdminAccess(User user) {
        if (user.isCommander()) System.out.println(user + " get admin access");
        else grantAccess(user);
    }

    public void logUnauthorizedAccessAttempt() {

    }

}

class User {

    private boolean isUnknown;
    private boolean isAstronaut;
    private boolean isCommander;

    public User() {
    }

    public boolean isUnknown() {
        return isUnknown;
    }

    public void setUnknown(boolean unknown) {
        isUnknown = unknown;
    }

    public boolean isAstronaut() {
        return isAstronaut;
    }

    public void setAstronaut(boolean astronaut) {
        isAstronaut = astronaut;
    }

    public boolean isCommander() {
        return isCommander;
    }

    public void setCommander(boolean commander) {
        isCommander = commander;
    }
}
