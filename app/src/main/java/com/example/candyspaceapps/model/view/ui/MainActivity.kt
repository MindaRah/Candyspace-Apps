package com.example.candyspaceapps.model.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.candyspaceapps.R
import com.example.candyspaceapps.databinding.ActivityMainBinding

//Main activity for app configuration and navigation
class MainActivity : AppCompatActivity() {

    private val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var appConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val sEhost: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fra_main) as NavHostFragment? ?: return
        val sEnavController = sEhost.navController
        appConfiguration = AppBarConfiguration(
            setOf(R.id.userFra)
        )
        setupActionBarWithNavController(sEnavController, appConfiguration)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
            {
            }
        }
        return true
    }
}