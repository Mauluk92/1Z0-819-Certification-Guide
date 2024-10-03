public class PostIncrementDecrementOperators {
    public static void main(String[] args){
        int value = 5;
        System.out.println("The value is " + value);
        System.out.println("Applying the post-increment operator (a++) produces " + value++);
        System.out.println("The value is now " + value);
        System.out.println("Applying the post-decrement operator (a--) produces " + value--);
        System.out.println("The value is now " + value);
    }
}