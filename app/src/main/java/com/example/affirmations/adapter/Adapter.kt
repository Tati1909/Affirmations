package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.databinding.ListItemBinding
import com.example.affirmations.model.Affirmation

//Adapter Нуждается в информации о том , как решить строковые ресурсы.
// Эта и другая информация о приложении хранится в Context, который вы можете передать в Adapter.

//Также адаптер берет аффирмацию из списка, возвращаемого функцией loadAffirmations(),
// и превращает его в представление элемента списка, чтобы его можно было отобразить в RecyclerView.
class Adapter(
    private val context: Context,
    private val dataSetList: List<Affirmation>
) : RecyclerView.Adapter<Adapter.ViewHolder>() { //<Adapter.ViewHolder> - указываем тип холдера

    //RecyclerView не взаимодействует напрямую с представлениями элементов, а работает с ними ViewHolder.
    //A ViewHolder представляет собой представление одного элемента списка RecyclerView и может использоваться повторно, когда это возможно.
    //ViewHolders хранят ссылки на каждый элемент списка (как в заметках мы искали заметки по Id,отсюда и название «держатель вида»).
    // Это упрощает обновление представления элемента списка новыми данными. ViewHolder также добавляет информацию,
    // которую использует RecyclerView для эффективного перемещения представлений по экрану.
    class ViewHolder(var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    /**
     * Создает новые view с R.layout.list_item в качестве шаблона
     */
    //Этот метод вызывается менеджером layoutManager для создания новых ViewHolders для RecyclerView
    //(когда нет существующих ViewHolders, которые можно использовать повторно). Подробнее см 2.3.3.4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //получить экземпляр LayoutInflater из предоставленного контекста ( context из parent)
        //расширить фактическое представление элемента списка
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    //получение количества элементов
    override fun getItemCount(): Int {
        return dataSetList.size
    }

    /**
    Заменяет старые данные существующей View новыми данными
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //элемент RecyclerView = позиция списка наших данных
        val recyclerViewItem = dataSetList[position]
        //обновляем холдер для отображения картинки imageView и строки аффирмации textView
        holder.binding.itemImage.setImageResource(recyclerViewItem.imageResourceId)
        holder.binding.itemTextView.text =
            context.resources.getString(recyclerViewItem.stringResourceId)

    }
}