package com.example.rizvan.housecomfort;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public static Resources mResources;

    Drawer.Result drawerResult;
    private static long back_pressed;
  //  public Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Roboto-LightItalic.ttf");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.mResources = getResources();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        TextView textViewTolbarTitle = (TextView)findViewById(R.id.toolbarTextView);
        textViewTolbarTitle.setTypeface(OpenSans.getInstance(getApplicationContext()).getTypeFace());

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }


        initializeNavigationDrawer(toolbar); //  init nav bar

        YoYo.with(Techniques.SlideInRight)
                .duration(5000)
                .playOn(findViewById(R.id.toolbarTextView));

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, RecyclerCardViewFragment.newInstance())
                    .commit();
        }


    }

    public static int generatePaletteColor(Integer drawable){

        Bitmap bitmap = BitmapFactory.decodeResource(getAppResources(), drawable);
        Palette palette = Palette.generate(bitmap, 24);
        int rgbColor = 0;

        try {
            rgbColor = palette.getVibrantSwatch().getRgb();

        }catch (NullPointerException e){
            Log.e("generatePaletteColor", e.toString());
        }

        return rgbColor;
    }

    public void onClickButtonTest(View view){
        SnackbarManager.show(
                Snackbar.with(getApplicationContext()) // context
                        .text("Different colors this time") // text to be displayed
                        .textColor(Color.WHITE) // change the text color
                        //.textTypeface(myTypeface) // change the text font
                        .color(Color.BLACK) // change the background color
                        .actionLabel("Action") // action button label
                        .actionColor(Color.YELLOW) // action button label color
                        //.actionLabelTypeface(myTypeface) // change the action button font
                        .animation(true)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                Log.d(TAG, "Doing something");
                            }
                        }) // action button's ActionClickListener
                , this); // activity where it is displayed
    }

    private void initializeNavigationDrawer(Toolbar toolbar) {

        AccountHeader.Result accHeaderResult = createAccountHeader();

        Drawer drawer = new Drawer();
        drawer.withActivity(this);
        drawer.withToolbar(toolbar);
        drawer.withAccountHeader(accHeaderResult);
        drawer.withDisplayBelowToolbar(true);
        drawer.withActionBarDrawerToggleAnimated(true);
        drawer.addDrawerItems(initializeItemNavBar());
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
                new PrimaryDrawerItem()
                        .withName(R.string.nav_bar_item_3)
                        .withIdentifier(1),
                new DividerDrawerItem(),
                new SecondaryDrawerItem()
                        .withName(R.string.nav_bar_item_4)};
    }

    private AccountHeader.Result createAccountHeader() {

        IProfile profile = new ProfileDrawerItem()
                .withName("HouseComfort")
                .withEmail("housecomfort@gmail.com")
                .withTextColorRes(R.color.md_black_1000);

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

    public static Resources getAppResources() {
        return MainActivity.mResources;
    }
    
    //  interface UI constructor
    /*
    public static boolean parseCommand (String receivedStringBLE){
        String  intermediateDataCommand = "";
        Integer integerCommand = 0;

        if(receivedStringBLE instanceof String){

            Log.i("receivedStringBLE: ", receivedStringBLE);

            for (int position = 0; position < receivedStringBLE.length(); position++){
                if('.' == receivedStringBLE.charAt(position)){

                    Log.i("fullLineReceivedEnd: ", fullLineReceived);

                    for (int positions = 0; positions < fullLineReceived.length(); positions++){
                        if(':' == fullLineReceived.charAt(positions)){

                            Log.i("intermediateDataCommand: ", intermediateDataCommand);

                            if(intermediateDataCommand.equals("dn"))  integerCommand = 1;
                            if(intermediateDataCommand.equals("ds"))  integerCommand = 2;
                            if(intermediateDataCommand.equals("ok"))  integerCommand = 3;
                            if(intermediateDataCommand.equals("err")) integerCommand = 4;
                        }
                        intermediateDataCommand = intermediateDataCommand + fullLineReceived.charAt(positions);
                    }
                }
                fullLineReceived = fullLineReceived + receivedStringBLE.charAt(position);

                Log.i("fullLineReceived: ", fullLineReceived);
                Log.i("fullLineReceived: ", "" + fullLineReceived.length());
            }

            switch (integerCommand) {
                case 1://dn
                    showToastMessage("Received: dn", 1000);
                    fullLineReceived = "";
                    break;
                case 2://ds
                    createElementsdeviceUI(fullLineReceived);
                    fullLineReceived = "";
                    break;
                case 3://ok
                    flagSettingConfirmation(0x10);
                    fullLineReceived = "";
                    break;
                case 4://err
                    flagSettingConfirmation(0x20);
                    fullLineReceived = "";
                default:
                    showToastMessage("Received: unknown command: " + fullLineReceived, 1000);
                    break;
            }
        }else{
            Log.e("Error parseAndActionCommand: ", "argument is not a string");
            return false;
        }
        return true;
    }

    public static boolean createElementsdeviceUI (String dsStringSettingData){

        StringElementsDevice stringElementsDevice = new StringElementsDevice();
        NumberCodeDevice numberCodeDevice = new NumberCodeDevice();

        stringElementsDevice.clearList();
        numberCodeDevice.clearList();

        String stNumberOfDevices;
        String stInfoOfDevices = null;
        String tempString = "";
        int    counter = 0;
        int    numberDevices = -1;
        int    numberCodeButtons = -1;

        for (int pos = 0; pos < dsStringSettingData.length(); pos++){                   
            if(':' == dsStringSettingData.charAt(pos)){                                
                if((pos + 1) <= dsStringSettingData.length()){
                    stringElementsDevice.colorDevice = "" + dsStringSettingData.charAt(pos+1);
                    stringElementsDevice.colorDevice = stringElementsDevice.colorDevice.toUpperCase();
                }
                if((pos + 3) <= dsStringSettingData.length()) {                         
                    stNumberOfDevices = "" + dsStringSettingData.charAt(pos + 3);
                    stInfoOfDevices = dsStringSettingData.substring(pos + 5, dsStringSettingData.length()); 
                    Log.i("stInfoOfDevices", stInfoOfDevices);
                    try {
                        numberCodeDevice.numberOfDevices = Integer.parseInt(stNumberOfDevices, 10); 
                    }catch (NumberFormatException err){
                        Log.i("Parse Int falied", "" + err.getMessage());
                    }
                }
            }
        } // out stInfoOfDevices, numberOfDevices

        // string date stInfoOfDevices
        // TITLE1,_____00_________0_________ON/OFF,____1________31______ON/OFF.
        //   |         |          |           |
        // nameDEV  codeBut    numDev        name

        Log.i("switch for date: --> ",  stInfoOfDevices.toString());

        for(int pos = 0; pos < stInfoOfDevices.length(); pos++){
            if((',' == stInfoOfDevices.charAt(pos)) | ('.' == stInfoOfDevices.charAt(pos))){
                switch (counter){
                    case 0:// Title Device
                        stringElementsDevice.titleDevice = tempString;
                        tempString = "";
                        break;
                    case 1:
                        try {
                            numberCodeButtons = Integer.parseInt(tempString.substring(0, 2), 10);
                            numberDevices = Integer.parseInt("" + (tempString.charAt(2)), 10);
                        }catch (NumberFormatException err){
                            Log.i("Parse Int falied ", "case 1:" + err.getMessage());
                        }
                        numberCodeDevice.numberDevices = numberDevices;
                        numberCodeDevice.numberCodeButtons_1 = numberCodeButtons;
                        stringElementsDevice.titleOptions_1 = tempString.substring(3, tempString.length());
                        tempString = "";
                        break;
                    case 2:
                        try {
                            numberCodeButtons = Integer.parseInt(tempString.substring(0, 2), 10);
                            numberDevices = Integer.parseInt("" + (tempString.charAt(2)), 10);
                        }catch (NumberFormatException err){
                            Log.i("Parse Int falied ", "case 2:" + err.getMessage());
                        }
                        numberCodeDevice.numberCodeButtons_2 = numberCodeButtons;
                        stringElementsDevice.titleOptions_2 = tempString.substring(3, tempString.length());
                        tempString = "";
                        break;
                    case 3:
                        try {
                            numberCodeButtons = Integer.parseInt(tempString.substring(0, 2), 10);
                            numberDevices = Integer.parseInt("" + (tempString.charAt(2)), 10);
                        }catch (NumberFormatException err){
                            Log.i("Parse Int falied ", "case 3:" + err.getMessage());
                        }
                        numberCodeDevice.numberCodeButtons_3 = numberCodeButtons;
                        stringElementsDevice.titleOptions_3 = tempString.substring(3, tempString.length());
                        tempString = "";
                        break;
                    case 4:
                        try {
                            numberCodeButtons = Integer.parseInt(tempString.substring(0, 2), 10);
                            numberDevices = Integer.parseInt("" + (tempString.charAt(2)), 10);
                        }catch (NumberFormatException err){
                            Log.i("Parse Int falied ", "case 4:" + err.getMessage());
                        }
                        numberCodeDevice.numberCodeButtons_4 = numberCodeButtons;
                        stringElementsDevice.titleOptions_4 = tempString.substring(3, tempString.length());
                        tempString = "";
                        break;
                    case 5:
                        try {
                            numberCodeButtons = Integer.parseInt(tempString.substring(0, 2), 10);
                            numberDevices = Integer.parseInt("" + (tempString.charAt(2)), 10);
                        }catch (  NumberFormatException err){
                            Log.i("Parse Int falied ", "case 5:" + err.getMessage());
                        }
                        numberCodeDevice.numberCodeButtons_5 = numberCodeButtons;
                        stringElementsDevice.titleOptions_5 = tempString.substring(3, tempString.length());
                        tempString = "";
                        break;
                }
                counter++;
            } else tempString = tempString + stInfoOfDevices.charAt(pos);

        }

        FragmentActivityDevice.remakingUI(stringElementsDevice, numberCodeDevice);
        return true;
    }

    public static void flagSettingConfirmation(int flag){
        showToastMessage("Received: unknown number" + flag, 1000);
    }
    */

}
