package com.neelv.adsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity {

    AdView adView;
    InterstitialAd interstitialAd;
    Button interstitialSAdsButton, rewardButton;
    RewardedVideoAd rewardads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sample AdMob App ID : ca-app-pub-1888256288991054/7359399286
        MobileAds.initialize(this, "ca-app-pub-1888256288991054~6976966343");

        adView = (AdView) findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);


        interstitialSAdsButton = (Button) findViewById(R.id.button);
        interstitialAd = new InterstitialAd(this);

        interstitialAd.setAdUnitId("ca-app-pub-1888256288991054~2490038371");
        interstitialSAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interstitialAd.loadAd(adRequest);
                if (interstitialAd.isLoaded())
                    interstitialAd.show();
            }

        });

        rewardads = MobileAds.getRewardedVideoAdInstance(this);
        rewardads.loadAd("ca-app-pub-1888256288991054~2905326562", adRequest);
        rewardButton = (Button) findViewById(R.id.button2);
        rewardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rewardads.isLoaded()) {
                    rewardads.show();
                }

            }
        });
    }
}