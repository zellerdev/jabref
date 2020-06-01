package org.jabref.bibsonomy.util;

import java.util.Optional;
import java.util.Set;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.Field;
import org.jabref.model.strings.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BibtexEntryUtil {

    private static final Log LOGGER = LogFactory.getLog(BibtexEntryUtil.class);

    /**
     * Check the (string) equality of two BibTex entries
     *
     * @return true if the entries are the same
     */
    public static boolean areEqual(final BibEntry firstBibEntry, final BibEntry secondBibEntry) {
        final Set<Field> commonFields = firstBibEntry.getFields();
        commonFields.addAll(secondBibEntry.getFields());
        LOGGER.debug("Total nr. of common fields: "
                + commonFields.size());
        for (final Field field : commonFields) {
            BibtexEntryUtil.LOGGER.debug("Comparing field: " + field);
            Optional<String> firstEntryFieldOpt = firstBibEntry.getField(field);
            Optional<String> secondEntryFieldOpt = secondBibEntry.getField(field);

            // fields that should be ignored
            if ((field != null) && !field.getName().startsWith("__")
                    && !"id".equals(field) && !field.getName().isEmpty()
                    && !"timestamp".equals(field)
                    && !"owner".equals(field)) {

                if (firstEntryFieldOpt.isPresent() && secondEntryFieldOpt.isPresent()) {
                    // check if b1 lacks a field that b2 has
                    if (StringUtil.isNullOrEmpty(firstEntryFieldOpt.get())
                            && !StringUtil.isNullOrEmpty(secondEntryFieldOpt.get())) {
                        LOGGER.debug("field " + field
                                + " is null for b1 but not for b2");
                        return false;
                    }
                    // check if b2 lacks a field that b1 has
                    if (StringUtil.isNullOrEmpty(secondEntryFieldOpt.get())
                            && !StringUtil.isNullOrEmpty(firstEntryFieldOpt.get())) {
                        LOGGER.debug("field " + field
                                + " is null for b2 but not for b1");
                        return false;
                    }
                    // check if both are empty/null -> OK
                    if (StringUtil.isNullOrEmpty(firstEntryFieldOpt.get())
                            && StringUtil.isNullOrEmpty(secondEntryFieldOpt.get())) {
                        continue;
                    }
                    // check for fields of b1 if they are the same in b2
                    if (!firstBibEntry.getField(field).equals(secondEntryFieldOpt)) {
                        LOGGER.debug("Found inequality for field: "
                                + field);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
