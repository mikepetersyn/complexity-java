package comp.turing;

public class Program<T> {

    private final InstructionCard<T>[] instructionCards;

    private final T[] initState;

    private int numberOperations;

    @SafeVarargs
    public Program(T[] initState, InstructionCard<T>... instructionCards) {
        this.initState = initState;
        this.instructionCards = instructionCards;
        this.initProgram();
    }

    private void initProgram() {
        this.numberOperations = 0;
        for (InstructionCard<T> i : this.instructionCards) {
            i.setNextInstructionCard(instructionCards[i.getNextInstructionCardNumber()]);
        }
    }

    public T[] getInitState() {
        return this.initState;
    }

    protected void start(BandMemory<T> bandMemory){
        System.out.println("Starting the program");
    }


}