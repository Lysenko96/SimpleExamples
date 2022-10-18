package anton.lysenko.info.demopaypal;

public class Order {

    private String name;
    private float subTotal;
    private float tax;
    private float shipping;
    private float total;

    public Order() {
    }

    public Order(String name, String subTotal, String tax, String shipping, String total) {
        this.name = name;
        this.shipping = Float.parseFloat(shipping);
        this.subTotal = Float.parseFloat(subTotal);
        this.tax = Float.parseFloat(tax);
        this.total = Float.parseFloat(total);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShipping() {
        return String.format("%.2f", shipping);
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public String getSubTotal() {
        return  String.format("%.2f", subTotal);
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = Float.parseFloat(subTotal);
    }

    public String getTax() {
        return String.format("%.2f",tax);
    }

    public void setTax(String tax) {
        this.tax = Float.parseFloat(tax);
    }

    public String getTotal() {
        return String.format("%.2f",total);
    }

    public void setTotal(String total) {
        this.total = Float.parseFloat(total);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", shipping=" + shipping +
                ", total=" + total +
                '}';
    }
}
