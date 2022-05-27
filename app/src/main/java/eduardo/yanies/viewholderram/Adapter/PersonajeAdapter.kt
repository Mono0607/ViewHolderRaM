package eduardo.yanies.viewholderram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import eduardo.yanies.viewholderram.Modelo.Personaje


class PersonajeAdapter(val PersonajeList:ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.tvNombre.text=PersonajeList[position].nombre
        holder.tvGenero.text = PersonajeList[position].Genero
        holder.tvEspecie.text = PersonajeList[position].Especie
        Picasso.get()
            .load(PersonajeList[position].foto)
            .into(holder.ivFoto)
    }

    override fun getItemCount(): Int {
        return PersonajeList.size
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        val ivFoto:ImageView
        val tvNombre:TextView
        val tvGenero:TextView
        val tvEspecie:TextView

        init {
            ivFoto = vista.findViewById(R.id.imaPersonaje)
            tvNombre = vista.findViewById(R.id.tvNombreP)
            tvGenero = vista.findViewById(R.id.tvGenero)
            tvEspecie = vista.findViewById(R.id.tvEspecie)
        }
    }
}