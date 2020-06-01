package org.jabref.gui.preferences;

import java.util.Collections;
import java.util.List;

import org.jabref.gui.DialogService;
import org.jabref.preferences.JabRefPreferences;

public class BibSonomyTabViewModel implements PreferenceTabViewModel {

    public BibSonomyTabViewModel(DialogService dialogService, JabRefPreferences preferences) {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void storeSettings() {

    }

    @Override
    public boolean validateSettings() {
        return false;
    }

    @Override
    public List<String> getRestartWarnings() {
        return Collections.emptyList();
    }
}
