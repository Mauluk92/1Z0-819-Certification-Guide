class ParentClass {
    public void noExceptionThrower() {}
}

class InvalidChildClass extends ParentClass {
    public void noExceptionThrower() throws Exception { // Will not compile since the parent method does not throw any exception

    }
}