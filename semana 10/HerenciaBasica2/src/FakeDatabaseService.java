public class FakeDatabaseService extends DatabaseService {

    public FakeDatabaseService(){

    }

    @Override
    public void connect() {
        // TODO Auto-generated method stub
        super.connect();
        System.out.println("Soy una BBDD tipo Fake");
    }

}
