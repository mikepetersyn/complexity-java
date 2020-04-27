package comp.turing.counting;

import comp.turing.*;

import java.util.Stack;

public class Counting extends Program<Integer, CountingState> {

    public Counting(Integer[] initState) {
        // 8 is blank char
        super(initState, 8);
    }

    @Override
    protected void start(Machine m) {
        super.start(m);

        Instruction<Integer> instruction;
        ReadWriteHead<Integer> head = m.getBandMemory().iterator();
        Stack<CountingState> countingStateSpace = m.getStateSpace();


        // init program by first moving the head to the least significant bit and state to 1
        head.moveToEnd();
        countingStateSpace.push(new CountingState(0));

        while (true) {
            // read the value from the tape and extract the instruction according to state and read value
            instruction = countingStateSpace.pop().getInstruction(head.read());
            // execute write instruction
            head.write(instruction.getSymbolToWrite());
            // push new state into stateSpace
            countingStateSpace.push(new CountingState(instruction.getNextInstructionID()));
            // execute move instruction
            if (instruction.getDirection() == Direction.HALT) {
                break;
            } else if (instruction.getDirection() == Direction.LEFT) {
                // if move instruction LEFT then move one step to the left
                head.move(-1);
            } else {
                // if move instruction RIGHT then move to the right most digit
                head.moveToEnd();
            }
        }
        System.out.format("Number of operations: %s \n", head.getNumberOperations());
    }


}

