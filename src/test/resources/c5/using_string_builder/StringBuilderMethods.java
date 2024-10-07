public class StringBuilderMethods {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("---Start---");
        System.out.println("Original string: ");
        System.out.println(sb);
        System.out.println("First we have the method append");
        System.out.println("Append does what is says, appends a string to the end");
        System.out.println(sb.append("---End---"));
        System.out.println("Insert, insert a string between two index: ");
        System.out.println(sb.insert(11, "---Middle---"));
        System.out.println("Replace, replaces a string between two index or an offset");
        System.out.println(sb.replace(0,3, "---BeforeTheStart---"));
        System.out.println("Finally, we have the reverse method, which actually invert the order of the characters");
        System.out.println(sb.reverse());
    }
}