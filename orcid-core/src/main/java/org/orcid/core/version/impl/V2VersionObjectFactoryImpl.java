/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.core.version.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.orcid.core.version.V2VersionObjectFactory;

/**
 * 
 * @author Will Simpson
 *
 */
public class V2VersionObjectFactoryImpl implements V2VersionObjectFactory {

    private final ConcurrentHashMap<Pair<Class<?>, String>, Class<?>> classMap = new ConcurrentHashMap<>();

    @Override
    public Object createEquivalentInstance(Object originalObject, String requiredVersion) {
        Class<?> originalClass = originalObject.getClass();
        Pair<Class<?>, String> key = new ImmutablePair<>(originalClass, requiredVersion);
        Class<?> requiredClass = classMap.get(key);
        if (requiredClass == null) {
            requiredClass = createClass(originalClass, requiredVersion);
            classMap.put(key, requiredClass);
        }
        return createInstance(requiredClass);
    }

    private Class<?> createClass(Class<?> originalClass, String requiredVersion) {
        try {
            return Class.forName(calculateClassFullName(originalClass, requiredVersion));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find equivalent class for " + originalClass + " in version " + requiredVersion, e);
        }
    }

    private String calculateClassFullName(Class<?> originalClass, String requiredVersion) {
        String requiredMinorVersion = requiredVersion.substring(requiredVersion.lastIndexOf('_') + 1);
        String originalPackageName = originalClass.getPackage().getName();
        String packageNameBase = originalPackageName.substring(0, originalPackageName.lastIndexOf('_') + 1);
        String originalClassName = originalClass.getSimpleName();
        String requiredClassFullName = packageNameBase + requiredMinorVersion + '.' + originalClassName;
        return requiredClassFullName;
    }

    private Object createInstance(Class<?> requiredClass) {
        try {
            return requiredClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Problem instantiating class " + requiredClass.getName(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Problem accessing class " + requiredClass.getName(), e);
        }
    }

}
