package lab2.strategy;

import lab2.model.LineToProcess;

public abstract class VigenereStrategy {

    private final LineToProcess lineToProcess;

    protected VigenereStrategy(final LineToProcess line) {
        this.lineToProcess = line;
    }

    abstract String processedLine();

    public String getKey() {
        return lineToProcess.getCycledKey().get();
    }

    public String getLineToProcess() {
        return lineToProcess.getLine();
    }
}
