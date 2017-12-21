package com.taradevko.aem.customexporter;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Metadata {

    @Inject
    @Named("jcr:primaryType")
    private String primaryType;

    @Inject
    @Optional
    @Named("jcr:mixinTypes")
    private String[] mixingTypes;

    public String getPrimaryType() {
        return primaryType;
    }

    public String[] getMixingTypes() {
        return mixingTypes;
    }
}
