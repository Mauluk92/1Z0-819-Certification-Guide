import java.util.Arrays;

public class CreatingArrays{
    public static void main(String[] args){
        int[] numbers = new int[3]; // Creates an array of three integers
        int[] yetOtherNumbers = new int[]{0, 1, 2} ;// Create an another array of three integers, this time specifying the elements
        int[] anonymousArray = {0, 1, 2}; // same thing, but this time with anonymous array

        for(int i=0; i < numbers.length; i++){
            numbers[i] = i; // this way you can access the element inside an array and assign them a value
        }

        System.out.println("Standard way of creating an array: " + Arrays.toString(numbers));
        System.out.println("Way of creating arrays while specifying its elements " + Arrays.toString(yetOtherNumbers));
        System.out.println("Anonymous arrays: " + Arrays.toString(anonymousArray));
    }
}