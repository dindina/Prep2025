package patterns;

enum DBProps {
    INSTANCE;

    private String databaseUrl = "jdbc:mysql://localhost:3306/mydb";
    private int maxConnections = 10;

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public int getMaxConnections() {
        return maxConnections;
    }
}
public class Singleton{
    public static void main(String[] args) {
        System.out.println(DBProps.INSTANCE);
        System.out.println(DBProps.INSTANCE.getDatabaseUrl());

    }
}

