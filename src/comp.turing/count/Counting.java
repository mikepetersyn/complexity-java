package comp.turing.count;

import comp.turing.BandMemory;
import comp.turing.InstructionCard;
import comp.turing.Program;

public class Counting extends Program<Integer> {

    public Counting(Integer[] initState) {

        super(
                initState,
                new InstructionCard<Integer>(
                        0, 1, -1, 1),
                new InstructionCard<Integer>(
                        1, 1, 1, 0)
        );
    }

    @Override
    protected void start(BandMemory<Integer> bandMemory) {
        super.start(bandMemory);

        bandMemory.read(bandMemory.getSize());

    }

}