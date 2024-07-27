import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartData {
    

    public List getAllCustomers(){
        return Stream.of(
            new Customer(1, "Prem", "prem.tiwari@finastra.com", Arrays.asList("392992", "39298828")),
            new Customer(2, "Punit", "punit.tiwari@finastra.com", Arrays.asList("29921", "4661772")),
            new Customer(3, "Shivu", "shivu.tiwari@finastra.com", Arrays.asList("0928828", "0828822")),
            new Customer(4, "Varun", "varun.tiwari@finastra.com", Arrays.asList("5672718", "78288272"))
        ).collect(Collectors.toList());
    }
}
