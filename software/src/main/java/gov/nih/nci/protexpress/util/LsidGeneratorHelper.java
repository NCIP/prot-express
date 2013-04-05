/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.domain.ConfigParamEnum;

/**
 * Helper class to generate the appropriate LSID values. LSIDs are multi-part
 * strings with the parts separated by colons, withe the form:
 *        urn:lsid:AuthorityID:NamespaceID:ObjectID:RevisionID
 * where,
 *        AuthorityID: An Internet domain name.
 *        NamespaceID: A namespace identifier, unique within the authority.
 *        ObjectID: An object identifier, unique within the namespace.
 *        RevisionID: An optional version string.
 *
 * @author Krishna Kanchinadam
 */

//urn:lsid:genologics.com:Experiment.pub1:Project.77.3

public final class LsidGeneratorHelper {
    /**
     * Default constructor.
     *
     */
    private LsidGeneratorHelper() {
    }

    /**
     * Given a ConfigParamEnum and the object id, returns the appropriate LSID string.
     *
     * @param configParamEnum the ConfigParamEnum.
     * @param objectId id of the object for which the LSID is to be generated.
     * @return the LSID string.
     */
    public static String getLsid(ConfigParamEnum configParamEnum, Long objectId) {
        return getLsid(configParamEnum.name(), objectId.toString());
    }

    /**
     * Given a ConfigParamEnum and the string id, returns the appropriate LSID string.
     *
     * @param configParamEnum the ConfigParamEnum.
     * @param objectId string id of the object for which the LSID is to be generated.
     * @return the LSID string.
     */
    public static String getLsid(ConfigParamEnum configParamEnum, String objectId) {
        return getLsid(configParamEnum.name(), objectId);
    }

    private static String getLsid(String configParamEnumName, String objectId) {
        StringBuffer objectLsid = new StringBuffer();
        return objectLsid
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_BASE.name()))
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_SEPARATOR.name()))
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_AUTHORITY.name()))
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_SEPARATOR.name()))
        .append(ConfigurationHelper.getConfiguration().getString(configParamEnumName))
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_SEPARATOR.name()))
        .append(objectId)
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_SEPARATOR.name()))
        .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.LSID_REVISION.name()))
        .toString();

    }
}
