import java.util.TreeMap;
public class SparseMatrixDOK /*extends ElementPos*/ implements SparseMatrix{
    private TreeMap<ElementPos, Double> matrix;
    private int rows, columns;
    private ElementPos z=new ElementPos(0,0);
    /**
     * @param r
     * @param c
     */
    public SparseMatrixDOK(int r, int c){
       // super(0, 0);//ElementPos Object Create
       matrix=new TreeMap<>();
        for(int i = 0; i < r; i++){
            for(int j=0;j < c;j++){
                matrix.put(z.setElementPos(r,c), 0.0);
            }
        }
        rows=r;
        columns=c;
    }
    @Override
    public int rowCount() {
       return rows;
    }

    @Override
    public int colCount() {
        return columns;
    }
    public void setElementPos(int x,int y){
        z.setRow(x);
        z.setColumn(y);
    }
    public ElementPos getElementPos(){
        return z;
    }
    @Override
    public double get(int r, int c) {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        double res;
        res=matrix.getOrDefault(z, null);
        return res;
    }

    @Override
    public void set(int r, int c, double element) throws IndexOutOfBoundsException {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        //use matrix.put, after making a new ElementPos, check if the position already has an element, you need to remove it first then put the new one.
        ElementPos newPos=new ElementPos(r,c);
        if(matrix.ceilingEntry(newPos)!=null){
            matrix.replace(newPos, element);
        }
        else{
            matrix.put(newPos, element);
        }
    }

    @Override
    public void zero(int r, int c) throws IndexOutOfBoundsException {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        
        //get the ElementPos with values r,c from the matrix and use matrix.remove(ElementPos key)
        ElementPos newPos=new ElementPos(r,c);
        if(matrix.ceilingEntry(newPos)!=null){
            matrix.replace(newPos, 0.0);
        }
        else{
            matrix.put(newPos, 0.0);
        }
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

        public SparseMatrixDOK.ElementPos setElementPos(int r2, int c2) {
            return null;
        }

        public void setRow(int x) {
        }

        public void setColumn(int y) {
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
