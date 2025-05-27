package com.jg.data.di

import com.jg.network.interfaces.ExpenseDataSource
import com.jg.data.repositories.ExpenseRepositoryImpl
import com.jg.repositories.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun bindExpenseRepository(dataSource: ExpenseDataSource): ExpenseRepository{
        return ExpenseRepositoryImpl(dataSource)
    }
}