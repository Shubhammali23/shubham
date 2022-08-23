///* Java Program to find sum of elements in a given array */
//class Main
//{
//    static int arr[] = {12,3,4,15};
//
//    // method for sum of elements in an array
//    static int sum()
//    {
//        int sum = 0; // initialize sum
//        int i;
//
//        // Iterate through all elements and add them to sum
//        for (i = 0; i < arr.length; i++)
//            sum += arr[i];
//
//        return sum;
//    }
//    public static void main(String[] args)
//    {
//        System.out.println("Sum of given array is " + sum());
//    }
//}
//
class Vehicle{
    void run()
    {System.out.println("Vehicle is running");}
}
class Bike2 extends Vehicle{
    void run()
    {System.out.println("Bike is running safely");}
    public static void main(String args[]){
        Bike2 obj = new Bike2();
        obj.run();//calling method
        Vehicle obj1 = new Vehicle();
        obj1.run();
    }
}
