package ua.kpi.comsys.iv7214.mb6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Chart extends AppCompatActivity {

    float percents[] = {30, 30, 40};
    String colors[] = {"Orange", "Green", "Black"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        setupPieChart();

        Button back = findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chart.this, MainActivity.class);
                startActivity(intent);
            }
        });
        
    }

    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i=0; i<percents.length; i++){
            pieEntries.add(new PieEntry(percents[i], colors[i]));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Color chart");
        pieDataSet.setColors(ColorTemplate.rgb("#FFAA00"), ColorTemplate.rgb("#00FF00"), ColorTemplate.rgb("#000000"));
        PieData pieData = new PieData(pieDataSet);

        //Get chart
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(pieData);
        chart.invalidate();
    }
}
