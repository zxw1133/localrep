package w.x.z.tablayout;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tb;
    private ViewPager vp;
    private List<Myfragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.viewPager);

        for(int i=0;i<5;i++){
            Myfragment myfragment= (Myfragment) Myfragment.newinstance(i);
            list.add(i,myfragment);
        }
        vp.setAdapter(new MyfragmentAdapter(getSupportFragmentManager()));
        tb.setupWithViewPager(vp);
        tb.setTabMode(TabLayout.MODE_FIXED);
        tb.setSelectedTabIndicatorColor(Color.GREEN);
        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        tb.setTabTextColors(Color.BLACK,Color.RED);

    }
    class MyfragmentAdapter extends FragmentPagerAdapter {
        private String[] tabs=new String[]{"tab1","tab2","tab3","tab4","tab5"};
        public MyfragmentAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
