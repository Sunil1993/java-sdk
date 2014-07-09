package com.unbxd.client;

import com.unbxd.client.autosuggest.AutoSuggestClient;
import com.unbxd.client.autosuggest.AutoSuggestClientFactory;
import com.unbxd.client.feed.FeedClient;
import com.unbxd.client.feed.FeedClientFactory;
import com.unbxd.client.recommendations.RecommendationsClient;
import com.unbxd.client.recommendations.RecommendationsClientFactory;
import com.unbxd.client.search.SearchClient;
import com.unbxd.client.search.SearchClientFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sourabh
 * Date: 07/07/14
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Unbxd {

    private static boolean _configured = false;

    private static String siteKey;
    private static String apiKey;
    private static String secretKey;
    private static boolean secure = false;

    private Unbxd(){}

    public static void configure(String siteKey, String apiKey, String secretKey){
        Unbxd.siteKey = siteKey;
        Unbxd.apiKey = apiKey;
        Unbxd.secretKey = secretKey;

        _configured = true;
    }

    public static void configure(String siteKey, String apiKey, String secretKey, boolean secure){
        Unbxd.configure(siteKey, apiKey, secretKey);
        Unbxd.secure = secure;
    }

    // Should return a new FeedClient
    public static FeedClient getFeedClient() throws ConfigException {
        if(!_configured)
            throw new ConfigException("Please configure first with Unbxd.configure()");
        return FeedClientFactory.getFeedClient(siteKey, secretKey, secure);
    }

    // Should return a new SearchClient
    public static SearchClient getSearchClient() throws ConfigException {
        if(!_configured)
            throw new ConfigException("Please configure first with Unbxd.configure()");
        return SearchClientFactory.getSearchClient(siteKey, apiKey, secure);
    }

    // Should return a new AutoSuggestClient
    public static AutoSuggestClient getAutoSuggestClient() throws ConfigException {
        if(!_configured)
            throw new ConfigException("Please configure first with Unbxd.configure()");
        return AutoSuggestClientFactory.getAutoSuggestClient(siteKey, apiKey, secure);
    }

    // Should return a new RecommenderClient
    public static RecommendationsClient getRecommendationsClient() throws ConfigException {
        if(!_configured)
            throw new ConfigException("Please configure first with Unbxd.configure()");
        return RecommendationsClientFactory.getRecommendationsClient(siteKey, apiKey, secure);
    }
}
