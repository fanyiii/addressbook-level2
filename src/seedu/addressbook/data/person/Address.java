package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
    		"Person addresses must consist of four strings seperated by commas";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String FIELD_SEPARATOR = ", ";
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_CODE_INDEX = 3;
    
    
    private Block block;
    private Unit unit;
    private Street street;
    private PostalCode postalCode;
    
    private final String value;
    private String[] addressFields;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        addressFields = trimmedAddress.split(FIELD_SEPARATOR);
        setFields(addressFields);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
        
    }

    private void setFields(String[] fields) {
    	try {
			this.block = new Block(fields[BLOCK_INDEX]);
			this.street = new Street(fields[STREET_INDEX]);
	    	this.unit = new Unit(fields[UNIT_INDEX]);
	    	this.postalCode = new PostalCode(fields[POSTAL_CODE_INDEX]);
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}   	
    }
    
    public Block getBlock() {
    	return this.block;
    }
    
    public Street getStreet() {
    	return this.street;
    }
    
    public Unit getUnit() {
    	return this.unit;
    }
    
    public PostalCode getPostalCode() {
    	return this.postalCode;
    }
    
    @Override
    public String toString() {
        return getBlock().toString() + FIELD_SEPARATOR +  
        	   getStreet().toString() + FIELD_SEPARATOR +
        	   getUnit().toString() + FIELD_SEPARATOR +
        	   getPostalCode().toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getBlock().equals(((Address) other).getBlock())
                && this.getStreet().equals(((Address) other).getStreet())
                && this.getUnit().equals(((Address) other).getUnit())
                && this.getPostalCode().equals(((Address) other).getPostalCode()));// state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
