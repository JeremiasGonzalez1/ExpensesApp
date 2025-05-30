package com.jg.data.di

import com.jg.data.repositories.BudgetRepositoryImpl
import com.jg.network.interfaces.ExpenseDataSource
import com.jg.data.repositories.ExpenseRepositoryImpl
import com.jg.network.interfaces.BudgetDataSource
import com.jg.repositories.BudgetRepository
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

    @Singleton
    @Provides
    fun bindBudgetRepository(dataSource: BudgetDataSource): BudgetRepository {
        return BudgetRepositoryImpl(dataSource)
    }
}