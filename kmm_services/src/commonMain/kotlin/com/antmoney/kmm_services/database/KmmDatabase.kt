package com.antmoney.kmm_services.database

//import com.antmoney.kmm_services.KmmServicesDB
import com.squareup.sqldelight.db.SqlDriver

expect suspend fun provideDbDriver(schema: SqlDriver.Schema): SqlDriver

//class KmmDatabase(
//    private val driverProvider: suspend (SqlDriver.Schema) -> SqlDriver
//) {
//    private var database: KmmServicesDB? = null
//
//    suspend fun initDatabase() {
//        if (database == null) {
//            database = driverProvider(KmmServicesDB.Schema).createDatabase()
//        }
//    }
//
//    suspend operator fun <R> invoke(block: suspend (KmmServicesDB) -> R): R {
//        initDatabase()
//        return block(database!!)
//    }
//
//    private fun SqlDriver.createDatabase(): KmmServicesDB = KmmServicesDB(driver = driver)
//}