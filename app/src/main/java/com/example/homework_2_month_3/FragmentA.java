package com.example.homework_2_month_3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private Button btnNextFragment;
    private TextView textView;
    private Button plusButton;
    private Button minusButton;
    private Integer count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initListener();
    }
    private void initListener() {
        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Sagida", textView.getText().toString());
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentB).addToBackStack(null).commit();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText(count.toString());
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                textView.setText(count.toString());
            }
        });
    }
    private void initView() {
        btnNextFragment = requireActivity().findViewById(R.id.btn_next);
        minusButton = requireActivity().findViewById(R.id.btn_minus_one);
        plusButton = requireActivity().findViewById(R.id.btn_plus_one);
        textView = requireActivity().findViewById(R.id.text_view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Sag", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Sag", "onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Sag", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Sag", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Sag", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Sag", "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Sag", "onDetach");
    }
}