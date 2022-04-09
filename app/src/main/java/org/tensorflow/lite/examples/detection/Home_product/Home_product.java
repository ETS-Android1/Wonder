package org.tensorflow.lite.examples.detection.Home_product;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.tensorflow.lite.examples.detection.MainActivity;
import org.tensorflow.lite.examples.detection.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_product#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_product extends Fragment {
    MainActivity activity;

    private Product_PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int tabCurrentIdx = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_product() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_product.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_product newInstance(String param1, String param2) {
        Home_product fragment = new Home_product();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onAttach(Context context){
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    public void onDetach(){
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_product, container, false);

        //홈으로 돌아가기 버튼
        ImageButton back_btn = v.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {activity.setFrag(0);}
        });

        tabLayout = v.findViewById(R.id.tabs);
        viewPager = v.findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("푸드"));
        tabLayout.addTab(tabLayout.newTab().setText("세제"));
        tabLayout.addTab(tabLayout.newTab().setText("바디"));
        tabLayout.addTab(tabLayout.newTab().setText("페이스"));

        pagerAdapter = new Product_PagerAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(tabCurrentIdx);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabCurrentIdx = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //탭화면
        /*

        private Context mContext;
        private TabLayout mTabLayout;
        private ViewPager mViewPager;
        private Product_PageAdapter mProductPageAdapter;

        mContext = mContext.getApplicationContext();
        mTabLayout=v.findViewById(R.id.tabs);

        mTabLayout.addTab(mTabLayout.newTab().setText("푸드"));
        mTabLayout.addTab(mTabLayout.newTab().setText("세제"));
        mTabLayout.addTab(mTabLayout.newTab().setText("페이스"));
        mTabLayout.addTab(mTabLayout.newTab().setText("바디"));

        mViewPager = v.findViewById(R.id.viewPager);
       // mProductPageAdapter = new Product_PageAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mProductPageAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

       */
        
        
        
        return v;
    }
}