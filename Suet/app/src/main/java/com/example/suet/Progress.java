package com.example.suet;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.ActionBarActivity;

import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Progress extends AppCompatActivity {


    BarChart chart;
    LineChart lineChart;
    PieChart pieChart;


    final FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


         chart = (BarChart) findViewById(R.id.barchart);


        int[] colors = new int[] {Color.rgb(220,101, 002),
                Color.rgb(20, 110,220),
                Color.rgb(150, 0, 29),
                Color.rgb(255, 255, 0),
                Color.rgb(120, 0, 225),
                Color.rgb(20, 110, 110),
                Color.rgb(255, 0, 255)
        };
        String[] legendName = {"Thing 1", "Thing 2", "Thing 3", "Thing 4", "Thing 5"};

        // barchart begin
//        List<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(0f, 30f));
//        entries.add(new BarEntry(1f, 80f));
//        entries.add(new BarEntry(2f, 60f));
//        entries.add(new BarEntry(3f, 50f));
//        // gap of 2f
//        entries.add(new BarEntry(5f, 70f));
//        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(stackedBarEntries(), "BarDataSet");
        set.setColors(colors);

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        //end barchart

        chart.setBackgroundColor(Color.LTGRAY);
        chart.setDrawBorders(true);


        // line chart begin
        lineChart = (LineChart) findViewById(R.id.linechart);

        LineDataSet linedataset = new LineDataSet(lineDataValues(), "Data 1");
        ArrayList<ILineDataSet> lineArrayDataSet = new ArrayList<>();

        lineArrayDataSet.add(linedataset);

        LineData lineData = new LineData(lineArrayDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();

        Description desc = new Description();
        desc.setText("my Graph is pretty");
        desc.setTextColor(Color.MAGENTA);

        desc.setTextSize(20);

        lineChart.setDescription(desc);


        //now the second data set:
        LineDataSet linedataset2 = new LineDataSet(lineDataValues2(), "Data 2");
        lineArrayDataSet.add(linedataset2);

        Legend legend1 = lineChart.getLegend();
        legend1.setEnabled(true);
        //legend1.setTextColor(Color.MAGENTA);
        legend1.setForm(Legend.LegendForm.LINE);
        legend1.setFormSize(20);
        legend1.setXEntrySpace(15);



        LegendEntry[] legendEntries = new LegendEntry[5];

        for (int i = 0 ; i< legendEntries.length ; i++){

            LegendEntry legendEntry = new LegendEntry();
            legendEntry.formColor = colors[i];
            legendEntry.label = String.valueOf(legendName[i]);
            legendEntries[i] = legendEntry;
        }

        legend1.setCustom(legendEntries);


      // Now for the Pie Chart

        pieChart = findViewById(R.id.piechart);
        PieDataSet pieDataSet = new PieDataSet(pieDataValues(), "");
        pieDataSet.setColors(colors);
        PieData pidata = new PieData(pieDataSet);

        pieChart.setData(pidata);

        pieChart.invalidate();






    }

    private ArrayList<BarEntry> stackedBarEntries(){

        ArrayList<BarEntry> datavalues = new ArrayList<BarEntry>();

        datavalues.add(new BarEntry(0, new float[]{2, 4.5f, 3, 5.5f, 10.2f}));
        datavalues.add(new BarEntry(1, new float[]{12, 11.2f, 6, 1.5f, 14.2f}));
        datavalues.add(new BarEntry(2, new float[]{9.9f, 13.5f, 3, 8.5f, 5.2f}));
        datavalues.add(new BarEntry(3, new float[]{4, 4.9f, 3.3f, 15.5f, 12.2f}));
        datavalues.add(new BarEntry(4, new float[]{4.5f, 4.5f, 9.3f, 11.5f, 11.2f}));
        datavalues.add(new BarEntry(5, new float[]{10.3f, 7.3f, 4.5f, 2.5f, 9.7f}));
        datavalues.add(new BarEntry(6, new float[]{7, 14.4f, 13, 8.5f, 1.2f}));



        return datavalues;
    }

    private List getDataSet() {
        ArrayList dataSets = null;

        ArrayList valueSet1 = new ArrayList();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList valueSet2 = new ArrayList();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }



    private ArrayList getXAxisValues() {
        ArrayList xAxis = new ArrayList();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

    private ArrayList<Entry> lineDataValues(){

        ArrayList<Entry> datavals = new ArrayList<Entry>();
        datavals.add(new Entry (0,20));
        datavals.add(new Entry (1,10));
        datavals.add(new Entry (2,26));
        datavals.add(new Entry (3,5));
        datavals.add(new Entry (4,25));
        datavals.add(new Entry (5,22));
        datavals.add(new Entry (5,11));

        return  datavals;

    }

    private ArrayList<Entry> lineDataValues2(){

        ArrayList<Entry> datavals2 = new ArrayList<Entry>();
        datavals2.add(new Entry (0,13));
        datavals2.add(new Entry (1,16));
        datavals2.add(new Entry (2,19));
        datavals2.add(new Entry (3,5));
        datavals2.add(new Entry (4,22));
        datavals2.add(new Entry (5,9));
        datavals2.add(new Entry (5,16));

        return datavals2;

    }

    private ArrayList<PieEntry> pieDataValues(){

        ArrayList<PieEntry> datavals = new ArrayList<>();
        datavals.add(new PieEntry(14, "Sun"));
        datavals.add(new PieEntry(11, "Mon"));
        datavals.add(new PieEntry(4, "Tues"));
        datavals.add(new PieEntry(3, "Wed"));
        datavals.add(new PieEntry(18, "Thu"));
        datavals.add(new PieEntry(7, "Fri"));
        datavals.add(new PieEntry(3, "Sat"));

        return datavals;
    }
}

//steps for line graph:*********************************

//add gradle dependencies
//add chart to xml
//set id
//declare chart and find by id
//build data values method to return arraylist of entries <Entry>
//make a new LineDataSet and pass in the arraylist of entries
//create arraylist with ILineDataSet as type
//add the linedata set to the arraylist
//create a LineData object and pass in the arrayList
//pass the linedata to the linechart object using setData()
//refresh by calling invalidate()