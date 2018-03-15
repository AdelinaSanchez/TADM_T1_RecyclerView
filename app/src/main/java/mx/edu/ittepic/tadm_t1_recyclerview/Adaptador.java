package mx.edu.ittepic.tadm_t1_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adelina on 14/03/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderPersonajes>
            implements View.OnClickListener {

        ArrayList<Alumnos> listaPersonajes;
        private View.OnClickListener listener;
        private Context mCtx;


        public Adaptador(ArrayList<Alumnos> listaPersonajes) {
            this.listaPersonajes = listaPersonajes;
        }

        @Override
        public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
            int layout=0;
            if (Utilidades.visualizacion==Utilidades.LIST){
                layout=R.layout.list_alumnos;
            }else {
                layout=R.layout.grid_alumnos;
            }

            View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

            view.setOnClickListener(this);

            return new ViewHolderPersonajes(view);

        }

        @Override
        public void onBindViewHolder(ViewHolderPersonajes holder, int position) {
            holder.etiNombre.setText(listaPersonajes.get(position).getNombre());

            if (Utilidades.visualizacion==Utilidades.LIST){
                holder.etiInformacion.setText(listaPersonajes.get(position).getInfo());
            }

            holder.foto.setImageResource(listaPersonajes.get(position).getFoto());

        }

        @Override
        public int getItemCount() {
            return listaPersonajes.size();
        }

        public void setOnClickListener(View.OnClickListener listener){
            this.listener=listener;

        }

        @Override
        public void onClick(View view) {
            if (listener!=null){
                listener.onClick(view);
            }
        }

        public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

            TextView etiNombre,etiInformacion;
            ImageView foto;

            public ViewHolderPersonajes(View itemView) {
                super(itemView);
                etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
                if (Utilidades.visualizacion==Utilidades.LIST){
                    etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
                }
                foto= (ImageView) itemView.findViewById(R.id.idImagen);
            }
        }
}
