package ua.kpi.comsys.iv7214.mb6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series1;
    private LineGraphSeries<DataPoint> series2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double x,y;
        x=0;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series1 = new LineGraphSeries<>();
        int numDataPoints = 100;
        for(int i=0; i<numDataPoints; i++){
            x = x+0.1;
            y = Math.pow(x, 3);
            series1.appendData(new DataPoint(x,y), true, 100);
        }
        x=-10;
        GraphView graph2 = (GraphView) findViewById(R.id.graph);
        series2 = new LineGraphSeries<>();
        for(int i=0; i<numDataPoints; i++){
            x = x+0.1;
            y = Math.pow(x, 3);
            series2.appendData(new DataPoint(x,y), true, 100);
        }

        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(-3);
        graph2.getViewport().setMaxX(3);
        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().setMinY(-8);
        graph2.getViewport().setMaxY(8);

        graph.addSeries(series1);
        graph2.addSeries(series2);


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Chart.class);
                startActivity(intent);
            }
        });

    }
}