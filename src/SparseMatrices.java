public class SparseMatrices {
    public static SparseMatrix add(SparseMatrix a, SparseMatrix b){
        SparseMatrix c;
        if(a.colCount() == b.colCount() && a.rowCount() == b.rowCount()){
            int rows = a.rowCount();
            int cols = a.colCount();
            c = new SparseMatrixLIL(rows, cols);
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    c.set(i, j, a.get(i, j) + b.get(i, j));
                }
            }
            return c;
        }
    else{
        System.out.println("The dimencions of the Matrixes are not the same.");
        return null;
    }
    }
}
