package comp.turing.busybeaver3;

import comp.turing.*;

import java.util.Stack;

public class Busy3 extends Program<Integer, Busy3State> {

    public Busy3() {
        super(8);
    }

    @Override
    protected void start(Machine<Integer, Busy3State> m) {
        super.start(m);

        Instruction<Integer> instruction;
        ReadWriteHead<Integer> head = m.getBandMemory().iterator();
        Stack<Busy3State> busy3StateSpace = m.getStateSpace();

        head.move(1);
        busy3StateSpace.push(new Busy3State(0));

        while(true){
            // read the value from the tape and extract the instruction according to state and read value
            instruction = busy3StateSpace.pop().getInstruction(head.read());
            // execute write instruction
            head.write(instruction.getSymbolToWrite());
            // push new state into stateSpace
            busy3StateSpace.push(new Busy3State(instruction.getNextInstructionID()));
            // execute move instruction
            if (instruction.getDirection() == Direction.HALT) {
                break;
            } else if (instruction.getDirection() == Direction.LEFT) {
                // if move instruction LEFT then move one step to the left
                head.move(-1);
            } else {
                // if move instruction RIGHT then move to the right most digit
                head.move(1);
            }
        }
        System.out.format("Number of operations: %s \n", head.getNumberOperations());
    }
}
