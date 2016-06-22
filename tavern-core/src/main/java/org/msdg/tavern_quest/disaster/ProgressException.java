package org.msdg.tavern_quest.disaster;

/**
 * 副本进度异常
 * Created by mw4157 on 16/6/7.
 */
public class ProgressException extends RuntimeException {

    public ProgressException() {
    }

    public ProgressException(String message) {
        super(message);
    }
}
