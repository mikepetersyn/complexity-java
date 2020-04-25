package comp.turing;

public class InstructionCard<T> {

    private final T intputChar;

    private final T charToWrite;

    private final T move;

    private final int nextInstructionCardNumber;

    private InstructionCard nextInstructionCard;

    public InstructionCard(T inputChar, T charToWrite, T move, int nextInstructionCardNumber) {
        this.intputChar = inputChar;
        this.charToWrite = charToWrite;
        this.move = move;
        this.nextInstructionCardNumber = nextInstructionCardNumber;
    }

    protected T getInputChar() {
        return this.intputChar;
    }

    protected T getCharToWrite() {
        return this.charToWrite;
    }

    protected T getMove() {
        return this.move;
    }

    protected int getNextInstructionCardNumber() {
        return this.nextInstructionCardNumber;
    }

    protected InstructionCard getNextInstructionCard() {
        return this.nextInstructionCard;
    }

    protected void setNextInstructionCard(InstructionCard instructionCard) {
        this.nextInstructionCard = instructionCard;
    }

}