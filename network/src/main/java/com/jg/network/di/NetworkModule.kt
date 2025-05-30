package com.jg.network.di

import com.jg.network.interfaces.ExpenseDataSource
import com.jg.network.BaseClient
import com.jg.network.BudgetDataSourceImpl
import com.jg.network.ExpenseDataSourceImpl
import com.jg.network.interfaces.BudgetDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesKtorClient(): HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                json = Json { ignoreUnknownKeys = true }
            )
        }
    }

    @Singleton
    @Provides
    fun providesBaseClient(httpClient: HttpClient): BaseClient{
        return BaseClient(httpClient)
    }

    @Singleton
    @Provides
    fun providesExpenseDataSource(baseClient:BaseClient): ExpenseDataSource {
        return ExpenseDataSourceImpl(baseClient)
    }

    @Singleton
    @Provides
    fun providesBudgetDataSource(baseClient: BaseClient): BudgetDataSource {
        return BudgetDataSourceImpl(baseClient)
    }

}
