package org.jabref.gui.bibsonomy;

import org.jabref.gui.DialogService;
import org.jabref.gui.JabRefFrame;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.preferences.JabRefPreferences;

public class BibSonomySidePaneViewModel {

    private final JabRefFrame frame;
    private final DialogService dialogService;

    public BibSonomySidePaneViewModel(ImportFormatPreferences importFormatPreferences, JabRefFrame frame, JabRefPreferences preferences, DialogService dialogService) {
        this.frame = frame;
        this.dialogService = dialogService;
    }

}
