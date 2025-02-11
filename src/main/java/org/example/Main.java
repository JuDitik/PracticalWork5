package org.example;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        String input = "abcTESTabc";
        for (char c : input.toCharArray()) {
            automaton.process(c);
        }
        System.out.println("Кінцевий стан: " + automaton.getCurrentState());
    }
}
