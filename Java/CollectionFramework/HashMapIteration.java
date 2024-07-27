package CollectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapIteration {

    /*
     * using entrySet()
     */

    // public static void main(String[] args) {
    //     Map<String, String> map = new HashMap<>();
    //     map.put("A", "Angular");
    //     map.put("J", "Java");
    //     map.put("P", "Python");
    //     map.put("H", "Hibernate");

    //     for (Map.Entry<String, String> each : map.entrySet()) {
    //         System.out.println(each.getKey() +" : "+each.getValue());
            
    //     }

    // }


    /*
     * using lambda expression
     */

    // public static void main(String[] args) {
    //     Map<String, String> langMap = new HashMap<>();
    //     langMap.put("A", "Angular");
    //     langMap.put("J", "Java");
    //     langMap.put("P", "Python");
    //     langMap.put("H", "Hibernate");

    //     langMap.forEach((a,b) -> System.out.println(a+" : "+b));        
    // }

    /*
     * using Stream API
     */
    
     public static void main(String[] args) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("A", "Angular");
        langMap.put("J", "Java");
        langMap.put("P", "Python");
        langMap.put("H", "Hibernate");

        langMap.entrySet().stream().forEach(each -> 
            System.out.println(each.getKey() +" : "+each.getValue()));     
    }
}
