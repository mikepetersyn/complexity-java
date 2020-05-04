package comp.turing.palindrome;

import comp.turing.Direction;
import comp.turing.Instruction;
import comp.turing.State;

public class PalindromeState extends State<Integer> {

    private Integer currentSateID;

    PalindromeState(Integer currentSateID){
        this.currentSateID = currentSateID;
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
                    return new Instruction<>(2, 8, Direction.LEFT);
                else if (symbolToRead == 1)
                    return new Instruction<>(4, 8, Direction.LEFT);
                else
                    return new Instruction<>(0, 1, Direction.HALT);
            }
            case 2: {
                if (symbolToRead == 0)
                    return new Instruction<>(2, 0, Direction.LEFT);
                else if (symbolToRead == 1)
                    return new Instruction<>(2, 1, Direction.LEFT);
                else
                    return new Instruction<>(3, 8, Direction.RIGHT);
            }
            case 3: {
                if (symbolToRead == 0)
                    return new Instruction<>(0, 8, Direction.RIGHT);
                else if (symbolToRead == 1)
                    return new Instruction<>(6, 1, Direction.NONE);
                else
                    return new Instruction<>(0, 8, Direction.NONE);
            }
            case 4: {
                if (symbolToRead == 0)
                    return new Instruction<>(4, 0, Direction.LEFT);
                else if (symbolToRead == 1)
                    return new Instruction<>(4, 1, Direction.LEFT);
                else
                    return new Instruction<>(5, 8, Direction.RIGHT);
            }
            case 5: {
                if (symbolToRead == 0)
                    return new Instruction<>(6, 0, Direction.NONE);
                else if (symbolToRead == 1)
                    return new Instruction<>(0, 8, Direction.RIGHT);
                else
                    return new Instruction<>(0, 8, Direction.NONE);
            }
            case 6: {
                if (symbolToRead == 0)
                    return new Instruction<>(6, 8, Direction.RIGHT);
                else if (symbolToRead == 1)
                    return new Instruction<>(6, 8, Direction.RIGHT);
                else
                    return new Instruction<>(0, 0, Direction.HALT);
            }
            default:
                return null;
        }
    }
}
