package com.filmsbykris.logtime;
import android.util.Log;

public class MultithreadThing extends Thread{
  @Override
  public void run() {
    int i=1;

    Long time1 = System.currentTimeMillis()/1000;
    while(i == 1){
      Long time2 = System.currentTimeMillis()/1000;
      Long time_check = time2 - time1;
      if ( time_check > 0 ){
        String ts = time2.toString();
        String string = String.format("TIMEEEE %s", ts);
        Log.e("Service", string );
        time1 = System.currentTimeMillis()/1000;
      }
    }
  }
}
