package com.example.spotman.classes.misc;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.spotman.classes.misc.http.Requester;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class MyLogger
    {
        public int nextId;
        public List<LogEntry> entries;

        public int totalWebCalls;

        public MyLogger()
        {
            nextId = 0;
            entries = new ArrayList<LogEntry>();

            totalWebCalls = 0;

        }

        public LogEntry GetEntry(int i)
        {
            return entries.get(i);
        }

        //=====
        //log methods:

        public void logError(String l)
        {
            LogEntry newentry;
            newentry = new LogEntry(Priority.High, l);
            entries.add(newentry);
            Log.d(newentry.tag, "[" + "error" + "]" + "\t" + newentry.logValue);
        }

        public void logGeneralError()
        {
            LogEntry newentry;
            newentry = new LogEntry(Priority.Normal, "General error logged.", "error");
            entries.add(newentry);
            Log.d(newentry.tag, "[" + newentry.tag + "]" + "\t" + newentry.logValue);
        }

        public void log(String l)
        {
            LogEntry newentry;
            newentry = new LogEntry(Priority.Normal, l);
            entries.add(newentry);
            Log.d(newentry.tag, "[" + newentry.tag + "]" + "\t" + newentry.logValue);
        }

        public void log(Priority priority, String l)
        {
            LogEntry newentry;
            newentry = new LogEntry(priority, l);
            entries.add(newentry);
            Log.d(newentry.tag, "[" + newentry.tag + "]" + "\t" + newentry.logValue);
        }

        public void log(String l, String tag)
        {
            LogEntry newentry;
            newentry = new LogEntry(Priority.Normal, l, tag);
            entries.add(newentry);
            Log.d(newentry.tag, "[" + newentry.tag + "]" + "\t" + newentry.logValue);

        }

        public void log(String l, Priority priority, String tag)
        {
            LogEntry newentry;
            newentry = new LogEntry(priority, l, tag);
            entries.add(newentry);
            Log.d(newentry.tag, "[" + newentry.tag + "]" + "\t" + newentry.logValue);

        }



        //quick log urls from requester
        public void logRequest(String url)
        {
            log("Request created for: " + url, "http");
            totalWebCalls ++;

        }
        public void logRequest(Request req)
        {
            log("Request created for: " + req.url(), "http");
            totalWebCalls ++;
        }


        //============
        //overrides:


        @NonNull
        @Override
        public String toString()
        {
            String so = "";

            for(LogEntry s : entries)
            {
                so += s.toString() + "\n";
            }

            return so;
        }



        //==================
        //logEntry inner class:
        public enum Priority {High, Low, Normal}
        public class LogEntry
        {
            public int id;

            public String tag;

            public LocalDateTime time;

            public Priority priority;
            public String logValue;


            //===
            //constructors:

            public LogEntry(Priority priority, String logValue)
            {
                this.time = LocalDateTime.now();
                this.priority = priority;
                this.logValue = logValue;

                this.tag = "none";
            }

            public LogEntry(Priority priority, String logValue, String tag)
            {
                this.time = LocalDateTime.now();
                this.priority = priority;
                this.logValue = logValue;

                this.tag = tag;
            }

            //===============


            @NonNull
            @Override
            public String toString()
            {
                return  "" + id + "\t" + logValue;
            }
        }
        //==================


    }
