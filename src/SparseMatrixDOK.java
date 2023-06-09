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
        matrix=new TreeMap<>();
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
    @Override
    public double get(int r, int c) {
        if(Math.abs(r) >= rows || Math.abs(c) >= columns){
            throw new IndexOutOfBoundsException("Position: ("+r+", "+c+") out of bounds for "+rows+"x"+columns+" matrix (indexes start from 0).");
        }
        double res;
        z.c = c;
        z.r = r;
        res=matrix.getOrDefault(z, (double) 0);
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
        matrix.remove(newPos);
    }

    @Override
    public void clear() {
        matrix.clear();
    }
     
    @Override
            public String toString(){
                    Set mtrx=matrix.entrySet();
                            String res="[ ";
                                    Iterator<Set<ElementPos>> it = mtrx.iterator();
                                            int curRow = 0;
                                                    while(it.hasNext()){
                                                                var row = it.next();
                                                                            Iterator<ElementPos> cols = row.iterator();
                                                                                        while(cols.hasNext()){
                                                                                                        ElementPos tmp = cols.next();
                                                                                                                        res += "("+curRow+", "+tmp.c+": "+matrix.get(tmp)+") ";
                                                                                                                                    }
                                                                                                                                                curRow++;
                                                                                                                                                        }
                                                                                                                                                                res +="]";
                                                                                                                                                                        return res;
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
