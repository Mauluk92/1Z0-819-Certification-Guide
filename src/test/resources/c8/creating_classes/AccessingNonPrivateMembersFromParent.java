class Parent {
    int nonPrivateMember = 1;
    private int privateMember = 2;

    public int getPrivateMember(){return privateMember;}
}

class Child extends Parent {

    public void getParentValues(){
        nonPrivateMember = 3; // Will compile, nonPrivateMember is package-private and not private
        getPrivateMember(); // Will compile since we are accessing its private member through a public method
    }
}