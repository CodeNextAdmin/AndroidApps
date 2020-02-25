/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.touringmusician;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TourMap extends View {

    private Bitmap mapImage;
    private CircularLinkedList list = new CircularLinkedList();
    private String insertMode = "Add";

    private Point lastPoint;
    private Point currentPoint;
    private ArrayList<Point> pointArray = new ArrayList<Point>();


    public TourMap(Context context) {
        super(context);
        mapImage = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.map);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mapImage, 0, 0, null);
        Paint pointPaint = new Paint();
        Paint linePaint = new Paint();
        linePaint.setColor(Color.BLUE);
        pointPaint.setColor(Color.RED);




        for (Point p : list) {
            /**
             **
             **  YOUR CODE GOES HERE
             **
             **/


            Log.d("Point in list", " x: " + p.x + " y: " + p.y);

            Log.d("getNext", " "+list.getCurrent() )  ;
            Log.d("getPrev", " "+list.getPrev() )  ;

            //if the current point is the same as last point, this is the first run
            //

            if(lastPoint ==null){
               // Log.d("point" , "currentPoint == lastPoint");
                lastPoint =p;

            }

            currentPoint = p;
            canvas.drawCircle(currentPoint.x, currentPoint.y, 20, pointPaint);
            canvas.drawLine(lastPoint.x, lastPoint.y, currentPoint.x, currentPoint.y, linePaint);

            lastPoint = currentPoint;
        }

        pointArray.add(currentPoint);
        // Log.d("currentPoint Array", "contains: " +pointArray.toString());
       // Log.d("array count" , ": " + pointArray.size());





        Log.d("onDraw", " list has :  " + list.head);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

       // Log.d("Touch Event", "x: " + event.getX());
        //Log.d("Touch Event ", "y: "+event.getY());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Point p = new Point((int) event.getX(), (int)event.getY());
                if (insertMode.equals("Closest")) {
                    list.insertNearest(p);
                } else if (insertMode.equals("Smallest")) {
                    list.insertSmallest(p);
                } else {
                    list.insertBeginning(p);

                }
                TextView message = (TextView) ((Activity) getContext()).findViewById(R.id.game_status);
                if (message != null) {
                    message.setText(String.format("Tour length is now %.2f", list.totalDistance()));
                }
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }

    public void reset() {

        Log.d("reset", "tourMap");
        list.reset();
        pointArray.clear();
        invalidate();
    }

    public void setInsertMode(String mode) {
        insertMode = mode;
    }


}
