package com.example.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathtrainer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Problem problem = new Problem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        generateProblem();
        MyClickListener listener = new MyClickListener();
        binding.next.setOnClickListener(listener);
        binding.solution1.setOnClickListener(listener);
        binding.solution2.setOnClickListener(listener);
        binding.solution3.setOnClickListener(listener);
        generateProblem();
    }

    private void generateProblem() {
        binding.problem.setText(problem.getProblem());
        binding.solution1.setBackgroundColor(getColor(R.color.still));
        binding.solution2.setBackgroundColor(getColor(R.color.still));
        binding.solution3.setBackgroundColor(getColor(R.color.still));
        int position = problem.getRandom(1, 4);
        int Res = problem.getResult();
        int NoRes1 = problem.getNoiseResult();
        int NoRes2 = problem.getNoiseResult();
        while ((Res == NoRes1)||(Res == NoRes2)||(NoRes1 == NoRes2)){
            NoRes1 = problem.getNoiseResult();
            NoRes2 = problem.getNoiseResult();
        }
        switch (position) {
            case 1:
                binding.solution1.setText(String.valueOf(Res));
                binding.solution2.setText(String.valueOf(NoRes1));
                binding.solution3.setText(String.valueOf(NoRes2));
                break;
            case 2:
                binding.solution1.setText(String.valueOf(NoRes1));
                binding.solution2.setText(String.valueOf(Res));
                binding.solution3.setText(String.valueOf(NoRes2));
                break;
            case 3:
                binding.solution1.setText(String.valueOf(NoRes1));
                binding.solution2.setText(String.valueOf(NoRes2));
                binding.solution3.setText(String.valueOf(Res));
                break;
        }
    }


    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.next:
                    generateProblem();
                    break;
                case R.id.solution1:
                case R.id.solution2:
                case R.id.solution3:
                    String text = ((TextView) view).getText().toString();
                    if (text.equals(String.valueOf(problem.getResult()))) {
                        view.setBackgroundColor(getColor(R.color.correct));
                        Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
                        generateProblem();
                    } else {
                        view.setBackgroundColor(getColor(R.color.wrong));
                        Toast.makeText(MainActivity.this, "Не правильно :(", Toast.LENGTH_SHORT).show();
                    }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}