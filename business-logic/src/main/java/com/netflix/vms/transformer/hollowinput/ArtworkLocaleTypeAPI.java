package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.custom.HollowObjectTypeAPI;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class ArtworkLocaleTypeAPI extends HollowObjectTypeAPI {

    private final ArtworkLocaleDelegateLookupImpl delegateLookupImpl;

    public ArtworkLocaleTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "territoryCodes",
            "bcp47Code",
            "effectiveDate",
            "attributes"
        });
        this.delegateLookupImpl = new ArtworkLocaleDelegateLookupImpl(this);
    }

    public int getTerritoryCodesOrdinal(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleReferencedOrdinal("ArtworkLocale", ordinal, "territoryCodes");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[0]);
    }

    public LocaleTerritoryCodeListTypeAPI getTerritoryCodesTypeAPI() {
        return getAPI().getLocaleTerritoryCodeListTypeAPI();
    }

    public int getBcp47CodeOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("ArtworkLocale", ordinal, "bcp47Code");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public StringTypeAPI getBcp47CodeTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getEffectiveDateOrdinal(int ordinal) {
        if(fieldIndex[2] == -1)
            return missingDataHandler().handleReferencedOrdinal("ArtworkLocale", ordinal, "effectiveDate");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[2]);
    }

    public DateTypeAPI getEffectiveDateTypeAPI() {
        return getAPI().getDateTypeAPI();
    }

    public int getAttributesOrdinal(int ordinal) {
        if(fieldIndex[3] == -1)
            return missingDataHandler().handleReferencedOrdinal("ArtworkLocale", ordinal, "attributes");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[3]);
    }

    public ArtworkAttributesTypeAPI getAttributesTypeAPI() {
        return getAPI().getArtworkAttributesTypeAPI();
    }

    public ArtworkLocaleDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}