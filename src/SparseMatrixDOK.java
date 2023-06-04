public class SparseMatrixDOK implements SparseMatrix{
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void set(int r, int c, double element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void zero(int r, int c) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'zero'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
