package test.jinesh.customnavigation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.alexvasilkov.android.commons.ui.Views;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.dant.centersnapreyclerview.SnappingRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import test.jinesh.customnavigation.FoldableLayout.FoldableListLayout;
import test.jinesh.customnavigation.FoldableLayout.GlideHelper;
import test.jinesh.customnavigation.FoldableLayout.UnfoldableView;
import test.jinesh.customnavigation.FoldableLayout.shading.GlanceFoldShading;

import test.jinesh.customnavigation.Folding_Cell.FoldingCell;
import worldline.com.foldablelayout.FoldableLayout;

import static android.support.v7.widget.LinearLayoutManager.*;

public class FirstFragment extends Fragment {
    HorizontalListView hlvSimpleList1;
    HorizontialListViewnew listView;
    ListView news_eventslist;
    private String[] mSimpleListValues = new String[] { "The Royal Castle", "Palm Rivera", "The Royal Castle",
            "Palm Rivera", "The Royal Castle", "Palm Rivera", "The Royal Castle", "Palm Rivera"};
    Context context=getActivity();
    ArrayList<HashMap<String, String>> arrayList;
    ArrayList<HashMap<String, String>> eventnewslist;

    ArrayList<HashMap<String, String>> poll_list;

    RecyclerView recycler_view1;
    SnappingRecyclerView mRecyclerView,pollslist;
    RecyclerView.LayoutManager mLayoutManager;
    private View detailsLayout;
    private UnfoldableView unfoldableView;

    LinearLayout main;

    Dialog foldabledialog;

    test.jinesh.customnavigation.Custom_Folding.FoldingCell fc;
    ImageView closebutton,foldable_location_image;

    TextView username,foldable_votecount;

    FoldingCell foldingCell ;
    Dialog Foldingdialog,downloadDilog,swipedialog;

    FrameLayout framelayout;

    FoldingCell folding;

    ScrollView scrollView;

    Activity mactivity;


    FoldingCell foldable;

    ImageView reference_Select,profile_Select,add_Select,title_head_image,head_image;
    ImageView project_select,count_image1,count_image2;

    TextView projecttext,foldable_description,notgoing,going;
    android.support.v4.app.FragmentTransaction ft;

    LinearLayout project_select_layout,project_select_lay,reference_Select_lay,home_Select_lay,profile_Select_lay,
            news_Desclayout,location_layout,count_layout1,count_layout2,count_layout3,vote_newsdate,recyclervote,
            imageView_layout;


    LinearLayout foldable_subhead_layout,parent_subhead_layout,vote_count_layout,datetime_layout,pollcount_layout,firstlayout
            ,firstselectmain,projectlist_bg;

    ImageView firstimage,swipeicon,swipeiconone;
    LinearLayout transimage;

    TextView foldable_subhead,title_type,heading,first_textlayout;

    Button closebutton1;

     Dialog transfialog;


    int min = 2,max = 4;



    // private View listTouchInterceptor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_activity_content, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.navIcon);


        //ft = getSupportFragmentManager().beginTransaction();
        TextView action_name = (TextView)  view.findViewById(R.id.action_name);
        Typeface action_name_type = Typeface.createFromAsset(getActivity().getAssets(),"UBUNTU-LIGHT.TTF");
        action_name.setTypeface(action_name_type);

        TextView welcome_title = (TextView)  view.findViewById(R.id.welcome_title);
        Typeface welcome_title_type = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
        welcome_title.setTypeface(welcome_title_type);


        TextView message = (TextView)  view.findViewById(R.id.message);
        Typeface message_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-LIGHT.TTF");
        message.setTypeface(message_type);

        mactivity = getActivity();

        firstlayout = new LinearLayout(mactivity);
        firstimage = new ImageView(mactivity);
        first_textlayout = new TextView(mactivity);
        firstselectmain  = new LinearLayout(mactivity);
        TextView clientcode_label = (TextView)  view.findViewById(R.id.clientcode_label);
        TextView clientcode = (TextView)  view.findViewById(R.id.clientcode);
        Typeface clientcode_label_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-LIGHT.TTF");
        clientcode_label.setTypeface(clientcode_label_type);
        clientcode.setTypeface(clientcode_label_type,Typeface.BOLD);
        main = (LinearLayout)view.findViewById(R.id.main);

        swipeicon = (ImageView)  view.findViewById(R.id.swipeicon);

        swipeicon.setVisibility(View.INVISIBLE);




        listView = (HorizontialListViewnew) view.findViewById(R.id.hlvSimpleList);
        reference_Select = (ImageView) view.findViewById(R.id.reference_Select);
        project_select = (ImageView) view.findViewById(R.id.project_select);
        profile_Select = (ImageView) view.findViewById(R.id.profile_Select);
        add_Select= (ImageView) view.findViewById(R.id.add_Select);
        projecttext =(TextView)view.findViewById(R.id.projecttext) ;
        project_select_lay =(LinearLayout) view.findViewById(R.id.project_select_lay) ;
        reference_Select_lay=(LinearLayout) view.findViewById(R.id.reference_Select_lay) ;
        profile_Select_lay=(LinearLayout) view.findViewById(R.id.profile_Select_lay) ;
        projectlist_bg = (LinearLayout) view.findViewById(R.id.projectlist_bg) ;
        imageView_layout  = (LinearLayout) view.findViewById(R.id.imageView_layout) ;
     //   project_select_layout =(LinearLayout) view.findViewById(R.id.project_select_layout);
        //hlvSimpleList1 = (HorizontalListView) view.findViewById(R.id.hlvSimpleList1);
        news_eventslist = (ListView) view.findViewById(R.id.news_eventslist);
        mRecyclerView = (SnappingRecyclerView) view.findViewById(R.id.recycler_view);
        username = (TextView) view.findViewById(R.id.username);
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        final Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"CaviarDreams_Bold.ttf");
        username.setTypeface(type);
        foldingCell = new FoldingCell(getContext());
        mRecyclerView.setHasFixedSize(true);
        recycler_view1= (RecyclerView) view.findViewById(R.id.recycler_view1);
        recycler_view1.setHasFixedSize(true);


        project_select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("project_select_lay clicked");
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();

            }
        });

        reference_Select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("reference clicked");
                ThirdFragment secondFragment = new ThirdFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();
            }
        });

        profile_Select_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FourthFragment secondFragment = new FourthFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();

            }
        });

        add_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FourthFragment secondFragment = new FourthFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, secondFragment);
                fragmentTransaction.commit();

            }
        });


        swipedialog= new Dialog(getContext(),R.style.Custom_Dialog);
        View convertViewseipe = inflater.inflate(R.layout.swipedialogue, null);
        swipedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        swipedialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        swipedialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       // swipedialog.getWindow().setBackgroundDrawableResource(R.color.black90);
        swipedialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        swipedialog.setContentView(convertViewseipe);

        swipeiconone=(ImageView) swipedialog.findViewById(R.id.swipeiconone);

        transimage = (LinearLayout)swipedialog.findViewById(R.id.transimage);

        Foldingdialog = new Dialog(getContext(),R.style.Custom_Dialog);
        Foldingdialog.setCancelable(false);

        View convertView = inflater.inflate(R.layout.customfold_dialog, null);
        Foldingdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Foldingdialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Foldingdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Foldingdialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);


        Foldingdialog.setContentView(convertView);
        closebutton=(ImageView) Foldingdialog.findViewById(R.id.closebutton);
        recyclervote=(LinearLayout) Foldingdialog.findViewById(R.id.recyclervote);
        foldable = (FoldingCell) Foldingdialog.findViewById(R.id.folding_cell);
        pollslist= (SnappingRecyclerView) Foldingdialog.findViewById(R.id.pollslist);
        foldable_subhead_layout  = (LinearLayout) Foldingdialog.findViewById(R.id.foldable_subhead_layout);
        parent_subhead_layout = (LinearLayout) Foldingdialog.findViewById(R.id.parent_subhead_layout);
        foldable_subhead = (TextView) Foldingdialog.findViewById(R.id.foldable_subhead);
        heading = (TextView) Foldingdialog.findViewById(R.id.heading);
        title_type = (TextView) Foldingdialog.findViewById(R.id.title_type);
        title_head_image = (ImageView) Foldingdialog.findViewById(R.id.title_head_image);
        head_image = (ImageView) Foldingdialog.findViewById(R.id.head_image);
        foldable_location_image  = (ImageView) Foldingdialog.findViewById(R.id.foldable_location_image);
        vote_count_layout = (LinearLayout) Foldingdialog.findViewById(R.id.vote_count_layout);
        datetime_layout = (LinearLayout) Foldingdialog.findViewById(R.id.datetime_layout);
        foldable_votecount = (TextView) Foldingdialog.findViewById(R.id.foldable_votecount);
        foldable_description = (TextView) Foldingdialog.findViewById(R.id.foldable_description);
        pollcount_layout = (LinearLayout) Foldingdialog.findViewById(R.id.pollcount_layout);
        news_Desclayout = (LinearLayout) Foldingdialog.findViewById(R.id.news_Desclayout);
        location_layout = (LinearLayout) Foldingdialog.findViewById(R.id.location_layout);
        count_layout1  = (LinearLayout) Foldingdialog.findViewById(R.id.count_layout1);
        count_layout2  = (LinearLayout) Foldingdialog.findViewById(R.id.count_layout2);
        count_layout3  = (LinearLayout) Foldingdialog.findViewById(R.id.count_layout3);
        count_image1  = (ImageView) Foldingdialog.findViewById(R.id.count_image1);
        count_image2  = (ImageView) Foldingdialog.findViewById(R.id.count_image2);
        notgoing = (TextView) Foldingdialog.findViewById(R.id.notgoing);
        going = (TextView) Foldingdialog.findViewById(R.id.going);
        vote_newsdate = (LinearLayout) Foldingdialog.findViewById(R.id.vote_newsdate);

        Button close = (Button) Foldingdialog.findViewById(R.id.closedialog);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foldable.fold(false);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                        Foldingdialog.cancel();
                    }
                }, 120);


            }
        });

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    foldable.fold(false);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                       Foldingdialog.cancel();
                    }
                }, 150);


            }
        });



         transfialog = new Dialog(getContext());

        //LayoutInflater inflater1=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView2 = inflater.inflate(R.layout.closbutton, null);
        transfialog.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        transfialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        transfialog.setContentView(convertView2);


        closebutton1=(Button) transfialog.findViewById(R.id.closedialog);





        downloadDilog = new Dialog(getContext());
        ImageView closebutton1;
        View convertView1 = inflater.inflate(R.layout.download_popup, null);
        downloadDilog.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        downloadDilog.getWindow().getAttributes().windowAnimations = R.style.Theme_Dialog_Translucent;
        downloadDilog.setContentView(convertView1);
        closebutton1=(ImageView) downloadDilog.findViewById(R.id.closebutton);



        closebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //foldable.toggle(false);

                downloadDilog.dismiss();



            }
        });

        arrayList = new ArrayList<HashMap<String, String>>();
        eventnewslist  = new ArrayList<HashMap<String, String>>();
        poll_list  = new ArrayList<HashMap<String, String>>();
        final NavigationActivity navigationActivity = (NavigationActivity) getActivity();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationActivity.drawerLayout.openDrawer(navigationActivity.navView);
            }
        });
        navigationActivity.navView.getMenu().getItem(0).setChecked(true);

        for(int i = 0 ; i <3;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            //if (i % 0 == 0) {

            // if (i % 2 == 0) {

            if (i == 0) {

                hashMap.put("projectnme", "The Royal Castle");
                hashMap.put("apartmentno", "A148");
                hashMap.put("invoicedate","10-09-2017");

            }
            else if (i==1)
            {

                hashMap.put("projectnme", "New Project");
                hashMap.put("apartmentno", "A149");
                hashMap.put("invoicedate","12-12-2017");
            }
            else if(i==2)
            {

                hashMap.put("projectnme", "Palm Rivera");
                hashMap.put("apartmentno", "A150");
                hashMap.put("invoicedate","10-09-2017");

            }
            arrayList.add(hashMap);
        }


        for(int i = 0 ; i <4;i++)
        {

            HashMap<String, String> hashMap = new HashMap<>();
            if (i == 0) {
                hashMap.put("title", "SunCity Club Handover");
                hashMap.put("type", "News");
                hashMap.put("desc","Suncity club house was handed over to all the proud owners of healthy.....");

            }
            else   if (i == 2)
            {
                hashMap.put("title", "SunCity Club Handover");
                hashMap.put("type", "Events");
                hashMap.put("desc","Conference Hall");
            }
            else   if (i == 1)
            {
                hashMap.put("title", "CMS Satisfaction Poll");
                hashMap.put("type", "Polls");
                hashMap.put("desc","Are you overall satisfied with Amarprakash App?");
            }
            else   if (i == 3)
            {
                hashMap.put("title", "Voting Polls");
                hashMap.put("type", "Polls");
                hashMap.put("desc","Are you overall satisfied with Amarprakash App?");
            }
            eventnewslist.add(hashMap);




        }



        for(int i = 0 ; i <5;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            //if (i % 2 == 0)
                if (i==0)
            {
                hashMap.put("imagename", "dashboard_select_bg");
                hashMap.put("name", "vote1");

            }

            if (i==1)
            {
                hashMap.put("imagename", "date");
                hashMap.put("name", "vote2");

            }

            if (i==2)
            {
                hashMap.put("imagename", "not_going");
                hashMap.put("name", "vote3");

            }

            if (i==3)
            {
                hashMap.put("imagename", "project_bg");
                hashMap.put("name", "vote4");

            }
            if (i==4)
            {
                hashMap.put("imagename", "project2_bg");
                hashMap.put("name", "vote5");

            }
            if (i==5)
            {
                hashMap.put("imagename", "popup_location");
                hashMap.put("name", "vote6");
            }

            poll_list.add(hashMap);

        }







        final ListAdapterHolder rechold = new ListAdapterHolder();
        mRecyclerView.setAdapter(rechold);









       /* ListAdapterHolder rechold = new ListAdapterHolder();
        mRecyclerView.setAdapter(rechold);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());*/


        ////mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


      //  final CarouselLayoutManager layoutManager = new CarouselLayoutManager(getContext(), HORIZONTAL, true);


        //initRecyclerView(mRecyclerView, new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true));

        ListAdapterHolder1 rechold1 = new ListAdapterHolder1();
        recycler_view1.setAdapter(rechold1);
        recycler_view1.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), HORIZONTAL, false);
        recycler_view1.setLayoutManager(layoutManager1);
        recycler_view1.setItemAnimator(new DefaultItemAnimator());




/*        final PollListAdapterHolder poladapter = new PollListAdapterHolder();
        pollslist.setAdapter(poladapter);*/

        /*final FoldingCellListAdapter	listAdapter1 = new FoldingCellListAdapter();
        news_eventslist.setAdapter(listAdapter1);


        news_eventslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                listAdapter1.registerToggle(pos);
            }
        });*/


      /*  if ( rechold!= null) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.smoothScrollToPosition(1);
                    mRecyclerView.smoothScrollToPosition(0);
                }
            }, 5);
        }*/



       // final LinearLayoutManager llayoutManager = ((LinearLayoutManager) mRecyclerView.getLayoutManager());
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_SETTLING) {
                    EventBus.getDefault().post(new ScrollEvent(0));
                } else
                    EventBus.getDefault().post(new ScrollEvent(1));

            }
        });




        if(rechold.getItemCount()>1)
      //  if(arrayList.size()>1)
        {

        /*    TranslateAnimation animation = new TranslateAnimation(-970.0f, 2000.0f, 0.0f, 0.0f);
            animation.setDuration(1000);
            animation.setFillAfter(false);
            swipeicon.startAnimation(animation);*/


/*            swipeicon.setVisibility(View.VISIBLE);
            Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slideleft);
            swipeicon.startAnimation(hyperspaceJumpAnimation);*/

            //projectlist_bg.setBackgroundColor(getResources().getColor(R.color.black90));


           // swipeicon.setBackgroundColor(getResources().getColor(R.color.black90));

/*            mRecyclerView.setFocusable(false);
            Animation animation1=new TranslateAnimation(200.f, -700.0f, 0.0f, 0.0f);
            animation1.setDuration(5000);
            swipeicon.startAnimation(animation1);
            main.setBackgroundColor(getResources().getColor(R.color.transparent));*/

            swipedialog.show();
            Animation animation1=new TranslateAnimation(200.f, -700.0f, 0.0f, 0.0f);
            animation1.setDuration(5000);
            //swipeiconone.startAnimation(animation1);
            transimage.startAnimation(animation1);


            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
/*                    swipeicon.setVisibility(View.GONE);
                    mRecyclerView.setFocusable(true);
                    mRecyclerView.setVisibility(View.VISIBLE);*/

                    swipedialog.dismiss();


                }
            }, 5000);



        /*    final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    mRecyclerView.scrollToPosition(1);
                }
            }, 1500);


            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    mRecyclerView.scrollToPosition(0);
                }
            }, 2500);*/


            //handler.dispatchMessage("running");




          /*  handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    mRecyclerView.scrollToPosition(1);
                }
            }, 4000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    mRecyclerView.scrollToPosition(0);
                }
            }, 4500);*/
        }









     /*   handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                mRecyclerView.scrollToPosition(0);
            }
        }, 200);*/





       /* mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.scrollToPosition(0);

            }
        }, 5);*/



        /*if (!rechold.i && !mRecyclerView.canScrollHorizontally(1))
        {
            mRecyclerView.getLayoutManager().smoothScrollToPosition(mRecyclerView, null, mAdapter.getItemCount() - 1);
        }*/

        if (rechold.getItemCount() > 1)
        {
           // mRecyclerView.getLayoutManager().scrollHorizontallyBy(1, mRecyclerView, null);

        }



        return view;
    }


    public void initRecyclerView(final RecyclerView recyclerView, final CarouselLayoutManager layoutManager) {

        final ListAdapterHolder rechold = new ListAdapterHolder();
        rechold.setContext(mactivity);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rechold);
        recyclerView.addOnScrollListener(new CenterScrollListener());



        // enable center post scrolling
        recyclerView.addOnScrollListener(new CenterScrollListener());
        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {

            @Override
            public void onCenterItemChanged(final int adapterPosition) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //5.0以下的手机会不会主动刷新到界面,需要调用此方法
                        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {
                            rechold.notifyDataSetChanged();
                        }
                    }
                }, 50);
            }
        });

        rechold.setLayoutManager(layoutManager);

        /**
         * 自动选中中间View
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.scrollToPosition(rechold.getItemCount()/2);
            }
        }, 100);
    }



    public class PollListAdapterHolder extends RecyclerView.Adapter<PollListAdapterHolder.ViewHolder> {



        public PollListAdapterHolder() {

        }

        private Context context;

        CarouselLayoutManager layoutManager;

        public void setLayoutManager(CarouselLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            final View sView = mInflater.inflate(R.layout.pool_itemscheck, parent, false);


            return new ViewHolder(sView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            holder.poll_image_text.setText(poll_list.get(position).get("name"));

            String imagename = poll_list.get(position).get("imagename");
            final GradientDrawable bgShape = (GradientDrawable) holder.poll_layout.getBackground();

            bgShape.setColor(getResources().getColor(R.color.white));


            holder.poll_image.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        final GradientDrawable bgShape2 = (GradientDrawable) holder.poll_layout.getBackground();
                        bgShape2.setColor(getResources().getColor(R.color.satisfied));
                        holder.poll_image_text.setTextColor(getContext().getResources().getColor(R.color.white));
                        holder.selectmain.setBackgroundResource(R.drawable.green_shadow);
                    }
                    else
                    {

                        //firstlayout.setBackgroundResource(R.drawable.oval_rectangle);
                        final GradientDrawable bgShape2 = (GradientDrawable) holder.poll_layout.getBackground();
                        bgShape2.setColor(getResources().getColor(R.color.white));
                        holder.poll_image_text.setTextColor(getContext().getResources().getColor(R.color.black));
                        holder.selectmain.setBackgroundResource(R.drawable.black_shadow);

                    }
                }
            });




           /* holder.poll_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(holder.poll_layout.isSelected())
                    {

                        System.out.println("Position:"+position+":"+true);

                    }


                    firstlayout.setBackgroundResource(R.drawable.oval_rectangle);
                    final GradientDrawable bgShape = (GradientDrawable) firstlayout.getBackground();
                    bgShape.setColor(getResources().getColor(R.color.white));
                    first_textlayout.setTextColor(getContext().getResources().getColor(R.color.black));
                    firstselectmain.setBackgroundResource(R.drawable.black_shadow);


                    final GradientDrawable bgShape2 = (GradientDrawable) holder.poll_layout.getBackground();
                    bgShape2.setColor(getResources().getColor(R.color.satisfied));
                    holder.poll_image_text.setTextColor(getContext().getResources().getColor(R.color.white));
                    holder.selectmain.setBackgroundResource(R.drawable.green_shadow);

                   firstlayout = holder.poll_layout;
                    first_textlayout = holder.poll_image_text;
                    firstselectmain  = holder.selectmain;












                }
            });*/






          /*  if (holder.project_name.getText().toString().equals("The Royal Castle")) {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project_bg));
            } else {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project2_bg));
            }
*/


            setAnimation(holder.itemView, position);
        }

        @Override
        public int getItemCount() {
            return poll_list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView poll_image_text;
            CheckBox poll_image;
            LinearLayout poll_layout,selectmain;

            public ViewHolder(View view) {
                super(view);

                poll_image_text = (TextView) view.findViewById(R.id.poll_image_text);
                poll_image = (CheckBox) view.findViewById(R.id.poll_image);
                poll_layout = (LinearLayout) view.findViewById(R.id.poll_layout);
                selectmain = (LinearLayout) view.findViewById(R.id.selectmain);

            }
        }

        private void setAnimation(View viewToAnimate, int position)
        {
            // If the bound view wasn't previously displayed on screen, it's animated
            int lastPosition = -1;
            if (position > lastPosition) {

                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);
              /*  final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator);
                viewToAnimate.setAnimation(animAnticipateOvershoot);*/
                lastPosition = position;
            }
            else if(lastPosition>position)
            {
               /* Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);*/

                final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator_reverse);
                viewToAnimate.setAnimation(animAnticipateOvershoot);
                position = lastPosition;
            }

        }
    }



    public class PollListAdapterHolder1 extends RecyclerView.Adapter<PollListAdapterHolder1.ViewHolder> {



        public PollListAdapterHolder1() {

        }

        private Context context;

        CarouselLayoutManager layoutManager;

        public void setLayoutManager(CarouselLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            final View sView = mInflater.inflate(R.layout.poll_list_item, parent, false);


            return new ViewHolder(sView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            holder.poll_image_text.setText(poll_list.get(position).get("name"));

            String imagename = poll_list.get(position).get("imagename");
            final GradientDrawable bgShape = (GradientDrawable) holder.poll_layout.getBackground();
            holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.not_going));

            bgShape.setColor(getResources().getColor(R.color.white));




           /* if(position==0)
            {
                holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.dashboard_select_bg));


                bgShape.setColor(getResources().getColor(R.color.bg1));
            }
            if(position==1)
            {
               // holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.date));
                bgShape.setColor(getResources().getColor(R.color.bg2));
            }
            if(position==2)
            {
                holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.not_going));
              //  bgShape.setColor(getResources().getColor(R.color.bg3));
            }
            if(position==3)
            {
                holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.project_bg));
                bgShape.setColor(getResources().getColor(R.color.bg4));
            }
            if(position==4)
            {
                holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.project2_bg));
                bgShape.setColor(getResources().getColor(R.color.bg5));
            }
            if(position==5)
            {
                holder.poll_image.setImageDrawable(getResources().getDrawable(R.drawable.popup_location));
                bgShape.setColor(getResources().getColor(R.color.bg6));
            }*/




            holder.poll_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(holder.poll_layout.isSelected())
                    {

                        System.out.println("Position:"+position+":"+true);

                    }


            /*        holder.firstlayout = new LinearLayout(getActivity());

                    final GradientDrawable bgShape = (GradientDrawable) holder.firstlayout.getBackground();
                    bgShape.setColor(getResources().getColor(R.color.gray));*/


                    //   int selected_item = position;

                    // System.out.println("position:"+selected_item);


                    /*final GradientDrawable bgShape = (GradientDrawable) firstlayout.getBackground();
                    bgShape.setColor(getResources().getColor(R.color.gray));*/



                    firstlayout.setBackgroundResource(R.drawable.oval_rectangle);
                    final GradientDrawable bgShape = (GradientDrawable) firstlayout.getBackground();
                    bgShape.setColor(getResources().getColor(R.color.white));
                    firstimage.setImageResource(R.drawable.going);
                    firstimage.setColorFilter(getContext().getResources().getColor(R.color.gray));
                    first_textlayout.setTextColor(getContext().getResources().getColor(R.color.black));
                    firstselectmain.setBackgroundResource(R.drawable.black_shadow);


                    final GradientDrawable bgShape2 = (GradientDrawable) holder.poll_layout.getBackground();
                    bgShape2.setColor(getResources().getColor(R.color.satisfied));

                    holder.poll_image.setImageResource(R.drawable.satisfied);
                    holder.poll_image.setColorFilter(getContext().getResources().getColor(R.color.transparent));
                    holder.poll_image_text.setTextColor(getContext().getResources().getColor(R.color.white));
                    holder.selectmain.setBackgroundResource(R.drawable.green_shadow);
                    // holder.poll_image.setColorFilter(getContext().getResources().getColor(R.color.white));

                    //  firstlayout.setBackgroundColor(getResources().getColor(R.color.satisfied));
                    firstlayout = holder.poll_layout;
                    firstimage = holder.poll_image;
                    first_textlayout = holder.poll_image_text;
                    firstselectmain  = holder.selectmain;



                    //  bgShape.setColor(getResources().getColor(R.color.satisfied));



















                }
            });






          /*  if (holder.project_name.getText().toString().equals("The Royal Castle")) {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project_bg));
            } else {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project2_bg));
            }
*/


            setAnimation(holder.itemView, position);
        }

        @Override
        public int getItemCount() {
            return poll_list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView poll_image_text;
            ImageView poll_image;
            LinearLayout poll_layout,selectmain;

            public ViewHolder(View view) {
                super(view);

                poll_image_text = (TextView) view.findViewById(R.id.poll_image_text);
                poll_image = (ImageView) view.findViewById(R.id.poll_image);
                poll_layout = (LinearLayout) view.findViewById(R.id.poll_layout);
                selectmain = (LinearLayout) view.findViewById(R.id.selectmain);

            }
        }

        private void setAnimation(View viewToAnimate, int position)
        {
            // If the bound view wasn't previously displayed on screen, it's animated
            int lastPosition = -1;
            if (position > lastPosition) {
              /*  ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setDuration(new Random().nextInt(1500));//to make duration random number between [0,501)
                viewToAnimate.startAnimation(anim);*/

                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);
              /*  final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator);
                viewToAnimate.setAnimation(animAnticipateOvershoot);*/
                lastPosition = position;
            }
            else if(lastPosition>position)
            {
               /* Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);*/

                final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator_reverse);
                viewToAnimate.setAnimation(animAnticipateOvershoot);
                position = lastPosition;
            }

        }
    }










    public class ListAdapterHolder extends RecyclerView.Adapter<ListAdapterHolder.ViewHolder> {



        public ListAdapterHolder() {

        }

        private Context context;

        CarouselLayoutManager layoutManager;

        public void setLayoutManager(CarouselLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            final View sView = mInflater.inflate(R.layout.project_list_item, parent, false);


            return new ViewHolder(sView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.project_name.setText(arrayList.get(position).get("projectnme"));
            holder.exe_name.setText(arrayList.get(position).get("apartmentno"));

            if (holder.project_name.getText().toString().equals("The Royal Castle")) {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project_bg));
            } else {
                holder.content.setBackgroundDrawable(getResources().getDrawable(R.drawable.project2_bg));
            }

            holder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("clicked");
                }
            });


            holder.download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    downloadDilog.show();
                }
            });

            holder.pay_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    downloadDilog.show();
                }
            });

           // setAnimation(holder.itemView, position);



        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView exe_name, project_name,pay_now,download,provious,date_Donwload,demandvalue,demandvalue_label,paid_value,paid_label,
                    outstanding_value,outstanding_label;
            LinearLayout content;

            public ViewHolder(View view) {
                super(view);
                exe_name = (TextView) view.findViewById(R.id.textView11);
                project_name = (TextView) view.findViewById(R.id.textView12);
                pay_now = (TextView) view.findViewById(R.id.pay_now);
                date_Donwload = (TextView) view.findViewById(R.id.date_Donwload);
                download = (TextView) view.findViewById(R.id.download);
                content = (LinearLayout) view.findViewById(R.id.content);
                provious = (TextView) view.findViewById(R.id.provious);
                demandvalue  = (TextView) view.findViewById(R.id.demandvalue);
                demandvalue_label   = (TextView) view.findViewById(R.id.demandvalue_label);
                paid_value  = (TextView) view.findViewById(R.id.paid_value);
                paid_label  = (TextView) view.findViewById(R.id.paid_label);
                outstanding_value   = (TextView) view.findViewById(R.id.outstanding_value);
                outstanding_label  = (TextView) view.findViewById(R.id.outstanding_label);
                Typeface exe_name_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-MEDIUM.TTF");
                exe_name.setTypeface(exe_name_type);
                demandvalue.setTypeface(exe_name_type);

                paid_value.setTypeface(exe_name_type);

                outstanding_value.setTypeface(exe_name_type);
                //outstanding_label.setTypeface(exe_name_type);


                Typeface date_Donwload_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-LIGHT.TTF");
                date_Donwload.setTypeface(date_Donwload_type);
                outstanding_label.setTypeface(date_Donwload_type);
                paid_label.setTypeface(date_Donwload_type);
                demandvalue_label.setTypeface(date_Donwload_type);
                Typeface download_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-BLACK.TTF");
                download.setTypeface(download_type);





                Typeface project_name_type = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
                project_name.setTypeface(project_name_type);
                provious.setTypeface(project_name_type);



                Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"UBUNTU-REGULAR.TTF");
                pay_now.setTypeface(type);
            }
        }

        private void setAnimation(View viewToAnimate, int position)
        {
            // If the bound view wasn't previously displayed on screen, it's animated
            int lastPosition = -1;
            if (position > lastPosition) {
              /*  ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setDuration(new Random().nextInt(1500));//to make duration random number between [0,501)
                viewToAnimate.startAnimation(anim);*/

                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);
              /*  final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator);
                viewToAnimate.setAnimation(animAnticipateOvershoot);*/
                lastPosition = position;
            }
            else if(lastPosition>position)
            {
               /* Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);*/

                final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(getActivity(), R.anim.anticipate_overshoot_interpolator_reverse);
                viewToAnimate.setAnimation(animAnticipateOvershoot);
                position = lastPosition;
            }

        }
    }



    public class ListAdapterHolder1 extends RecyclerView.Adapter<ListAdapterHolder1.ViewHolder> {
        //protected FoldableLayout mFoldableLayout;

        private HashSet<Integer> unfoldedIndexes = new HashSet<>();
        private View.OnClickListener defaultRequestBtnClickListener;
        // FoldingCell sView;

        int clickedposition ;

        //FoldingCell sView;

        Boolean open = false;

        public ListAdapterHolder1() {

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            final View sView = mInflater.inflate(R.layout.news_event_listitem, parent, false);
            System.out.println("Viewtype:"+viewType);
            return new ViewHolder(sView);
        }




        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position)
        {

            holder.type.setText(eventnewslist.get(position).get("type"));
            holder.title_header.setText(eventnewslist.get(position).get("title"));
            holder.description_row.setText(eventnewslist.get(position).get("desc"));

            Typeface clientcode_label_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-MEDIUM.TTF");
            holder.title_header.setTypeface(clientcode_label_type);

            Typeface type_type = Typeface.createFromAsset(getActivity().getAssets(),"UBUNTU-REGULAR.TTF");
            holder.type.setTypeface(type_type);

            Typeface count_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-BOLD.TTF");
            holder.count.setTypeface(count_type,Typeface.BOLD);

            Typeface voted_type = Typeface.createFromAsset(getActivity().getAssets(),"ROBOTO-LIGHT.TTF");
            holder.voted.setTypeface(voted_type);

            holder.time.setTypeface(voted_type);
            holder.time.setTextColor(Color.WHITE);




            if(eventnewslist.get(position).get("type").equalsIgnoreCase("Events"))
            {
                holder.parent_time_layout.setVisibility(View.VISIBLE);

            }
            else
            {
                holder.parent_time_layout.setVisibility(View.GONE);
            }

        //    holder.arrow_click.setOnClickListener(defaultRequestBtnClickListener);



            holder.arrow_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("clicked");

                    final PollListAdapterHolder poladapter = new PollListAdapterHolder();
                    pollslist.setAdapter(poladapter);
                    if(eventnewslist.get(position).get("type").equalsIgnoreCase("Polls"))
                    {
                        GradientDrawable bgShape = (GradientDrawable) foldable_subhead_layout.getBackground();
                        bgShape.setColor(getResources().getColor(R.color.pollsarrow));
                        foldable_location_image.setVisibility(View.GONE);
                        vote_newsdate.setVisibility(View.GONE);
                        GradientDrawable parent_subhead_color = (GradientDrawable) parent_subhead_layout.getBackground();
                        parent_subhead_color.setColor(getResources().getColor(R.color.pollsarrow));

                        foldable_subhead.setText("Polls");
                        title_type.setText("Polls");
                        vote_count_layout.setVisibility(View.VISIBLE);

                       // title_head_image.setBackgroundDrawable(getResources().getDrawable(getContext(), R.drawable.polls_image));
                        title_head_image.setBackgroundResource(R.drawable.polls_image);
                        head_image.setBackgroundResource(R.drawable.polls_image);
                        //foldable_description.setText("Are you overall satisfied with Amarprakash and its services....?");
                        foldable_description.setText("Are you satisfied with Amarprakash and its services?");
                      //  foldable_description.setTextSize(12);
                        heading.setText("CM Satisfaction Poll");
                        datetime_layout.setVisibility(View.GONE);
                        pollcount_layout.setVisibility(View.VISIBLE);
                        location_layout.setVisibility(View.VISIBLE);
                        news_Desclayout.setVisibility(View.GONE);
                        count_layout1.setVisibility(View.GONE);

                        GradientDrawable countlayoutbg = (GradientDrawable) count_layout3.getBackground();
                        countlayoutbg.setColor(getResources().getColor(R.color.satisfied));

                        GradientDrawable countlayoutun = (GradientDrawable) count_layout2.getBackground();
                        countlayoutun.setColor(getResources().getColor(R.color.white));

                        count_image1.setBackgroundDrawable(getResources().getDrawable(R.drawable.unsatisfied));
                        count_image2.setBackgroundDrawable(getResources().getDrawable(R.drawable.satisfied));

                        count_layout1.setVisibility(View.GONE);
                        notgoing.setVisibility(View.VISIBLE);
                        going.setVisibility(View.VISIBLE);
                        notgoing.setTextColor(getResources().getColor(R.color.black));
                        notgoing.setText("Unsatisfied");
                        going.setText("Satisfied");


                        closebutton.setVisibility(View.GONE);

                      //  recyclervote.setVisibility(View.GONE);

                        if(eventnewslist.get(position).get("title").contains("Voting"))
                        {
                            pollcount_layout.setVisibility(View.GONE);
                            recyclervote.setVisibility(View.VISIBLE);
                            foldable_description.setText("Are you satisfied with Amarprakash and its services?");
                            //  foldable_description.setTextSize(12);
                            heading.setText("Voting Polls");
                        }
                        else
                        {
                            pollcount_layout.setVisibility(View.VISIBLE);
                            recyclervote.setVisibility(View.GONE);
                            foldable_description.setText("Are you satisfied with Amarprakash and its services?");
                            //  foldable_description.setTextSize(12);
                            heading.setText("CM Satisfaction Poll");
                        }

                    }
                    else if(eventnewslist.get(position).get("type").equalsIgnoreCase("Events"))
                    {
                        GradientDrawable bgShape = (GradientDrawable) foldable_subhead_layout.getBackground();
                        bgShape.setColor(getResources().getColor(R.color.eventarrow));
                        GradientDrawable parent_subhead_color = (GradientDrawable) parent_subhead_layout.getBackground();
                        parent_subhead_color.setColor(getResources().getColor(R.color.eventarrow));
                        foldable_subhead.setText("Events");
                        title_type.setText("Events");
                        title_head_image.setBackgroundResource(R.drawable.event);
                        head_image.setBackgroundResource(R.drawable.event);
                        foldable_location_image.setVisibility(View.VISIBLE);
                        vote_count_layout.setVisibility(View.VISIBLE);
                        foldable_description.setText("Conference Hall");
                        pollcount_layout.setVisibility(View.VISIBLE);
                        location_layout.setVisibility(View.VISIBLE);
                        datetime_layout.setVisibility(View.VISIBLE);
                        news_Desclayout.setVisibility(View.GONE);

                        vote_newsdate.setVisibility(View.GONE);
                        GradientDrawable countlayoutfriend= (GradientDrawable) count_layout1.getBackground();
                        countlayoutfriend.setColor(getResources().getColor(R.color.white));

                        GradientDrawable countlayoutbg = (GradientDrawable) count_layout3.getBackground();
                        countlayoutbg.setColor(getResources().getColor(R.color.notgoingbackground));

                        GradientDrawable countlayoutun = (GradientDrawable) count_layout2.getBackground();
                        countlayoutun.setColor(getResources().getColor(R.color.goingbackground));

                        count_image1.setBackgroundDrawable(getResources().getDrawable(R.drawable.not_going));
                        count_image2.setBackgroundDrawable(getResources().getDrawable(R.drawable.going));

                        count_layout1.setVisibility(View.VISIBLE);

                        notgoing.setVisibility(View.VISIBLE);
                        going.setVisibility(View.VISIBLE);
                        notgoing.setText("Not Going");
                        going.setText("Going");
                        notgoing.setTextColor(getResources().getColor(R.color.white));


                        closebutton.getLayoutParams().height = 40;

                        closebutton.getLayoutParams().width = 40;

                        closebutton.setScaleType(ImageView.ScaleType.FIT_XY);

                        closebutton.setVisibility(View.INVISIBLE);
                        vote_count_layout.setVisibility(View.GONE);

                        recyclervote.setVisibility(View.GONE);

                    }
                    else if(eventnewslist.get(position).get("type").equalsIgnoreCase("News"))
                    {
                        vote_count_layout.setVisibility(View.VISIBLE);
                        pollcount_layout.setVisibility(View.VISIBLE);
                        location_layout.setVisibility(View.VISIBLE);
                        datetime_layout.setVisibility(View.VISIBLE);
                        GradientDrawable bgShape = (GradientDrawable) foldable_subhead_layout.getBackground();
                        bgShape.setColor(getResources().getColor(R.color.newsarrow));
                        GradientDrawable parent_subhead_color = (GradientDrawable) parent_subhead_layout.getBackground();
                        parent_subhead_color.setColor(getResources().getColor(R.color.newsarrow));
                        foldable_subhead.setText("News");
                        title_type.setText("News");
                        title_head_image.setBackgroundResource(R.drawable.news_image);
                        head_image.setBackgroundResource(R.drawable.news_image);
                        foldable_location_image.setVisibility(View.INVISIBLE);
                       // vote_count_layout.setVisibility(View.GONE);
                        pollcount_layout.setVisibility(View.GONE);
                        location_layout.setVisibility(View.GONE);
                        news_Desclayout.setVisibility(View.VISIBLE);
                        vote_newsdate.setVisibility(View.VISIBLE);
                        datetime_layout.setVisibility(View.GONE);
                        closebutton.getLayoutParams().height = 40;

                        closebutton.getLayoutParams().width = 40;

                        closebutton.setScaleType(ImageView.ScaleType.FIT_XY);



                        foldable_description.setText("Suncity club house was handed over to all the proud owners of healthy home in security project");

                        foldable_description.setClickable(true);
                        closebutton.setVisibility(View.INVISIBLE);
                        recyclervote.setVisibility(View.GONE);


                        //if(position ==3)


                        foldable_subhead.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                transfialog.show();


                            }
                        });
                    }


                    Foldingdialog.show();

                    if(eventnewslist.get(position).get("type").equalsIgnoreCase("News"))
                    {
                        vote_count_layout.setVisibility(View.GONE);
                    }

                    foldable.toggle(false);



                }
            });



            if(eventnewslist.get(position).get("type").equalsIgnoreCase("Events"))
            {
                holder.type_bg.setBackgroundDrawable( getResources().getDrawable(R.drawable.event_bg) );
                holder.arrow_click.setColorFilter(getResources().getColor(R.color.eventarrow), android.graphics.PorterDuff.Mode.MULTIPLY);
                holder.type.setTextColor(getResources().getColor(R.color.eventarrow));
                holder.location_icon.setVisibility(View.VISIBLE);
                holder.event_background_image.setBackgroundDrawable(getResources().getDrawable(R.drawable.event));


            }

            if(eventnewslist.get(position).get("type").equalsIgnoreCase("Polls"))
            {
                holder.type_bg.setBackgroundDrawable( getResources().getDrawable(R.drawable.polls_bg) );
                holder.arrow_click.setColorFilter(getResources().getColor(R.color.pollsarrow), android.graphics.PorterDuff.Mode.MULTIPLY);
                holder.type.setTextColor(getResources().getColor(R.color.pollsarrow));
              //  holder.location_icon.setVisibility(View.VISIBLE);
                holder.count.setText("68");
                holder.voted.setText("Voted");
                GradientDrawable bgShape = (GradientDrawable) foldable_subhead_layout.getBackground();
                bgShape.setColor(getResources().getColor(R.color.pollsarrow));
                holder.event_background_image.setBackgroundDrawable(getResources().getDrawable(R.drawable.polls_image));
               // location_layout.setVisibility(View.VISIBLE);
            }
            else if(holder.type.getText().toString().equalsIgnoreCase("News"))
            {
                holder.type_bg.setBackgroundDrawable( getResources().getDrawable(R.drawable.news_bg) );
                holder.arrow_click.setColorFilter(getResources().getColor(R.color.newsarrow), android.graphics.PorterDuff.Mode.MULTIPLY);
                holder.type.setTextColor(getResources().getColor(R.color.newsarrow));
                GradientDrawable bgShape = (GradientDrawable) foldable_subhead_layout.getBackground();
                bgShape.setColor(getResources().getColor(R.color.newsarrow));
                holder.event_background_image.setBackgroundDrawable(getResources().getDrawable(R.drawable.news_image));
               //
            }
            setAnimation(holder.itemView, position);
        }

        @Override
        public int getItemCount() {
            return eventnewslist.size();
        }

        public void registerToggle(int position) {
            if (unfoldedIndexes.contains(position))
                registerFold(position);
            else
                registerUnfold(position);
        }

        public void registerFold(int position) {
            unfoldedIndexes.remove(position);
        }

        public void registerUnfold(int position) {
            unfoldedIndexes.add(position);
        }

        public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
            this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView type,title_header,description_row,voted,count,time ;
            LinearLayout type_bg;
            ImageView arrow_click ,location_icon;

            LinearLayout parent_time_layout,event_background_image;

         //  ImageView closebutton;

            FoldableListLayout fc;

            public ViewHolder(View view) {
                super(view);
                type = (TextView) view.findViewById(R.id.type);
                title_header = (TextView) view.findViewById(R.id.title_header);
                type_bg  = (LinearLayout) view.findViewById(R.id.type_bg );
                arrow_click = (ImageView) view.findViewById(R.id.arrow_click);
                parent_time_layout   = (LinearLayout) view.findViewById(R.id.parent_time_layout);
                event_background_image = (LinearLayout) view.findViewById(R.id.event_background_image);
                location_icon   = (ImageView) view.findViewById(R.id.location_icon);
                description_row = (TextView) view.findViewById(R.id.description_row);
                voted = (TextView) view.findViewById(R.id.voted);
                time = (TextView) view.findViewById(R.id.time);
                        count       =(TextView) view.findViewById(R.id.count);
              //  closebutton = (ImageView) view.findViewById(R.id.closebutton);
              /*  fc= (FoldableListLayout) view.findViewById(R.id.folding_cell);*/

            }
        }

        private void setAnimation(View viewToAnimate, int position) {
            // If the bound view wasn't previously displayed on screen, it's animated
            int lastPosition = -1;
            if (position > lastPosition) {


                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
            else if(lastPosition<position)
            {
                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.scroll_anim);
                viewToAnimate.startAnimation(animation);
                position = lastPosition;
            }
        }
    }
}
