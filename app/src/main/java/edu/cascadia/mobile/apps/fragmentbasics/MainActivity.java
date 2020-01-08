package edu.cascadia.mobile.apps.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    boolean onA = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                //.add(R.id.fragment_place, new FragmentA(), "frag")
                .commit();
    }
    //TODO: Prepare an function for the button to load fragment B into the fragment place
    // ALSO: put the current fragment onto the back stack and set a transition
    public void onSwitchFrag(View view) {

        if (onA == true) {
            fm.beginTransaction()
                    .setTransition(TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.fragment_place, new FragmentB(), "fragB")
                    .addToBackStack("fragA")
                    .commit();
            onA = false;
            }
        else {
            fm.beginTransaction()
                    .replace(R.id.fragment_place, new FragmentA(), "fragA")
                    .setTransition(TRANSIT_FRAGMENT_FADE)
                    .addToBackStack("fragB")
                    .commit();
            onA = true;
            }

    }
}
