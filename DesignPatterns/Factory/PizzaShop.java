
public class PizzaShop{

    public static void main(String[] args) {
        PizzaFactory factory = new NYStylePizzaFactory();
        Pizza pizza = factory.orderPizza("Cheese");
    }
}