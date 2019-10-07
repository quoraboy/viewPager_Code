package com.example.last;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class viewpageradaptor extends FragmentStatePagerAdapter {

    public viewpageradaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
     pager1 pg =new pager1();
        Bundle bundle=new Bundle();
        i=i+1;
        bundle.putString("Message","Hello from page:"+i);
        pg.setArguments(bundle);

        return pg;



    }

    @Override
    public int getCount() {
        return 3;
    }
}
