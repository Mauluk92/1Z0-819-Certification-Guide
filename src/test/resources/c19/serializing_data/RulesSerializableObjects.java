import java.io.*;

public class RulesSerializableObjects {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);
        System.out.println("Seirializing object!");

        InvalidSerializableObject object = new InvalidSerializableObject();

        stream.writeObject(object); // Will raise a NotSerializableException!


    }
}



class InvalidSerializableObject {
    // Will raise a NotSerializableException at runtime during serialization
}