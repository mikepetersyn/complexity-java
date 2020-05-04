import comp.turing.Machine;
import comp.turing.busybeaver3.Busy3;
import comp.turing.busybeaver3.Busy3State;
import comp.turing.counting.Counting;
import comp.turing.counting.CountingState;
import comp.turing.palindrome.Palindrome;
import comp.turing.palindrome.PalindromeState;

public class Main {

    public static void main(String[] args) {
    /*
        // counting example
        Integer[] countingInit = {1, 0, 1, 1};

        Counting counting = new Counting(countingInit);

        Machine<Integer, CountingState> countingMachine = new Machine<>(counting);
        countingMachine.startProgram();


        // busy beaver 3 example
        Busy3 busy3 = new Busy3();

        Machine<Integer, Busy3State> busy3Machine = new Machine<>(busy3,6);

        busy3Machine.startProgram();
    */
        // palindrome example
        Integer[] palindromeInit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Palindrome palindrome = new Palindrome(palindromeInit);

        Machine<Integer, PalindromeState> palindromeMachine = new Machine<>(palindrome);

        palindromeMachine.startProgram();


    }
}