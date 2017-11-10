package com.podliva.web.url;

import com.google.common.base.MoreObjects;

public class PapaJonsUrlComposer implements UrlComposer {
    private final String protocol;
    private final String domen;
    private final String apiPath;
    private final String query;
    private final String url;

    public PapaJonsUrlComposer(String protocol, String domen, String apiPath, String query) {
        this.protocol = protocol;
        this.domen = domen;
        this.apiPath = apiPath;
        this.query = query;
        this.url = buildUrl();
    }

    private String buildUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(protocol)
                .append(domen)
                .append(apiPath)
                .append(query);
        return stringBuilder.toString();
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .toString();
    }
}
