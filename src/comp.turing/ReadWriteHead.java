package comp.turing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReadWriteHead<T> implements Iterator<T> {

    private int current;

    private int numberOperations;

    ArrayList<T> cells;

    public ReadWriteHead(BandMemory<T> cells) {
        this.current = 0;
        this.numberOperations = 0;
        this.cells = cells.getCells();
    }

    @Override
    public boolean hasNext() {
        if (current < cells.size())
            return true;
        else
            return false;
    }

    public boolean hasPrevious() {
        if (current == 0)
            return false;
        else
            return true;
    }

    @Override
    public T next() {
        if (!this.hasNext())
            throw new NoSuchElementException();
        else {
            this.current++;
            this.numberOperations++;
            return cells.get(this.current);
        }
    }

    public T previous() {
        if (!this.hasPrevious())
            throw new NoSuchElementException();
        else {
            this.current--;
            this.numberOperations++;
            return cells.get(this.current);
        }
    }

    public T move(int m) {
        if (m == -1) {
            this.numberOperations++;
            return this.previous();
        } else if (m == 1) {
            this.numberOperations++;
            return this.next();
        } else
            throw new IllegalArgumentException();
    }

    public void moveToStart() {
        while (this.current > 1) {
            this.numberOperations++;
            this.current--;
        }
    }

    public void moveToEnd() {
        while (this.current < this.cells.size() - 1) {
            this.numberOperations++;
            this.current++;
        }
    }

    public T read() {
        this.numberOperations++;
        return this.cells.get(this.current);
    }

    public void write(T e) {
        this.numberOperations++;
        this.cells.set(this.current, e);
    }

    @Override
    public void remove() {
        this.numberOperations++;
        this.cells.remove(this.current);
    }

    public int getNumberOperations() {
        return this.numberOperations;
    }

}
