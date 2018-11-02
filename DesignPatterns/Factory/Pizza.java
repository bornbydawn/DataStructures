
import java.util.*;

public abstract class Pizza{
    String name;
    String dough;
    String sauce;

    List toppings = new ArrayList<String>();
    
    void prepare(){

        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");

        toppings.forEach(t -> System.out.print(", " +t));
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
}