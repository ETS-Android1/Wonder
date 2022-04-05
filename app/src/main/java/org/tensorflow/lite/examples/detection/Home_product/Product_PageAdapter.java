package org.tensorflow.lite.examples.detection.Home_product;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Product_PageAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public Product_PageAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount=pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Product_food product_food = new Product_food();
                return product_food;


            case 1:
                Product_wash product_wash = new Product_wash();
                return product_wash;


            case 2:
                Product_face product_face = new Product_face();
                return product_face;

            case 3:
                Product_body product_body = new Product_body();
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
