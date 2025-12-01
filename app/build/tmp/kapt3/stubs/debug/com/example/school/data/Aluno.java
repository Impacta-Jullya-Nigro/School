package com.example.school.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJZ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/example/school/data/Aluno;", "", "id", "", "nome", "", "idade", "professor", "turmaId", "responsavelId", "condutorId", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCondutorId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getIdade", "getNome", "()Ljava/lang/String;", "getProfessor", "getResponsavelId", "getTurmaId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/example/school/data/Aluno;", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "aluno", foreignKeys = {@androidx.room.ForeignKey(entity = com.example.school.data.Turma.class, parentColumns = {"id_turma"}, childColumns = {"turma_id"}, onDelete = 3), @androidx.room.ForeignKey(entity = com.example.school.data.Responsavel.class, parentColumns = {"id_responsavel"}, childColumns = {"responsavel_id"}, onDelete = 3), @androidx.room.ForeignKey(entity = com.example.school.data.Condutor.class, parentColumns = {"id_condutor"}, childColumns = {"condutor_id"}, onDelete = 3)})
public final class Aluno {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nome = null;
    private final int idade = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String professor = null;
    @androidx.room.ColumnInfo(name = "turma_id", index = true)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer turmaId = null;
    @androidx.room.ColumnInfo(name = "responsavel_id", index = true)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer responsavelId = null;
    @androidx.room.ColumnInfo(name = "condutor_id", index = true)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer condutorId = null;
    
    public Aluno(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nome, int idade, @org.jetbrains.annotations.NotNull()
    java.lang.String professor, @org.jetbrains.annotations.Nullable()
    java.lang.Integer turmaId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer responsavelId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer condutorId) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final int getIdade() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfessor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTurmaId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getResponsavelId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCondutorId() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.school.data.Aluno copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nome, int idade, @org.jetbrains.annotations.NotNull()
    java.lang.String professor, @org.jetbrains.annotations.Nullable()
    java.lang.Integer turmaId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer responsavelId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer condutorId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}