package com.example.harsh.datafetch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BnAddUser,BnReadUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        BnAddUser=view.findViewById(R.id.bn_add_user);
        BnAddUser.setOnClickListener(this);

        BnReadUser=view.findViewById(R.id.bn_view_user);
        BnReadUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bn_add_user:

                Fetch.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddData()).addToBackStack(null).commit();
                break;

            case R.id.bn_view_user:

                Fetch.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }

}
