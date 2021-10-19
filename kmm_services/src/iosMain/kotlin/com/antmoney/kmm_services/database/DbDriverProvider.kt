package com.antmoney.kmm_services.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver


actual suspend fun provideDbDriver(schema: SqlDriver.Schema): SqlDriver {
    return NativeSqliteDriver(schema, "test.db")
}