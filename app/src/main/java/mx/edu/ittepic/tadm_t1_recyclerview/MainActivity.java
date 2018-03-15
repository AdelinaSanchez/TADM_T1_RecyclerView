package mx.edu.ittepic.tadm_t1_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Alumnos> listalumnos;
    RecyclerView recyclerAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        construirRecycler();

    }

    private void llenarPersonajes() {
        listalumnos.add(new Alumnos("Adelina","Adelina Sanchez Olea",R.drawable.ade));
        listalumnos.add(new Alumnos("Daniel","Jesus Daniel Villa",R.drawable.dany));
        listalumnos.add(new Alumnos("Cristina","Ana Cristina Verdin ",R.drawable.cristy));
        listalumnos.add(new Alumnos("Celeste","Celeste Garcia ",R.drawable.iconper));
        listalumnos.add(new Alumnos("Marco","Marco Yera PArtida",R.drawable.iconper));
        listalumnos.add(new Alumnos("Karen","Karen Gutierrez",R.drawable.iconper));


    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnList: Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.btnGrid: Utilidades.visualizacion=Utilidades.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listalumnos=new ArrayList<>();
        recyclerAlumnos=  findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerAlumnos.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarPersonajes();

        Adaptador adapter=new Adaptador(listalumnos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+listalumnos.get
                                (recyclerAlumnos.getChildAdapterPosition(view))
                                .getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerAlumnos.setAdapter(adapter);
    }
}
