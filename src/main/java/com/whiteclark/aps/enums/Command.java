package com.whiteclark.aps.enums;

/**
 * Command enums for the application,
 * Any new command can be registered there e.g. Move Backward 'B'
 *
 */
public enum Command {
    /** Move Forward command*/
    F("F"), 

    /** Move Left command*/
    L("L"),

    /** Move Right command*/
    R("R");

	/** String representation of enum */
    private String key;
    
    Command(String commandKey) {
        this.key = commandKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * Return Key in String
     */
    public String toString(){
        return key;
    }
}
