public class WithoutImportsMustNotCompile {

    public static void main(String[] args){
        Random rd = new Random();
        System.out.println("The following is a random number: " rd.nextInt(5));
    }
}