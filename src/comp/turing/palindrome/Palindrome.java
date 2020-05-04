package comp.turing.palindrome;

import comp.turing.*;
import comp.turing.counting.CountingState;

import java.util.Stack;

public class Palindrome extends Program<Integer, PalindromeState> {


    public Palindrome(Integer[] initState) {
        super(initState, 8);
    }

    @Override
    protected void start(Machine<Integer, PalindromeState> m) {
        super.start(m);

        Instruction<Integer> instruction;
        ReadWriteHead<Integer> head = m.getBandMemory().iterator();
        Stack<PalindromeState> palindromeStateSpace = m.getStateSpace();

        // init the machine; start with state 0 and move to the first symbol
        head.moveToStart();
        head.move(1);
        palindromeStateSpace.push(new PalindromeState(0));

        while(true){
            // read the value from the tape and extract the instruction according to state and read value
            instruction = palindromeStateSpace.pop().getInstruction(head.read());
            // execute write instruction
            head.write(instruction.getSymbolToWrite());
            // push new state into stateSpace
            palindromeStateSpace.push(new PalindromeState(instruction.getNextInstructionID()));
            // execute move instruction
            if (instruction.getDirection() == Direction.HALT) {
                if(instruction.getSymbolToWrite() == 1){
                    System.out.println("Input is a palindrome");
                    break;
                } else {
                    System.out.println("Input is not a palindrome");
                    break;
                }
            } else if (instruction.getDirection() == Direction.LEFT) {
                head.move(-1);
            } else if (instruction.getDirection() == Direction.RIGHT) {
                head.move(1);
            }
        }
        System.out.format("Number of operations: %s \n", head.getNumberOperations());
    }
}
