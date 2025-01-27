interface AnInterfaceWithAllowedModifiers {
    private void privateMethod(){}
    static void staticMethod(){}
    default void defaultMethod(){}
    private static void privateStaticMethod(){}
}