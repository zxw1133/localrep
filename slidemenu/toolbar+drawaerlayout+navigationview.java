package w.x.z.xmllayout;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FloatingActionButton fb= (FloatingActionButton) findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"119",Snackbar.LENGTH_LONG)
                        .setAction("sure", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"snackbar",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("ZXW");//customize the title,个性化设置title
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));//设置title颜色

        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitleTextColor(Color.RED);
        mToolbar.setSubtitle("zxw");
//        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"menu_click",Toast.LENGTH_SHORT).show();
            }
        });


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button and make it enabled
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_layout_open, R.string.drawer_layout_close);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//        mActionBarDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);//channge the icon,改变图标
//        mActionBarDrawerToggle.syncState();////show the default icon and sync the DrawerToggle state,如果你想改变图标的话，这句话要去掉。这个会使用默认的三杠图标
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));//设置状态栏颜色
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification:
                Toast.makeText(MainActivity.this,"notification",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item1:
                Toast.makeText(MainActivity.this,"action_item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item2:
                Toast.makeText(MainActivity.this,"action_item2",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this,"default",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
