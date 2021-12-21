import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.fitmass.User

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_USERNAME = "username"
val COL_EMAIL = "email"
val COL_PASSWORD = "password"
val COL_ID = "id"
class DataBaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_USERNAME VARCHAR(256),$COL_EMAIL VARCHAR(256),$COL_PASSWORD VARCHAR(256))"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_USERNAME, user.username)
        contentValues.put(COL_EMAIL, user.email)
        contentValues.put(COL_PASSWORD, user.password)

        val result = database.insert(TABLE_NAME, null, contentValues)
        if (result == -1.toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData(): MutableList<User> {
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User()
                user.id = result.getString(result.getColumnIndexOrThrow(COL_ID)).toInt()
                user.username = result.getString(result.getColumnIndexOrThrow(COL_USERNAME))
                user.email = result.getString(result.getColumnIndexOrThrow(COL_EMAIL))
                user.password = result.getString(result.getColumnIndexOrThrow(COL_PASSWORD))
                list.add(user)
            }
            while (result.moveToNext())
        }
        return list
    }
}