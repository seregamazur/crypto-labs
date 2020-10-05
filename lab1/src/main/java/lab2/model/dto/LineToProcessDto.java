package lab2.model.dto;

import java.util.Objects;

public class LineToProcessDto {

    private final String value;
    private final String key;

    public LineToProcessDto(final String value, final String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LineToProcessDto that = (LineToProcessDto) o;
        return Objects.equals(value, that.value) &&
            Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, key);
    }
}
