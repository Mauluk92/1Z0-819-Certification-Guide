class CustomException extends Exception {
    public CustomException(String message, Exception ex){
        super(message, ex); // This constructor calls the super constructor providing informations and wrapping another exception
    }
}