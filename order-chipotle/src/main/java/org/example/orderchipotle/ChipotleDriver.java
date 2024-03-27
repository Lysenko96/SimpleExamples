package org.example.orderchipotle;


/**
 * ### **ChipotleDriver**
 * ChipotleDriver class declaration */

public class ChipotleDriver {

    /** main method declaration
     * fill in the blank spots below: */

    public static void main(String[] args) {

        Burrito defaultBurrito = new Burrito();
//        Latte latte = new Latte(defaultBurrito);
//        System.out.println(defaultBurrito.hashCode());
//        System.out.println(latte.hashCode());
//        System.out.println(defaultBurrito.equals(latte));

        /* veggieBurrito: regular, veggie, white rice, pinto beans, guacamole, lettuce, tomatillo */

        Burrito veggieBurrito = new Burrito(SIZE.REGULAR, PROTEIN.VEGGIE, RICE_TYPE.WHITE, BEANS_TYPE.PINTO,
                true, true, false, false, true);

        /* Same as veggieBurrito, use copy constructor */

        Latte veggieBurrito2 = new Latte(veggieBurrito);

        /* Same as defaultBurrito, use copy constructor */

        Latte defaultBurrito2 = new Latte(defaultBurrito);

        /* create an order of THREE Burritos */

        LatteOrder order = new LatteOrder(3);

        /* no need to change anything here  */

        /* add defaultBurrito to the order */
        System.out.println(order.addLatte(defaultBurrito));

        /* add veggieBurrito to the order */
        System.out.println(order.addLatte(veggieBurrito));

        /* add veggieBurrito2 to the order */
        System.out.println(order.addLatte(veggieBurrito2));

        /* add defaultBurrito2 to the order */
        System.out.println(order.addLatte(defaultBurrito2));

        /* are veggieBurrito and veggieBurrito2 the same? should be! */
        System.out.print("are veggieBurrito and veggieBurrito2 the same?");
        System.out.println(veggieBurrito.equals(veggieBurrito2));

        /* are veggieBurrito and defaultBurrito the same? shouldn't be... */
        System.out.print("are veggieBurrito and defaultBurrito the same?");
        System.out.println(veggieBurrito.equals(defaultBurrito));

        System.out.println(order);
    }
}
