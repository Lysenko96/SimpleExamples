package org.example.orderchipotle;

/** ### **BurritoOrder**  */
public class BurritoOrder {

    /**
    A private member variable, `m_order`, which is an array of base type Burrito.
    Each element saved in this array should be a Burrito object.
    A private member variable, `m_numBurritos`, which tells
    how many Burritos are currently in the order
    A private member variable, `m_numBurritosMax`, which tells
    how many Burritos there will be in the order total (size of the m_order array)
    Default constructor which defaults to an order of a single default Burrito.
    */

    private Burrito[] m_order;
    private int m_numBurritos;
    private int m_numBurritosMax;

    /**
     * - Default constructor which defaults to an order of a single default Burrito.
     */
    public BurritoOrder() {
        m_numBurritosMax++;
        m_numBurritos++;
        m_order = new Burrito[] {new Burrito()};
    }

    /**
     * Overloaded constructor that takes an integer parameter that tells
     * how many Burritos will be added to the order and initializes the order instance variable to an empty Burrito array of that size.
     * @param m_numBurritosMax
     */

    public BurritoOrder(int m_numBurritosMax) {
        this.m_numBurritosMax = m_numBurritosMax;
        m_order = new Burrito[m_numBurritosMax];
    }

    /**
     * public int addBurrito(Burrito b)`— add the parameter Burrito object to the BurritoOrder’s m_order member variable.
     * Given that the order is saved as a Burrito array, remember that once the order is full you will not be able to add more Burrito!
     * **Implement this method to indicate that adding the additional Burrito was unsuccessful.
     * If the addition was successful the method should return a 1 and if unsuccessful (array is full) return -1.**
     * @param b
     * @return 1 or -1
     */
    public int addBurrito(Burrito b) {
        if(m_numBurritos < m_numBurritosMax) {
            m_order[m_numBurritos] = b;
            m_numBurritos++;
            return 1;
        }
        return -1;
    }

    /**
     * public double calcTotal()` — returns the total cost of the order by adding up the prices of each Burrito in the order
     * (hint: use the calcCost method from the Burrito class for each Burrito object in the m_order array)
     * @return double
     */

    public double calcTotal(){
        double total = 0;
        for(Burrito b : m_order) {
            if(b!=null) total+=b.getCost();
        }
        return total;
    }

    /**
     * public String toString()`— returns a String representing this order,
     * so that the employee at Chipotle can repeat the order back to you before sending it to be prepared.
     * This method should begin by calling the calcTotal() method so that the total price of the order can be displayed at the top.
     * Then, it should list all of the details of all Burritos in the order.
     * @return String
     */

    @Override
    public String toString() {
        StringBuilder burritosInfo = new StringBuilder(System.lineSeparator());
        for(Burrito b : m_order) {
            burritosInfo.append(b).append(System.lineSeparator());
        }
        return "BurritoOrder{" +
                "calcTotal=" + calcTotal() + " " +
                "m_order=" + burritosInfo +
                '}';
    }
}

class LatteOrder extends BurritoOrder {

    public LatteOrder(int m_numBurritosMax) {
        super(m_numBurritosMax);
    }

    public int addLatte(Burrito b) {
        return super.addBurrito(b);
    }
}
