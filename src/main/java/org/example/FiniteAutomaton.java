package org.example;

public class FiniteAutomaton {
    // Change visibility of State to package-private
    enum State {
        S0, S1, S2, S3, F
    }

    private State currentState;

    public FiniteAutomaton() {
        reset();
    }

    public void reset() {
        currentState = State.S0;
    }

    public void process(char c) {
        switch (currentState) {
            case S0 -> currentState = (c == 'T') ? State.S1 : State.S0;
            case S1 -> currentState = (c == 'E') ? State.S2 : (c == 'T') ? State.S1 : State.S0;
            case S2 -> currentState = (c == 'S') ? State.S3 : (c == 'T') ? State.S1 : State.S0;
            case S3 -> currentState = (c == 'T') ? State.F : State.S0;
            case F -> {}
        }
    }

    public boolean isAccepted() {
        return currentState == State.F;
    }

    public State getCurrentState() {
        return currentState;
    }

    public static void main(String[] args) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        String input = "abcTESTabc";
        for (char c : input.toCharArray()) {
            automaton.process(c);
        }
        System.out.println("Кінцевий стан: " + automaton.getCurrentState());
    }
}
