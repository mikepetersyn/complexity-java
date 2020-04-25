package comp.turing;

public class Machine<T> {

    private final BandMemory<T> bandMemory;

    private final Program<T> program;

    private final int leastBit;

    private boolean haltState;

    private int stateSpace;

    public Machine(Program<T> program) {
        this.bandMemory = new BandMemory<T>(program.getInitState());
        this.program = program;
        this.leastBit = bandMemory.getSize() - 1;
        this.haltState = false;
    }

    public Machine(Program<T> program, int size) {
        this.bandMemory = new BandMemory(program.getInitState(), size);
        this.program = program;
        this.leastBit = bandMemory.getSize() - 1;
        this.haltState = false;
    }

    public void startProgram(){
        this.program.start(this.bandMemory);
    }



}