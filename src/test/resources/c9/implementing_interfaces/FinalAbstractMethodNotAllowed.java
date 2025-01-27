interface AnInterface {
    final abstract void notAllowed(); // Will not compile since an abstract method cannot be marked as final (Final requires an already implemented method)
}