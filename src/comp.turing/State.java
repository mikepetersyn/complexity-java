package comp.turing;

public abstract class State<T> {

    public abstract Integer getCurrentStateID();

    public abstract Instruction<T> getInstruction(T symbolToRead);

}
