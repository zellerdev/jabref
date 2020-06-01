package org.jabref.bibsonomy.util;

public class PluginCallBack implements CallBack {

	private AbstractPluginWorker worker;

	public void stopFetching() {

		if(worker != null)
			worker.stopFetching();

	}

	public PluginCallBack(AbstractPluginWorker pluginWorker) {

		this.worker = pluginWorker;
	}
}
