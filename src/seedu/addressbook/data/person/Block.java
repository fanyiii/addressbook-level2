package seedu.addressbook.data.person;


/**
 * Represents a Person's block  in the address book.
 * Guarantees: immutable
 */
public class Block {

    public final String value;
	
    public Block(String block) {
        this.value = block;
    }

    @Override
    public String toString() {
        return this.value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }
}
