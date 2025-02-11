package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FiniteAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, S3",
            "TEST, F",
            "TTEST, F",
            "T, S1",
            "TES, S3",
            "abcdef, S0"
    })
    void testAutomaton(String input, String expectedState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        for (char c : input.toCharArray()) {
            automaton.process(c);
        }
        assertEquals(expectedState, automaton.getCurrentState().name());
    }

    @Test
    void testReset() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.process('T');
        automaton.reset();
        assertEquals("S0", automaton.getCurrentState().name());
    }
}