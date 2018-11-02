
public class CheesePizza extends Pizza{
    

    IngredientFactory ingredientFactory;
    
    

    public CheesePizza( IngredientFactory ingredientFactory){
       this.ingredientFactory = ingredientFactory;
    }

   @Override
   void prepare() {
       System.out.println("Preparing" + this.name);

       this.dough = ingredientFactory.createDough();
       this.sauce = ingredientFactory.createSauce();
       this.cheese = ingredientFactory.createCheese();
   }
}