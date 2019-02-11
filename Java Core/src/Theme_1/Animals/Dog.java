package Theme_1.Animals;

public class Dog extends Animal{

    public Dog(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void getName() {
        System.out.println(this.name);
    }
}
