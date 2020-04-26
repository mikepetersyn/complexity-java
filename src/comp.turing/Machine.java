package comp.turing;

import java.util.Stack;

public class Machine<T, E> {

    private BandMemory<T> bandMemory;

    private Stack<E> stateSpace;

    private final Program<T,E> program;

    public Machine(Program<T,E> program) {
        this.program = program;
        this.bandMemory = new BandMemory<T>(program.getInitState(), program.getBlank());
        this.stateSpace = new Stack<>();
    }

    public Machine(Program<T,E> program, int size) {
        this.program = program;
        this.bandMemory = new BandMemory<T>(program.getBlank(), size);
        this.stateSpace = new Stack<>();
    }

    public void startProgram() {
        this.program.start(this);
    }

    public BandMemory<T> getBandMemory() {
        return this.bandMemory;
    }

    public Stack<E> getStateSpace() {
        return this.stateSpace;
    }

}