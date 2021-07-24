package DataStructure.PatternPrinting;

public class Patterns {
    public static void main(String[] args) {


        System.out.println(" Patterns Demonstration ....");

        System.out.println("1]. Right Triangle Star Pattern");
        rightTriangle();

        System.out.println("2]. Left Triangle Star Pattern");
        leftTriangle();

        System.out.println("3]. Pyramid Star Pattern");
        pyramidPattern();

        System.out.println("4]. Downward Triangle Star Pattern");
        downwordTrianglePattern();

        System.out.println("5]. Right Down Mirror Star Pattern");
        rightDownMirrorStar();

        System.out.println("6]. Right Pascal's Triangle");
        rightPascalTriangle();

        System.out.println("6]. Left Pascal's Triangle");
        leftPascalTriangle();

        System.out.println("7]. Sandglass Star Pattern");
        sandGlassPattern();
        permute("ABC" , 0 , 2);
    }

    private static void permute(String str, int l, int r)
    {
        if (l == r) {
            System.out.println(str);
        }
            else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    private static void sandGlassPattern() {

    }

    private static void leftPascalTriangle() {
        for(int i=6 ; i>0 ; i--){
            for(int j=1 ; j<=6 ; j++) {
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0 ; i<6 ; i++){
            for(int j=0 ; j<6 ; j++) {
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void rightPascalTriangle() {
        for(int i=0 ; i<6 ; i++){
            for(int j=0 ; j<6 ; j++) {
                if(j<=i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for(int i=6 ; i>0 ; i--){
            for(int j=0 ; j<i ; j++) {
                System.out.print("*");
             }
            System.out.println();
        }
    }

    private static void rightDownMirrorStar() {
        for(int i=0 ; i<6 ; i++){
            for(int j=0 ; j<6 ; j++){
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void downwordTrianglePattern() {
        for(int i=6 ; i>=0 ; i--){
            for(int j=0 ; j<i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pyramidPattern() {
        for(int i=5 ; i>=0; i--){
            for(int j=0 ; j<6 ; j++){
                if(j>=i)
                    System.out.print("* ");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for(int i=5 ; i>=0; i--){
            for(int j=0 ; j<5 ; j++){
                if(j>=i)
                    System.out.print(" ");
                else
                    System.out.print(" *");
            }
            System.out.println();
        }
    }


    private static void leftTriangle() {
        for(int i=5 ; i>=0; i--){
            for(int j=0 ; j<6 ; j++){
                if(j>=i)
                    System.out.print("*\t");
                else
                    System.out.print(" \t");
            }
            System.out.println();
        }
    }

    private static void rightTriangle() {
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<=i ; j++){
                    System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }
}
