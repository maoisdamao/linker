package com.example.link2;
 /** Created by yaoxiang on 14-4-23.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public  class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mPoints         =1;
    private double mDistance    =0;
    private double mDistance2   =0;
    private boolean mIsMove     =false;
    private  int    mCurX       =0;
    private  int    mCurY       =0;
    private   int   mDx         =0;
    private   int   mDy         =0;
    /*播放键切换标志，true为播放状态*/
    boolean PFlag = true; 
    /*静音键切换标志，true为静音状态*/
    boolean MuteFlag = true;
    



    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.mix_view, container, false); ;
        
        switch(getArguments().getInt(ARG_SECTION_NUMBER)){
            case 1:
            {
                rootView= inflater.inflate(R.layout.mix_view, container, false);
                ImageButton pcctrl=(ImageButton)rootView.findViewById(R.id.imageButton_sd);
                ImageButton mousectrl=(ImageButton)rootView.findViewById(R.id.imageButton_mouse);

                LayoutInflater inflatercomputer=getActivity().getLayoutInflater();
                final View computerview=inflatercomputer.inflate(R.layout.mix_view, null);
                final View mouseview=inflatercomputer.inflate(R.layout.mouse_page, null);

                Button mlefttbutton=(Button)mouseview.findViewById(R.id.left_btn);
                Button mmiddletbutton=(Button)mouseview.findViewById(R.id.middle_btn);
                Button mrighttbutton=(Button)mouseview.findViewById(R.id.right_btn);
                TextView mTouchPad=(TextView)mouseview.findViewById(R.id.touchpad);
                mlefttbutton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch(motionEvent.getAction())
                        {
                            case MotionEvent.ACTION_POINTER_DOWN:
                                break;
                            case MotionEvent.ACTION_DOWN:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_LBKD);
                                System.out.println("left1");
                                break;
                            }
                            case MotionEvent.ACTION_UP:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_LBKU);
                                System.out.println("left2");
                                break;
                            }
                        }
                        return false;
                    }
                });

                mmiddletbutton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch(motionEvent.getAction())
                        {
                            case MotionEvent.ACTION_POINTER_DOWN:
                                break;
                            case MotionEvent.ACTION_DOWN:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_MBKD);
                                System.out.println("middle1");
                                break;
                            }
                            case MotionEvent.ACTION_UP:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_MBKU);
                                System.out.println("middle2");
                                break;
                            }
                        }
                        return false;
                    }
                });


                mrighttbutton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch(motionEvent.getAction())
                        {
                            case MotionEvent.ACTION_POINTER_DOWN:
                                break;
                            case MotionEvent.ACTION_DOWN:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_RBKD);
                                System.out.println("right1");
                                break;
                            }
                            case MotionEvent.ACTION_UP:
                            {
                                StaticString.comm.SendMessage(StaticString.mouse_RBKU);
                                System.out.println("right2");
                                break;
                            }
                        }
                        return false;
                    }
                });


                mTouchPad.setLongClickable(true);
                mTouchPad.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        mPoints=motionEvent.getPointerCount();
                        switch(motionEvent.getAction())
                        {
                            case MotionEvent.ACTION_POINTER_DOWN:
                                break;
                            case MotionEvent.ACTION_DOWN:
                            {
                                mIsMove=false;
                                mCurX=(int)motionEvent.getX();
                                mCurY=(int)motionEvent.getY();
                                if(mPoints==2)
                                {
                                    int ptx0=(int)motionEvent.getX(0);
                                    int pty0=(int)motionEvent.getY(0);
                                    int ptx1=(int)motionEvent.getX(1);
                                    int pty1=(int)motionEvent.getY(1);
                                    mDistance= Math.sqrt(Math.pow(ptx1-ptx0,2)-Math.pow(pty1-pty0,2));
                                }
                                break;
                            }
                            case MotionEvent.ACTION_MOVE:
                            {
                                if(mPoints==1){
                                    mDx=(int)motionEvent.getX()-mCurX;
                                    mDy=(int)motionEvent.getY()-mCurY;
                                    if(Math.abs(mDx)>4||Math.abs(mDy)>4){
                                        String xStr=String.valueOf(mDx);
                                        String yStr=String.valueOf(mDy);

                                        StaticString.comm.SendMessage("MOVE|"+xStr+"|"+yStr);
                                    }
                                }
                                mCurX=(int)motionEvent.getX();
                                mCurY=(int)motionEvent.getY();

                                break;
                            }

                        }
                        return false;
                    }
                });








                Button restartbutton=(Button)computerview.findViewById(R.id.imageButton_restart);
                Button shutdownbutton=(Button)computerview.findViewById(R.id.imageButton_sd);
  /**              ImageButton volmutebutton=(ImageButton)computerview.findViewById(R.id.volumemute_imagebtn);
                ImageButton volvoicebutton=(ImageButton)computerview.findViewById(R.id.volumevoice_imagebtn);
                ImageButton voladdbutton=(ImageButton)computerview.findViewById(R.id.volumeadd_imagebtn);
                ImageButton volsubbutton=(ImageButton)computerview.findViewById(R.id.volumesub_imagebtn);
*/
                restartbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.RESET);
                    }
                });
                shutdownbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.SHUTDOWN);
                    }
                });
/**
                volmutebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.volume_SOUNDQSHUT);
                    }
                });
                volvoicebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.volume_SOUNDOPEN);
                    }
                });
                voladdbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.volume_SOUNDADD);
                    }
                });
                volsubbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StaticString.comm.SendMessage(StaticString.volume_SOUNDSUB);
                    }
                });
                */







                pcctrl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ViewGroup p = (ViewGroup) computerview.getParent();
                        if (p != null) {
                            p.removeAllViewsInLayout();
                        }
                        new AlertDialog.Builder(getActivity()).setTitle("关机与重启").setIcon(
                                android.R.drawable.ic_dialog_info).setView(
                                computerview)
                                .setNegativeButton("取消", null).show();
                    }
                });

                mousectrl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ViewGroup p = (ViewGroup) mouseview.getParent();
                        if (p != null) {
                            p.removeAllViewsInLayout();
                        }
                        new AlertDialog.Builder(getActivity()).setTitle("使用鼠标").setIcon(
                                android.R.drawable.ic_dialog_info).setView(
                                mouseview)
                                .setNegativeButton("取消", null).show();
                    }
                });







                break;
            }
            case 2:
            case 3:
            {
                rootView= inflater.inflate(R.layout.music_view, container, false);
                Button openmusicbutton=(Button)rootView.findViewById(R.id.btn_openfile);
                ImageView musiclight=(ImageView)rootView.findViewById(R.id.music_imageView);
                final AnimationDrawable musiclightAnimation=(AnimationDrawable)musiclight.getDrawable();
                musiclightAnimation.stop();

                openmusicbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<String> filelist = new ArrayList<String>();
                        SharedPreferences settings = getActivity().getSharedPreferences(StaticString.SERRING_INFOS, 0);
                        String name[] = new String[100];
                        for (int i = 0; i < MainActivity.count_of_file; i++) {
                            name[i] = settings.getString(StaticString.NAME + i, "");
                            filelist.add(name[i]);
                        }//读出存储在sharedprerence的值

                        Object[] temp = filelist.toArray();
                        String[] filelsitshow = new String[temp.length];
                        for (int i = 0; i < temp.length; i++)
                            filelsitshow[i] = temp[i].toString();
                        /*建立选区文件的对话框*/
                        new AlertDialog.Builder(getActivity()).setTitle("请选择")
                                .setIcon(android.R.drawable.ic_dialog_info)
                                .setSingleChoiceItems(filelsitshow, 0,
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                StaticString.comm.SendMessage("OPEN|" + i);
                                                Toast.makeText(getActivity(), "OPEN|" + i, Toast.LENGTH_SHORT).show();
                                                musiclightAnimation.start();
                                                dialogInterface.dismiss();

                                            }
                                        }).setNegativeButton("取消", null).show();

                    }
                });

//                ImageButton mutemusicbutton=(ImageButton)rootView.findViewById(R.id.mutemusic_btn);
//                ImageButton smallmusicbutton=(ImageButton)rootView.findViewById(R.id.smallmusic_btn);   //音量减小
                ImageButton loudmusicbutton=(ImageButton)rootView.findViewById(R.id.loudmusic_btn);
                ImageButton upsongbutton=(ImageButton)rootView.findViewById(R.id.presong_btn);          //前一首
                final ImageButton playmusicbutton=(ImageButton)rootView.findViewById(R.id.playmusic_btn);
//                ImageButton stopmusicbutton=(ImageButton)rootView.findViewById(R.id.stopmusic_btn);
                ImageButton downsongbutton=(ImageButton)rootView.findViewById(R.id.nextsong_btn);
                /*播放键切换标志，true为播放状态*/
//                boolean PFlag = true; 

                ImageButton.OnClickListener musiccontrol=new ImageButton.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.playmusic_btn:
                            {if(PFlag == true){
                            	playmusicbutton.setImageResource(R.drawable.ic_music_plause);
                            	StaticString.comm.SendMessage(StaticString.player_PLAY);
                                musiclightAnimation.start();
                                PFlag = false;
                            }else{
                            	playmusicbutton.setImageResource(R.drawable.ic_music_start);
                            	StaticString.comm.SendMessage(StaticString.player_SUSPEND);
                                musiclightAnimation.stop();
                                PFlag = true;
                            }
                                break;
                            }

//                            case R.id.stopmusic_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.player_SUSPEND);
//                                musiclightAnimation.stop();
//                                break;
//                            }
                            case R.id.presong_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.player_LAST);
                                break;
                            }
                            case R.id.nextsong_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.player_NEXT);
                                break;
                            }
//                            case R.id.mutemusic_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.player_SOUND);
//                                break;
//                            }
                            case R.id.loudmusic_btn:
                            {if(MuteFlag == true){
                            	playmusicbutton.setImageResource(R.drawable.ic_volumn_up);
                            	/*此处功能应为取消静音*/
                                StaticString.comm.SendMessage(StaticString.player_SOUNDADD);
                                MuteFlag = false;
                            }else{
                            	playmusicbutton.setImageResource(R.drawable.ic_volumn_mute);
                                StaticString.comm.SendMessage(StaticString.player_SOUND);
                                MuteFlag = true;
                            }
                                break;
                            }
//                            case R.id.smallmusic_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.player_SOUNDSUB);
//                                break;
//                            }
//                            case R.id.min_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.player_MIN);
//                                break;
//                            }
                        }
                    }
                };


//                mutemusicbutton.setOnClickListener(musiccontrol);
//                smallmusicbutton.setOnClickListener(musiccontrol);
                loudmusicbutton.setOnClickListener(musiccontrol);
                upsongbutton.setOnClickListener(musiccontrol);
                playmusicbutton.setOnClickListener(musiccontrol);
//                stopmusicbutton.setOnClickListener(musiccontrol);
                downsongbutton.setOnClickListener(musiccontrol);

                break;
            }
//            case 3:
//            {
//                rootView= inflater.inflate(R.layout.moive_view, container, false);
//                ImageView moivelight=(ImageView)rootView.findViewById(R.id.moiveimageView);
//                Button openmoivebutton=(Button)rootView.findViewById(R.id.openmoive_btn);
//                final AnimationDrawable moivelightAnimation=(AnimationDrawable)moivelight.getDrawable();
//                moivelightAnimation.stop();
//
//                openmoivebutton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        ArrayList<String> filelist = new ArrayList<String>();
//                        SharedPreferences settings = getActivity().getSharedPreferences(StaticString.SERRING_INFOS, 0);
//                        String name[] = new String[100];
//                        for (int i = 0; i < ControlActivity.count_of_file; i++) {
//                            name[i] = settings.getString(StaticString.NAME + i, "");
//                            filelist.add(name[i]);
//                        }//读出存储在sharedprerence的值
//
//                        Object[] temp = filelist.toArray();
//                        String[] filelsitshow = new String[temp.length];
//                        for (int i = 0; i < temp.length; i++)
//                            filelsitshow[i] = temp[i].toString();
//                        /*建立选区文件的对话框*/
//                        new AlertDialog.Builder(getActivity()).setTitle("请选择")
//                                .setIcon(android.R.drawable.ic_dialog_info)
//                                .setSingleChoiceItems(filelsitshow, 0,
//                                        new DialogInterface.OnClickListener() {
//
//                                            @Override
//                                            public void onClick(DialogInterface dialogInterface, int i) {
//                                                StaticString.comm.SendMessage("OPEN|" + i);
//                                                Toast.makeText(getActivity(), "OPEN|" + i, Toast.LENGTH_SHORT).show();
//                                                moivelightAnimation.start();
//                                                dialogInterface.dismiss();
//
//                                            }
//                                        }).setNegativeButton("取消", null).show();
//
//                    }
//                });
//
//
//                ImageButton mutemoivebutton=(ImageButton)rootView.findViewById(R.id.mutemoive_btn);
//                ImageButton smallmoivebutton=(ImageButton)rootView.findViewById(R.id.smallmoive_btn);
//                ImageButton loudmoivebutton=(ImageButton)rootView.findViewById(R.id.loudmoive_btn);
//                ImageButton speedbutton=(ImageButton)rootView.findViewById(R.id.speed_btn);
//                ImageButton playmoivebutton=(ImageButton)rootView.findViewById(R.id.playmoive_btn);
//                ImageButton stopmoivebutton=(ImageButton)rootView.findViewById(R.id.stopmoive_btn);
//                ImageButton fastbutton=(ImageButton)rootView.findViewById(R.id.fast_btn);
//
//                ImageButton.OnClickListener moivecontrol=new ImageButton.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        switch (view.getId()){
//                            case R.id.playmoive_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_PLAY);
//                                moivelightAnimation.start();
//                                break;
//                            }
//
//                            case R.id.stopmoive_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_SUSPEND);
//                                moivelightAnimation.stop();
//                                break;
//                            }
//                            case R.id.speed_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_SPEED);
//
//                                break;
//                            }
//                            case R.id.fast_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_BACK);
//                                break;
//                            }
//                            case R.id.mutemoive_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_SOUND);
//                                break;
//                            }
//                            case R.id.loudmoive_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_SOUNDADD);
//                                break;
//                            }
//                            case R.id.smallmoive_btn:
//                            {
//                                StaticString.comm.SendMessage(StaticString.video_SOUNDSUB);
//                                break;
//                            }
////                            case R.id.min_btn:
////                            {
////                                StaticString.comm.SendMessage(StaticString.player_MIN);
////                                break;
////                            }
//                        }
//                    }
//                };
//
//
//                mutemoivebutton.setOnClickListener(moivecontrol);
//                smallmoivebutton.setOnClickListener(moivecontrol);
//                loudmoivebutton.setOnClickListener(moivecontrol);
//                speedbutton.setOnClickListener(moivecontrol);
//                playmoivebutton.setOnClickListener(moivecontrol);
//                stopmoivebutton.setOnClickListener(moivecontrol);
//                fastbutton.setOnClickListener(moivecontrol);
//
//
//
//
//
//                break;
//            }
            case 4:
            {
                rootView= inflater.inflate(R.layout.ppt_view, container, false);
                Button openpptbutton=(Button)rootView.findViewById(R.id.openppt_btn);
                ImageView pptlight=(ImageView)rootView.findViewById(R.id.pptimageView);
                final AnimationDrawable pptlightAnimation=(AnimationDrawable)pptlight.getDrawable();
               pptlightAnimation.stop();



                openpptbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<String> filelist=new ArrayList<String>();
                        SharedPreferences settings=getActivity().getSharedPreferences(StaticString.SERRING_INFOS, 0);
                        String name[]=new String[100];
                        for(int i=0;i<MainActivity.count_of_file;i++)
                        {
                            name[i]=settings.getString(StaticString.NAME+i,"");
                            filelist.add(name[i]);
                        }//读出存储在sharedprerence的值

                        Object [] temp=filelist.toArray();
                        String [] filelsitshow=new String[temp.length];
                        for(int i=0;i<temp.length;i++)
                            filelsitshow[i]=temp[i].toString();
                        /*建立选区文件的对话框*/
                        new AlertDialog.Builder(getActivity()).setTitle("请选择").setIcon(android.R.drawable.ic_dialog_info)
                                .setSingleChoiceItems(filelsitshow,0,
                                        new DialogInterface.OnClickListener(){

                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                StaticString.comm.SendMessage("OPEN|" + i);
                                                Toast.makeText(getActivity(),"OPEN|"+i,Toast.LENGTH_SHORT).show();
                                                dialogInterface.dismiss();
                                                pptlightAnimation.start();
                                            }
                                        }).setNegativeButton("取消", null).show();

                    }
                });

                ImageButton pptbutton=(ImageButton)rootView.findViewById(R.id.PPT_btn);
                ImageButton outpptbutton=(ImageButton)rootView.findViewById(R.id.exitPPT_btn);
                ImageButton uppagebutton=(ImageButton)rootView.findViewById(R.id.uppage_btn);
                ImageButton downpagebutton=(ImageButton)rootView.findViewById(R.id.downpage_btn);
//                pptbutton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        StaticString.comm.SendMessage(StaticString.ppt_PLAY);
//                        //Log.i("system.out", "computer-->start");
//                    }
//                });

                ImageButton.OnClickListener pptcontrol=new ImageButton.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.PPT_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.ppt_PLAY);
                                pptlightAnimation.start();
                                Log.i("system.out", "pptplay-->start");
                                break;
                            }

                            case R.id.uppage_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.ppt_PAGEUP);
                                Log.i("system.out", "uppage-->start");
                                break;
                            }
                            case R.id.downpage_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.ppt_PAGEDOWN);
                                Log.i("system.out", "downpage-->start");
                                break;
                            }case R.id.exitPPT_btn:
                            {
                                StaticString.comm.SendMessage(StaticString.ppt_EXIT);
                                Log.i("system.out", "exitPPT-->start");
                                pptlightAnimation.stop();
                                break;
                            }
                        }
                    }
                };

                pptbutton.setOnClickListener(pptcontrol);
                outpptbutton.setOnClickListener(pptcontrol);
                uppagebutton.setOnClickListener(pptcontrol);
                downpagebutton.setOnClickListener(pptcontrol);


                break;
            }
        }

        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.i("system.out", "onActivityCreated-->start");
//        ImageButton pptbutton=(ImageButton)getView().findViewById(R.id.imageButton_sd);
//
//                pptbutton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //StaticString.comm.SendMessage(StaticString.ppt_PLAY);
//
//                    }
//                });
    }


}