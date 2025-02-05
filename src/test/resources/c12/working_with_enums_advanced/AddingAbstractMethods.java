public class AddingAbstractMethods {
    public static void main(String[] args){
        Season winter = Season.WINTER;
        System.out.println("Translation of Winter is: " + winter.getTranslation());
    }
}

enum Season {
    SPRING{
        public String getTranslation(){
            return "Primavera";
        }
    },
    SUMMER{
        public String getTranslation(){
            return "Estate";
        }
    },
    FALL{
        @Override
        public String getTranslation() {
            return "Autunno";
        }
    },
    WINTER{
        @Override
        public String getTranslation() {
            return "Inverno";
        }
    };

    public abstract String getTranslation();
}