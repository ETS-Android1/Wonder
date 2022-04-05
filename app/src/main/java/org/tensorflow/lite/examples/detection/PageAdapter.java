package org.tensorflow.lite.examples.detection;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public PageAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount=pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                product_food product_food = new product_food();
                return product_food;


            case 1:
                product_wash product_wash = new product_wash();
                return product_wash;


            case 2:
                product_face product_face = new product_face();
                return product_face;

            case 3:
                product_body product_body = new product_body();
                return product_body;

            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return mPageCount;
    }
}
