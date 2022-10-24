package seedu.rc4hdb.model;

import static java.util.Objects.requireNonNull;

/**
 * Represents a field with a string value.
 */
public abstract class Field {

    public final String value;

    protected Field(String value) {
        requireNonNull(value);
        this.value = value;
    }

    /**
     * Returns true if given {@code Field}'s value is contained in this Field's value
     * @return true if the field value is a substring of this field's value.
     */
    public boolean containsIgnoreCase(Field field) {
        return isSubclass(field) && this.value.toLowerCase().contains(field.value.toLowerCase());
    }

    /**
     * Returns true if {@code other} is a subclass of {@code this} or if {@code this} is a subclass of {@code other}.
     * @return true if the condition above is satisfied.
     */
    private boolean isSubclass(Field other) {
        return other.getClass().equals(this.getClass());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Field)) {
            return false;
        }

        Field otherField = (Field) other;
        return isSubclass(otherField) && otherField.value.equals(this.value);
    }

}