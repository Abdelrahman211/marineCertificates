package com.example.marinecertificates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity
{

    //Initialize variable
    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Creating the transaction from btn_crt to CrtFragment
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,new CrtFragment());
        fragmentTransaction.commit();


        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.add(R.id.frame_layout,new CorFragment());
        fragmentTransaction1.commit();



        //Assign variable
        bottomNavigation = findViewById(R.id.bottom_navigation);

        //Add menu item
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_profile));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_pending));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
            }
        });
        //Set home count
        bottomNavigation.setCount(3,"10");
        //Set profile fragment initially selected
        bottomNavigation.show(1,true);

        Fragment homefragment = new HomeFragment();
        Fragment profilefragment = new ProfileFragment();
        Fragment pendingfragment = new PendingFragment();


        loadFragment(homefragment);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment=homefragment;
                        //when id is 1
                        // Initialize home fragment
                        break;
                    case 2:
                        fragment=profilefragment;
                        //when id is 2
                        //Initialize profile fragment
                        break;
                    case 3:
                        fragment=pendingfragment;
                        //when id is 3
                        //Initialize pending fragment
                        break;
                    default:
                }
                loadFragment(fragment);

            }

        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item){

            }
        });


    }


    private void loadFragment(Fragment fragment) {
        //Replace fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }

}