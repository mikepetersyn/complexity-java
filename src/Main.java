import comp.turing.Machine;
import comp.turing.busybeaver3.Busy3;
import comp.turing.busybeaver3.Busy3State;
import comp.turing.counting.Counting;
import comp.turing.counting.CountingState;

public class Main {

    public static void main(String[] args) {

        // counting example
        Integer[] countingInitState = {1, 0, 1, 1};

        Counting counting = new Counting(countingInitState);

        Machine<Integer, CountingState> countingMachine = new Machine<>(counting);

        countingMachine.startProgram();


        // busy beaver 3 example
        Busy3 busy3 = new Busy3();

        Machine<Integer, Busy3State> busy3Machine = new Machine<>(busy3,6);

        busy3Machine.startProgram();


    }
}