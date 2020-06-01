package org.jabref.bibsonomy.util;

import org.jabref.Globals;
import org.jabref.model.database.BibDatabaseContext;

import org.bibsonomy.rest.client.util.MultiDirectoryFileFactory;

public class JabRefFileFactory extends MultiDirectoryFileFactory {

    public JabRefFileFactory(BibDatabaseContext context) {
        super(context.getFileDirectories(Globals.prefs.getFilePreferences()).get(0),
                context.getFileDirectories(Globals.prefs.getFilePreferences()).get(0),
                context.getFileDirectories(Globals.prefs.getFilePreferences()).get(0));
    }

}
