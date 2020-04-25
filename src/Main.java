import comp.turing.Machine;
import comp.turing.count.Counting;

public class Main {

    public static void main(String[] args) {

        Integer[] initState = {1, 0, 1, 1};

        Counting counting = new Counting(initState);

        Machine<Integer> countingMachine = new Machine<>(counting);

        countingMachine.startProgram();

    }
}