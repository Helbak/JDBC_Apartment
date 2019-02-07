package apartmentsJDBC;

public class MainJDBC {

    public static void main(String[] args) {

        Questions q = new Questions();
        RequestJDBC keyJDBC=new RequestJDBC();
       keyJDBC.searcherDB(q.requester());
    }

}
