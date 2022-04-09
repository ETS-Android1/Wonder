package org.tensorflow.lite.examples.detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.tensorflow.lite.examples.detection.AR.Fragment_ar;
import org.tensorflow.lite.examples.detection.Exp.Fragment_exp;
import org.tensorflow.lite.examples.detection.Home.Fragment_home;
import org.tensorflow.lite.examples.detection.Home.Home_loca_list;
import org.tensorflow.lite.examples.detection.Home.Home_loca_map;
import org.tensorflow.lite.examples.detection.Home_product.Home_product;
import org.tensorflow.lite.examples.detection.Home.Home_shops;
import org.tensorflow.lite.examples.detection.Home_product.Product_body;
import org.tensorflow.lite.examples.detection.Home_product.Product_face;
import org.tensorflow.lite.examples.detection.Home_product.Product_food;
import org.tensorflow.lite.examples.detection.Home_product.Product_wash;

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

    Fragment fragment1, fragment2, fragment3, fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Product_food();
        fragment2 = new Product_wash();
        fragment3 = new Product_body();
        fragment4 = new Product_face();

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
                ft.replace(R.id.main_frame, home_product);
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