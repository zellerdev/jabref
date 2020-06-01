package org.jabref.gui.bibsonomy;

import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import org.jabref.gui.JabRefFrame;
import org.jabref.gui.SidePaneComponent;
import org.jabref.gui.SidePaneManager;
import org.jabref.gui.SidePaneType;
import org.jabref.gui.actions.Action;
import org.jabref.gui.actions.StandardActions;
import org.jabref.gui.icon.IconTheme;
import org.jabref.logic.l10n.Localization;
import org.jabref.preferences.JabRefPreferences;

public class BibSonomySidePane extends SidePaneComponent {

    private final JabRefPreferences preferences;
    private final BibSonomySidePaneViewModel viewModel;

    public BibSonomySidePane(SidePaneManager sidePaneManager, JabRefPreferences preferences, JabRefFrame frame) {
        super(sidePaneManager, IconTheme.JabRefIcons.WWW, "BibSonomy");
        this.preferences = preferences;
        this.viewModel = new BibSonomySidePaneViewModel(preferences.getImportFormatPreferences(), frame, preferences, frame.getDialogService());
    }

    @Override
    public Priority getResizePolicy() {
        return Priority.NEVER;
    }

    @Override
    public Action getToggleAction() {
        return StandardActions.TOGGLE_BIBSONOMY;
    }

    @Override
    protected Node createContentPane() {
        //TODO: write tag cloud etc.
        return new VBox();
    }

    @Override
    public SidePaneType getType() {
        return SidePaneType.BIBSONOMY;
    }

}
