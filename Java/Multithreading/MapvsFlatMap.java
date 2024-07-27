import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap{


    public static void main(String[] args) {

        EkartData ed = new EkartData();

        List<Customer> customers = ed.getAllCustomers();
        List<String> emailList = 
            customers.stream().map(eachCustomer -> eachCustomer.getEmail()).collect(Collectors.toList());
        System.out.println(emailList);

        List<String> phoneList = 
            customers.stream().flatMap(each -> each.getPhone().stream()).collect(Collectors.toList());
        
        System.out.println(phoneList);

        
    }
}