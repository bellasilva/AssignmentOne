package com.cny0166.assignmentone;

/**
 * Created by Julian on 7/08/2015.
 */

public enum RATING { // Stores minimum age information for film objects.
    GENERAL(0), PARENTAL_GUIDANCE(12), MATURE(16);

    private int minimumAge;

    private RATING (int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getMinAge() {

        return minimumAge;
    }


}