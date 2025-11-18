import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<DatabaseService> dataBaseServices = new ArrayList<>();
        MySQLDatabaseService mySQL = new MySQLDatabaseService();
        SQLiteDatabaseService SQLite = new SQLiteDatabaseService();
        FakeDatabaseService fake = new FakeDatabaseService();

        dataBaseServices.add(fake);
        dataBaseServices.add(SQLite);
        dataBaseServices.add(mySQL);

        for (DatabaseService databaseService : dataBaseServices) {
            databaseService.connect();
        }
    }
}
