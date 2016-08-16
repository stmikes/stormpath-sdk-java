package com.stormpath.sdk.impl.config;

import com.stormpath.sdk.cache.CacheConfigurationBuilder;
import com.stormpath.sdk.client.AuthenticationScheme;
import com.stormpath.sdk.client.ClientCredentials;
import com.stormpath.sdk.authc.RequestAuthenticatorFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class holds the default configuration properties.
 *
 * During application initialization all the properties found in the pre-defined locations that are
 * defined by the user will be added here in the order defined in {@link com.stormpath.sdk.impl.client.DefaultClientBuilder}.
 * Unset values will use default values from {@link com/stormpath/sdk/config/stormpath.properties}.
 *
 * @since 1.0.0
 */
public class ClientConfiguration {

    private String apiKeyFile;
    private String apiKeyId;
    private String apiKeySecret;
    private boolean cacheManagerEnabled;
    private long cacheManagerTtl;
    private long cacheManagerTti;
    private Map<String, CacheConfigurationBuilder> cacheManagerCaches = new LinkedHashMap<>();
    private String baseUrl;
    private int connectionTimeout;
    private AuthenticationScheme authenticationScheme;
    private RequestAuthenticatorFactory requestAuthenticatorFactory;
    private ClientCredentials clientCredentials;
    private int proxyPort;
    private String proxyHost;
    private String proxyUsername;
    private String proxyPassword;

    public String getApiKeyFile() {
        return apiKeyFile;
    }

    public void setApiKeyFile(String apiKeyFile) {
        this.apiKeyFile = apiKeyFile;
    }

    public String getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(String apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public String getApiKeySecret() {
        return apiKeySecret;
    }

    public void setApiKeySecret(String apiKeySecret) {
        this.apiKeySecret = apiKeySecret;
    }

    public AuthenticationScheme getAuthenticationScheme() {
        return authenticationScheme;
    }

    public void setAuthenticationScheme(AuthenticationScheme authenticationScheme) {
        this.authenticationScheme = authenticationScheme;
    }

    public RequestAuthenticatorFactory getRequestAuthenticatorFactory() {
        return requestAuthenticatorFactory;
    }

    public void setRequestAuthenticatorFactory(RequestAuthenticatorFactory requestAuthenticatorFactory) {
        this.requestAuthenticatorFactory = requestAuthenticatorFactory;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isCacheManagerEnabled() {
        return cacheManagerEnabled;
    }

    public void setCacheManagerEnabled(boolean cacheManagerEnabled) {
        this.cacheManagerEnabled = cacheManagerEnabled;
    }

    public Map<String, CacheConfigurationBuilder> getCacheManagerCaches() {
        return cacheManagerCaches;
    }

    public void setCacheManagerCaches(Map<String, CacheConfigurationBuilder> cacheManagerCaches) {
        this.cacheManagerCaches = cacheManagerCaches;
    }

    public long getCacheManagerTti() {
        return cacheManagerTti;
    }

    public void setCacheManagerTti(long cacheManagerTti) {
        this.cacheManagerTti = cacheManagerTti;
    }

    public long getCacheManagerTtl() {
        return cacheManagerTtl;
    }

    public void setCacheManagerTtl(long cacheManagerTtl) {
        this.cacheManagerTtl = cacheManagerTtl;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    public ClientCredentials getClientCredentials() {
        return clientCredentials;
    }

    public void setClientCredentials(ClientCredentials clientCredentials) {
        this.clientCredentials = clientCredentials;
    }
    @Override
    public String toString() {
        return "ClientConfiguration{" +
                "apiKeyFile='" + apiKeyFile + '\'' +
                ", apiKeyId='" + apiKeyId + '\'' +
                ", apiKeySecret='" + apiKeySecret + '\'' +
                ", cacheManagerTtl=" + cacheManagerTtl +
                ", cacheManagerTti=" + cacheManagerTti +
                ", cacheManagerCaches=" + cacheManagerCaches +
                ", baseUrl='" + baseUrl + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", authenticationScheme=" + authenticationScheme +
                ", proxyPort=" + proxyPort +
                ", proxyHost='" + proxyHost + '\'' +
                ", proxyUsername='" + proxyUsername + '\'' +
                ", proxyPassword='" + proxyPassword + '\'' +
                '}';
    }
}
