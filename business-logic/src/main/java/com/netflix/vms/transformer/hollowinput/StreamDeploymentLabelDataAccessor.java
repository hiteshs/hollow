package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.data.AbstractHollowDataAccessor;
import com.netflix.hollow.core.index.key.PrimaryKey;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;

@SuppressWarnings("all")
public class StreamDeploymentLabelDataAccessor extends AbstractHollowDataAccessor<StreamDeploymentLabelHollow> {

    public static final String TYPE = "StreamDeploymentLabelHollow";
    private VMSHollowInputAPI api;

    public StreamDeploymentLabelDataAccessor(HollowConsumer consumer) {
        super(consumer, TYPE);
        this.api = (VMSHollowInputAPI)consumer.getAPI();
    }

    public StreamDeploymentLabelDataAccessor(HollowReadStateEngine rStateEngine, VMSHollowInputAPI api) {
        super(rStateEngine, TYPE);
        this.api = api;
    }

    public StreamDeploymentLabelDataAccessor(HollowReadStateEngine rStateEngine, VMSHollowInputAPI api, String ... fieldPaths) {
        super(rStateEngine, TYPE, fieldPaths);
        this.api = api;
    }

    public StreamDeploymentLabelDataAccessor(HollowReadStateEngine rStateEngine, VMSHollowInputAPI api, PrimaryKey primaryKey) {
        super(rStateEngine, TYPE, primaryKey);
        this.api = api;
    }

    @Override public StreamDeploymentLabelHollow getRecord(int ordinal){
        return api.getStreamDeploymentLabelHollow(ordinal);
    }

}