package lab2.model;

import lab2.CycledKey;

public class LineToProcess {

    private final String line;
    private final CycledKey cycledKey;

    public LineToProcess(final String line, final CycledKey cycledKey) {
        this.line = line.toUpperCase();
        this.cycledKey = cycledKey;
    }

    public String getLine() {
        return line;
    }

    public CycledKey getCycledKey() {
        return cycledKey;
    }
}
