public class NYStylePizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        IngredientFactory ingredientFactory = new NYIngredientFactory();

        if (type.equals("Cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.name = "New York Style Cheese Pizza";
        }

        if(type.equals("Clam")){

            pizza = new ClamPizza(ingredientFactory);
            pizza.name = "New York Style Clam Pizza";
        }

        return pizza;
    }   

}