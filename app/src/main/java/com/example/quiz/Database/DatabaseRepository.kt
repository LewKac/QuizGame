package com.example.quiz.Database

import android.app.Application

class DatabaseRepository(application: Application) {

    private val dbDao: UserDao

    init {
        val db: UserDatabase = UserDatabase.getInstance(application.applicationContext)
        dbDao = db.userDao()
    }

    fun returnUsers() : List<User> {
        val users = dbDao.getAllSortPoints()
        return users
    }

    fun deleteUser(user : User) {
        dbDao.delete(user)
    }

    fun addUser(user : UserClass) {
        dbDao.addUser(User(0, user.username, user.score))
    }
}