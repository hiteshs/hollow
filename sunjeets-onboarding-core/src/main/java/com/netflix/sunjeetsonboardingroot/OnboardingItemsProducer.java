package com.netflix.sunjeetsonboardingroot;

import com.google.inject.Inject;
import com.netflix.cinder.producer.CinderProducerBuilder;
import com.netflix.hollow.api.producer.HollowProducer;
import com.netflix.sunjeetsonboardingroot.OnboardingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnboardingItemsProducer {

    private static final String DEFAULT_NAMESPACE = "SunjeetsOnboardingItems.v1";
    private HollowProducer producer;

    private static final Logger logger = LoggerFactory.getLogger(OnboardingItemsProducer.class);

    @Inject
    public OnboardingItemsProducer(CinderProducerBuilder.Factory producerBuilder) {

        logger.info("SNAP: Injecting OnboardingItemsProducer instance");

        producer = producerBuilder.get()
                .forNamespace(DEFAULT_NAMESPACE)
                .withRestore()
                .withSingleProducerEnforcer()
                .build();

        producer.initializeDataModel(OnboardingItem.class);

        // To develop locally using local storage:
        // producer = HollowProducerProxyBuilder.localProxyForDevEnvironment("my-unique-namespace", "path-on-local-disk").build();
    }


    public void publishData(boolean isPrimaryProducer) {

        // producer.enablePrimaryProducer(isPrimaryProducer);
        producer.enablePrimaryProducer(true);
        try {

            producer.runCycle(state -> {
                long l = System.currentTimeMillis();
                state.add(new OnboardingItem(1, "Software Engineer Bootcamp", true));
                state.add(new OnboardingItem(2, "Cinder Hello World", true));
                state.add(new OnboardingItem(3, "Coldstarts with Tim", true));
                state.add(new OnboardingItem(4, "History of VMS with Lavanya", true));
                state.add(new OnboardingItem(5, "Eventprocessing with Tim", true));
                state.add(new OnboardingItem(6, "Future of VMS with Lavanya", true));
                state.add(new OnboardingItem(7, "VMS data model with David", true));
                state.add(new OnboardingItem(8, "Gutenberg with Kinesh", true));
                state.add(new OnboardingItem(9, "ULog with David", true));
                state.add(new OnboardingItem(10, "Oncall stuff with Jatin", false));
                state.add(new OnboardingItem(11, "Hollow metrics revamp", true));
                state.add(new OnboardingItem(12, "Cinder metrics revamp", true));
                state.add(new OnboardingItem(13, "Cinder release", true));
                state.add(new OnboardingItem(14, "Sunjeet Debugging leader election " + l, true));
            });
        } finally {
            producer.enablePrimaryProducer(false);
        }

    }

}