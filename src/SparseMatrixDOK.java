import java.util.TreeMap;
//import java.math;
public class SparseMatrixDOK implements SparseMatrix{
    private TreeMap<ElementPos, Double> matrix;
    private int rows, columns;

    public SparseMatrixDOK(int r, int c){
        rows = r;
        columns = c;
    }
    @Override
    public int rowCount() {
       return rows;
    }

    @Override
    public int colCount() {
        return columns;
    }

    @Override
    public double get(int r, int c) {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        double res = 0;
        //get double value with key ElementPos(r, c) and assign it to res
        return res;
    }

    @Override
    public void set(int r, int c, double element) throws IndexOutOfBoundsException {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        
        //use matrix.put, after making a new ElementPos, check if the position already has an element, you need to remove it first then put the new one.
    }

    @Override
    public void zero(int r, int c) throws IndexOutOfBoundsException {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        
        //get the ElementPos with values r,c from the matrix and use matrix.remove(ElementPos key)
    }

    @Override
    public void clear() {
        matrix.clear();
    }

    @Override
    public boolean isEmpty() {
       return matrix.isEmpty();
    }
    
    private class ElementPos implements Comparable<ElementPos>{
        private int r, c;

        private ElementPos(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(SparseMatrixDOK.ElementPos o) {
            if(this.r != o.r){
                return this.r - o.r;
            }
            else{
                return this.c - o.c;
            }
        }
    }
}
