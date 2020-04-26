package comp.turing;

import java.util.ArrayList;
import java.util.Arrays;


public class BandMemory<T> implements Iterable<T> {

    private ArrayList<T> cells;

    public BandMemory(T[] initState, T blank) {
        this.cells = new ArrayList<T>();
        this.cells.add(blank);
        this.cells.addAll(Arrays.asList(initState));
        this.cells.add(blank);
    }

    public BandMemory(T blank, int size) {
        this.cells = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            this.cells.add(blank);
        }
    }

    ArrayList<T> getCells() {
        return this.cells;
    }


    @Override
    public ReadWriteHead<T> iterator() {
        return new ReadWriteHead<>(this);
    }

}