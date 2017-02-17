package org.jabref.gui.actions.bibsonomy;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import org.jabref.gui.JabRefFrame;
import org.jabref.gui.bibsonomy.BibSonomySettingsDialog;
import org.jabref.logic.l10n.Localization;


/**
 * {@link ShowSettingsDialogAction} creates and displays the {@link BibSonomySettingsDialog}
 *
 * @author Waldemar Biller <biller@cs.uni-kassel.de>
 */
public class ShowSettingsDialogAction extends AbstractAction {

    private JabRefFrame jabRefFrame;

    public void actionPerformed(ActionEvent e) {
        BibSonomySettingsDialog psd = new BibSonomySettingsDialog(jabRefFrame);
        psd.setVisible(true);
        psd.setLocationRelativeTo(jabRefFrame);
    }

    public ShowSettingsDialogAction(JabRefFrame jabRefFrame) {
        super(Localization.lang("Settings"), new ImageIcon(ShowSettingsDialogAction.class.getResource("/images/bibsonomy/wrench-screwdriver.png")));
        this.jabRefFrame = jabRefFrame;
    }
}
