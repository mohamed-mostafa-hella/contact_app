package com.example.mmh.myfragmenttrain.fragment;

import android.content.ContentUris;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mmh.myfragmenttrain.R;
import com.example.mmh.myfragmenttrain.data_folder.contact_elem_data;
import com.example.mmh.myfragmenttrain.adabter.recyclerviewadabter;

import java.util.ArrayList;

public class call_fragment extends Fragment {

    View v;
    ArrayList<contact_elem_data>data;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.call_fragment,container,false);
        recyclerView=v.findViewById(R.id.contact_viewer);

        recyclerviewadabter recyclerviewadabter=new recyclerviewadabter(data, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerviewadabter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data=new ArrayList<>();
        getContactList();
    }

    private void getContactList() {

        Cursor cur = getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {



            while (cur != null && cur.moveToNext()) {
                contact_elem_data elem=new contact_elem_data();
                elem.setId( cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID)) ) ;
                elem.setName(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)) );
                elem.setPhoto(ContactsContract.Contacts.openContactPhotoInputStream(getActivity().getContentResolver(),
                        ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, new Long(elem.getId()))));

                if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = getActivity().getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{elem.getId()}, null);
                    ArrayList<String>numbers=new ArrayList<>();
                    while (pCur.moveToNext()) {
                        numbers.add(pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    }
                    elem.setPhonenum(numbers);
                    pCur.close();
                }

                data.add(elem);
            }
        }
        if(cur!=null){
            cur.close();
        }
    }

}
