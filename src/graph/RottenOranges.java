package graph;
import java.util.*;
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int rotten=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean anyRotted=false;
            for(int i=0;i<size;i++){
                int[] val=queue.poll();
                int row=val[0];
                int col=val[1];
                int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
                for(int[] dir:dirs){
                    int nr = row+dir[0];
                    int nc = col+dir[1];
                    if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        queue.offer(new int[]{nr,nc});
                        anyRotted=true;
                    }
                }
            }
            if(anyRotted)
                rotten++;
        }
        if(fresh>0)return -1;
        return rotten;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns");
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(grid));

    }
}
