package militaryElite;

import militaryElite.Enum.State;

import java.util.Arrays;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(State state) {
        boolean stateExists = Arrays.asList(State.values()).contains(state);
        if(!stateExists) {
           throw new IllegalArgumentException();
        }
        this.state = state;
    }

    public void completeMission() {
        state = State.finished;
    }

    public String getCodeName() {
        return codeName;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.name());
    }
}
