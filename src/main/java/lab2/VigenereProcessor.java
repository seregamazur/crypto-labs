package lab2;

import lab2.model.CycledKey;
import lab2.model.LineToProcess;
import lab2.model.Operation;
import lab2.model.dto.LineToProcessDto;
import lab2.strategy.VigenereDecryptedLine;
import lab2.strategy.VigenereEncyptedLine;

import static lab2.model.Operation.ENCRYPT;

public class VigenereProcessor {

    private final ValidationService validationService;

    public VigenereProcessor(final ValidationService validationService) {
        this.validationService = validationService;
    }

    public String getProcessedLine(final Operation operation, final LineToProcessDto line) {
        validationService.validateLineToProcessDto(line);
        CycledKey cycledKey = new CycledKey(line.getKey(), line.getValue().trim().length());
        if (operation == ENCRYPT) {
            return new VigenereEncyptedLine(new LineToProcess(line.getValue(), cycledKey)).processedLine();
        }
        return new VigenereDecryptedLine(new LineToProcess(line.getValue(), cycledKey)).processedLine();
    }

}
