package comp.turing;

public abstract class Program<T,E> {

    private T[] initState;

    private T blank;

    public Program(T[] initState, T blank) {
        this.initState = initState;
        this.blank = blank;
    }

    public Program(T blank) {
        this.blank = blank;
    }

    protected T[] getInitState() {
        return this.initState;
    }

    public T getBlank(){
        return this.blank;
    }

    protected void start(Machine<T,E> machine){
        System.out.println("Starting the program");
    }


}