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
import java.lang.Integer;
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
public final class AlunoDao_Impl implements AlunoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Aluno> __insertionAdapterOfAluno;

  private final EntityDeletionOrUpdateAdapter<Aluno> __deletionAdapterOfAluno;

  private final EntityDeletionOrUpdateAdapter<Aluno> __updateAdapterOfAluno;

  public AlunoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAluno = new EntityInsertionAdapter<Aluno>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `aluno` (`id`,`nome`,`idade`,`professor`,`turma_id`,`responsavel_id`,`condutor_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Aluno entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        statement.bindLong(3, entity.getIdade());
        if (entity.getProfessor() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProfessor());
        }
        if (entity.getTurmaId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getTurmaId());
        }
        if (entity.getResponsavelId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getResponsavelId());
        }
        if (entity.getCondutorId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCondutorId());
        }
      }
    };
    this.__deletionAdapterOfAluno = new EntityDeletionOrUpdateAdapter<Aluno>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `aluno` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Aluno entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfAluno = new EntityDeletionOrUpdateAdapter<Aluno>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `aluno` SET `id` = ?,`nome` = ?,`idade` = ?,`professor` = ?,`turma_id` = ?,`responsavel_id` = ?,`condutor_id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Aluno entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        statement.bindLong(3, entity.getIdade());
        if (entity.getProfessor() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProfessor());
        }
        if (entity.getTurmaId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getTurmaId());
        }
        if (entity.getResponsavelId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getResponsavelId());
        }
        if (entity.getCondutorId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCondutorId());
        }
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Aluno aluno, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAluno.insert(aluno);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Aluno aluno, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAluno.handle(aluno);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Aluno aluno, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAluno.handle(aluno);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Aluno>> getAllAlunos() {
    final String _sql = "SELECT * from aluno ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"aluno"}, new Callable<List<Aluno>>() {
      @Override
      @NonNull
      public List<Aluno> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfIdade = CursorUtil.getColumnIndexOrThrow(_cursor, "idade");
          final int _cursorIndexOfProfessor = CursorUtil.getColumnIndexOrThrow(_cursor, "professor");
          final int _cursorIndexOfTurmaId = CursorUtil.getColumnIndexOrThrow(_cursor, "turma_id");
          final int _cursorIndexOfResponsavelId = CursorUtil.getColumnIndexOrThrow(_cursor, "responsavel_id");
          final int _cursorIndexOfCondutorId = CursorUtil.getColumnIndexOrThrow(_cursor, "condutor_id");
          final List<Aluno> _result = new ArrayList<Aluno>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Aluno _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpIdade;
            _tmpIdade = _cursor.getInt(_cursorIndexOfIdade);
            final String _tmpProfessor;
            if (_cursor.isNull(_cursorIndexOfProfessor)) {
              _tmpProfessor = null;
            } else {
              _tmpProfessor = _cursor.getString(_cursorIndexOfProfessor);
            }
            final Integer _tmpTurmaId;
            if (_cursor.isNull(_cursorIndexOfTurmaId)) {
              _tmpTurmaId = null;
            } else {
              _tmpTurmaId = _cursor.getInt(_cursorIndexOfTurmaId);
            }
            final Integer _tmpResponsavelId;
            if (_cursor.isNull(_cursorIndexOfResponsavelId)) {
              _tmpResponsavelId = null;
            } else {
              _tmpResponsavelId = _cursor.getInt(_cursorIndexOfResponsavelId);
            }
            final Integer _tmpCondutorId;
            if (_cursor.isNull(_cursorIndexOfCondutorId)) {
              _tmpCondutorId = null;
            } else {
              _tmpCondutorId = _cursor.getInt(_cursorIndexOfCondutorId);
            }
            _item = new Aluno(_tmpId,_tmpNome,_tmpIdade,_tmpProfessor,_tmpTurmaId,_tmpResponsavelId,_tmpCondutorId);
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
  public Flow<Aluno> getAluno(final int id) {
    final String _sql = "SELECT * from aluno WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"aluno"}, new Callable<Aluno>() {
      @Override
      @NonNull
      public Aluno call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfIdade = CursorUtil.getColumnIndexOrThrow(_cursor, "idade");
          final int _cursorIndexOfProfessor = CursorUtil.getColumnIndexOrThrow(_cursor, "professor");
          final int _cursorIndexOfTurmaId = CursorUtil.getColumnIndexOrThrow(_cursor, "turma_id");
          final int _cursorIndexOfResponsavelId = CursorUtil.getColumnIndexOrThrow(_cursor, "responsavel_id");
          final int _cursorIndexOfCondutorId = CursorUtil.getColumnIndexOrThrow(_cursor, "condutor_id");
          final Aluno _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpIdade;
            _tmpIdade = _cursor.getInt(_cursorIndexOfIdade);
            final String _tmpProfessor;
            if (_cursor.isNull(_cursorIndexOfProfessor)) {
              _tmpProfessor = null;
            } else {
              _tmpProfessor = _cursor.getString(_cursorIndexOfProfessor);
            }
            final Integer _tmpTurmaId;
            if (_cursor.isNull(_cursorIndexOfTurmaId)) {
              _tmpTurmaId = null;
            } else {
              _tmpTurmaId = _cursor.getInt(_cursorIndexOfTurmaId);
            }
            final Integer _tmpResponsavelId;
            if (_cursor.isNull(_cursorIndexOfResponsavelId)) {
              _tmpResponsavelId = null;
            } else {
              _tmpResponsavelId = _cursor.getInt(_cursorIndexOfResponsavelId);
            }
            final Integer _tmpCondutorId;
            if (_cursor.isNull(_cursorIndexOfCondutorId)) {
              _tmpCondutorId = null;
            } else {
              _tmpCondutorId = _cursor.getInt(_cursorIndexOfCondutorId);
            }
            _result = new Aluno(_tmpId,_tmpNome,_tmpIdade,_tmpProfessor,_tmpTurmaId,_tmpResponsavelId,_tmpCondutorId);
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
