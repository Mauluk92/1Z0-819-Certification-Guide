public class SwitchStatement {
    public static void main(String[] args) {
        int value = 5;

        switch (value) { // switch start statement with mandatory braces
            case 5: // case statement. This one will be executed
                System.out.println("Executed first branch");
                break; // transfer control outside switch statement
            case 6:
                break; // will not be executed
            case 7:
                break; // will not be executed
            default: //Optional default branch. Can be placed in any order
        }
    }
}