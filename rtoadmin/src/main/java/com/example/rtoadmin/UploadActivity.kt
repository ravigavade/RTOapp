package com.example.rtoadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rtoadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val ownerName=binding.uploadOwnerName.text.toString()
            val vehicleBrand=binding.uploadVehicleBrand.text.toString()
            val vehicleRTO=binding.uploadVehicalRTO.text.toString()
            val vehicleNumber=binding.uploadVehicalNumber.text.toString()

            databaseReference=FirebaseDatabase.getInstance().getReference("Vehicle Information")
            val vehicleData=VehicleData(ownerName,vehicleBrand,vehicleRTO,vehicleNumber)
            databaseReference.child(vehicleNumber).setValue(vehicleData).addOnSuccessListener{
                binding.uploadOwnerName.text.clear()
                binding.uploadVehicalRTO.text.clear()
                binding.uploadVehicalNumber.text.clear()
                binding.uploadVehicleBrand.text.clear()

                Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show()

                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}