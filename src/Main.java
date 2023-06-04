public class Main {
    public static void main(String[] args) {
        SparseMatrix SM = new SparseMatrixLIL(4, 6);
        System.out.println(SM.isEmpty());
        SM.set(0, 2, 3);
        SM.set(0, 3, 7);
        SM.set(1, 0, 1);
        SM.set(1, 4, 2);
        SM.set(1, 5, 3);
        SM.set(3, 1, 9);
        SM.set(3, 3, 5);
        System.out.println(SM.isEmpty());

        System.out.println(SM);
        System.out.println(SM.get(1, 0));
        System.out.println(SM.get(3, 1));
        SM.zero(3, 1);
        System.out.println(SM.get(3, 1));
        System.out.println(SM);
        SM.clear();
        System.out.println(SM);

        //SparseMatrices test
        System.out.println();
        SparseMatrix a = new SparseMatrixLIL(2, 2);
        for(int i = 0; i < 2; i++){
            a.set(i, i, 2);
        }
        SparseMatrix b = new SparseMatrixLIL(2, 2);
        b.set(0, 1, 2);
        b.set(1, 0, 2);
        b.set(1, 1, 2);
        SparseMatrix sum1 = SparseMatrices.add(a, b);
        System.out.println(sum1);
        System.out.println("Flag1");

        SparseMatrix c = new SparseMatrixDOK(2, 2);
        for(int i = 0; i < 2; i++){
            c.set(i, i, 9);
        }

        SparseMatrix d = new SparseMatrixDOK(3, 2);
        d.set(0, 1, 8);
        d.set(1, 0, 7);
        d.set(1, 1, 10);
        SparseMatrix sum2 = SparseMatrices.add(c, d);
        System.out.println(sum2);
        System.out.println("Flag2");
    }
}
