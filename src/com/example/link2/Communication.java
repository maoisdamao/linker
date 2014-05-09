package com.example.link2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by yaoxiang on 14-3-15.
 */
public class Communication implements CommunicationInterface{

    protected Socket _socket =null;
    private  PrintWriter _printeWriter =null;
    protected String  _message ="";
    private    Thread _thread =null;
    long time1=0;
    private BufferedReader _bufferedReader= null;




    @Override

    public int Connetct(String MYSERVERIP, int MYSERVEDRPORT) {

        try
                {   _socket=new Socket();
                    SocketAddress address = new InetSocketAddress(MYSERVERIP,MYSERVEDRPORT);
                    time1 = System.currentTimeMillis();
                    _socket.connect(address, 1000);//���������������������������������1000������
                    _bufferedReader=new BufferedReader(new InputStreamReader(_socket.getInputStream(),"GB2312"));
                    _printeWriter=new PrintWriter(_socket.getOutputStream(),true);
                    _socket.setSoTimeout(1000); //���������������������������������������1000������
                    return 2;

    }

    catch (Exception e)
    {
        if (!_socket.isClosed() && _socket.isConnected())
            return 0;//������������������
        else
            return 1;  //������������

    }
    finally{
        long time2 = System.currentTimeMillis();

    }



    }
    public void Stopsocket() throws IOException {
        _socket.close();
    }
    @Override
    public String SendMessage(String mymessage) {
        try
        {

            _printeWriter.println(mymessage);
            _printeWriter.flush();


        }
        catch(Exception e)
        {

        }

        return mymessage;
    }


    public void StartReadThread() {

        _thread=new Thread(_runnable);
        _thread.start();
    }

    public void StopReadThread() {


        _thread.currentThread().interrupt();
    }


    private  Runnable _runnable =new Runnable() {
        @Override
        public void run() {
            while(true){
                try
                {
                    if ((_message =_bufferedReader.readLine())!=null)
                    { StaticString.handler.sendMessage(StaticString.handler.obtainMessage(0,_message));
                    }
                }
                catch (Exception e)
                {

                }
            }
        }
    };

}
