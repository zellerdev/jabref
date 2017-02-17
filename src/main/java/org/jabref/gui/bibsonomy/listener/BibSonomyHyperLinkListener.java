package org.jabref.gui.bibsonomy.listener;

import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;

import org.jabref.gui.JabRefFrame;
import org.jabref.gui.actions.bibsonomy.AbstractBibSonomyAction;
import org.jabref.gui.bibsonomy.GroupingComboBoxItem;
import org.jabref.gui.bibsonomy.SearchType;
import org.jabref.gui.worker.bibsonomy.ImportPostsByCriteriaWorker;

/**
 * {@link BibSonomyHyperLinkListener} runs the {@link ImportPostsByCriteriaWorker} as soon as
 * the user clicks on a hyperlink in the tag cloud.
 */
public class BibSonomyHyperLinkListener extends AbstractBibSonomyAction implements HyperlinkListener {

	private JComboBox<?> visibilityComboBox;

	public void hyperlinkUpdate(HyperlinkEvent e) {

		if (e.getEventType() == EventType.ACTIVATED) {
			StringTokenizer tokenizer = new StringTokenizer(e.getDescription(), " ");
			if (tokenizer.hasMoreElements()) {

				String criteria = tokenizer.nextToken();
				ImportPostsByCriteriaWorker worker = new ImportPostsByCriteriaWorker(getJabRefFrame(), criteria, SearchType.TAGS, ((GroupingComboBoxItem) visibilityComboBox.getSelectedItem()).getKey(), ((GroupingComboBoxItem) visibilityComboBox.getSelectedItem()).getValue(), false);
				performAsynchronously(worker);
			}

		}
	}

	public BibSonomyHyperLinkListener(JabRefFrame jabRefFrame, JComboBox<?> visibilityComboBox) {
		super(jabRefFrame, null, null);
		this.visibilityComboBox = visibilityComboBox;
	}

	public void actionPerformed(ActionEvent e) {}

}
