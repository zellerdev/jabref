package org.jabref.gui.util.bibsonomy;

import java.util.Optional;

import org.jabref.bibsonomy.BibSonomyGlobals;

import org.bibsonomy.rest.client.util.MultiDirectoryFileFactory;
import org.jabref.gui.JabRefFrame;

public class JabRefFileFactory extends MultiDirectoryFileFactory {

	private final JabRefFrame jabRefFrame;

	public JabRefFileFactory(JabRefFrame jabRefFrame) {
		super(null, null, null);
		this.jabRefFrame = jabRefFrame;
	}

	@Override
	public String getPsDirectory() {
		String psFileDir = JabRefGlobalsHelper.getDBSpecificPSDirectory(jabRefFrame);
		if (psFileDir != null) return psFileDir;

		return getFileDirectory();
	}

	@Override
	public String getPdfDirectory() {
		String pdfFileDir = JabRefGlobalsHelper.getDBSpecificPDFDirectory(jabRefFrame);
		if (pdfFileDir != null) return pdfFileDir;

		return getFileDirectory();
	}

	@Override
	public String getFileDirectory() {
		String fileDir = JabRefGlobalsHelper.getDBSpecificUserFileDirIndividual(jabRefFrame);
		if (fileDir != null) return fileDir;

		fileDir = JabRefGlobalsHelper.getDBSpecificUserFileDir(jabRefFrame);
		if (fileDir != null) return fileDir;

		Optional<String> fileDirectoryOpt = jabRefFrame.getCurrentBasePanel().getBibDatabaseContext().getMetaData().getDefaultFileDirectory();
		if (jabRefFrame.getCurrentBasePanel().getBibDatabaseContext().getMetaData() != null && fileDirectoryOpt.isPresent()) {
			return fileDirectoryOpt.get();

		}

		return BibSonomyGlobals.BIBSONOMY_FILE_DIRECTORY;
	}

}
