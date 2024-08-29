package com.ng.matrix2d;

public class UnionFind {
	
	
	//Leetcode 1905 Using union find to count num of subIslands.
	//We only need to count total iland when cell is 1 and each successful union decrease its count by 1.
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int row = grid2.length;
        int col = grid2[0].length;
        int totalIsland = 0; // initially will be total 1's in the grid

        DisjointSet islandDSU = new DisjointSet(row * col);

        for (int r = 0; r < row; r++) {

            for (int c = 0; c < col; c++) {

                if (grid2[r][c] == 1) {

                    totalIsland++; // suppose each 1 is separate island

                    if (c + 1 < col && grid2[r][c + 1] == 1) {

                        totalIsland -= islandDSU.union(getIdx(r, c, col), getIdx(r, c + 1, col)); // each sucessful union will decrease island count by 1
                    }

                    if (r + 1 < row && grid2[r + 1][c] == 1) {

                        totalIsland -= islandDSU.union(getIdx(r, c, col), getIdx(r + 1, c, col)); // each sucessful union will decrease island count by 1
                    }
                }
            }
        }

        boolean[] visited = new boolean[row * col]; // to keep track if this group already been counted
        int notSubIsland = 0;

        for (int r = 0; r < row; r++) {

            for (int c = 0; c < col; c++) {

                if (grid2[r][c] == 1 && grid1[r][c] == 0) { // its this group is not subisland

                    int groupIdx = islandDSU.find(getIdx(r, c, col));

                    if (!visited[groupIdx]) { // if not counted earlier

                        visited[groupIdx] = true;
                        notSubIsland++;

                    }
                }

            }

        }

        return totalIsland - notSubIsland;

    }
    
    class DisjointSet {

        int[] parent = null;
        int[] rank = null;

        public DisjointSet(int n) {

            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int e) {

            if (parent[e] == e) {
                return e;
            }

            int g = find(parent[e]);
            parent[e] = g;

            return g;
        }

        public int union(int e1, int e2) {

            int g1 = find(e1);
            int g2 = find(e2);

            if (g1 == g2) {

                return 0; // same group no union
            }

            if (rank[g1] < rank[g2]) {

                parent[g1] = g2;

            } else if (rank[g2] < rank[g1]) {

                parent[g2] = g1;

            } else {

                parent[g2] = g1;
                rank[g1]++;

            }

            return 1; // decrease 1 in total island count

        }
    }

    //convert 2d matric to roworder 1d matrix
    public int getIdx(int r, int c, int col) {

        return (r * col) + c;
    }
    
    
    //leetcode 200. Number of Islands
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        UnionFindForGrid uf = new UnionFindForGrid(grid);

        for(int r = 0; r < row ; r ++){

                for(int c = 0; c < col; c++){

                    if(grid[r][c] == '1'){

                        int idx1 = r * col + c; // 1-d index
                        
                        // check left
                        if(c > 0 && grid[r][c - 1] == '1'){

                            int idx2 = r * col + (c - 1); // 1-d index

                            uf.unionByRank(idx1, idx2);
                        }
                        
                        // check above
                        if(r > 0 && grid[r - 1][c] == '1'){
                            
                            int idx2 = (r - 1) * col + c; // 1-d Index

                            uf.unionByRank(idx1, idx2);
                        }
                    }

                }

        }

        return uf.disjointCount;
    }

    private class UnionFindForGrid{

        private int[] parent = null;
        private int[] rank = null;
        private int disjointCount = 0;
        
        private UnionFindForGrid(char[][] arr){

            int row = arr.length;
            int col = arr[0].length;

            parent = new int[row * col];
            rank = new int[row * col];

            for(int r = 0; r < row ; r ++){

                for(int c = 0; c < col; c++){

                    if(arr[r][c] == '1'){

                        int idx = r * col + c; // correspsing 1-d index 
                        
                        parent[idx] = idx;
                        
                        disjointCount++;
                    }

                }
            }
        }

        // accepts corresponding 1-d index
        private int find(int idx){

            if(parent[idx] == idx){
                
                return idx;
            }

            int res = find(parent[idx]);

            parent[idx] = res; // path compression

            return res;

        }

        // accepts corresponding 1-d index
        private void unionByRank(int idx1, int idx2){

            int l = find(idx1); // parent of idx1
            int r = find(idx2); // parent of idx2

            if(l == r){
                
                return ; // union not required;
            
            }

            if(rank[r] < rank[l]){

                parent[r] = l; // parent of r will be l

            }else if(rank[l] < rank[r]){

                parent[l] = r; // parent of l will be r
            
            }else{ // can be anyone

                parent[l] = r; // parent of l will be r

                rank[r] += 1;

            }

            disjointCount--;

        }

    }

}
