public class StringMethods {
    public static void main(String[] args){
        String hello = "Hello";
        System.out.println("The string 'Hello' has 5 characters so its length is: " + hello.length());
        System.out.println("The second character in the same string is: " + hello.charAt(1));
        System.out.println("The first occurrence of the string 'el' is : " + hello.indexOf("el"));
        System.out.println("The substring starting from the second character to the last is: " + hello.substring(1, hello.length() - 1));
        System.out.println("We can get a new lowercase string from the old one: " + hello.toLowerCase());
        System.out.println("We can get a new uppercase String from the old one: " + hello.toUpperCase());
        System.out.println("The string 'Hello' is not equal to the string 'HELLO' " + hello.equals(hello.toUpperCase()));
        System.out.println("But they are equal if using the method equalsIgnoreCase " + hello.equalsIgnoreCase(hello.toUpperCase()));
        System.out.println("The 'Hello' string does start with the substring 'Hel' " + hello.startsWith("Hel"));
        System.out.println("The 'Hello' string does end with the substring 'lo' " + hello.endsWith("lo"));
        System.out.println("We could replace the 'ello' substring with the letter 'i' " + hello.replace("ello", "i"));
        System.out.println("The 'Hello' string contains the substring 'll' " + hello.contains("ll"));
    }
}