public class UnrelatedInstanceOfOperatorApplication {
    public static void main(String[] args){
        Fish fish = new Fish();
        boolean value = fish instanceof Mammal; // Will not compile since Fish and Mammal are not related
    }
}

class Mammal{}

class Fish{}