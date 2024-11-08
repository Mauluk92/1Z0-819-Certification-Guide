class Parent {}

class FirstChild extends Parent {}

class SecondChild extends Parent {}

class NestedChild extends FirstChild {}

public class SingleInheritance {
    public static void main(String[] args){
        NestedChild nestedChild = new NestedChild();
        System.out.println("Nested child is child-class of Parent class: " + (nestedChild instanceof Parent));
    }
}