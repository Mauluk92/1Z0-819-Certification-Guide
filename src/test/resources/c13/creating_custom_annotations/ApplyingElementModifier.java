@interface MarkerAnnotation {
    String required(); // Valid, it is public implicitly
    public String anotherRequired(); // Valid, it is explicitly public
    protected String notValid(); // Invalid, will not compile since it is not public
}