package org.tensorflow.lite.examples.detection.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import org.tensorflow.lite.examples.detection.MainActivity;
import org.tensorflow.lite.examples.detection.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_loca_map#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_loca_map extends Fragment {
    MainActivity activity;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_loca_map() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_loca_map.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_loca_map newInstance(String param1, String param2) {
        Home_loca_map fragment = new Home_loca_map();
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
        View v =  inflater.inflate(R.layout.home_loca_map, container, false);

        //홈으로 돌아가기 버튼
        ImageButton back_btn = v.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(0);
            }
        });

        //위치(리스트)로 가는 버튼
        Button to_list_btn = v.findViewById(R.id.to_list_btn);
        to_list_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(5);
            }
        });



        return v;
    }
}