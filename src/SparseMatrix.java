public interface SparseMatrix {
    //methods below are public and abstract by default
    int rowCount();
    int colCount();
    double get(int r, int c);
    void set(int r, int c, double element);
    void zero(int r, int c);
    void clear();
    boolean isEmpty();
    String toString();
}
