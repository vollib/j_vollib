package org.vollib.j_vollib.helper;

/**
 * Created by Maricris on 19/04/2017.
 */
public enum Flag {

    CALL(1, 'c'), PUT(-1, 'p');

    double doubleVal;
    char charVal;
    Flag(double doubleVal, char charVal) {
        this.doubleVal = doubleVal;
        this.charVal = charVal;
    }

    public static Flag valueOf(char flag) {
        for (Flag f : Flag.values()) {
            if (f.charVal == flag) {
                return f;
            }
        }
        return null;
    }

    public double doubleValue() {
        return doubleVal;
    }
}
