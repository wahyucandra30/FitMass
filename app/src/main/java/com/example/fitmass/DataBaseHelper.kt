import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.fitmass.Article
import com.example.fitmass.User

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_USERNAME = "username"
val COL_EMAIL = "email"
val COL_PASSWORD = "password"
val COL_ID = "id"

val TABLE_NAME_2 = "Articles"
val COL_TITLE = "title"
val COL_CONTENT = "content"
val COL_AUTHOR = "author"
val COL_ID_2 = "id"

class DataBaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable=
            "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_USERNAME VARCHAR(256),$COL_EMAIL VARCHAR(256),$COL_PASSWORD VARCHAR(256))"
        db?.execSQL(createUserTable)

        val createArticlesTable =
            "CREATE TABLE $TABLE_NAME_2 ($COL_ID_2 INTEGER PRIMARY KEY AUTOINCREMENT,$COL_TITLE VARCHAR(256),$COL_CONTENT TEXT,$COL_AUTHOR VARCHAR(256))"
        db?.execSQL(createArticlesTable)
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

    fun getArticleList(): MutableList<Article> {
        var list : MutableList<Article> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME_2
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val article = Article()
                article.id = result.getString(result.getColumnIndexOrThrow(COL_ID_2)).toInt()
                article.title = result.getString(result.getColumnIndexOrThrow(COL_TITLE))
                article.content = result.getString(result.getColumnIndexOrThrow(COL_CONTENT))
                article.author = result.getString(result.getColumnIndexOrThrow(COL_AUTHOR))
                list.add(article)
            }
            while (result.moveToNext())
        }
        return list
    }
}