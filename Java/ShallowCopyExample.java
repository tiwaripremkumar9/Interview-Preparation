// to learn difference between shallow copy and deep copy.

class ABC {
    int x = 100;
}

class ShallowCopyExample{
    public static void main(String[] args) {
        ABC obj1 = new ABC();
        System.out.println(obj1.x);
       
        ABC obj2 = obj1; //this copies the reference, not the value
        // doing change in copied object or the original object,
        // will  be visible/affect in both the objects.
        obj2.x = 500;
        System.out.println(obj1.x);

        obj1.x = 600;
        System.out.println(obj2.x);


    }
}