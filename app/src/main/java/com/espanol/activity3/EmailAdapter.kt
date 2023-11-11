package com.espanol.activity3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter (private val emailList: ArrayList<ItemsViewModel>, private val activ: Context) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>(){

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val senderNameTextView: TextView = itemView.findViewById(R.id.text_sender_view)
        val subjectTextView: TextView = itemView.findViewById(R.id.text_email_subject)
        val contentPreviewTextView: TextView = itemView.findViewById(R.id.text_email_content_view)
        val emailLinearLayout: LinearLayout = itemView.findViewById(R.id.email_linear_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.email_list_item, parent, false)
        return EmailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.senderNameTextView.text = email.senderName
        holder.subjectTextView.text = email.subject
        holder.contentPreviewTextView.text = email.content
        holder.emailLinearLayout.setOnClickListener {
            MainActivity.name = email.senderName
            MainActivity.subject = email.subject
            MainActivity.content = email.content

            activ.startActivity(Intent(activ,EmailViewContent::class.java))
        }
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}