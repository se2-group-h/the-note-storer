package com.notes.backend.configs;

import org.springframework.stereotype.Component;

@Component
public class SecuritySwitcher {

    private boolean isEnabled = true;

    public synchronized void setEnabled(boolean value) {
        isEnabled = value;
    }

    public boolean isDisabled() {
        return !isEnabled;
    }
}
