package com.cartoonjumper;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AndroidLauncher extends AndroidApplication implements AdHandler {
	private InterstitialAd interstitialAd;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new com.cartoonjumper.game.MainGame(this), config);
		interstitialAd = new InterstitialAd(this);

		interstitialAd.setAdUnitId("ca-app-pub-6306276344364522/9269703751");
		AdRequest.Builder builder1 = new AdRequest.Builder();

		AdRequest ad = builder1.build();

		interstitialAd.loadAd(ad);
	}
	@Override
	public void showAds(boolean show) {

	}

	public void showInterstitialAd(final Runnable then) {

		runOnUiThread(new Runnable() {



			public void run() {

				if (then != null) {

					interstitialAd.setAdListener(new AdListener() {



						public void onAdClosed() {



							Gdx.app.postRunnable(then);

							AdRequest.Builder builder = new AdRequest.Builder();

							AdRequest ad = builder.build();

							interstitialAd.loadAd(ad);

						}

					});

				}

				interstitialAd.show();

			}

		});

	}
}
