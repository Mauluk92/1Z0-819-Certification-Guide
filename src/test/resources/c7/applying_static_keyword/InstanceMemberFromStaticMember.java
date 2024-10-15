public class InstanceMemberFromStaticMember {
    int counterInstanceVariable = 0;

    public static void main(String[] args){
        counterInstanceVariable++; // Won't compile since it is an instance variable referenced from outside an instance member, inside a static method
    }
}