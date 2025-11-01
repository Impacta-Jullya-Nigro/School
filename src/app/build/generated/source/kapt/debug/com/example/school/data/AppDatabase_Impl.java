package com.example.school.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile AlunoDao _alunoDao;

  private volatile CondutorDao _condutorDao;

  private volatile ResponsavelDao _responsavelDao;

  private volatile EscolaDao _escolaDao;

  private volatile TurmaDao _turmaDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `aluno` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `idade` INTEGER NOT NULL, `serie` TEXT NOT NULL, `turma` TEXT NOT NULL, `professor` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `condutor` (`id_condutor` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `telefone` TEXT NOT NULL, `placa_veiculo` TEXT NOT NULL, `criado_em` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `responsavel` (`id_responsavel` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `telefone` TEXT NOT NULL, `criado_em` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `escola` (`id_escola` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `endereco` TEXT NOT NULL, `telefone` TEXT NOT NULL, `criado_em` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `turma` (`id_turma` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `horario_entrada` TEXT NOT NULL, `horario_saida` TEXT NOT NULL, `id_escola` INTEGER NOT NULL, `criado_em` INTEGER NOT NULL, FOREIGN KEY(`id_escola`) REFERENCES `escola`(`id_escola`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `condutor_aluno` (`id_condutor` INTEGER NOT NULL, `id_aluno` INTEGER NOT NULL, `criado_em` INTEGER NOT NULL, PRIMARY KEY(`id_condutor`, `id_aluno`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `aluno_responsavel` (`id_aluno` INTEGER NOT NULL, `id_responsavel` INTEGER NOT NULL, `criado_em` INTEGER NOT NULL, PRIMARY KEY(`id_aluno`, `id_responsavel`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c544397353e6171a0e9c2a7669ad9199')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `aluno`");
        db.execSQL("DROP TABLE IF EXISTS `condutor`");
        db.execSQL("DROP TABLE IF EXISTS `responsavel`");
        db.execSQL("DROP TABLE IF EXISTS `escola`");
        db.execSQL("DROP TABLE IF EXISTS `turma`");
        db.execSQL("DROP TABLE IF EXISTS `condutor_aluno`");
        db.execSQL("DROP TABLE IF EXISTS `aluno_responsavel`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(4);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.example.school.data.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsAluno = new HashMap<String, TableInfo.Column>(6);
        _columnsAluno.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAluno.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAluno.put("idade", new TableInfo.Column("idade", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAluno.put("serie", new TableInfo.Column("serie", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAluno.put("turma", new TableInfo.Column("turma", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAluno.put("professor", new TableInfo.Column("professor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAluno = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAluno = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAluno = new TableInfo("aluno", _columnsAluno, _foreignKeysAluno, _indicesAluno);
        final TableInfo _existingAluno = TableInfo.read(db, "aluno");
        if (!_infoAluno.equals(_existingAluno)) {
          return new RoomOpenHelper.ValidationResult(false, "aluno(com.example.school.data.Aluno).\n"
                  + " Expected:\n" + _infoAluno + "\n"
                  + " Found:\n" + _existingAluno);
        }
        final HashMap<String, TableInfo.Column> _columnsCondutor = new HashMap<String, TableInfo.Column>(5);
        _columnsCondutor.put("id_condutor", new TableInfo.Column("id_condutor", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutor.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutor.put("telefone", new TableInfo.Column("telefone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutor.put("placa_veiculo", new TableInfo.Column("placa_veiculo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutor.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCondutor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCondutor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCondutor = new TableInfo("condutor", _columnsCondutor, _foreignKeysCondutor, _indicesCondutor);
        final TableInfo _existingCondutor = TableInfo.read(db, "condutor");
        if (!_infoCondutor.equals(_existingCondutor)) {
          return new RoomOpenHelper.ValidationResult(false, "condutor(com.example.school.data.Condutor).\n"
                  + " Expected:\n" + _infoCondutor + "\n"
                  + " Found:\n" + _existingCondutor);
        }
        final HashMap<String, TableInfo.Column> _columnsResponsavel = new HashMap<String, TableInfo.Column>(4);
        _columnsResponsavel.put("id_responsavel", new TableInfo.Column("id_responsavel", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResponsavel.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResponsavel.put("telefone", new TableInfo.Column("telefone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResponsavel.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResponsavel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResponsavel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResponsavel = new TableInfo("responsavel", _columnsResponsavel, _foreignKeysResponsavel, _indicesResponsavel);
        final TableInfo _existingResponsavel = TableInfo.read(db, "responsavel");
        if (!_infoResponsavel.equals(_existingResponsavel)) {
          return new RoomOpenHelper.ValidationResult(false, "responsavel(com.example.school.data.Responsavel).\n"
                  + " Expected:\n" + _infoResponsavel + "\n"
                  + " Found:\n" + _existingResponsavel);
        }
        final HashMap<String, TableInfo.Column> _columnsEscola = new HashMap<String, TableInfo.Column>(5);
        _columnsEscola.put("id_escola", new TableInfo.Column("id_escola", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEscola.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEscola.put("endereco", new TableInfo.Column("endereco", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEscola.put("telefone", new TableInfo.Column("telefone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEscola.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEscola = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEscola = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEscola = new TableInfo("escola", _columnsEscola, _foreignKeysEscola, _indicesEscola);
        final TableInfo _existingEscola = TableInfo.read(db, "escola");
        if (!_infoEscola.equals(_existingEscola)) {
          return new RoomOpenHelper.ValidationResult(false, "escola(com.example.school.data.Escola).\n"
                  + " Expected:\n" + _infoEscola + "\n"
                  + " Found:\n" + _existingEscola);
        }
        final HashMap<String, TableInfo.Column> _columnsTurma = new HashMap<String, TableInfo.Column>(6);
        _columnsTurma.put("id_turma", new TableInfo.Column("id_turma", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTurma.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTurma.put("horario_entrada", new TableInfo.Column("horario_entrada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTurma.put("horario_saida", new TableInfo.Column("horario_saida", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTurma.put("id_escola", new TableInfo.Column("id_escola", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTurma.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTurma = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTurma.add(new TableInfo.ForeignKey("escola", "CASCADE", "NO ACTION", Arrays.asList("id_escola"), Arrays.asList("id_escola")));
        final HashSet<TableInfo.Index> _indicesTurma = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTurma = new TableInfo("turma", _columnsTurma, _foreignKeysTurma, _indicesTurma);
        final TableInfo _existingTurma = TableInfo.read(db, "turma");
        if (!_infoTurma.equals(_existingTurma)) {
          return new RoomOpenHelper.ValidationResult(false, "turma(com.example.school.data.Turma).\n"
                  + " Expected:\n" + _infoTurma + "\n"
                  + " Found:\n" + _existingTurma);
        }
        final HashMap<String, TableInfo.Column> _columnsCondutorAluno = new HashMap<String, TableInfo.Column>(3);
        _columnsCondutorAluno.put("id_condutor", new TableInfo.Column("id_condutor", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutorAluno.put("id_aluno", new TableInfo.Column("id_aluno", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCondutorAluno.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCondutorAluno = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCondutorAluno = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCondutorAluno = new TableInfo("condutor_aluno", _columnsCondutorAluno, _foreignKeysCondutorAluno, _indicesCondutorAluno);
        final TableInfo _existingCondutorAluno = TableInfo.read(db, "condutor_aluno");
        if (!_infoCondutorAluno.equals(_existingCondutorAluno)) {
          return new RoomOpenHelper.ValidationResult(false, "condutor_aluno(com.example.school.data.CondutorAlunoCrossRef).\n"
                  + " Expected:\n" + _infoCondutorAluno + "\n"
                  + " Found:\n" + _existingCondutorAluno);
        }
        final HashMap<String, TableInfo.Column> _columnsAlunoResponsavel = new HashMap<String, TableInfo.Column>(3);
        _columnsAlunoResponsavel.put("id_aluno", new TableInfo.Column("id_aluno", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlunoResponsavel.put("id_responsavel", new TableInfo.Column("id_responsavel", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlunoResponsavel.put("criado_em", new TableInfo.Column("criado_em", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlunoResponsavel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlunoResponsavel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlunoResponsavel = new TableInfo("aluno_responsavel", _columnsAlunoResponsavel, _foreignKeysAlunoResponsavel, _indicesAlunoResponsavel);
        final TableInfo _existingAlunoResponsavel = TableInfo.read(db, "aluno_responsavel");
        if (!_infoAlunoResponsavel.equals(_existingAlunoResponsavel)) {
          return new RoomOpenHelper.ValidationResult(false, "aluno_responsavel(com.example.school.data.AlunoResponsavelCrossRef).\n"
                  + " Expected:\n" + _infoAlunoResponsavel + "\n"
                  + " Found:\n" + _existingAlunoResponsavel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c544397353e6171a0e9c2a7669ad9199", "e3d2bc3b2bf7013d46959b44b21c3c1d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","aluno","condutor","responsavel","escola","turma","condutor_aluno","aluno_responsavel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `aluno`");
      _db.execSQL("DELETE FROM `condutor`");
      _db.execSQL("DELETE FROM `responsavel`");
      _db.execSQL("DELETE FROM `escola`");
      _db.execSQL("DELETE FROM `turma`");
      _db.execSQL("DELETE FROM `condutor_aluno`");
      _db.execSQL("DELETE FROM `aluno_responsavel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlunoDao.class, AlunoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CondutorDao.class, CondutorDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ResponsavelDao.class, ResponsavelDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EscolaDao.class, EscolaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TurmaDao.class, TurmaDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public AlunoDao alunoDao() {
    if (_alunoDao != null) {
      return _alunoDao;
    } else {
      synchronized(this) {
        if(_alunoDao == null) {
          _alunoDao = new AlunoDao_Impl(this);
        }
        return _alunoDao;
      }
    }
  }

  @Override
  public CondutorDao condutorDao() {
    if (_condutorDao != null) {
      return _condutorDao;
    } else {
      synchronized(this) {
        if(_condutorDao == null) {
          _condutorDao = new CondutorDao_Impl(this);
        }
        return _condutorDao;
      }
    }
  }

  @Override
  public ResponsavelDao responsavelDao() {
    if (_responsavelDao != null) {
      return _responsavelDao;
    } else {
      synchronized(this) {
        if(_responsavelDao == null) {
          _responsavelDao = new ResponsavelDao_Impl(this);
        }
        return _responsavelDao;
      }
    }
  }

  @Override
  public EscolaDao escolaDao() {
    if (_escolaDao != null) {
      return _escolaDao;
    } else {
      synchronized(this) {
        if(_escolaDao == null) {
          _escolaDao = new EscolaDao_Impl(this);
        }
        return _escolaDao;
      }
    }
  }

  @Override
  public TurmaDao turmaDao() {
    if (_turmaDao != null) {
      return _turmaDao;
    } else {
      synchronized(this) {
        if(_turmaDao == null) {
          _turmaDao = new TurmaDao_Impl(this);
        }
        return _turmaDao;
      }
    }
  }
}
