package comp.turing;

public class Instruction<T> {

    private Integer nextInstructionID;

    private T symbolToWrite;

    private Direction direction;

    public Instruction(Integer nextInstructionID, T symbolToWrite, Direction direction) {
        this.nextInstructionID = nextInstructionID;
        this.symbolToWrite = symbolToWrite;
        this.direction = direction;
    }

    public Integer getNextInstructionID() {
        return this.nextInstructionID;
    }

    public T getSymbolToWrite() {
        return this.symbolToWrite;
    }

    public Direction getDirection() {
        return this.direction;
    }



}
