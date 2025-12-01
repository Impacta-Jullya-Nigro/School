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
public final class EscolaDao_Impl implements EscolaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Escola> __insertionAdapterOfEscola;

  private final EntityDeletionOrUpdateAdapter<Escola> __deletionAdapterOfEscola;

  private final EntityDeletionOrUpdateAdapter<Escola> __updateAdapterOfEscola;

  public EscolaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEscola = new EntityInsertionAdapter<Escola>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `escola` (`id_escola`,`nome`,`endereco`,`numero`,`cep`,`diretor`,`criado_em`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Escola entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getEndereco() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEndereco());
        }
        if (entity.getNumero() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNumero());
        }
        if (entity.getCep() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCep());
        }
        if (entity.getDiretor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDiretor());
        }
        statement.bindLong(7, entity.getCriadoEm());
      }
    };
    this.__deletionAdapterOfEscola = new EntityDeletionOrUpdateAdapter<Escola>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `escola` WHERE `id_escola` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Escola entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfEscola = new EntityDeletionOrUpdateAdapter<Escola>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `escola` SET `id_escola` = ?,`nome` = ?,`endereco` = ?,`numero` = ?,`cep` = ?,`diretor` = ?,`criado_em` = ? WHERE `id_escola` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Escola entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getEndereco() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEndereco());
        }
        if (entity.getNumero() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNumero());
        }
        if (entity.getCep() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCep());
        }
        if (entity.getDiretor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDiretor());
        }
        statement.bindLong(7, entity.getCriadoEm());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Escola escola, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEscola.insert(escola);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Escola escola, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEscola.handle(escola);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Escola escola, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEscola.handle(escola);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Escola>> getAllEscolas() {
    final String _sql = "SELECT * from escola ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"escola"}, new Callable<List<Escola>>() {
      @Override
      @NonNull
      public List<Escola> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_escola");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfCep = CursorUtil.getColumnIndexOrThrow(_cursor, "cep");
          final int _cursorIndexOfDiretor = CursorUtil.getColumnIndexOrThrow(_cursor, "diretor");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final List<Escola> _result = new ArrayList<Escola>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Escola _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpEndereco;
            if (_cursor.isNull(_cursorIndexOfEndereco)) {
              _tmpEndereco = null;
            } else {
              _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
            }
            final String _tmpNumero;
            if (_cursor.isNull(_cursorIndexOfNumero)) {
              _tmpNumero = null;
            } else {
              _tmpNumero = _cursor.getString(_cursorIndexOfNumero);
            }
            final String _tmpCep;
            if (_cursor.isNull(_cursorIndexOfCep)) {
              _tmpCep = null;
            } else {
              _tmpCep = _cursor.getString(_cursorIndexOfCep);
            }
            final String _tmpDiretor;
            if (_cursor.isNull(_cursorIndexOfDiretor)) {
              _tmpDiretor = null;
            } else {
              _tmpDiretor = _cursor.getString(_cursorIndexOfDiretor);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Escola(_tmpId,_tmpNome,_tmpEndereco,_tmpNumero,_tmpCep,_tmpDiretor,_tmpCriadoEm);
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
  public Flow<Escola> getEscola(final int id) {
    final String _sql = "SELECT * from escola WHERE id_escola = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"escola"}, new Callable<Escola>() {
      @Override
      @NonNull
      public Escola call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id_escola");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfCep = CursorUtil.getColumnIndexOrThrow(_cursor, "cep");
          final int _cursorIndexOfDiretor = CursorUtil.getColumnIndexOrThrow(_cursor, "diretor");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criado_em");
          final Escola _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpEndereco;
            if (_cursor.isNull(_cursorIndexOfEndereco)) {
              _tmpEndereco = null;
            } else {
              _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
            }
            final String _tmpNumero;
            if (_cursor.isNull(_cursorIndexOfNumero)) {
              _tmpNumero = null;
            } else {
              _tmpNumero = _cursor.getString(_cursorIndexOfNumero);
            }
            final String _tmpCep;
            if (_cursor.isNull(_cursorIndexOfCep)) {
              _tmpCep = null;
            } else {
              _tmpCep = _cursor.getString(_cursorIndexOfCep);
            }
            final String _tmpDiretor;
            if (_cursor.isNull(_cursorIndexOfDiretor)) {
              _tmpDiretor = null;
            } else {
              _tmpDiretor = _cursor.getString(_cursorIndexOfDiretor);
            }
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _result = new Escola(_tmpId,_tmpNome,_tmpEndereco,_tmpNumero,_tmpCep,_tmpDiretor,_tmpCriadoEm);
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
