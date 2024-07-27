public class MainClass {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Prem");

        Employee emp2 = new Employee();
        emp2.setId(1);
        emp2.setName("Prem");
        
        System.out.println("Shallow Comparison: "+(emp1==emp2));
        System.out.println("Deep Comparison: "+emp1.equals(emp2));
    }
    
}
