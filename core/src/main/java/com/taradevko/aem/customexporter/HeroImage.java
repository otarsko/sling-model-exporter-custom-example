package com.taradevko.aem.customexporter;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = Resource.class, resourceType = { "weretail/components/content/heroimage" })
@Exporter(name = "yaml-exporter", extensions = "yaml")
public class HeroImage {

    @Inject
    private String title;

    @Inject
    private String fileReference;

    @Self
    private Metadata metadata;

    public String getTitle() {
        return title;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public String getFileReference() {
        return fileReference;
    }
}
