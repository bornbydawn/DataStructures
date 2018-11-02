
public class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza(){
        this.name = "New York Style Cheese Pizza";
        this.sauce = "Marinara Sauce";
        this.dough = "Thin Crust Dough";

        this.toppings.add("Grated Reggiano Cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting New York Style");
    }
}