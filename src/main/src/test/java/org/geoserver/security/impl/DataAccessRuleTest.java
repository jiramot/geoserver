/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.impl;

import static org.junit.Assert.*;

import org.geoserver.security.AccessMode;
import org.geoserver.security.impl.DataAccessRule;
import org.junit.Test;

import junit.framework.TestCase;

public class DataAccessRuleTest {

    @Test
    public void testEqualRoot() {
        DataAccessRule rule1 = new DataAccessRule("*", "*", AccessMode.READ);
        DataAccessRule rule2 = new DataAccessRule("*", "*", AccessMode.READ);
        assertEquals(0, rule1.compareTo(rule2));
        assertEquals(rule1, rule2);
        assertEquals(rule1.hashCode(), rule2.hashCode());
    }
    
    @Test
    public void testDifferentRoot() {
        DataAccessRule rule1 = new DataAccessRule("*", "*", AccessMode.READ);
        DataAccessRule rule2 = new DataAccessRule("*", "*", AccessMode.WRITE);
        assertEquals(-1, rule1.compareTo(rule2));
        assertFalse(rule1.equals(rule2));
    }
    
    @Test
    public void testDifferenPath() {
        DataAccessRule rule1 = new DataAccessRule("topp", "layer1", AccessMode.READ);
        DataAccessRule rule2 = new DataAccessRule("topp", "layer2", AccessMode.READ);
        assertEquals(-1, rule1.compareTo(rule2));
        assertFalse(rule1.equals(rule2));
    }
}
