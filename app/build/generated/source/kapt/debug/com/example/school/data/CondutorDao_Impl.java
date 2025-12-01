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
public final class CondutorDao_Impl implements CondutorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Condutor> __insertionAdapterOfCondutor;

  private final EntityDeletionOrUpdateAdapter<Condutor> __deletionAdapterOfCondutor;

  private final EntityDeletionOrUpdateAdapter<Condutor> __updateAdapterOfCondutor;

  public CondutorDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCondutor = new EntityInsertionAdapter<Condutor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `condutor` (`id_condutor`,`nome`,`telefone`,`placa_veiculo`,`criado_em`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Condutor entity) {
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
        if (entity.getPlacaVeiculo() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPlacaVeiculo());
        }
        statement.bindLong(5, entity.getCriadoEm());
      }
    };
    this.__deletionAdapterOfCondutor = new EntityDeletionOrUpdateAdapter<Condutor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `condutor` WHERE `id_condutor` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Condutor entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCondutor = new EntityDeletionOrUpdateAdapter<Condutor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `condutor` SET `id_condutor` = ?,`nome` = ?,`telefone` = ?,`placa_veiculo` = ?,`criado_em` = ? WHERE `id_condutor` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Condutor entity) {
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
        if (entity.getPlacaVeiculo() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPlacaVeiculo());
        }
        statement.bindLong(5, entity.getCriadoEm());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Condutor condutor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCondutor.insert(condutor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Condutor condutor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCondutor.handle(condutor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Condutor condutor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCondutor.handle(condutor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Condutor>> getAllCondutores() {
    final String _sql = "SELECT * from condutor ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"condutor"}, new Callable<List<Condutor>>() {
      @Override
      @NonNull
      public List<Condutor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_condutor");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final int _cursorIndexOfPlacaVeiculo = CursorUtil.getColumnIndexOrThrow(_cursor, "placa_veiculo");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final List<Condutor> _result = new ArrayList<Condutor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Condutor _item;
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
            final String _tmpPlacaVeiculo;
            if (_cursor.isNull(_cursorIndexOfPlacaVeiculo)) {
              _tmpPlacaVeiculo = null;
            } else {
              _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Condutor(_tmpId,_tmpNome,_tmpTelefone,_tmpPlacaVeiculo,_tmpCriadoEm);
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
  public Flow<Condutor> getCondutor(final int id) {
    final String _sql = "SELECT * from condutor WHERE id_condutor = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"condutor"}, new Callable<Condutor>() {
      @Override
      @NonNull
      public Condutor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_condutor");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final int _cursorIndexOfPlacaVeiculo = CursorUtil.getColumnIndexOrThrow(_cursor, "placa_veiculo");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final Condutor _result;
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
            final String _tmpPlacaVeiculo;
            if (_cursor.isNull(_cursorIndexOfPlacaVeiculo)) {
              _tmpPlacaVeiculo = null;
            } else {
              _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _result = new Condutor(_tmpId,_tmpNome,_tmpTelefone,_tmpPlacaVeiculo,_tmpCriadoEm);
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
