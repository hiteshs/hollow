package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.custom.HollowObjectTypeAPI;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class StreamDeploymentTypeAPI extends HollowObjectTypeAPI {

    private final StreamDeploymentDelegateLookupImpl delegateLookupImpl;

    public StreamDeploymentTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "deploymentInfo",
            "deploymentLabel",
            "deploymentPriority",
            "s3PathComponent",
            "s3FullPath"
        });
        this.delegateLookupImpl = new StreamDeploymentDelegateLookupImpl(this);
    }

    public int getDeploymentInfoOrdinal(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleReferencedOrdinal("StreamDeployment", ordinal, "deploymentInfo");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[0]);
    }

    public StreamDeploymentInfoTypeAPI getDeploymentInfoTypeAPI() {
        return getAPI().getStreamDeploymentInfoTypeAPI();
    }

    public int getDeploymentLabelOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("StreamDeployment", ordinal, "deploymentLabel");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public StreamDeploymentLabelSetTypeAPI getDeploymentLabelTypeAPI() {
        return getAPI().getStreamDeploymentLabelSetTypeAPI();
    }

    public int getDeploymentPriority(int ordinal) {
        if(fieldIndex[2] == -1)
            return missingDataHandler().handleInt("StreamDeployment", ordinal, "deploymentPriority");
        return getTypeDataAccess().readInt(ordinal, fieldIndex[2]);
    }

    public Integer getDeploymentPriorityBoxed(int ordinal) {
        int i;
        if(fieldIndex[2] == -1) {
            i = missingDataHandler().handleInt("StreamDeployment", ordinal, "deploymentPriority");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[2]);
            i = getTypeDataAccess().readInt(ordinal, fieldIndex[2]);
        }
        if(i == Integer.MIN_VALUE)
            return null;
        return Integer.valueOf(i);
    }



    public int getS3PathComponentOrdinal(int ordinal) {
        if(fieldIndex[3] == -1)
            return missingDataHandler().handleReferencedOrdinal("StreamDeployment", ordinal, "s3PathComponent");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[3]);
    }

    public StringTypeAPI getS3PathComponentTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getS3FullPathOrdinal(int ordinal) {
        if(fieldIndex[4] == -1)
            return missingDataHandler().handleReferencedOrdinal("StreamDeployment", ordinal, "s3FullPath");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[4]);
    }

    public StringTypeAPI getS3FullPathTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public StreamDeploymentDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}