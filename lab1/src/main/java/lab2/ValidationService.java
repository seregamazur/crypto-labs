package lab2;

import lab2.exception.InvalidLineToProcessException;
import lab2.model.dto.LineToProcessDto;

public class ValidationService {

    private static final String INVALID_LINE_TO_PROCESS_MESSAGE = "Invalid value or key.";

    public void validateLineToProcessDto(final LineToProcessDto line) {
        if (isEmptyLine(line.getValue()) || isEmptyLine(line.getKey())) {
            throw new InvalidLineToProcessException(INVALID_LINE_TO_PROCESS_MESSAGE);
        }
    }

    private boolean isEmptyLine(final String value) {
        return value == null || value.length() == 0;
    }
}
