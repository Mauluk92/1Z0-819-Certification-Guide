import java.io.*;

public class ApplyingSerializableInterface {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);

        System.out.println("Seirializing object!");

        ObjectToSerialize object = new ObjectToSerialize();
        object.setName("Nicola");
        stream.writeObject(object);

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        InputStream inputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        ObjectToSerialize objectDeserialized = (ObjectToSerialize) objectInputStream.readObject();
        System.out.println("Deserialized object with name: " + objectDeserialized.getName());

        objectInputStream.close();
        stream.close();


    }
}


class ObjectToSerialize implements Serializable { // Will serialize since Serializable is only a marker interface
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}