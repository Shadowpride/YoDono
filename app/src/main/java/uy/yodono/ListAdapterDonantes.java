package uy.yodono;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterDonantes extends RecyclerView.Adapter<ListAdapterDonantes.ViewHolderDonantes>{
    private List<ListElementListaDonantes> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterDonantes(List<ListElementListaDonantes> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){ return mData.size();}



    @Override
    public ListAdapterDonantes.ViewHolderDonantes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element_listadonantes, null);
        return new ListAdapterDonantes.ViewHolderDonantes(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterDonantes.ViewHolderDonantes holder, final int position) {
        holder.bindData(mData.get(position));

    }

    public void setItems(List<ListElementListaDonantes> items) {mData = items;}

    public class ViewHolderDonantes extends RecyclerView.ViewHolder {
        TextView bdname,bdgrupo,bddepartmaento;

        ViewHolderDonantes(View itemView){
            super(itemView);
            bdname = itemView.findViewById(R.id.BDnombreTV);
            bdgrupo = itemView.findViewById(R.id.BDgrupoTV);
            bddepartmaento = itemView.findViewById(R.id.BDdepartamentoTV);
        }

        void bindData(final ListElementListaDonantes item){
            bdname.setText(item.getBdname());
            bdgrupo.setText(item.getBdgrupo());
            bddepartmaento.setText(item.getBddepartamento());

        }
    }
}

