package Spring4.tx.annotation;

import java.util.List;

public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
