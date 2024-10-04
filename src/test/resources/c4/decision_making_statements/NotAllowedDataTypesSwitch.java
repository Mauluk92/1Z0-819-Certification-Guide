import java.util.Date;

public class NotAllowedDataTypesSwitch {
    public static void main(String[] args){
        /*
         Only primitive data types, wrappers and String are allowed in switch statement
         */
        Date dateObjNotAllowed = new Date();
        switch (dateObjNotAllowed){
            // Will not compile
        }
    }
}