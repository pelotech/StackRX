package liffft.com.stackrx.services.base;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Base service implementation which handles the Retrofit RestAdapter and service creation.
 * The class template parameter represents the service interface to create from the RestAdapter.
 */
public abstract class BaseService<InterfaceType> {
    private final Class<InterfaceType> interfaceClass;
    private final ServiceParameters serviceParameters;
    private InterfaceType service = null;
    public static final int NETWORK_TIMEOUT_SECONDS = 15;

    /**
     * Setup retrofit with the correct parameters from the environment.
     *
     * @param interfaceClass retrofit interface to different REST endpoints
     * @param parameters     environment parameters
     */
    public BaseService(final Class<InterfaceType> interfaceClass, final ServiceParameters parameters) {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!");
        }
        this.interfaceClass = interfaceClass;
        this.serviceParameters = parameters;

        InitService();
    }

    /**
     * Will verify any SSL cert when not on PRODUCTION environment.
     * @return OkClient for service. non-production environments will verify any ssl cert.
     */
    private OkClient getClient() {

        OkHttpClient client = new OkHttpClient();

            // auto-verify SSL certs for non-production environments.
        try {
                KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                trustStore.load(null, null);

                client.setSslSocketFactory(new TrustEverythingSSLSocketFactory());
                client.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String url, SSLSession sslSession) {
                    return true;
                    }
                });
            client.setConnectTimeout(NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS);

            return new OkClient(client);
        }

        catch (Exception ex) {
            Log.e(BaseService.class.toString(), ex.toString() + "\n" + ex.getMessage());
            return null;
        }

    }

    public void InitService() {
        service = null;
        RequestInterceptor interceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {

                Iterator<Map.Entry<String, String>> itor = serviceParameters.getHeaders().iterator();
                while (itor.hasNext()) {
                    Map.Entry<String, String> entry = itor.next();
                    request.addHeader(entry.getKey(), entry.getValue());
                }

                itor = serviceParameters.getQueryParams().iterator();
                while (itor.hasNext()) {
                    Map.Entry<String, String> entry = itor.next();
                    request.addQueryParam(entry.getKey(), entry.getValue());
                }
            }
        };

        RestAdapter.Builder restAdapterBuilder = new RestAdapter.Builder();

        OkClient pinnedClient = getClient();

        restAdapterBuilder
                .setClient(pinnedClient)
                .setEndpoint(serviceParameters.getUrl())
                .setRequestInterceptor(interceptor)
                .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS);

        RestAdapter restAdapter = restAdapterBuilder.build();

        // Create the service
        service = restAdapter.create(interfaceClass);

    }

    public InterfaceType API() {
        return service;
    }


}
