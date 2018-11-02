
public class NYStylePizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("Cheese")) {

            pizza = new NYStyleCheesePizza();
        }

        return pizza;
    }

}