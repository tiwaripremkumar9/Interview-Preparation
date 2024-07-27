public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;
    
    //create private ctor
    private SynchronizedSingleton(){

    }

    // synchronized static getInstanceMethod 
    synchronized public static SynchronizedSingleton getInstance(){
        if(instance == null){
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
