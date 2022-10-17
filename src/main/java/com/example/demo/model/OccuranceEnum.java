package com.example.demo.model;

import java.io.Serializable;


public enum OccuranceEnum implements Serializable{
	ONE(1), 
	DAILY_ONCE(2), 
	DAILY_TWICE(3), 
	DAILY_NOLIMIT(4), 
	WEEKLY(5), 
	MONTHLY(6);
    
    private final int occurance;
    
    OccuranceEnum(int occurance) {
        this.occurance = occurance;
    }
 
    public int getOccuranceAsInt() {
        return occurance;
    }
 
    public String getOccuranceAsString() {
        return String.valueOf(occurance);
    }
 
    public static OccuranceEnum convertIntToOccuranceEnum(int iOccurance) {
        for (OccuranceEnum occurance : OccuranceEnum.values()) {
            if (occurance.getOccuranceAsInt() == iOccurance) {
                return occurance;
            }
        }
        return null;
    }
 
    public static OccuranceEnum convertStringToOccuranceEnum(String inputOccurance) {
        for (OccuranceEnum occuranceEnum : OccuranceEnum.values()) {
            if (occuranceEnum.getOccuranceAsString().equals(inputOccurance)) {
                return occuranceEnum;
            }
        }
        return null;
    }
 
    public static int convertOccuranceEnumToInt(OccuranceEnum occuranceEnum) {
    	for (OccuranceEnum occurance : OccuranceEnum.values()) {
            if (occurance.getOccuranceAsInt() == occuranceEnum.getOccuranceAsInt()) {
                return occurance.getOccuranceAsInt();
            }
        }
        return -1;
    }
 
    public static String convertOccuranceToString(OccuranceEnum inputEnum) {
        for (OccuranceEnum occuranceenum : OccuranceEnum.values()) {
            if (occuranceenum.getOccuranceAsInt() == inputEnum.getOccuranceAsInt()) {
                return occuranceenum.getOccuranceAsString();
            }
        }
        return null;
    }
   
}
