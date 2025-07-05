package Arrays;
import java.util.Scanner;

class ConsoleArrayOperations{
    
    void add1d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter the size of array 2:");
        int n2 = sc.nextInt();

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        if(n1!=n2){
            System.out.println("Matrix addition cannot perform becauze sizes are not equal");
            return;
        }

        System.out.println("Enter the element of array 1:");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the element of array 2:");
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }


        int[] arr3 = new int[n1];

        for(int i = 0;i<n1;i++){
            arr3[i] =arr1[i] + arr2[i];
        }

        System.out.println("Your both 1D Array after addition is:");
        for(int i=0;i<n1;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
        System.out.println("Addition Completed for 1D Array.......");
    }

    void add2d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and column of Matrix 1:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Enter the row and column of Matrix 2:");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        if((r1!=r2) || (c1 !=c2)){
            System.out.println("Matrix addition cannot be perform.....");
            return;
        }

        int[][] arr1 = new int[r1][c1];
        int[][] arr2 = new int[r2][c2];

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] arr3 = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("Your 2D Matrix after addition is:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Addition Completed for 2D Array.......");
    }

    void sub2d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and column of Matrix 1:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Enter the row and column of Matrix 2:");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        if((r1!=r2) || (c1 !=c2)){
            System.out.println("Matrix addition cannot be perform.....");
            return;
        }

        int[][] arr1 = new int[r1][c1];
        int[][] arr2 = new int[r2][c2];

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] arr3 = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                arr3[i][j] = arr1[i][j] - arr2[i][j];
            }
        }

        System.out.println("Your 2D Matrix after Subtraction is:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Subtraction Completed for 1D Array.......");
    }


    void sub1d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter the size of array 2:");
        int n2 = sc.nextInt();

        if(n1!=n2){
            System.out.println("Matrix subtraction cannot perform becauze sizes are not equal");
            return;
        }

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.out.println("Enter the element of array 1:");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the element of array 2:");
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n1];

        for(int i = 0;i<n1;i++){
            arr3[i] =arr1[i] - arr2[i];
        }

        System.out.println("Your both 1D Array after subtraction is:");
        for(int i=0;i<n1;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println("Subtraction Completed for 1D Array.......");
    }

    void mul1d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter the size of array 2:");
        int n2 = sc.nextInt();

        if(n1!=n2){
            System.out.println("Matrix multiplication cannot perform becauze sizes are not equal");
            return;
        }

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.out.println("Enter the element of array 1:");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the element of array 2:");
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n1];

        for(int i = 0;i<n1;i++){
            arr3[i] =arr1[i] * arr2[i];
        }

        System.out.println("Your both 1D Array after multiplication is:");
        for(int i=0;i<n1;i++){
            System.out.print(arr3[i]);
        }
        System.out.println();
        System.out.println("Multiplication Completed for 1D Array.......");
    }

    void mul2d(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and column of Matrix 1:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Enter the row and column of Matrix 2:");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        if (c1 != r2) {
            System.out.println("Matrix multiplication cannot be performed...");
            return;
        }

        int[][] arr1 = new int[r1][c1];
        int[][] arr2 = new int[r2][c2];

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the element of matrix 1:");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] arr3 = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                arr3[i][j] = 0;
                for(int k =0 ;k<c1;k++){
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }

            }
        }

        System.out.println("Your 2D Matrix after multiplication is:");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Multiplication Completed for 1D Array.......");
    }
}

public class MatrixOperationsConsoleBased extends ConsoleArrayOperations {
    public static void main(String[] args) {

        ConsoleArrayOperations cad = new ConsoleArrayOperations();
    
        while (true) {
            System.out.println("Choose the operations You want to perform from the given list:");
            System.out.println("1: 1-Dimension Array Addition");
            System.out.println("2: 2-Dimension Array Addition");
            System.out.println("3: 1-Dimension Array Subtraction");
            System.out.println("4: 2-Dimension Array Subtraction");
            System.out.println("5: 1-Dimension Array Multiplication");
            System.out.println("6: 2-Dimension Array Multiplication");
            System.out.println("0: Exit.....");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the operation you want to perform from their S.NO. i.e 1,2,3,4,5,6,0:");
            int choice = sc.nextInt();

            if(choice == 0){
                System.out.println("Exiting the program.....");
                return;
            }

            switch (choice) {
                case 1:
                    cad.add1d();
                    break;
                case 2:
                    cad.add2d();
                    System.out.println("Addition Completed for 2D Array.......");
                    break;
                case 3:
                    cad.sub1d();
                    System.out.println("Subtraction Completed for 1D Array.......");
                    break;
                case 4:
                    cad.sub2d();
                    System.out.println("Subtraction Completed for 2D Array.......");
                    break;
                case 5:
                    cad.mul1d();
                    System.out.println("Multiplication Completed for 1D Array.......");
                    break;
                case 6:
                    cad.mul2d();
                    System.out.println("Multiplication Completed for 2D Array.......");
                    break;
                default:
                    System.out.println("Invalid Choice! Please enter a valid choice.....");
                    break;
            }
            
        }


    }
    
}
