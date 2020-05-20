package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SecondFragment.GetUserDetail {

    var TAG = "ActivityLifeCycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "===>onCreate()")
        loadFragment()
    }
    private fun loadFragment()
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val secondFragment = SecondFragment()
        secondFragment.getUserDetail = this
        fragmentTransaction.add(R.id.fragment_container,secondFragment)
        fragmentTransaction.commit()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "===>onStart()")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "===>onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "===>onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "===>onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "===>onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "===>onDelete()")
    }

    override fun showDetails(firstName: String, lastName: String) {
        val firstFragment:FirstFragment = first_fragment as FirstFragment
        firstFragment.showDetails(firstName, lastName)
    }
}
