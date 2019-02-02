package com.sachinkrdkflare.pehlishuruaat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Walkthrough extends Activity {

    public ViewPager mSlideViewPager;
    public LinearLayout mDotLayout;

    public TextView[] mDots;

    public SliderAdapter sliderAdapter;

    public Button mNextBtn;
    public Button mBackBtn;

    public int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough_layout);


        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);

        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener;

    {
        viewListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                addDotsIndicator(i);
                mCurrentPage = i;

                if (i == 0) {

                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(false);
                    mBackBtn.setVisibility(View.INVISIBLE);

                    mNextBtn.setText("Next");
                    mBackBtn.setText("");
                } else if (i == mDots.length - 1) {

                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.VISIBLE);

                    mNextBtn.setText("Finish");
                    mBackBtn.setText("Back");
                } else {

                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.VISIBLE);

                    mNextBtn.setText("Next");
                    mBackBtn.setText("Back");
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };
    }
}
