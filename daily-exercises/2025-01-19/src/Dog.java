public class Dog implements Animal{
    private String name;
    public Dog(String name){
        this.name = name;
    }

    @Override
    public String makeSound(){
        return "Bow!";
    }

    @Override
    public String getName(){
        return this.name;
    }
}
