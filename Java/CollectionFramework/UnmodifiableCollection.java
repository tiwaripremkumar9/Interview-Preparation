package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollection {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1,2,3,4,56,7,8,9,10));
        Collection<Integer> UnmodifiableList = 
                            Collections.unmodifiableCollection(aList);
        aList.add(11);  //this will not throw any error
        UnmodifiableList.add(12); // this will throw unsupported operaion exception.
        aList.stream().forEach(System.out::println);
    }
}
