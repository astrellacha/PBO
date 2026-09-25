import java.util.ArrayList;
public class Bank{
  
 private ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String firstname, String lastname) {
        customers.add(new Customer(firstname, lastname));
    }

    public int getnumofcustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }
}