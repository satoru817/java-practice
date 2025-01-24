public class Cat implements Animal{
    private String name;
    public Cat(String name){
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Meow";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
