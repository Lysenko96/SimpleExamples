Task size:
Small

Type of service:
Programming

Discipline:
Computer science

Programming language:
Java

Paper instructions:
In this assignment, you will build 2 classes to represent objects that would be used in a Chipotle ordering system. You will then demonstrate the use of these classes in a Driver class which will create a few orders for Burritos.
In this assignment, you will get your first exposure to using abstraction and encapsulation to design objects and use them to accomplish a goal. We will continue to build on the foundations used in this assignment for the rest of the semester.

## **Designing a Solution**

This assignment is relatively straightforward. Your assignment should consist of the following classes:

### **Burrito**

This class stores information about a single Burrito. It should contain the following:

- **Private member variables** to store the following:
- `m_size` size of the Burrito (either kids or regular)
- `m_protein` The protein (chicken, steak, veggie)
- `m_rice` The type of rice (white, brown, no rice)
- `m_beans` The type of beans (black, pinto, no beans)
- Whether it should contain any of the following extras or not (make one true/false variable for each extra)
- `m_guac` Guacamole
- `m_tomatillo` Tomatillo salsa
- `m_sourCream` Sour cream
- `m_cheese` Cheese
- `m_lettuce` Lettuce
- A **default constructor** that creates a default burrito which is regular-sized with chicken, white rice, black beans, lettuce and sour cream.
- A **fully specified, overloaded constructor** that sets all of the member variables as given.
- A **copy constructor** using the appropriate shallow or deep copies for member variables.
- **Public accessors and mutators** for some of the member variables
- A public method named **calcCost()** that returns a double that is the cost of the Burrito. Burrito cost is determined by:
- The size:
- Kids: $7.00
- Regular: $9.00
-- The protein:
- +$0.50 for chicken
- + $1.25 for steak
- + $.50 for veggie
- The extras:
- +$2.65 for Guacamole unless the protein is “veggie” in which case, guacamole is included.
- +$0 for Tomatillo salsa
- +$0.25 for Sour cream
- +$0.50 for Cheese
- +$0 for Lettuce
- E.g. the “default” Burrito should come out to $9.75. With the following breakdown:
- Size → regular: + $9
- Chicken → + $0.50
- Sour cream → +$0.25
- Lettuce → + $0
- A public method named **toString()** that returns a String containing the Burrito’s member variable values and cost as calculated by
calcCost().
- A public method name equals() that returns a Boolean to determine if two Burritos are “equal.” You can assume two Burritos are equal if they have all the same member variables.
- Make sure to test this class before moving on. For example, a default Burrito should cost a total of $9.75.

### **BurritoOrder**

This class stores information about an order of potentially multiple Burritos. It should contain the following:

- A private member variable, `m_order`, which is an array of base type Burrito. Each element saved in this array should be a Burrito object.
- A private member variable, `m_numBurritos`, which tells how many Burritos are currently in the order
- A private member variable, `m_numBurritosMax`, which tells how many Burritos there will be in the order total (size of the m_order array)
- Default constructor which defaults to an order of a single default Burrito.
- Overloaded constructor that takes an integer parameter that tells how many Burritos will be added to the order and initializes the order instance variable to an empty Burrito array of that size.
- `public int addBurrito(Burrito b)`— add the parameter Burrito object to the BurritoOrder’s m_order member variable. Given that the order is saved as a Burrito array, remember that once the order is full you will not be able to add more Burrito! **Implement this method to indicate that adding the additional Burrito was unsuccessful. If the addition was successful the method should return a 1 and if unsuccessful (array is full) return -1.**
- `public double calcTotal()` — returns the total cost of the order by adding up the prices of each Burrito in the order (hint: use the calcCost method from the Burrito class for each Burrito object in the m_order array)
- `public String toString()`— returns a String representing this order, so that the employee at Chipotle can repeat the order back to you before sending it to be prepared. This method should begin by calling the calcTotal() method so that the total price of the order can be displayed at the top. Then, it should list all of the details of all Burritos in the order.

### **ChipotleDriver**

This class will serve as a driver class to your Burrito and BurritoOrder classes. It should therefore contain only a main method and be the only class that contains one. Below is some code illustrating the methods of Burrito and BurritoOrder. **Note that first few lines are incomplete. Fill them in and include this code in the main method.** (I have attached the screenshot of the code that needs to be included and filled in for the main method)

Note that all of your functionality should be implemented in your class methods, and NOT in *main*. The only purpose of *main* for this program is to instantiate instances (create objects) of your class and invoke methods specified in the class. ***Comments are required in Javadoc format.***

So, your deliverables are 3 .java files (Burrito.java, BurritoOrder.java, ChipotleDriver.java) and a README.txt, the README should include the usual required information.

Comments from Customer
This task should be completed with the original code/solutions. Please make sure you do not use any open source solutions.
This task should be completed with well-commented code. Please comment all methods and functions.