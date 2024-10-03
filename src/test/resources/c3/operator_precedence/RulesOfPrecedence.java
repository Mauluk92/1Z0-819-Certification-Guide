public class RulesOfPrecedence{
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        System.out.println("We have a = " + a + " and b = " + b + " ");
        System.out.println("For example, addition has lower precedence than pre-unary operators");
        System.out.println("Executing a + --b");
        System.out.println("First we decrement b by one, giving " + (b -1));
        System.out.println("Then the value is returned and the addition is executed, giving globally: " + (a + --b));
    }
}