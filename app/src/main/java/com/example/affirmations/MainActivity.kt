package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.Adapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //данные аффирмаций
        val affirmationData: List<Affirmation> = Datasource().loadAffirmations()
        //устанавливаем список
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        //указываем списку, что нужно использовать адаптер
        //создаем новый объект Adapter(new не указываем)
        recyclerView.adapter = Adapter(this@MainActivity, affirmationData)

        //Этот параметр нужен только для повышения производительности
        //!Только если размер вашего макета RecyclerView фиксирован в макете activity_main.xml
        recyclerView.setHasFixedSize(true)
    }
}