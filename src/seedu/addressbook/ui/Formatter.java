package seedu.addressbook.ui;


import java.util.List;


public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String DEFAULT_LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String DEFAULT_LS = System.lineSeparator();

    private static final String DEFAULT_DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    private final String linePrefix;
    private final String lineSeparator;
    private final String divider;

    public Formatter() {
    	this(DEFAULT_LINE_PREFIX, DEFAULT_LS, DEFAULT_DIVIDER);
    }
    
    public Formatter(String linePrefix,String lineSeparator, String divider) {
    	this.linePrefix = linePrefix;
    	this.lineSeparator = lineSeparator;
    	this.divider = divider;
    }
    
    public String formatMsgToUser(String m) {
    	return this.linePrefix + m.replace("\n", this.lineSeparator + this.linePrefix);
    }
    
    public String getLinePrefix() {
    	return this.linePrefix;
    }
    
    public String getLineSeparator() {
    	return this.lineSeparator;
    }
    
    public String getDivider() {
    	return this.divider;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
