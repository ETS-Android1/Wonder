package org.tensorflow.lite.examples.detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//프래그먼트들 바꾸는 액티비티
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavi;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment_home frag_home;
    private Fragment_ar frag_ar;
    private Fragment_exp frag_exp;

    private Home_product home_product;
    private Home_loca_map home_loca_map;
    private Home_loca_list home_loca_list;
    private Home_shops home_shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_home=new Fragment_home();
        frag_ar=new Fragment_ar();
        frag_exp=new Fragment_exp();
        setFrag(0);

        home_product = new Home_product();
        home_loca_map = new Home_loca_map();
        home_loca_list = new Home_loca_list();
        home_shops = new Home_shops();


        bottomNavi = findViewById(R.id.bottom_navi);
        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home_fragment:
                        setFrag(0);
                        break;
                    case R.id.ar_fragment:
                        setFrag(1);
                        break;
                    case R.id.exp_fragment:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });


    }
    public void setFrag(int n){
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();

        switch (n)
        {
            case 0: //홈화면
                ft.replace(R.id.main_frame,frag_home);
                ft.commit();
                break;
            case 1: //ar 화면
                ft.replace(R.id.main_frame,frag_ar);
                ft.commit();
                break;
            case 2: //유통기한 화면
                ft.replace(R.id.main_frame,frag_exp);
                ft.commit();
                break;

            case 3: //홈화면 -> 제품화면 으로 이동
                ft.replace(R.id.main_frame,home_product);
                ft.commit();
                break;

            case 4: //홈화면 -> 위치(맵)화면
                ft.replace(R.id.main_frame,home_loca_map);
                ft.commit();
                break;
            case 5: //홈화면 -> 위치(리스트)화면
                ft.replace(R.id.main_frame,home_loca_list);
                ft.commit();
                break;

            case 6: //홈화면 -> 매장확인하기 화면
                ft.replace(R.id.main_frame,home_shops);
                ft.commit();
                break;

        }



    }


}