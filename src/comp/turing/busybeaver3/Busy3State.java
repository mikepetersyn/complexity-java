package comp.turing.busybeaver3;

import comp.turing.Direction;
import comp.turing.Instruction;
import comp.turing.State;

public class Busy3State extends State<Integer> {

    private Integer currentStateID;

    public Busy3State(Integer currentStateID) {
        this.currentStateID = currentStateID;
    }

    @Override
    public Integer getCurrentStateID() {
        return this.currentStateID;
    }

    @Override
    public Instruction<Integer> getInstruction(Integer symbolToRead) {
        switch (this.currentStateID) {
            case 0: {
                if (symbolToRead == 0) return new Instruction<>(1, 1, Direction.RIGHT);
                else if (symbolToRead == 1) return new Instruction<>(0, 1, Direction.HALT);
                else return new Instruction<>(1, 1, Direction.RIGHT);
            }
            case 1: {
                if (symbolToRead == 0) return new Instruction<>(2, 0, Direction.RIGHT);
                else if (symbolToRead == 1) return new Instruction<>(1, 1, Direction.RIGHT);
                else return new Instruction<>(2,0,Direction.RIGHT);
            }
            case 2: {
                if (symbolToRead == 0) return new Instruction<>(2,1,Direction.LEFT);
                else if (symbolToRead == 1) return new Instruction<>(0,1,Direction.LEFT);
                else return new Instruction<>(2,1,Direction.LEFT);
            }
            default:
                return null;
        }
    }
}
