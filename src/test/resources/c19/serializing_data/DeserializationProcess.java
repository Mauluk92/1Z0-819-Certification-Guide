import java.io.*;

public class DeserializationProcess {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);

        System.out.println("Serializing object!");

        ObjectToSerialize object = new ObjectToSerialize();
        object.setCounter(7);
        stream.writeObject(object);

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        InputStream inputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        System.out.println("Deserialization started!");

        ObjectToSerialize objectDeserialized = (ObjectToSerialize) objectInputStream.readObject();
        System.out.println("Deserialized object with counter: " + objectDeserialized.getCounter());
        System.out.println("Deserialized object transient has value: " + objectDeserialized.getState()); // Will print 0!
        objectInputStream.close();
        stream.close();


    }
}

class ObjectToSerialize extends ParentClassNonSerializable implements Serializable {
    private int counter;
    private transient int state; // Will not be serialized during the process

    {
        state = 9; // Will not be serialized
        System.out.println("Inside initializer block!"); // Will not be invoked during deserialization!
    }

    public ObjectToSerialize(){
        // Invoked upon creation but during deserialization
        System.out.println("Inside Serializable Class!");
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

class ParentClassNonSerializable {
    public ParentClassNonSerializable() {
        // Invoked during deserialization!
        System.out.println("Inside Non Deserializable Class!");
    }
}