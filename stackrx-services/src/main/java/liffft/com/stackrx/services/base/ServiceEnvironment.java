package liffft.com.stackrx.services.base;

import com.google.inject.Singleton;

/**
 * Created by pair on 4/6/15.
 */
@Singleton
public class ServiceEnvironment {

    private static ServiceParameters secureParameters;

    public ServiceEnvironment () {
        secureParameters = new ServiceParameters("https://api.stackexchange.com", "PRODUCTION");
        secureParameters.putQueryParameter("format", "json");
        secureParameters.putHeader("Accept", "application/json");
        secureParameters.putHeader("Content-Type", "application/json");
    }

    public ServiceParameters getSecureParameters() {
        return secureParameters;
    }

}
