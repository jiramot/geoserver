/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.importer.web;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.wicket.model.IModel;
import org.geoserver.web.wicket.GeoServerDataProvider;
import org.geoserver.importer.ImportContext;

public class ImportContextProvider extends GeoServerDataProvider<ImportContext> {
    public static Property<ImportContext> ID = new BeanProperty("id", "id");
    public static Property<ImportContext> STATE = new BeanProperty("state", "state");
    public static Property<ImportContext> CREATED = new BeanProperty("created", "created");
    public static Property<ImportContext> UPDATED = new BeanProperty("updated", "updated");

    boolean sortByUpdated = false;

    public ImportContextProvider() {
        this(false);
    }

    public ImportContextProvider(boolean sortByUpdated) {
        this.sortByUpdated = sortByUpdated;
    }

    @Override
    protected List<Property<ImportContext>> getProperties() {
        return Arrays.asList(ID, STATE, CREATED, UPDATED);
    }
    @Override
    protected List<ImportContext> getItems() {
        return IteratorUtils.toList(ImporterWebUtils.importer().getAllContexts() );
    }

    @Override
    protected IModel newModel(Object object) {
        return new ImportContextModel((ImportContext) object);
    }
}
