package model;

public class TTField {
    private final int index;
    private final Object parent;

    // Initialisiert das Feld mit einem Index und dem übergeordneten Objekt.
    public TTField(int index, Object parent) {
        this.index = index;
        this.parent = parent;
    }
}
