package seedu.addressbook.data.person;


/**
 * Represents a Person's unit number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Unit {

    public final String value;
	
	/**
     * Validates given unit number.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        this.value = unit;
    }

    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
