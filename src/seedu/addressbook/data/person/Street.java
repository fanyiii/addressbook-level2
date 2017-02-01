package seedu.addressbook.data.person;

/**
 * Represents a Person's street in the address book.
 * Guarantees: immutable
 */
public class Street {

    public final String value;
	
	/**
     * Validates given street.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street) {
    	this.value = street;
    }

    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
