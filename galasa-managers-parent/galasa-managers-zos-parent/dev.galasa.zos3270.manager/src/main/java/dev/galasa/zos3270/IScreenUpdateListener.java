/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.zos3270;

import javax.validation.constraints.NotNull;

public interface IScreenUpdateListener {

    public enum Direction {
        RECEIVED,
        SENDING
    }

    void screenUpdated(@NotNull Direction direction, AttentionIdentification aid);

}
