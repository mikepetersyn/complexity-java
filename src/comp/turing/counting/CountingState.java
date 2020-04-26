package comp.turing.counting;

import comp.turing.Direction;
import comp.turing.Instruction;
import comp.turing.State;

public class CountingState extends State<Integer> {

    private Integer currentSateID;


    public CountingState(Integer currentStateID) {
        this.currentSateID = currentStateID;
    }

    @Override
    public Integer getCurrentStateID() {
        return this.currentSateID;
    }

    @Override
    public Instruction<Integer> getInstruction(Integer symbolToRead) {
        switch (this.currentSateID) {
            case 0: {
                if (symbolToRead == 1)
                    return new Instruction<>(0, 1, Direction.RIGHT);
                else if (symbolToRead == 0)
                    return new Instruction<>(0, 0, Direction.RIGHT);
                else
                    return new Instruction<>(1, 8, Direction.LEFT);
            }

            case 1: {
                if (symbolToRead == 0)
                    return new Instruction<>(0, 1, Direction.RIGHT);
                else if (symbolToRead == 1)
                    return new Instruction<>(1, 0, Direction.LEFT);
                else
                    return new Instruction<>(0, 1, Direction.HALT);
            }
            default:
                return null;
        }
    }


}