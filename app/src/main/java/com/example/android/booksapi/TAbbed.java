package com.example.android.booksapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.booksapi.SettingsActivity;

public class TAbbed extends AppCompatActivity {

    RecyclerView rv;
    ProgressDialog progressDialog;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    RelativeLayout india,usaaa,global,cricket,football,sports,cnbc,ft,bloom;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private  ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        initialize();
        View x= LayoutInflater.from(getBaseContext()).inflate(R.layout.navigation_drawer,navigationView);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);

        assert drawerLayout!=null;
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){

                    case R.id.nav_home:
                        item.setChecked(true);
                        mViewPager.setCurrentItem(0);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_photos:
                        mViewPager.setCurrentItem(1);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_movies:
                        item.setChecked(true);
                        mViewPager.setCurrentItem(2);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.enter:
                        mViewPager.setCurrentItem(3);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nature:
                        mViewPager.setCurrentItem(4);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.politics:
                        mViewPager.setCurrentItem(5);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.tech:
                        mViewPager.setCurrentItem(6);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_settings:
                        Intent i=new Intent(TAbbed.this, SettingsActivity.class);
                        startActivity(i);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_logout:
                        Intent ii=new Intent(TAbbed.this, MainActivity.class);
                        startActivity(ii);
                        finish();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }});

}

    public void initialize(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        actionBarDrawerToggle.syncState();
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a news instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        View rootView;
        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            switch (getArguments().getInt(ARG_SECTION_NUMBER))
            {
                case 1: {
                    rootView = inflater.inflate(R.layout.latest, container, false);
                    rootView.findViewById(R.id.rlglobal).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),cnn_news.class);
                            startActivity(i);
                        }
                    });

                    rootView.findViewById(R.id.india).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),TOI.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.usarl).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),Usa_Today.class);
                            startActivity(i);
                        }
                    });
                    break;
                }
                case 2: {
                    rootView = inflater.inflate(R.layout.sports, container, false);
                    rootView.findViewById(R.id.rlcricket).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),FirstPage.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.rlfoot).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),Football_Page.class);
                            startActivity(i);

                        }
                    });
                    rootView.findViewById(R.id.rlsports).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Intent i=new Intent(getActivity(),espn.class);
                            startActivity(i);
                        }
                    });

                    break;
                }

                case 3: {
                    rootView = inflater.inflate(R.layout.edcation, container, false);
                    rootView.findViewById(R.id.cnbc).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),cnbc.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.bloom).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),bloomberg.class);
                            startActivity(i);

                        }
                    });
                    rootView.findViewById(R.id.ft).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Intent i=new Intent(getActivity(),ft.class);
                            startActivity(i);
                        }
                    });
                    break;
                }
                case 4: {
                    rootView=inflater.inflate(R.layout.entertainment,container,false);
                    rootView.findViewById(R.id.rlbuzz).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),Buzzfeed.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.rlbible).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),bible.class);
                            startActivity(i);

                        }
                    });
                    rootView.findViewById(R.id.rlweekly).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Intent i=new Intent(getActivity(),weekly.class);
                            startActivity(i);
                        }
                    });
                    break;
                }
                case 5: {
                    rootView=inflater.inflate(R.layout.nature,container,false);
                    rootView.findViewById(R.id.rlnational).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),national.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.rlpolygon).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),polyon.class);
                            startActivity(i);

                        }
                    });
                    rootView.findViewById(R.id.rlscience).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Intent i=new Intent(getActivity(),science.class);
                            startActivity(i);
                        }
                    });
                    break;
                }
                case 6: {
                    rootView=inflater.inflate(R.layout.music,container,false);
                    rootView.findViewById(R.id.rlmtv).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),national.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.rlmtvuk).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),polyon.class);
                            startActivity(i);

                        }
                    });
                    break;
                }
                case 7: {
                    rootView=inflater.inflate(R.layout.technology,container,false);
                    rootView.findViewById(R.id.rlars).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(),national.class);
                            startActivity(i);
                        }
                    });
                    rootView.findViewById(R.id.rltech2).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i=new Intent(getActivity(),polyon.class);
                            startActivity(i);

                        }
                    });
                    rootView.findViewById(R.id.rltech3).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Intent i=new Intent(getActivity(),science.class);
                            startActivity(i);
                        }
                    });
                    break;
                }
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Latest News";
                case 1:
                    return "Sports";
                case 2:
                    return "Business";
                case 3:
                    return "Entertainment";
                case 4:
                    return "Nature";
                case 5:
                    return "Music";
                case 6:
                    return "Technology";
            }
            return null;
        }
    }
    public void checkNetworkConnection() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No internet Connection");
        builder.setMessage("Please turn on internet connection to continue");
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        if (isConnected) {
            Log.d("Network", "Connected");
            return true;
        } else {
            checkNetworkConnection();
            Log.d("Network", "Not Connected");
            return false;
        }
    }
}
