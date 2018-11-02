abstract class Beverage{

    protected String description;

    protected abstract Double cost();
}

abstract class CondimentDecorator extends Beverage{

    private Beverage beverage;

    public void setBeverage(Beverage beverage){
        this.beverage = beverage;
    }

    public Beverage getBeverage(){
        return this.beverage;
    }


    protected abstract String getDescription();
}

class Espresso extends Beverage{

    public Espresso(){
        this.description = "Espresso";
    }

    public String getDescription(){
        return this.description;
    }

    public Double cost(){
        return 0.99;
    }
}

class Mocha extends CondimentDecorator{
    
    public Mocha(Beverage beverage){
        this.setBeverage(beverage);
    }

    @Override
    protected String getDescription() {
        return this.description + ", Mocha";
    }

    @Override
    public Double cost(){
        return this.getBeverage().cost() + 0.20;
    }
}

class CoffeeShop{

    public static void main(String[] args) {
        Beverage espresso = new Espresso();

        Beverage espressoWithMocha = new Mocha(espresso);

        System.out.println(espressoWithMocha.cost());
    }
}


