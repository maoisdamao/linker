package com.example.link2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class computerPage extends Fragment {
    @Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
    		Bundle savedInstanceState){
    	return inflater.inflate(R.layout.mix_view,container,false);
    }
	
}