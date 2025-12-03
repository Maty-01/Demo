//Abdul MAteen
//FA23-BCS-014
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;



class MatrixSquareThread  implements Runnable{
    int[][] matrix;
    int[][] result;
    int row;
    int size;

    public MatrixSquareThread(int[][] matrix, int[][] result, int row, int size) {
        this.matrix = matrix;
        this.result = result;
        this.row = row;
        this.size = size;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() +  "is going to take care of row " + row);
        for(int j = 0 ; j < size; j++){
            int sum  = 0;
            for(int k = 0 ; k < size ; k++){
                sum+= matrix[row][j] * matrix[j][k];
            }
            result[row][j] = sum; 
        }
    }    
}

class MatrixSquare {
    public static void main(String[] args) {
        int size = 5;
        int [][] result = new int[size][size];
        if(args.length == 0){
            System.out.println("Please Enter number of threads");
        }
        int numThread = Integer.parseInt(args[0]);
        int[][] matrix = {
            {6,4,4,4,1},
            {5,2,6,9,4},
            {7,1,3,3,1},
            {9,0,3,6,5},
            {5,6,2,9,9}            
        };

        System.out.println("Source Matrix is:");
        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        ExecutorService execute = new ForkJoinPool(numThread);

        for(int i = 0 ; i < size ; i++){
            execute.execute(matrix,result,i,size);
        }
        
        execute.shutdown();
        while(!execute.isTerminated()){}

        System.out.println("The Result of Matrix MxM is:");
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                System.out.println(result[i][j] +  " ");
            }
            System.out.println(" ");
        }
    }
}