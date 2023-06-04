import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SparseMatrixLIL implements SparseMatrix{

    private List<TreeSet<ElementInfo>> matrix;
    private int rows, columns;

    public SparseMatrixLIL(int r, int c){
        matrix = new LinkedList<>();
        for(int i = 0; i < r; i++){
            matrix.add(new TreeSet<>());
        }
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
       Iterator<TreeSet<ElementInfo>> it = matrix.iterator();
       ElementInfo res = new ElementInfo(c);

       int curRow = 0;
       while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                Iterator<ElementInfo> cols = row.iterator();
                while(cols.hasNext()){
                    ElementInfo tmp = cols.next();
                    if(tmp.c == c){
                        res = tmp;
                    }
                }
                break;
            }
            curRow+=1;
       }

       return res.val;
    }

    @Override
    public void set(int r, int c, double element) {
        Iterator<TreeSet<ElementInfo>> it = matrix.iterator();
        int curRow = 0;
        ElementInfo toPut = new ElementInfo(c, element);

        if(Math.abs(element) < 1e-5){
            zero(r, c);
            return;
        }
        while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                row.add(toPut);
            }
            curRow+=1;
        }
    }

    @Override
    public void zero(int r, int c) {
        if(r > rows){
            throw new IndexOutOfBoundsException("Row index: "+r+ " is out of bounds.");
        }
        if(c > columns){
            throw new IndexOutOfBoundsException("Column index: "+c+" is out of bounds.");
        }
        Iterator<TreeSet<ElementInfo>> it = matrix.iterator();
 
        int curRow = 0;
        while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                Iterator<ElementInfo> cols = row.iterator();
                while(cols.hasNext()){
                    if(cols.next().c == c){
                        cols.remove();
                    }
                }
                break;
            }
            curRow+=1;
        }
    }

    @Override
    public void clear() {
        Iterator<TreeSet<ElementInfo>> it = matrix.iterator();

        while(it.hasNext()){
            var row = it.next();
            Iterator<ElementInfo> cols = row.iterator();
            while(cols.hasNext()){
                cols.next();
                cols.remove();
            }
        }
 
    }

    @Override
    public boolean isEmpty() {
       Iterator<TreeSet<ElementInfo>> rows = matrix.iterator();
        while(rows.hasNext()){
            var row = rows.next();
            Iterator<ElementInfo> cols = row.iterator();
            if(cols.hasNext()){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String res="[ ";

        Iterator<TreeSet<ElementInfo>> it = matrix.iterator();
        int curRow = 0;
        while(it.hasNext()){
            var row = it.next();
            Iterator<ElementInfo> cols = row.iterator();
            while(cols.hasNext()){
                //never reaches here
                ElementInfo tmp = cols.next();
                res += "("+curRow+", "+tmp.c+": "+tmp.val+") ";
            }
            curRow++;
        }
        res +="]";
        return res;
    }
    
    private class ElementInfo implements Comparable<ElementInfo>{
        private int c;
        private double  val;

        private ElementInfo(int c, double val){
            this.c = c;
            this.val = val;
        }
        private ElementInfo(int c){
            val = 0;
            this.c = c;
        }
        @Override
        public int compareTo(ElementInfo o) {
            return this.c - o.c;
        }
    }
}
