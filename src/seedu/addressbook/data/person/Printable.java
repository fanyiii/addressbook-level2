package seedu.addressbook.data.person;

/**
 * A read-only immutable interface for objects which can be converted to a printable string representation
 */

public interface Printable {

    /**
     * Produce a printable string representation of the object
     * (Format:"Object: Value", e.g. Name: John Smith, Phone: 12349862)
     */
	String getPrintableString();
	
}
