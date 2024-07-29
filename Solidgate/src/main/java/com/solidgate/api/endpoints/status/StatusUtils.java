package com.solidgate.api.endpoints.status;

import static java.util.Objects.nonNull;
import static org.awaitility.Awaitility.await;

public class StatusUtils {

    StatusRequests statusRequests;

    public StatusUtils(StatusRequests statusRequests) {
        this.statusRequests = statusRequests;
    }

    public void waitUntilSuccessStatus() {
        await().until(() -> nonNull(statusRequests.getStatus().getOrder()) && statusRequests.getStatus().getOrder().getStatus().equals("settle_ok"));
    }
}