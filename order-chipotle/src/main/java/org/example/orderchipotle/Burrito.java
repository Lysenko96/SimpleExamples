package org.example.orderchipotle;

import lombok.EqualsAndHashCode;

import java.util.Objects;

/** ### **Burrito** */
public class Burrito {

    /** **Private member variables** to store the following:
    * `m_size` size of the Burrito (either kids or regular)
    * `m_protein` The protein (chicken, steak, veggie)
    * `m_rice` The type of rice (white, brown, no rice)
    * `m_beans` The type of beans (black, pinto, no beans)
    * Whether it should contain any of the following extras or not
    * (make one true/false variable for each extra)
    * `m_guac` Guacamole
    * `m_tomatillo` Tomatillo salsa
    * `m_sourCream` Sour cream
    * `m_cheese` Cheese
    * `m_lettuce` Lettuce */
    private static final double GUACAMOLE = 2.65;
    private static final double TOMATILLO = 0;
    private static final double SOUR_CREAM = 0.25;
    private static final double CHEESE = 0.50;
    private static final double LETTUCE = 0;
    private  SIZE m_size;
    private PROTEIN m_protein;
    private RICE_TYPE m_rice;
    private BEANS_TYPE m_beans;
    private boolean isGuacamole;
    private boolean isTomatillo;
    private boolean isSourCream;
    private boolean isCheese;
    private boolean isLettuce;
    private double cost;

    /** A **default constructor** that creates a default burrito
     * which is regular-sized
     * with chicken,
     * white rice,
     * black beans,
     * lettuce
     * sour cream. */
    public Burrito() {
        m_size = SIZE.REGULAR;
        m_protein = PROTEIN.CHICKEN;
        m_rice = RICE_TYPE.WHITE;
        m_beans = BEANS_TYPE.BLACK;
        isLettuce = true;
        isSourCream = true;
        cost = calcCost();
    }

    /** A **fully specified, overloaded constructor** that sets all of the member variables as given. */
    public Burrito(SIZE m_size, PROTEIN m_protein, RICE_TYPE m_rice, BEANS_TYPE m_beans,
                   boolean isGuacamole, boolean isTomatillo, boolean isSourCream, boolean isCheese, boolean isLettuce) {
        this.m_size = m_size;
        this.m_protein = m_protein;
        this.m_rice = m_rice;
        this.m_beans = m_beans;
        this.isGuacamole = isGuacamole;
        this.isTomatillo = isTomatillo;
        this.isSourCream = isSourCream;
        this.isCheese = isCheese;
        this.isLettuce = isLettuce;
        cost = calcCost();
    }

    /** A **copy constructor** using the appropriate shallow or deep copies for member variables. */

    public Burrito(Burrito burrito) {
        this.m_size = burrito.getM_size();
        this.m_protein = burrito.getM_protein();
        this.m_rice = burrito.getM_rice();
        this.m_beans = burrito.getM_beans();
        this.isGuacamole = burrito.isGuacamole();
        this.isTomatillo = burrito.isTomatillo();
        this.isSourCream = burrito.isSourCream();
        this.isCheese = burrito.isCheese();
        this.isLettuce = burrito.isLettuce();
        cost = burrito.getCost();
    }

    /** A public method named **calcCost()** that returns a double that is the cost of the Burrito. Burrito cost is determined by:
    The size:
    Kids:    $7.00
    Regular: $9.00
    The protein:
    $0.50 for chicken
    $1.25 for steak
    $.50 for veggie
    The extras:
    $2.65 for Guacamole unless the protein is “veggie” in which case, guacamole is included.
    $0 for Tomatillo salsa
    $0.25 for Sour cream
    $0.50 for Cheese
    $0 for Lettuce
    E.g. the “default” Burrito should come out to $9.75. With the following breakdown:
    Size → regular: $9
    Chicken →       $0.50
    Sour cream →    $0.25
    Lettuce →       $0 */
    public double calcCost() {
        if (isGuacamole && !m_protein.equals(PROTEIN.VEGGIE)) cost += GUACAMOLE;
        if (isTomatillo) cost += TOMATILLO;
        if (isSourCream) cost += SOUR_CREAM;
        if (isCheese) cost += CHEESE;
        if (isLettuce) cost += LETTUCE;
        cost += m_size.getPrice() + m_protein.getPrice();
        return cost;
    }

    /** **Public accessors and mutators** for some of the member variables */
    public void setM_size(SIZE m_size) {
        this.m_size = m_size;
    }

    public void setM_protein(PROTEIN m_protein) {
        this.m_protein = m_protein;
    }

    public void setM_rice(RICE_TYPE m_rice) {
        this.m_rice = m_rice;
    }

    public void setM_beans(BEANS_TYPE m_beans) {
        this.m_beans = m_beans;
    }

    public void setGuacamole(boolean guacamole) {
        isGuacamole = guacamole;
    }

    public void setTomatillo(boolean tomatillo) {
        isTomatillo = tomatillo;
    }

    public void setSourCream(boolean sourCream) {
        isSourCream = sourCream;
    }

    public void setCheese(boolean cheese) {
        isCheese = cheese;
    }

    public void setLettuce(boolean lettuce) {
        isLettuce = lettuce;
    }

    public SIZE getM_size() {
        return m_size;
    }

    public PROTEIN getM_protein() {
        return m_protein;
    }

    public RICE_TYPE getM_rice() {
        return m_rice;
    }

    public BEANS_TYPE getM_beans() {
        return m_beans;
    }

    public boolean isGuacamole() {
        return isGuacamole;
    }

    public boolean isTomatillo() {
        return isTomatillo;
    }

    public boolean isSourCream() {
        return isSourCream;
    }

    public boolean isCheese() {
        return isCheese;
    }

    public boolean isLettuce() {
        return isLettuce;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /** A public method name equals()
     * that returns a Boolean to determine if two Burritos are “equal.”
     *  You can assume two Burritos are equal if they have all the same member variables. */

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Burrito burrito = (Burrito) o;
        return isGuacamole == burrito.isGuacamole && isTomatillo == burrito.isTomatillo && isSourCream == burrito.isSourCream && isCheese == burrito.isCheese && isLettuce == burrito.isLettuce &&
                Double.compare(cost, burrito.cost) == 0 && m_size == burrito.m_size && m_protein == burrito.m_protein && m_rice == burrito.m_rice && m_beans == burrito.m_beans;
    }

    /** hashCode @Override because @Override equals */
    @Override
    public int hashCode() {
        return Objects.hash(m_size, m_protein, m_rice, m_beans, isGuacamole, isTomatillo, isSourCream, isCheese, isLettuce, cost);
    }

    /** A public method named **toString()**
     * that returns a String containing the Burrito’s member variable values and cost as calculated by calcCost(). */

    @Override
    public String toString() {
        return "Burrito{" +
                "m_size=" + m_size +
                ", m_protein=" + m_protein +
                ", m_rice=" + m_rice +
                ", m_beans=" + m_beans +
                ", isGuacamole=" + isGuacamole +
                ", isTomatillo=" + isTomatillo +
                ", isSourCream=" + isSourCream +
                ", isCheese=" + isCheese +
                ", isLettuce=" + isLettuce +
                ", cost=" + cost +
                '}';
    }
}


/** enum for size of Burrito */
enum SIZE {
    KIDS(7.00), REGULAR(9.00);

    private double price;

    SIZE(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

/** enum The protein */
enum PROTEIN {
    CHICKEN(0.50), STEAK(1.25), VEGGIE(0.50);

    private double price;

    PROTEIN(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

/** enum The type of rice */
enum RICE_TYPE {
    WHITE, BROWN, NO_RICE
}

/** enum The type of beans */
enum BEANS_TYPE {
    BLACK, PINTO, NO_BEANS
}

/** Latte extends Burrito */

class Latte extends Burrito {

    public Latte(Burrito burrito) {
        super(burrito);
    }

}
