public interface SparseMatrix {
    //methods below are public and abstract by default
    int rowCount();
    int colCount();
    double get(int r, int c);
    void set(int r, int c, double element) throws IndexOutOfBoundsException;
    void zero(int r, int c) throws IndexOutOfBoundsException;
    void clear();
    boolean isEmpty();
    String toString();
}
