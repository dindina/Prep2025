package patterns;

class Burger{
    public String bun;
    public String patty;

    public String cheese;

    public void setBun(String b)
    {
        this.bun = b;
    }
    public void setCheese(String s)
    {
        this.cheese = s;
    }
    public void setPatty(String p)
    {
        this.patty = p;
    }

    @Override
    public String toString(){
        return bun+"-"+cheese+"-"+patty;
    }

}

class BurgerBuilder{
    Burger burger;
    public BurgerBuilder(){
        burger = new Burger();
    }

    public Burger build()
    {
        return burger;
    }

    public BurgerBuilder addBun(String b)
    {
        this.burger.bun= b;
        return this;
    }
    public BurgerBuilder addCheese(String s)
    {
        this.burger.cheese= s;
        return this;
    }
    public BurgerBuilder addPatty(String p)
    {
        this.burger.patty= p;
        return this;
    }






}

public class BuilderPattern {

    public static void main(String[] args) {
        BurgerBuilder bb = new BurgerBuilder();
        //large , chicken, cheese
        Burger burger  = bb.addCheese("cheese")
                .addBun("large")
                .addPatty("chicken")
                .build();
        System.out.println(burger);

        Burger burger1  = bb.addCheese("nocheese")
                .addBun("small")
                .addPatty("beef")
                .build();
        System.out.println(burger1);

    }
}
