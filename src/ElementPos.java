public class ElementPos{
    private int row,column;
    //private double value;

    public ElementPos(int r,int c){
        row=r;
        column=c;
       // value=v;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    /*public double getValue(){
        return value;
    }
    public void setValue(double value){   
        this.value=value;
    }*/
}
