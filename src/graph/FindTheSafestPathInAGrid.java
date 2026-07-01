package graph;

import java.util.*;

public class FindTheSafestPathInAGrid {
    public void dfs(int[][] dist, int r, int c, int mid, boolean[][] visited){
        if(r<0 || c<0 || r>=dist.length || c>=dist.length || dist[r][c]<mid || visited[r][c]){
            return;
        }
        visited[r][c]=true;
        dfs(dist,r+1,c,mid,visited);
        dfs(dist,r-1,c,mid,visited);
        dfs(dist,r,c+1,mid,visited);
        dfs(dist,r,c-1,mid,visited);
    }
    public int maximumSafenessFactor(List<ArrayList<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    queue.add(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int[][] dir ={{0,-1},{0,1},{1,0},{-1,0}};
            for(int i=0;i<dir.length;i++){
                int nr = cell[0]+dir[i][0];
                int nc = cell[1]+dir[i][1];
                if(nr>=0 && nr<dist.length && nc>=0 && nc<dist.length && dist[nr][nc]==-1){
                    dist[nr][nc]=dist[cell[0]][cell[1]]+1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        int max=0;
        int low = 0, high = 2*(n)-2;
        while(low<=high){
            boolean[][] visited = new boolean[n][n];
            int mid = low + (high-low)/2;
            dfs(dist,0,0,mid,visited);
            if(visited[n - 1][n - 1]){
                max=Math.max(max,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the grid");
        int n=sc.nextInt();
        List<ArrayList<Integer>> grid=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int value=sc.nextInt();
                list.add(value);
            }
            grid.add(list);
        }
        FindTheSafestPathInAGrid obj=new FindTheSafestPathInAGrid();
        int res = obj.maximumSafenessFactor(grid);
        System.out.println("Maximum Safest factor: "+res);
    }
}
