package com.example.school.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/school/data/SchoolViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "alunoDao", "Lcom/example/school/data/AlunoDao;", "responsavelDao", "Lcom/example/school/data/ResponsavelDao;", "turmaDao", "Lcom/example/school/data/TurmaDao;", "escolaDao", "Lcom/example/school/data/EscolaDao;", "condutorDao", "Lcom/example/school/data/CondutorDao;", "(Lcom/example/school/data/AlunoDao;Lcom/example/school/data/ResponsavelDao;Lcom/example/school/data/TurmaDao;Lcom/example/school/data/EscolaDao;Lcom/example/school/data/CondutorDao;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
public final class SchoolViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    @org.jetbrains.annotations.NotNull()
    private final com.example.school.data.AlunoDao alunoDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.school.data.ResponsavelDao responsavelDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.school.data.TurmaDao turmaDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.school.data.EscolaDao escolaDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.school.data.CondutorDao condutorDao = null;
    
    public SchoolViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.example.school.data.AlunoDao alunoDao, @org.jetbrains.annotations.NotNull()
    com.example.school.data.ResponsavelDao responsavelDao, @org.jetbrains.annotations.NotNull()
    com.example.school.data.TurmaDao turmaDao, @org.jetbrains.annotations.NotNull()
    com.example.school.data.EscolaDao escolaDao, @org.jetbrains.annotations.NotNull()
    com.example.school.data.CondutorDao condutorDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
}