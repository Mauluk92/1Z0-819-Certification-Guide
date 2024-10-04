public class ForLoopsMultipleInitializations {
    public static void main(String[] args){
        for (int i = 1, c = 1; (i < 3) | (c < 4); i++, c++){ // 3 Loops will be executed
            System.out.println("Loop number " + i);
        }
    }
}