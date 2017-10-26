package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

@SuppressWarnings("all")
public class CodecPrivateDataStringPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<VMSHollowInputAPI, CodecPrivateDataStringHollow> {

    public CodecPrivateDataStringPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, ((HollowObjectSchema)consumer.getStateEngine().getSchema("CodecPrivateDataString")).getPrimaryKey().getFieldPaths());
    }

    public CodecPrivateDataStringPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, true, fieldPaths);
    }

    public CodecPrivateDataStringPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefreah, String... fieldPaths) {
        super(consumer, "CodecPrivateDataString", isListenToDataRefreah, fieldPaths);
    }

    public CodecPrivateDataStringHollow findMatch(Object... keys) {
        int ordinal = idx.getMatchingOrdinal(keys);
        if(ordinal == -1)
            return null;
        return api.getCodecPrivateDataStringHollow(ordinal);
    }

}