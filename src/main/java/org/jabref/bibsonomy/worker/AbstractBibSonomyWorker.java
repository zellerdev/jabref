package org.jabref.bibsonomy.worker;

import org.jabref.bibsonomy.BibSonomyProperties;
import org.jabref.gui.JabRefFrame;

import org.bibsonomy.model.logic.LogicInterface;
import org.bibsonomy.rest.client.RestLogicFactory;
import org.bibsonomy.rest.client.util.FileFactory;

public abstract class AbstractBibSonomyWorker {

	private boolean fetchNext = true;
	private final FileFactory fileFactory;
	protected final JabRefFrame jabRefFrame;

	public AbstractBibSonomyWorker(JabRefFrame jabRefFrame) {
		this.jabRefFrame = jabRefFrame;
		this.fileFactory = new JabRefFileFactory(jabRefFrame);
	}

	public synchronized void stopFetching() {

		fetchNext = false;
	}

	protected synchronized boolean fetchNext() {

		return fetchNext;
	}

	protected LogicInterface getLogic() {
		return new RestLogicFactory(BibSonomyProperties.getApiUrl(), RestLogicFactory.DEFAULT_RENDERING_FORMAT, RestLogicFactory.DEFAULT_CALLBACK_FACTORY, fileFactory).getLogicAccess(PluginProperties.getUsername(), PluginProperties.getApiKey());
	}
}
