import java.util.List;

class ToyFileSystem {
    private final String rootPath = "/"; // Top most directory in the file system
    private List<ToyLocation> listOfLocations; // Each file system has multiple locations within itself
}

class ToyDirectory implements ToyLocation {
    // Represents a directory within the file system
}

class ToyFile implements ToyLocation {
    // Represents a file inside the file system
}

interface ToyLocation {
    // Represents a location inside a file system
}