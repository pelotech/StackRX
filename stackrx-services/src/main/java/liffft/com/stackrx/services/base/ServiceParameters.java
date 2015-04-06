package liffft.com.stackrx.services.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Parameters containing endpoint, header, and query parameters for a service.
 */

public class ServiceParameters {
    private final String url;
    private final String endpoint;

    private final Map<String, String> queryParams = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public boolean ignoreCerts = false;

    public ServiceParameters(String url, String endpoint) {
        this.url = url;
        this.endpoint = endpoint;
    }

    public void putQueryParameter(String key, String value) {
        queryParams.put(key, value);
    }

    public void putHeader(String key, String value) {
        headers.put(key, value);
    }

    public Set<Map.Entry<String, String>> getQueryParams() {
        return queryParams.entrySet();
    }

    public Set<Map.Entry<String, String>> getHeaders() {
        return headers.entrySet();
    }

    public String getUrl() {
        return url;
    }
    
    public String getEndpoint() {
        return endpoint;
    }
}
