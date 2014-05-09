package com.example.link2;

import android.os.Handler;

/**
 * Created by yaoxiang on 14-4-1.
 */
public class StaticString {

    public  static   final String SEETING_IP="SEETING_Ip";
    public  static   final String IP="IP";
    public  static   final String PASSWORD="PASSWORD";
    public  static   final String CheckREC_PassNo="password incorrect!";
    public  static   final String CheckREC_PassYes="password correct!";
    public  static   CommunicationInterface comm=new Communication();
    public  static   Handler handler;
    public  static   final String SERRING_INFOS="SERRING_Infos";
    public  static   final String NAME="NAME";
    public  static   final String CheckREC_EndofFile="end of file";
    public  static   final String CheckCONNECT_OutofTime="������������";
    public  static   final String CheckREAD_OutofTime="������������������";
    public  static   final String AcStopSocket="���������������������";
    /**
     * ������
     */
    public static final String SHUTDOWN="SHUTDOWN|0";
    /**
     * ������
     */
    public static final String RESET="SHUTDOWN|1";
    /**
     * ������������������������
     */
    public static final String LOAD="LOAD|1";
    /**
     * ������������,i���������������������������������������������
     */
    public static final String OPEN="OPEN|i";
    //PPT������
    /**
     * ������PPT
     */
    public static final String ppt_PLAY="PPT|1";
    /**
     * ���������ppt
     */
    public static final String ppt_PAGEUP="PPT|2";
    /**
     * ���������PPT
     */
    public static final String ppt_PAGEDOWN="PPT|3";
    /**
     * ������PPT������
     */
    public static final String ppt_EXIT="PPT|4";

    // audio������������
    /**
     * ������/������
     */
    public static final String player_PLAY="PLAYER|1";
    /**
     * ������
     */
    public static final String player_SUSPEND="PLAYER|2";
    /**
     * ���������
     */
    public static final String player_LAST="PLAYER|3";
    /**
     * ���������
     */
    public static final String player_NEXT="PLAYER|4";
    /**
     * ������/������������
     */
    public static final String player_SOUND="PLAYER|5";
    /**
     * ������������
     */
    public static final String player_SOUNDADD="PLAYER|6";
    /**
     * ������������
     */
    public static final String player_SOUNDSUB="PLAYER|7";
    /**
     * ���������
     */
    public static final String player_MIN="PLAYER|8";
    //video������������
    /**
     * ������/������
     */
    public static final String video_PLAY = "PLAYER|9";
    /**
     * ������
     */
    public static final String video_SUSPEND = "PLAYER|10";
    /**
     * ������/������������
     */
    public static final String video_SOUND = "PLAYER|11";
    /**
     * ������������
     */
    public static final String video_SOUNDADD = "PLAYER|12";
    /**
     * ������������
     */
    public static final String video_SOUNDSUB = "PLAYER|13";
    /**
     * ������
     */
    public static final String video_SPEED="PLAYER|14";
    /**
     * ������
     */
    public static final String video_BACK="PLAYER|15";
    /**
     * ������
     */
    public static final String video_EXIT="PLAYER|16";


    /**
     * 0���winXP��� 1���win7
     * 1:��������� 2������������ -1������������ -2���������������
     * by hcy
     */
    public static final String volume_SOUNDADD = "VOLUME|1";
    public static final String volume_SOUNDSUB = "VOLUME|2";
    public static final String volume_SOUNDQSHUT = "VOLUME|-1";
    public static final String volume_SOUNDOPEN = "VOLUME|-2";




    //���������������������
    /**
     * ������������,������i������������������������������������������/������������������������������������������/������������������������
     */
    public static final String mouse_WHEEL="MW|i";
    /**
     * ������������,x,y���������������������������������������������������
     */
    public static final String mouse_MOVE="MOVE|x|y";
    /**
     * ������������������
     */
    public static final String mouse_LBKD="TM|1";
    /**
     * ������������������
     */
    public static final String mouse_LBKU="TM|2";
    /**
     * ������������������
     */
    public static final String mouse_RBKD="TM|3";
    /**
     * ������������������
     */
    public static final String mouse_RBKU="TM|4";
    /**
     * ������������������
     */
    public static final String mouse_MBKD="TM|5";
    /**
     * ������������������
     */
    public static final String mouse_MBKU="TM|6";


    //���������������������
    /**
     * A���������
     */
    public static final String key_AD="KB|AD";
    /**
     * A���������
     */
    public static final String key_AU="KB|AU";
    /**
     * B���������
     */
    public static final String key_BD="KB|BD";
    /**
     * B���������
     */
    public static final String key_BU="KB|BU";
    /**
     * C���������
     */
    public static final String key_CD="KB|CD";
    /**
     * C���������
     */
    public static final String key_CU="KB|CU";
    /**
     * D���������
     */
    public static final String key_DD="KB|DD";
    /**
     * D���������
     */
    public static final String key_DU="KB|DU";
    /**
     * E���������
     */
    public static final String key_ED="KB|ED";
    /**
     * E���������
     */
    public static final String key_EU="KB|EU";
    /**
     * F���������
     */
    public static final String key_FD="KB|FD";
    /**
     * F���������
     */
    public static final String key_FU="KB|FU";
    /**
     * G���������
     */
    public static final String key_GD="KB|GD";
    /**
     * G���������
     */
    public static final String key_GU="KB|GU";
    /**
     * H���������
     */
    public static final String key_HD="KB|HD";
    /**
     * H���������
     */
    public static final String key_HU="KB|HU";
    /**
     * I���������
     */
    public static final String key_ID="KB|ID";
    /**
     * I���������
     */
    public static final String key_IU="KB|IU";
    /**
     * J���������
     */
    public static final String key_JD="KB|JD";
    /**
     * J���������
     */
    public static final String key_JU="KB|JU";
    /**
     * K���������
     */
    public static final String key_KD="KB|KD";
    /**
     * K���������
     */
    public static final String key_KU="KB|KU";
    /**
     * L���������
     */
    public static final String key_LD="KB|LD";
    /**
     * L���������
     */
    public static final String key_LU="KB|LU";
    /**
     * M���������
     */
    public static final String key_MD="KB|MD";
    /**
     * M���������
     */
    public static final String key_MU="KB|MU";
    /**
     * N���������
     */
    public static final String key_ND="KB|ND";
    /**
     * N���������
     */
    public static final String key_NU="KB|NU";
    /**
     * O���������
     */
    public static final String key_OD="KB|OD";
    /**
     * O���������
     */
    public static final String key_OU="KB|OU";
    /**
     * P���������
     */
    public static final String key_PD="KB|PD";
    /**
     * P���������
     */
    public static final String key_PU="KB|PU";
    /**
     * Q���������
     */
    public static final String key_QD="KB|QD";
    /**
     * Q���������
     */
    public static final String key_QU="KB|QU";
    /**
     * R���������
     */
    public static final String key_RD="KB|RD";
    /**
     * R���������
     */
    public static final String key_RU="KB|RU";
    /**
     * S���������
     */
    public static final String key_SD="KB|SD";
    /**
     * S���������
     */
    public static final String key_SU="KB|SU";
    /**
     * T���������
     */
    public static final String key_TD="KB|TD";
    /**
     * T���������
     */
    public static final String key_TU="KB|TU";
    /**
     * U���������
     */
    public static final String key_UD="KB|UD";
    /**
     * U���������
     */
    public static final String key_UU="KB|UU";
    /**
     * V���������
     */
    public static final String key_VD="KB|VD";
    /**
     * V���������
     */
    public static final String key_VU="KB|VU";
    /**
     * W���������
     */
    public static final String key_WD="KB|WD";
    /**
     * W���������
     */
    public static final String key_WU="KB|WU";
    /**
     * X���������
     */
    public static final String key_XD="KB|XD";
    /**
     * X���������
     */
    public static final String key_XU="KB|XU";
    /**
     * Y���������
     */
    public static final String key_YD="KB|YD";
    /**
     * Y���������
     */
    public static final String key_YU="KB|YU";
    /**
     * Z���������
     */
    public static final String key_ZD="KB|ZD";
    /**
     * Z���������
     */
    public static final String key_ZU="KB|ZU";

    /**
     * 1���������
     */
    public static final String key_1D="KB|1D";
    /**
     * 1���������
     */
    public static final String key_1U="KB|1U";
    /**
     * 2���������
     */
    public static final String key_2D="KB|2D";
    /**
     * 2���������
     */
    public static final String key_2U="KB|2U";
    /**
     * 3���������
     */
    public static final String key_3D="KB|3D";
    /**
     * 3���������
     */
    public static final String key_3U="KB|3U";
    /**
     * 4���������
     */
    public static final String key_4D="KB|4D";
    /**
     * 4���������
     */
    public static final String key_4U="KB|4U";
    /**
     * 5���������
     */
    public static final String key_5D="KB|5D";
    /**
     * 5���������
     */
    public static final String key_5U="KB|5U";
    /**
     * 6���������
     */
    public static final String key_6D="KB|6D";
    /**
     * 6���������
     */
    public static final String key_6U="KB|6U";
    /**
     * 7���������
     */
    public static final String key_7D="KB|7D";
    /**
     * 7���������
     */
    public static final String key_7U="KB|7U";
    /**
     * 8���������
     */
    public static final String key_8D="KB|8D";
    /**
     * 8���������
     */
    public static final String key_8U="KB|8U";
    /**
     * 9���������
     */
    public static final String key_9D="KB|9D";
    /**
     * 9���������
     */
    public static final String key_9U="KB|9U";
    /**
     * 0���������
     */
    public static final String key_0D="KB|0D";
    /**
     * 0���������
     */
    public static final String key_0U="KB|0U";

    /**
     * ������������������
     */
    public static final String key_UPKD="KB|UPKD";
    /**
     * ������������������
     */
    public static final String key_UPKU="KB|UPKU";
    /**
     * ������������������
     */
    public static final String key_DOWNKD="KB|DOWNKD";
    /**
     * ������������������
     */
    public static final String key_DOWNKU="KB|DOWNKU";
    /**
     * ������������������
     */
    public static final String key_LEFTKD="KB|LEFTKD";
    /**
     * ������������������
     */
    public static final String key_LEFTKU="KB|LEFTU";
    /**
     * ������������������
     */
    public static final String key_RIGHTKD="KB|RIGHTKD";
    /**
     * ������������������
     */
    public static final String key_RIGTHKU="KB|RIGHTKU";
    /**
     * TAB���������
     */
    public static final String key_TABD="KB|TABD";
    /**
     * TAB���������
     */
    public static final String key_TABU="KB|TABU";
    /**
     * Shift���������
     */
    public static final String key_SHIFTD="KB|SHIFTD";
    /**
     * Shift���������
     */
    public static final String key_SHIFTU="KB|SHIFTU";
    /**
     * Ctrl���������
     */
    public static final String key_CTRLD="KB|CTRLD";
    /**
     * Ctrl���������
     */
    public static final String key_CTRLU="KB|CTRLU";
    /**
     * Alt���������
     */
    public static final String key_ALTD="KB|ALTD";
    /**
     * Alt���������
     */
    public static final String key_ALTU="KB|ALTU";
    /**
     * Enter���������
     */
    public static final String key_ENTERD="KB|ENTERD";
    /**
     * Enter���������
     */
    public static final String key_ENTERU="KB|ENTERU";
    /**
     * PageUp���������
     */
    public static final String key_PAGEUPD="KB|PAGEUPD";
    /**
     * PageUp���������
     */
    public static final String key_PAGEUPU="KB|PAGEUPU";
    /**
     * PageDown���������
     */
    public static final String key_PAGEDOWND="KB|PAGEDOWND";
    /**
     * PageDown���������
     */
    public static final String key_PAGEDOWNU="KB|PAGEDOWNU";
    /**
     * Backspace���������
     */
    public static final String key_BACKSPACED="KB|BACKSPACED";
    /**
     * Backspace���������
     */
    public static final String key_BACKSPACEU="KB|BACKESPACEU";
    /**
     * Space���������
     */
    public static final String key_SPACED="KB|SPACED";
    /**
     * Space���������
     */
    public static final String key_SPACEU="KB|SPACEU";
    /**
     * Esc���������
     */
    public static final String key_ESCD="KB|ESCD";
    /**
     * Esc���������
     */
    public static final String key_ESCU="KB|ESCU";
}
