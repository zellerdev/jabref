package org.jabref.bibsonomy.worker;

import java.util.Collections;
import java.util.Optional;

import org.jabref.bibsonomy.BibSonomyProperties;
import org.jabref.gui.JabRefFrame;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.BibSonomyField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bibsonomy.model.logic.LogicInterface;
import org.bibsonomy.model.logic.LogicInterfaceFactory;

/**
 * Delete a Post from the service
 */
public class DeletePostsWorker extends AbstractBibSonomyWorker {

    private static final Log LOGGER = LogFactory.getLog(DeletePostsWorker.class);

    private BibEntry[] entries;

    public void run() {
        for (BibEntry entry : entries) {
            final Optional<String> intrahashOpt = entry.getField(BibSonomyField.INTRAHASH);
            final Optional<String> usernameOpt = entry.getField(BibSonomyField.USERNAME);

            if ((intrahashOpt.isPresent()) || intrahashOpt.get().isEmpty() || (usernameOpt.isPresent() && !intrahashOpt.isPresent() && !(BibSonomyProperties.getUsername().equals(usernameOpt.get())))) {
                try {
                    LogicInterface logic = LogicInterfaceFactory.getLogic(jabRefFrame.getCurrentBasePanel().getBibDatabaseContext());
                    logic.deletePosts(BibSonomyProperties.getUsername(), Collections.singletonList(intrahashOpt.get()));
                    jabRefFrame.output(Localization.lang("Deleting post %0", intrahashOpt.get()));
                    entry.clearField(BibSonomyField.INTRAHASH);
                } catch (Exception ex) {
                    LOGGER.error(Localization.lang("Failed deleting post %0", intrahashOpt.get()));
                }
            }
        }
        jabRefFrame.output(Localization.lang("Done"));
    }

    public DeletePostsWorker(JabRefFrame jabRefFrame, BibEntry[] entries) {
        super(jabRefFrame);
        this.entries = entries;
    }
}
