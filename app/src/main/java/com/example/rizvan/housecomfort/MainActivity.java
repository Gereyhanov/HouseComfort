package com.example.rizvan.housecomfort;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


public class MainActivity extends AppCompatActivity {

    Drawer.Result drawerResult;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        initializeNavigationDrawer(toolbar);

    }

    private void initializeNavigationDrawer(Toolbar toolbar) {

        AccountHeader.Result accHeaderResult = createAccountHeader();

        Drawer drawer = new Drawer();
        drawer.withActivity(this);
        drawer.withToolbar(toolbar);
        drawer.withAccountHeader(accHeaderResult);
        drawer.withDisplayBelowToolbar(true);
        drawer.withActionBarDrawerToggleAnimated(true);
        drawer.addDrawerItems(
                initializeItemNavBar()
        );
        drawer.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                showToastMessage("I = " + i + " L=" + l,1000);
            }
        })
        .build();

    }

    private IDrawerItem[] initializeItemNavBar() {
        return new IDrawerItem[]{new PrimaryDrawerItem()
                .withName(R.string.nav_bar_item_1)
                .withIdentifier(1),
                new PrimaryDrawerItem()
                        .withName(R.string.nav_bar_item_2)
                        .withIdentifier(1),
                new DividerDrawerItem(),
                new SecondaryDrawerItem()
                        .withName(R.string.nav_bar_item_3)};
    }

    private AccountHeader.Result createAccountHeader() {

        IProfile profile = new ProfileDrawerItem()
                .withName("Rizvan")
                .withEmail("gereyhanov@gmail.com")
                .withIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));

        return new AccountHeader()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.header_blue_grey_800)
                    .addProfiles(profile)
                    .build();
    }

    @Override
    public void onBackPressed() {
        if(drawerResult != null && drawerResult.isDrawerOpen()){
            drawerResult.closeDrawer();
        }else {
            super.onBackPressed();
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                showToastMessage(R.string.showText_exit, 1000);
                back_pressed = System.currentTimeMillis();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public  void showToastMessage(Object text, int duration){
        final Toast aToast = Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT);
        aToast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                aToast.cancel();
            }
        }, duration);
    }


}
