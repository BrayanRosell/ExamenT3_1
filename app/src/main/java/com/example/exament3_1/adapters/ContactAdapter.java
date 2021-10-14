package com.example.exament3_1.adapters;

import android.Manifest;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.telecom.CallRedirectionService;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.exament3_1.MainActivity;
import com.example.exament3_1.R;
import com.example.exament3_1.personajes.Contacto;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private List<Contacto> mData;
    private static final int PERMISSION_SEND_SMS = 123;
    public ContactAdapter(List<Contacto> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false); //Obtener el layout
        ContactViewHolder vh = new ContactViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        TextView contact = holder.itemView.findViewById(R.id.tvContacts);
        TextView numero = holder.itemView.findViewById(R.id.tvNumero);
        Contacto contacto = mData.get(position);

        contact.setText(contacto.getNombre());
        numero.setText(contacto.getPhone());

        Button btnLlamar = holder.itemView.findViewById(R.id.btnLlamar);
        Button btnMensaje = holder.itemView.findViewById(R.id.btnMensaje);

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contacto.getPhone(), null));
                holder.itemView.getContext().startActivity(intent);

            }
        });

        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Por cada clase adapter, se necesita una clase ViewHolder
    public class ContactViewHolder extends RecyclerView.ViewHolder {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}