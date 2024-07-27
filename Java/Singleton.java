public class Singleton {

    private static Singleton instance = null;

    public String s;

    // private constructor - so that the object creation through constructor is not possible outside of this class
    private Singleton(){
        s = "I am an instance";
    }

    //static because we need to create the instance through
    public static Singleton getInstance(){
         if(instance == null)
            instance = new Singleton();
        return instance;
    }
    

    public static void main(String[] args) {
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        System.out.println("Hashcode of s2: "+s2.hashCode());
        System.out.println("Hashcode of s3: "+s3.hashCode());
    }
}