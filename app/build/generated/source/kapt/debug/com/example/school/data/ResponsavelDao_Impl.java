package com.example.school.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ResponsavelDao_Impl implements ResponsavelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Responsavel> __insertionAdapterOfResponsavel;

  private final EntityDeletionOrUpdateAdapter<Responsavel> __deletionAdapterOfResponsavel;

  private final EntityDeletionOrUpdateAdapter<Responsavel> __updateAdapterOfResponsavel;

  public ResponsavelDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfResponsavel = new EntityInsertionAdapter<Responsavel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `responsavel` (`id_responsavel`,`nome`,`telefone`,`email`,`criado_em`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Responsavel entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getTelefone() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTelefone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEmail());
        }
        statement.bindLong(5, entity.getCriadoEm());
      }
    };
    this.__deletionAdapterOfResponsavel = new EntityDeletionOrUpdateAdapter<Responsavel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `responsavel` WHERE `id_responsavel` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Responsavel entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfResponsavel = new EntityDeletionOrUpdateAdapter<Responsavel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `responsavel` SET `id_responsavel` = ?,`nome` = ?,`telefone` = ?,`email` = ?,`criado_em` = ? WHERE `id_responsavel` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Responsavel entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getTelefone() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTelefone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEmail());
        }
        statement.bindLong(5, entity.getCriadoEm());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Responsavel responsavel,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfResponsavel.insert(responsavel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Responsavel responsavel,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfResponsavel.handle(responsavel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Responsavel responsavel,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfResponsavel.handle(responsavel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Responsavel>> getAllResponsaveis() {
    final String _sql = "SELECT * from responsavel ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"responsavel"}, new Callable<List<Responsavel>>() {
      @Override
      @NonNull
      public List<Responsavel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_responsavel");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final List<Responsavel> _result = new ArrayList<Responsavel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Responsavel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpTelefone;
            if (_cursor.isNull(_cursorIndexOfTelefone)) {
              _tmpTelefone = null;
            } else {
              _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Responsavel(_tmpId,_tmpNome,_tmpTelefone,_tmpEmail,_tmpCriadoEm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Responsavel> getResponsavel(final int id) {
    final String _sql = "SELECT * from responsavel WHERE id_responsavel = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"responsavel"}, new Callable<Responsavel>() {
      @Override
      @NonNull
      public Responsavel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_responsavel");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final Responsavel _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpTelefone;
            if (_cursor.isNull(_cursorIndexOfTelefone)) {
              _tmpTelefone = null;
            } else {
              _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _result = new Responsavel(_tmpId,_tmpNome,_tmpTelefone,_tmpEmail,_tmpCriadoEm);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
