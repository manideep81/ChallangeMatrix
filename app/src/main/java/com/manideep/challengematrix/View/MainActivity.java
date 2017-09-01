package com.manideep.challengematrix.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manideep.challengematrix.Controller.ShortestPath;
import com.manideep.challengematrix.Model.Result;
import com.manideep.challengematrix.R;

public class MainActivity extends AppCompatActivity {

    EditText etRows;
    EditText etCols;
    EditText etData;
    Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRows = (EditText) this.findViewById(R.id.et_rows);
        etCols = (EditText) this.findViewById(R.id.et_cols);
        etData = (EditText) this.findViewById(R.id.et_data);
        btnGenerate = (Button) this.findViewById(R.id.btn_generate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etRows.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the number of rows", Toast.LENGTH_SHORT).show();
                    return;
                } else if(etCols.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the number of cols", Toast.LENGTH_SHORT).show();
                    return;
                } else if(etData.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the (space delimited) matrix values" , Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    String[] vals = etData.getText().toString().split(" ");
                    Integer rows = Integer.valueOf(etRows.getText().toString());
                    Integer cols = Integer.valueOf(etCols.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("vals", vals);
                    bundle.putInt("rows", rows);
                    bundle.putInt("cols", cols);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Please enter a Valid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkPath(String[] vals, int rows, int cols) {

        Result result = ShortestPath.performAction(vals, rows, cols);

        if (result.getSuccess()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (result.getMinimum() != null) {
            System.out.println("Minimum is: " + result.getMinimum());
            System.out.print("Path: [");
            for (int i = 0; i < result.getPath().size(); i++) {

                System.out.print(result.getPath().get(i) + 1 + "\t");

            }
            System.out.println("]");
        }

        return result.getSuccess();

    }
}
