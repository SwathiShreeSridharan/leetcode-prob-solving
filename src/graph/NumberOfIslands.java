//DFS

package graph;

import java.util.Scanner;

public class NumberOfIslands {
    public void dfs(char[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0')
            return;
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        char[][] grid=new char[rows][cols];
        System.out.println("Enter the grid elements");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=sc.next().charAt(0);
            }
        }
        NumberOfIslands n=new NumberOfIslands();
        System.out.println("Number of Islands: "+n.numIslands(grid));
    }
}
