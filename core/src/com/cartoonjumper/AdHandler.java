package com.cartoonjumper;

/**
 * Created by vaibh on 8/2/2017.
 */

public interface AdHandler {
    public void showAds(boolean show) ;
    public void showInterstitialAd(Runnable then);
}
