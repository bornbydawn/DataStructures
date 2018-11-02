
import java.util.*;

public abstract class Pizza{
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    List toppings = new ArrayList<String>();
    
    //this class was alreadt implemented in factory pattern
    abstract void prepare(){
    }

    void bake(){
        System.out.println("Baking");
    }

    void cut(){
        System.out.println("Cutting into diagonal slices");
    }

    void box(){
        System.out.println("Boxing");
    }

    public String toString(){
        System.out.println("Pizza being made");
    }
}