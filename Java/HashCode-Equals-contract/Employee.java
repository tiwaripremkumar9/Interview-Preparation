public class Employee {

    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object emp){
        if(emp == null || getClass() != emp.getClass())
            return false;
        if(emp == this)
            return true;
        Employee employee = (Employee) emp;
        if(this.getId() == employee.getId()){
            return true;
        }

        return false;

    }

}
