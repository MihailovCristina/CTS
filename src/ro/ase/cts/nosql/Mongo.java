package ro.ase.cts.nosql;

public class Mongo {
    String host = "localhost";
    Integer port = 27017;
    String databaseName = "test";
    String collection = "employees";

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getCollection() {
        return collection;
    }
}
