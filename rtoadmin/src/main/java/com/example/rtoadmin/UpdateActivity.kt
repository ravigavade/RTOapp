package com.example.rtoadmin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rtoadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun updateData(vehicleNumber: String,ownerName:String, vehicleBrand:String,vehicleRTO:String){
        databaseReference=FirebaseDatabase.getInstance().getReference("Vehicle Information")

        val vehicleData= mapOf<String,String>("ownerName" to ownerName, "vehicleBrand" to vehicleBrand, "vehicleRTO" to vehicleRTO)
        databaseReference.child(vehicleNumber).updateChildren(vehicleData).addOnSuccessListener {
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()
            finish()
        }.addOnFailureListener {
            Toast.makeText(this,"unable to update",Toast.LENGTH_SHORT).show()
        }
    }
}