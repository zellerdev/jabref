package org.jabref.gui.worker.bibsonomy;

import org.jabref.bibsonomy.BibSonomyProperties;

import org.jabref.gui.JabRefFrame;
import org.jabref.gui.util.bibsonomy.JabRefFileFactory;
import org.jabref.gui.worker.AbstractWorker;

import org.bibsonomy.model.logic.LogicInterface;
import org.bibsonomy.rest.client.RestLogicFactory;
import org.bibsonomy.rest.client.util.FileFactory;

/**
 * {@link AbstractBibSonomyWorker} is the base for all Workers which need to support stopping execution.
 *
 * @author Waldemar Biller <biller@cs.uni-kassel.de>
 */
public abstract class AbstractBibSonomyWorker extends AbstractWorker {

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
		return new RestLogicFactory(BibSonomyProperties.getApiUrl(), RestLogicFactory.DEFAULT_RENDERING_FORMAT, RestLogicFactory.DEFAULT_CALLBACK_FACTORY, fileFactory).getLogicAccess(BibSonomyProperties.getUsername(), BibSonomyProperties.getApiKey());
	}
}
