import java.io.*;

public class TransientModifier {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);

        System.out.println("Seirializing object!");

        ObjectToSerialize object = new ObjectToSerialize();

        object.setCounter(10);
        object.setState(7);

        stream.writeObject(object);

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        InputStream inputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        ObjectToSerialize objectDeserialized = (ObjectToSerialize) objectInputStream.readObject();
        System.out.println("Deserialized object with counter value: " + objectDeserialized.getCounter());

        assert objectDeserialized.getState() == 0; // Deserialized transient state is default value: 0

        objectInputStream.close();
        stream.close();
    }
}


class ObjectToSerialize implements Serializable {
    private int counter;
    private transient int state; // Will not be serialized during the process

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