package com.example.deadnote3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "happy First Fragment! ";
    private Button fragmentButton;

    private EditText textEdit;

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof Controller) {
            this.controller = (Controller) context;
        } else {
            throw new IllegalStateException("Activity must implements Controller");
        }
        super.onAttach(context);
        Log.d(TAG, "onAttach() called with: context = [" + context + "]");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentButton = view.findViewById(R.id.first_fragment_button);

        fragmentButton.setOnClickListener(this);

        textEdit = view.findViewById(R.id.first_text);

        Log.d(TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return inflater.inflate(R.layout.fragment_first, container, false);


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    interface Controller {
        void startButtonPressed(String message);

    }

    private Controller controller;

    @Override
    public void onClick(View view) {
        // getContext() контекст
        // getActivity() активность запустившая фрагмент
        // requireActivity() доступ к активности позволяет предоставить

//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .add(R.layout.second_fragment_holder, new SecondFragment())
//                    .addToBackStack(null)
//                    .commit();

        controller.startButtonPressed(textEdit.getText().toString());

    }
}

