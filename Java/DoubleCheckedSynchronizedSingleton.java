public class DoubleCheckedSynchronizedSingleton {
    
    private static DoubleCheckedSynchronizedSingleton instance;

    private DoubleCheckedSynchronizedSingleton() {

    }

    public static DoubleCheckedSynchronizedSingleton getInstance(){
        if(instance == null){
            synchronized(DoubleCheckedSynchronizedSingleton.class){
                instance = new DoubleCheckedSynchronizedSingleton();
            }
        }

        return instance;
    }
}
