package com.manideep.challengematrix.View;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.manideep.challengematrix.Controller.ShortestPath;
import com.manideep.challengematrix.Model.Result;
import com.manideep.challengematrix.R;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;
    Integer rows;
    Integer cols;
    String[] vals;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /* TextView to show the result */
        tvResult = (TextView) this.findViewById(R.id.tv_result);

        try {
        /* Obtain all the values from the Intent */
            vals = (String[]) this.getIntent().getExtras().getSerializable("vals");
            rows = this.getIntent().getExtras().getInt("rows");
            cols = this.getIntent().getExtras().getInt("cols");
        } catch(Exception ex) {
            Toast.makeText(this, "Invalid Access", Toast.LENGTH_SHORT).show();
            finish();
        }
        /* Display a Please wait message */
        tvResult.setText("Calculating, Please wait...");

        /* Start Processing */
        new RequestPerformTask().execute();


    }

    private class RequestPerformTask extends AsyncTask<String, Boolean, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                result = ShortestPath.performAction(vals, rows, cols);
                publishProgress(true);
            } catch (Exception ex) {
                publishProgress(false);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Boolean... values) {
            super.onProgressUpdate(values);

            /* Check if finished Successfully */
            if (values[0]) {
                String res = "";

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        res += vals[i * cols + j] + "\t";
                    }
                    res += "\n";
                }

                res += "\n";

                if (result.getSuccess()) {
                    res += "Yes\n";
                } else {
                    res += "No\n";
                }

                if (result.getMinimum() != null) {
                    res += "Minimum is: " + result.getMinimum() + "\n";
                    res += "Path: [";
                    for (int i = 0; i < result.getPath().size(); i++) {

                        res += result.getPath().get(i) + 1 + "\t";

                    }
                    res += "]";
                }

                if (result.getInvalid()) {
                    res += "Invalid Matrix";
                }

                tvResult.setText(res);
            } else {
                tvResult.setText("An Error Occurred, Please try again");
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}




