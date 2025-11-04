package com.example.school;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006*"}, d2 = {"Lcom/example/school/CadastrarAlunoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/school/databinding/FragmentCadastrarAlunoBinding;", "aluno", "Lcom/example/school/data/Aluno;", "alunoId", "", "binding", "getBinding", "()Lcom/example/school/databinding/FragmentCadastrarAlunoBinding;", "condutorList", "", "Lcom/example/school/data/Condutor;", "responsavelList", "Lcom/example/school/data/Responsavel;", "turmaList", "Lcom/example/school/data/Turma;", "viewModel", "Lcom/example/school/data/SchoolViewModel;", "getViewModel", "()Lcom/example/school/data/SchoolViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bind", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "salvarAluno", "setupCondutorSpinner", "setupResponsavelSpinner", "setupTurmaSpinner", "app_debug"})
public final class CadastrarAlunoFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.school.databinding.FragmentCadastrarAlunoBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private int alunoId = -1;
    @org.jetbrains.annotations.Nullable()
    private com.example.school.data.Aluno aluno;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.school.data.Turma> turmaList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.school.data.Responsavel> responsavelList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.school.data.Condutor> condutorList;
    
    public CadastrarAlunoFragment() {
        super();
    }
    
    private final com.example.school.databinding.FragmentCadastrarAlunoBinding getBinding() {
        return null;
    }
    
    private final com.example.school.data.SchoolViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupTurmaSpinner() {
    }
    
    private final void setupResponsavelSpinner() {
    }
    
    private final void setupCondutorSpinner() {
    }
    
    private final void bind(com.example.school.data.Aluno aluno) {
    }
    
    private final void salvarAluno() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}