package ResponsiPrakPBO;

public class Main {


    public static void main(String[] args) {


        ModelTransactions model = new ModelTransactions();
        ViewTransactions view = new ViewTransactions();
        Controller controller = new Controller(model, view);
    }

}