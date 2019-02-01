package com.sachinkrdkflare.pehlishuruaat;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context) {

        this.context = context;

    }

    public int[] slideimages = {

            R.drawable.eat_icons,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    public String[] slide_headlines = {

            "Donate Blood",
            "Find Donors",
            "Search Drives"
    };

    public String[] slide_desc = {
            "Get notified when there is a need of blood with the same blood group as yours. ",
            "Need blood?Is it an emergency?we have hundreds of people ready to do the good",
            "Find blood donation drives happening around the city,or add one yours."

    };

    @Override
    public int getCount() {
        return slide_headlines.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view  = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimages);
        TextView slideheadlines = (TextView) view.findViewById(R.id.slide_headlines);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slideimages[position]);
        slideheadlines.setText(slide_headlines[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);
        
        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
