package test.jinesh.customnavigation;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    LinearLayout dashboard_circlelayout,reference_circlelayout;
    ImageView home_Select,reference_Select,project_select,add_Select,profile_Select;
    TextView REFERENCEtext;
    LinearLayout project_select_lay,reference_Select_lay,home_Select_lay,profile_Select_lay;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_activity_content, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.navIcon);
        TextView action_name = (TextView)  view.findViewById(R.id.action_name);
        Typeface action_name_type = Typeface.createFromAsset(getActivity().getAssets(),"UBUNTU-LIGHT.TTF");
        action_name.setTypeface(action_name_type);
        dashboard_circlelayout = (LinearLayout)view.findViewById(R.id.dashboard_circlelayout);
        reference_circlelayout = (LinearLayout)view.findViewById(R.id.reference_circlelayout);
        home_Select= (ImageView) view.findViewById(R.id.home_Select);
        reference_Select= (ImageView)view.findViewById(R.id.reference_Select);
        project_select = (ImageView) view.findViewById(R.id.project_select);

        project_select_lay =(LinearLayout) view.findViewById(R.id.project_select_lay) ;
        //reference_Select_lay=(LinearLayout) view.findViewById(R.id.reference_Select_lay) ;
        profile_Select_lay=(LinearLayout) view.findViewById(R.id.profile_Select_lay) ;
        home_Select_lay=(LinearLayout) view.findViewById(R.id.home_Select_lay) ;

        REFERENCEtext  = (TextView) view.findViewById(R.id.REFERENCEtext);
        profile_Select  = (ImageView)view.findViewById(R.id.profile_Select);
        dashboard_circlelayout.setVisibility(View.GONE);
        home_Select.setVisibility(View.VISIBLE);
        reference_circlelayout.setVisibility(View.VISIBLE);
        reference_Select.setVisibility(View.GONE);
        REFERENCEtext.setVisibility(View.GONE);


        profile_Select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("reference clicked");
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();
            }
        });

        project_select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("reference clicked");
                 SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();
            }
        });

        home_Select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("reference clicked");
                FirstFragment secondFragment = new FirstFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();
            }
        });


      /*  reference_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("reference clicked");
                ThirdFragment secondFragment = new ThirdFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();
            }
        });*/

        final NavigationActivity navigationActivity = (NavigationActivity) getActivity();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationActivity.drawerLayout.openDrawer(navigationActivity.navView);
            }
        });
        return view;
    }
}
