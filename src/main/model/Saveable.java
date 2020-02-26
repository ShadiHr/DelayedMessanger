package model;

import java.io.IOException;

// Represents data that can be saved to file
public interface Saveable {

    // MODIFIES:
    // EFFECTS: Writes saveable to file
    void save() throws IOException;

}
