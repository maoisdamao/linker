package com.example.link2;


import java.io.IOException;

/**
 * Created by yaoxiang on 14-3-15.
 */
public interface CommunicationInterface {

    int Connetct(String MYSERVERIP, int MYSERVEDRPORT);//������������
    String SendMessage(String mymessage);//������������
    void StartReadThread();//���������������������������������������������
     void StopReadThread() ;
    void Stopsocket() throws IOException;

}
