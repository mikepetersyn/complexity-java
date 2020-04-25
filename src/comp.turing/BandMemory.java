package comp.turing;

public class BandMemory<T> {

    private final int size;

    private T[] cells;

    public BandMemory(T[] initState) {
        this.size = initState.length;
        this.cells = initState.clone();
    }

    public BandMemory(T[] initState, int size) {
        this.size = size;
        this.initCells(initState, size);
    }

    private void initCells(T[] initState, int size) {
        this.cells = initState.clone();
        for (int i = initState.length; i <= size; i++) {
            this.cells[i] = null;
        }
    }

    public T read(int index){
        return this.cells[index];
    }

    public int getSize() {
        return size;
    }

}