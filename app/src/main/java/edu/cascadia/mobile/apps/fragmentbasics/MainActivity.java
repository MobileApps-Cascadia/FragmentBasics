package edu.cascadia.mobile.apps.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    boolean onA = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .commit();
    }
    //TODO: Prepare an function for the button to load fragment B into the fragment place
    // ALSO: put the current fragment onto the back stack and set a transition
    public void onSwitchFrag(View view) {
        Fragment otherFragment;
        if (onA == true){
            otherFragment = new FragmentB();
            onA = false;
        }
        else {
            otherFragment = new FragmentA();
            onA = true;
        }
        fm.beginTransaction()
            .replace(R.id.fragment_place, otherFragment, "frag")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack("frag")
            .commit();
    }

    //TODO: Override the onBackPressed() Activity method to make fragments respond to the "Back" button

}
