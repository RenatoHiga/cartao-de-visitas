package br.com.dio.cartaovisitas

import android.app.Application
import br.com.dio.cartaovisitas.data.AppDatabase
import br.com.dio.cartaovisitas.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}