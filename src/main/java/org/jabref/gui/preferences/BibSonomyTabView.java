package org.jabref.gui.preferences;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import org.jabref.logic.l10n.Localization;
import org.jabref.preferences.JabRefPreferences;

import com.airhacks.afterburner.views.ViewLoader;
import de.saxsys.mvvmfx.utils.validation.visualization.ControlsFxVisualizer;

public class BibSonomyTabView extends AbstractPreferenceTabView<BibSonomyTabViewModel> implements PreferencesTab{

    @FXML private CheckBox BibSonomyCredentialsStoreApiKey;
    @FXML private TextField BibSonomyCredentialsApiUrl;
    @FXML private TextField BibSonomyCredentialsUsername;
    @FXML private TextField BibSonomyCredentialsApiKey;

    private ControlsFxVisualizer validationVisualizer = new ControlsFxVisualizer();

    private final JabRefPreferences preferences;

    public BibSonomyTabView(JabRefPreferences preferences) {
        this.preferences = preferences;

        ViewLoader.view(this)
                  .root(this)
                  .load();
    }

    @Override
    public String getTabName() {
        return Localization.lang("BibSonomy");
    }

    public void initialize(){
        this.viewModel = new BibSonomyTabViewModel(dialogService, preferences);
    }

}
