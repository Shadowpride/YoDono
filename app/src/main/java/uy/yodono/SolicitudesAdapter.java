package uy.yodono;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uy.yodono.Entidades.Solicitudes;

public class SolicitudesAdapter extends RecyclerView.Adapter<SolicitudesAdapter.SolicitudesHolder> {
    private List<Solicitudes> fragment_home = new ArrayList<>();

    @NonNull
    @Override
    public SolicitudesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element_solicitudes, parent, false);
        return new SolicitudesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudesHolder holder, int position) {
        Solicitudes solicitud_actual = fragment_home.get(position);
        holder.textViewFecha.setText(solicitud_actual.getFecha_limite());
        holder.textViewDepartamento.setText(solicitud_actual.getDepartamento());
        holder.textViewGrupo.setText(solicitud_actual.getGrupo_sanguineo());
        holder.textViewDonantes.setText(solicitud_actual.getCantidad_donantes());

    }

    @Override
    public int getItemCount() {
        return fragment_home.size();
    }

    public void setSolicitudes(List<Solicitudes> fragment_home) {
        this.fragment_home = fragment_home;
        notifyDataSetChanged();
    }

    class SolicitudesHolder extends RecyclerView.ViewHolder {
        private TextView textViewFecha;
        private TextView textViewGrupo;
        private TextView textViewDepartamento;
        private TextView textViewDonantes;

        public SolicitudesHolder(@NonNull View itemView) {
            super(itemView);
            textViewFecha = itemView.findViewById(R.id.solicitudesFechaLim);
            textViewGrupo = itemView.findViewById(R.id.solicitudesGrupo);
            textViewDepartamento = itemView.findViewById(R.id.solicitudesDepartamento);
            textViewDonantes = itemView.findViewById(R.id.solicitudesDonantesReq);

        }
    }
}


