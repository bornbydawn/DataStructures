

class NYIngedientFactory implements IngredientFactory{
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
    @Override
    public Clams createClams() {
        return new FreshClams();
    }

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicesPepperoni();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Mushroom(), new RedPepper()};
        return veggies;
    }


}

class ReggianoCheese{};
class FreshClams{};
class ThinCrustDough{};
class SlicesPepperoni{};
class MarinaraSauce{};
class Mushroom{};
class RedPepper{};