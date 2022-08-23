//class LargestNumberOfArray
//{
//    public static int LargestNumber(int[] a, int total)
//    {
//        int temp;
//        for (int i = 0; i < total; i++)
//        {
//            for (int j = i + 1; j < total; j++)
//            {
//                if (a[i] > a[j])
//                {
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//                return a[total];
//            }
//        }
//        return  0;
//    }
//
//    public static void main(String[] args)
//    {
//
//        int[] arr = {10, 40, 30, 50};
//        System.out.println("Largest: " + LargestNumber(arr, arr.length));
//
//    }
//}


class LargestNumberOfArray {
public static void main(String[] args)
{
    int[] arr=new int[] {10,30,50,20};
    int max= arr[0];
    for (int i=0;i<arr.length;i++){
        if (arr[i]>max){
            max=arr[i];

        }

    }
    System.out.println(max);
}
}