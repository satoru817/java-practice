public class Bird implements Animal{
    private String name;

    public Bird(String name){
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Crooky";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
