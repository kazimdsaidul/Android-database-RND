package saidul.com.androiddatabasernd.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 8/14/18.
 */
@Entity(tableName = "Person")
class Person(
        @field:ColumnInfo(name = "name")
        val name: String,
        @field:ColumnInfo(name = "email")
        val email: String,
        @field:ColumnInfo(name = "phone")
        val phone: String,
        @field:ColumnInfo(name = "address1")
        val address1: String,
        @field:ColumnInfo(name = "address2")
        val address2: String,
        @field:ColumnInfo(name = "fatherName")
        val fatherName: String,
        @field:ColumnInfo(name = "motherName")
        val motherName: String,
        @field:ColumnInfo(name = "city")
        val city: String,
        @field:ColumnInfo(name = "country")
        val country: String,
        @field:ColumnInfo(name = "profession")
        val profersion: String,
        @field:ColumnInfo(name = "mobileNumber")
        val mobileNumber: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L


}