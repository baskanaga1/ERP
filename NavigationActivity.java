package test.jinesh.customnavigation;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<String> menuList;
    ArrayAdapter<String> menuAdapter;
    NavigationView navView;
    DrawerLayout drawerLayout;
    FrameLayout mainContent;
    android.support.v4.app.FragmentTransaction ft;
    private float lastScale = 1.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = (NavigationView) findViewById(R.id.navView);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        FirstFragment firstFragment = new FirstFragment();
        ft = getSupportFragmentManager().beginTransaction();
        mainContent=(FrameLayout)findViewById(R.id.mainContent);
        ft.add(R.id.mainContent, firstFragment).commit();
        navView.inflateHeaderView(R.layout.header);
        navView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
              float min = 0.85f;
                float max = 1.0f;
                float scaleFactor = (max - ((max - min) * slideOffset));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                {
                  //  mainContent.setScaleX(scaleFactor);
                    mainContent.setScaleY(scaleFactor);
                }
                else
                {
                    ScaleAnimation anim = new ScaleAnimation(lastScale, scaleFactor, lastScale, scaleFactor, mainContent.getWidth()/2, mainContent.getHeight()/2);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    mainContent.startAnimation(anim);

                    lastScale = scaleFactor;
                }
                drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
                drawerLayout.setDrawerShadow(R.drawable.rectangle_shadow, GravityCompat.START);
                drawerLayout.getChildAt(0).setTranslationX(slideOffset * drawerView.getWidth());
                drawerLayout.bringChildToFront(drawerView);
                drawerLayout.requestLayout();
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                /*ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mainContent.getLayoutParams();
                params.setMargins(0, 0, 0, 0);
                mainContent.setLayoutParams(params);*/
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.dashboard:
                FirstFragment firstFragment = new FirstFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, firstFragment).commit();
                break;
            case R.id.quick_pay:
                SecondFragment secondFragment = new SecondFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, secondFragment).commit();
                break;
            case R.id.maintenance:
                ThirdFragment thirdFragment = new ThirdFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, thirdFragment).commit();
                break;
            case R.id.news_events:
                FourthFragment fourthFragment = new FourthFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, fourthFragment).commit();
                break;
            case R.id.discussion:
                FourthFragment seventhFragment = new FourthFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, seventhFragment).commit();
                break;
            case R.id.general_poll:
                FourthFragment fifthFragment = new FourthFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, fifthFragment).commit();
                break;
            case R.id.contact_us:
                FourthFragment sixthFragment = new FourthFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContent, sixthFragment).commit();
                break;
        }
        return true;
    }
}
