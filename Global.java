package com.example.spotman.classes.misc;

import android.content.Context;

import com.example.spotman.classes.Fact;
import com.example.spotman.classes.misc.http.Requester;

import java.util.ArrayList;
import java.util.List;

public class Global
{

    //fields:
    //=======================================================================
    public String tst;

    public List<Fact> factList = new ArrayList<>();

    public Fact fact1;
    public Fact fact2;

    public Requester requester;

    //=======================================================================


    //constructor
    public Global()
    {

    }


    public void initRequester(Context context)
    {
        requester = new Requester(context);
    }

}
