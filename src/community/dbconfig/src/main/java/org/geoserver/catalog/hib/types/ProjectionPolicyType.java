/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.catalog.hib.types;

import org.geoserver.catalog.ProjectionPolicy;
import org.geoserver.hibernate.types.EnumUserType;

public class ProjectionPolicyType extends EnumUserType<ProjectionPolicy> {

    public ProjectionPolicyType() {
        super(ProjectionPolicy.class);
    }

}
