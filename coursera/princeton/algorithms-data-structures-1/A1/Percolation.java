/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private int[] trackingConnections;
    private int dimension;
    private int numberOfFullSites;
    private WeightedQuickUnionUF uf;
    private int TOP = -1;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.numberOfFullSites = 0;
        this.dimension = n;
        this.uf = new WeightedQuickUnionUF(n);
        this.grid = new boolean[n];
        for (int i = 0; i < n*n; i++) {
            this.trackingConnections[i] = i;
            if(i < n) {
                // the values should point to negative 1, the top
                this.uf.union(i, this.TOP);
            } else if ( i < ) {
                // Have bottom row equal to n*n + 1
            }
        }

        // Make the first row values equal to -1?
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int above
        this.grid[(row * this.dimension) + col] = true;

        //Union function
        if()
        this.uf.union();

        this.numberOfFullSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return this.grid[(row * this.dimension) + col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.numberOfFullSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}