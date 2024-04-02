package com.example.quiz.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User ORDER BY score DESC LIMIT 3")
    fun getAllSortPoints(): List<User>


    @Query("SELECT * FROM User WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds : IntArray) : List<User>

    @Insert
    fun addUser(vararg users: User)

    @Delete
    fun delete(user: User)
}