public class UnreachableCode {
    public static void main(String[] args){
        return;
        System.out.println("Cannot be reached"); // Won't compile, it is not reachable
    }
}