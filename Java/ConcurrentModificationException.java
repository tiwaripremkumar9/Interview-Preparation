import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  two examples of ConcurrentModificationException
 */
public class ConcurrentModificationException {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("1", "2", "3", "4", "5");
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            String val = (String) iterator.next();
            if("3".equals(val)){
                myList.remove(val);
            }
            System.out.println(val);
        }

        Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				//myMap.put("1", "4");
				myMap.put("4", "4");
			}
		}



    }


}