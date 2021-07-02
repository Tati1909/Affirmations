package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //устанавливаем данные аффирмаций
        val myDataset = Datasource().loadAffirmations()
        //устанавливаем список
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //указываем списку, что нужно использовать адаптер
        //создаем новый объект ItemAdapter
        recyclerView.adapter = ItemAdapter(this, myDataset)

        //Этот параметр нужен только для повышения производительности
        recyclerView.setHasFixedSize(true)
    }
}