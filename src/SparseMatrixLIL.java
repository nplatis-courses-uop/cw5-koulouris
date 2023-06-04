import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SparseMatrixLIL implements SparseMatrix{

    private List<TreeMap<Integer, Double>> matrix;
    private int rows, columns;
    private ElementInfo elInf;

    public SparseMatrixLIL(int r, int c){
        matrix = new LinkedList<>();
        for(int i = 0; i < r; i++){
            matrix.add(new TreeMap<>());
            
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
       Iterator<TreeMap<Integer, Double>> it = matrix.iterator();
       double res = 0;

       int curRow = 0;
       while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                if(row.get(c) != null){
                    res = row.get(c);
                }
                break;
            }
            curRow+=1;
       }

       return res;
    }

    @Override
    public void set(int r, int c, double element) {
        Iterator<TreeMap<Integer, Double>> it = matrix.iterator();
        int curRow = 0;

        if(Math.abs(element) < 1e-5){
            zero(r, c);
            return;
        }
        while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                row.put(c, element);
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
        Iterator<TreeMap<Integer, Double>> it = matrix.iterator();
 
        int curRow = 0;
        while(it.hasNext()){
            var row =  it.next();
            if(curRow == r){
                if(row.remove(c) == null){
                    //System.out.println("Element at: ("+r+", "+c+") is already zero.");
                }
                break;
            }
            curRow+=1;
        }
    }

    @Override
    public void clear() {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                zero(i, j);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        Iterator<TreeMap<Integer, Double>> it = matrix.iterator();

        while(it.hasNext()){
            var row =  it.next();
            if(row.isEmpty() == false){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String res="[ ";

        Iterator<TreeMap<Integer, Double>> it = matrix.iterator();
        int curRow = 0;
        while(it.hasNext()){
            var row = it.next();
            Set<Integer> cols = row.keySet();
            for(Integer i: cols){
                res += "("+curRow+", "+i+": "+row.get(i)+") ";
            }
            curRow++;
        }
        res +="]";
        return res;
    }
    
    private class ElementInfo{
        private int c;
        private double  val;

        public ElementInfo(int c, double val){
            this.c = c;
            this.val = val;
        }
    }
}
