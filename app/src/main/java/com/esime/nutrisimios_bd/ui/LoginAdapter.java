package com.esime.nutrisimios_bd.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.esime.nutrisimios_bd.ui.SingIn.SignIn;
import com.esime.nutrisimios_bd.ui.SingUp.SingUp;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    };



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SignIn signIn = new SignIn();
                return signIn;
            case 1:
            SingUp singUp = new SingUp();
            return singUp;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
