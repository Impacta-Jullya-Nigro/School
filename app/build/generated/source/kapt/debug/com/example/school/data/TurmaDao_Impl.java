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
public final class TurmaDao_Impl implements TurmaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Turma> __insertionAdapterOfTurma;

  private final EntityDeletionOrUpdateAdapter<Turma> __deletionAdapterOfTurma;

  private final EntityDeletionOrUpdateAdapter<Turma> __updateAdapterOfTurma;

  public TurmaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTurma = new EntityInsertionAdapter<Turma>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `turma` (`id_turma`,`turno`,`serie`,`nome`,`criado_em`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Turma entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTurno() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTurno());
        }
        if (entity.getSerie() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSerie());
        }
        if (entity.getNome() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNome());
        }
        statement.bindLong(5, entity.getCriadoEm());
      }
    };
    this.__deletionAdapterOfTurma = new EntityDeletionOrUpdateAdapter<Turma>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `turma` WHERE `id_turma` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Turma entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfTurma = new EntityDeletionOrUpdateAdapter<Turma>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `turma` SET `id_turma` = ?,`turno` = ?,`serie` = ?,`nome` = ?,`criado_em` = ? WHERE `id_turma` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Turma entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTurno() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTurno());
        }
        if (entity.getSerie() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSerie());
        }
        if (entity.getNome() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNome());
        }
        statement.bindLong(5, entity.getCriadoEm());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Turma turma, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTurma.insert(turma);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Turma turma, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTurma.handle(turma);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Turma turma, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTurma.handle(turma);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Turma>> getAllTurmas() {
    final String _sql = "SELECT * from turma ORDER BY serie ASC, nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"turma"}, new Callable<List<Turma>>() {
      @Override
      @NonNull
      public List<Turma> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_turma");
          final int _cursorIndexOfTurno = CursorUtil.getColumnIndexOrThrow(_cursor, "turno");
          final int _cursorIndexOfSerie = CursorUtil.getColumnIndexOrThrow(_cursor, "serie");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final List<Turma> _result = new ArrayList<Turma>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Turma _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTurno;
            if (_cursor.isNull(_cursorIndexOfTurno)) {
              _tmpTurno = null;
            } else {
              _tmpTurno = _cursor.getString(_cursorIndexOfTurno);
            }
            final String _tmpSerie;
            if (_cursor.isNull(_cursorIndexOfSerie)) {
              _tmpSerie = null;
            } else {
              _tmpSerie = _cursor.getString(_cursorIndexOfSerie);
            }
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Turma(_tmpId,_tmpTurno,_tmpSerie,_tmpNome,_tmpCriadoEm);
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
  public Flow<Turma> getTurma(final int id) {
    final String _sql = "SELECT * from turma WHERE id_turma = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"turma"}, new Callable<Turma>() {
      @Override
      @NonNull
      public Turma call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_turma");
          final int _cursorIndexOfTurno = CursorUtil.getColumnIndexOrThrow(_cursor, "turno");
          final int _cursorIndexOfSerie = CursorUtil.getColumnIndexOrThrow(_cursor, "serie");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final Turma _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTurno;
            if (_cursor.isNull(_cursorIndexOfTurno)) {
              _tmpTurno = null;
            } else {
              _tmpTurno = _cursor.getString(_cursorIndexOfTurno);
            }
            final String _tmpSerie;
            if (_cursor.isNull(_cursorIndexOfSerie)) {
              _tmpSerie = null;
            } else {
              _tmpSerie = _cursor.getString(_cursorIndexOfSerie);
            }
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _result = new Turma(_tmpId,_tmpTurno,_tmpSerie,_tmpNome,_tmpCriadoEm);
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
