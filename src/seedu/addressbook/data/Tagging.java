package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Represent an adding or deleting of a tag for a specific person that happened during that session
 */

public class Tagging {
	
	public static final int STATUS_ADDED = 1;
	public static final int STATUS_DELETED = 2;
	private static final String SYMBOL_ADDED = "+";
	private static final String SYMBOL_DELETED = "-";
	
	private final Person person;
	private final Tag tag;
	private final int status;
	
	
	public Tagging(Person person, Tag tag, int status) {
		this.person = person;
		this.tag = tag;
		this.status = status;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public Tag getTag() {
		return tag;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String toString() {
		String str = "";
		if (status == STATUS_ADDED) {
			str += SYMBOL_ADDED + " ";
		} if (status == STATUS_DELETED) {
			str +=  SYMBOL_DELETED + " ";
		}
		str += getPerson().getName().toString() + " [" + getTag().toString() + "]";
		return str;
	}
}
