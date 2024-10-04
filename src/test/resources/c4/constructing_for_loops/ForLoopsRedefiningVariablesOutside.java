public class ForLoopsRedefiningVariablesOutside {
    public static void main(String[] args){
        int i = 0;
        for (i = 1; i < 4; i++){// valid, will be compiled and executed
            System.out.println("Loop number: " + i);
        }
    }
}