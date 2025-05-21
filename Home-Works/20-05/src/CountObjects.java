class MyClass {
    static int objectCount = 0; 
    //static because otherwise every object will have its own count variable starting at 0
    
    public MyClass() {
        objectCount++; 
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

public class CountObjects {
    public static void main(String[] args) {
        MyClass o1 = new MyClass();
        MyClass o2 = new MyClass();
        MyClass o3 = new MyClass();

        System.out.println("Number of objects created: " + MyClass.getObjectCount());
        //can call it with a class name
    }
}
