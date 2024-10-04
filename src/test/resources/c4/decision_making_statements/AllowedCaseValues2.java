public class AllowedCaseValues2 {
    public static void main(String[] args){
        int value = 4;
        switch (value){
            case getInt(): // Will not compile since it is not a constant expression, but a method
        }
    }

    public static int getInt(){
        return 4;
    }
}